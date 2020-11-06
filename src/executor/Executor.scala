package executor

import logger.{Logger, Message, Severity}
import syntaxTree._

class Executor
{
    var programMemory: List[ProgramDefinition] = List()
    var globalStack: VarStack = List()

    @throws(classOf[Message])
    def executeProgram(program: Program, mainFuncName: String): Value = program match
    {
        case Program(entities) =>
            val (_programMemory, _globalStack) = prepareProgramExecution(entities)
            programMemory = _programMemory
            globalStack = _globalStack
            programMemory.find(p => p match
            {
                case MethodDefinition(name, _, params, _) => name == mainFuncName && params.isEmpty
                case _ => false
            }).getOrElse(throw new Exception(s"No method named '$mainFuncName' exists")) match
            {
                case MethodDefinition(_, _, _, block) => executeBlock(block, Nil) match
                {
                    case Right(_) => NoValue
                    case Left(l) => l
                }
            }
    }

    /**
     * Returns program memory and global stack for a program before execution.
     */
    def prepareProgramExecution(program: List[ProgramDefinition],
                                _programMemory: List[ProgramDefinition] = List(),
                                _globalStack: VarStack = List()):(List[ProgramDefinition], VarStack) = program match
    {
        case (valDef: ValueDefinition) :: tail =>
            prepareProgramExecution(tail, _programMemory, defToVar(valDef, _globalStack) :: _globalStack)
        case (methodDef: MethodDefinition) :: tail =>
            prepareProgramExecution(tail, methodDef :: _programMemory, _globalStack)
        case (typeDef: TypeDefinition) :: tail =>
            prepareProgramExecution(tail, typeDef :: _programMemory, _globalStack)
        case Nil => (_programMemory, _globalStack)
    }

    /**
     * Executes block of GDSL code.
     *
     * Returns either a (potentially) modified variable stack or a single value.
     * If a single value is returned, the executor reached a Return statement.
     */
    def executeBlock(block: Block, stack: VarStack): Either[Value, VarStack] = block match
    {
        case Nil => Right(stack)
        case Return(exp) :: _ => Left(executeExpression(exp, stack))
        case h :: t =>
            executeStatement(h, stack) match
            {
                case Right(newStack) => executeBlock(t, newStack)
                case Left(retVal) => Left(retVal)
            }
    }

    /**
     * Executes a Statement.
     *
     * Returns either a (potentially) modified variable stack or a single value.
     * If a single value is returned, the block contained a Return statement.
     */
    def executeStatement(stm: Statement, stack: VarStack): Either[Value, VarStack] = stm match
    {
        case ValueDefinition(decl, exp) => Right(Variable(decl.name, executeExpression(exp, stack)) :: stack)
        case Conditional(cond, trueBlock, falseBlock) => executeConditional(cond, trueBlock, falseBlock, stack)
        case _: Return => throw new Exception("Should not happen")
    }

    /**
     * Executes a Conditional statement.
     *
     * Returns either a (potentially) modified variable stack or a single value.
     * If a single value is returned, the block contained a Return statement.
     */
    def executeConditional(cond: Expression, trueBlock: Block, falseBlock: Block, stack: VarStack): Either[Value, VarStack] =
    {
        if(executeExpression(cond, stack) match
        {
            case BoolValue(true) => true
            case BoolValue(false) => false
            case IntValue(0) => false
            case IntValue(_) => true
            case RealValue(0.0) => false
            case RealValue(_) => true
            case x => throw new Exception(s"Conditionals on ${x.getClass} is not supported")
        })
        {
            executeBlock(trueBlock, stack)
        }
        else
        {
            executeBlock(falseBlock, stack)
        }
    }

    def executeExpression(exp: Expression, stack: VarStack): Value = exp match
    {
        case NoValueLiteral() => NoValue
        case BoolLiteral(b) => BoolValue(b)
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => RealValue(r)
        case SetLiteral(exps) => executeSetLiteral(exps, stack)
        case Identifier(name) => executeIdentifier(name, stack)
        case MemberAccess(exp, field) => executeMemberAccess(exp, field, stack).get
        case TypeCheck(exp, typeId) => executeTypeCheck(exp, typeId, stack).get
        case SetComprehension(elem, cond, app) => executeSetComprehension(elem, cond, app, stack)
        case Operation(operator, operands) => executeOperation(operator, operands, stack)
    }

    /**
     * Executes set literals and is responsible for flattening nested sets.
     */
    def executeSetLiteral(exps: List[Expression], stack: VarStack): SetValue =
    {
        SetValue(exps.toSet.map(executeExpression(_, stack)))
    }

    def executeIdentifier(name: String, stack: VarStack): Value =
    {
        stack.find(v => v.name == name).getOrElse(
            globalStack.find(v => v.name == name).getOrElse(
                throw new Exception(s"No variable with name '$name' exists"))
        ).value
    }

    /**
     * Exstracts value from object, given a field name.
     */
    def getFieldValue(obj: Value, fieldName: String): Option[Value] = obj match
    {
        case ObjectValue(typeName, fields) =>
            val fieldIndex = programMemory.collectFirst
            {
                case TypeDefinition(name, fieldDefs, _) if typeName == name => fieldDefs.indexWhere(f => f.name == fieldName)
            }.getOrElse(return None)

            fieldIndex match
            {
                case -1 => None
                case n => Some(fields(n))
            }
        case _ => None
    }

    /**
     * Executes memberaccess (dot operator (.)) on objects.
     *
     * Given a set as input, it will return field values with the correct names.
     */
    def executeMemberAccess(exp: Expression, fieldName: String, stack: VarStack): Option[Value] = executeExpression(exp, stack) match
    {
        case objVal: ObjectValue => getFieldValue(objVal, fieldName)
        case set: SetValue =>
            Some(set.map(getFieldValue(_, fieldName) match
            {
                case Some(fieldVal) => fieldVal
                case None => NoValue
            }))
        case value => Logger.log(Severity.Error, s"'$value' is not an object", 0); None
    }

    /**
     * Executes type check of the resulting value of the expression.
     */
    def executeTypeCheck(exp: Expression, typeId: Type, stack: VarStack): Option[Value] =
    {
        Some(BoolValue(compareType(typeId, executeExpression(exp, stack))))
    }

    def executeSetComprehension(elementDef: ElementDefinition, cond: Expression, app: Expression, stack: VarStack): SetValue =
    {
        // Execute expression in element definition
        val valueSet = executeExpression(elementDef.exp, stack) match
        {
            case setValue: SetValue => setValue
            case _ => throw new Exception("Element:"+elementDef.exp+ "is not in a set")
        }

        // Filter the set of values
        val filteredSet: SetValue = valueSet.collect(element => executeExpression(cond, Variable(elementDef.name, element) :: stack) match {
            case BoolValue(value) => value
            case _ => throw new Exception("Condition of set comprehension does not result in a boolean value")
        })

        // Apply application
        filteredSet.map(element => executeExpression(app, Variable(elementDef.name, element) :: stack))
    }

    def executeOperation(operator: Operator, operands: List[Expression], stack: VarStack): Value = operator match
    {
        case Negation => OperationExecutor.negation(executeExpression(operands.head, stack))
        case Not => OperationExecutor.not(executeExpression(operands.head, stack))
        case Cardinality => OperationExecutor.cardinality(executeExpression(operands.head, stack))
        case Forall(element) => executeForall(element, operands.head, stack)
        case Exists(element) => executeExists(element, operands.head, stack)
        case Choose(element) => executeChoose(element, operands.head, stack).get
        case Add => OperationExecutor.add(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Sub => OperationExecutor.sub(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Mul => OperationExecutor.mul(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Div => OperationExecutor.div(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Pow => OperationExecutor.pow(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Equal => OperationExecutor.equal(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case NotEqual => OperationExecutor.notEqual(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case LessThan => OperationExecutor.lessThan(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case LessThanEqual => OperationExecutor.lessThanEqual(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case GreaterThan => OperationExecutor.greaterThan(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case GreaterThanEqual => OperationExecutor.greaterThanEqual(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case And => OperationExecutor.and(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Or => OperationExecutor.or(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Implies => OperationExecutor.implies(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Union => OperationExecutor.union(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Intersect => OperationExecutor.intersect(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Difference => OperationExecutor.difference(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case Subset => OperationExecutor.subset(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case PropSubset => OperationExecutor.propSubset(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case InSet => OperationExecutor.inSet(executeExpression(operands.head, stack), executeExpression(operands.tail.head, stack))
        case MethodCall(name, arity) => executeMethodCall(name, operands, -1, stack)
    }

    def executeForall(element: ElementDefinition, check: Expression, stack: VarStack): BoolValue = executeExpression(element.exp, stack) match
    {
        case SetValue(s) => BoolValue(s.forall(elem => executeExpression(check, Variable(element.name, elem) :: stack) match
        {
            case BoolValue(b) => b
            case _ => throw new Exception("Execution of check expression does not result in a boolean")
        }))
        case _ => throw new Exception("Execution of element definition does not result in a set")
    }

    def executeExists(element: ElementDefinition, check: Expression, stack: VarStack): BoolValue = executeExpression(element.exp, stack) match
    {
        case SetValue(s) => BoolValue(s.exists(elem => executeExpression(check, Variable(element.name, elem) :: stack) match
        {
            case BoolValue(b) => b
            case _ => throw new Exception("Execution of check expression does not result in a boolean")
        }))
        case _ => throw new Exception("Execution of element definition does not result in a set")
    }

    def executeChoose(element: ElementDefinition, cond: Expression, stack: VarStack): Option[Value] = executeExpression(element.exp, stack) match
    {
        case SetValue(set) =>
            set.find(elementValue => executeExpression(cond, Variable(element.name, elementValue) :: stack) match
            {
                case BoolValue(b) => b
                case _ =>
                    Logger.log(Severity.Error, "Execution of choose condition does not result i a boolean", -0)
                    false
            })
        case _ =>
            Logger.log(Severity.Error, "Execution of element definition does not result in a set", -0)
            None
    }

    def executeMethodCall(name: String, operands: List[Expression], lineNum: Int, stack: VarStack): Value =
    {
        val args: List[Value] = operands.map(op => executeExpression(op, stack))


        val correctlyNamedEntities = programMemory.collect
        {
            case methodDef: MethodDefinition if methodDef.name == name => methodDef
            case typeDef: TypeDefinition if typeDef.name == name => typeDef
        }

        correctlyNamedEntities match
        {
            case methodDefs
                if methodDefs.forall
                {
                    case _: MethodDefinition => true
                    case _ => false
                } => callMethod(methodDefs.filter(_.asInstanceOf[MethodDefinition].name == name).asInstanceOf[List[MethodDefinition]], args, lineNum)
            case (typeDef: TypeDefinition) :: Nil => constructObject(typeDef, args, lineNum)
            case (_: TypeDefinition) :: _ => throw new Message(Severity.Error, s"More than one type or method with name '$name' exists", lineNum)
            case _ => throw new Exception("Something went wrong")
        }
    }

    private def noMethodMessage(methodDef: MethodDefinition, args: List[Value]): String =
        s"No method called '${methodDef.name}' exists which takes arguments of type(s): ${args.map(_.getType).mkString(", ")}"

    def callMethod(methodDefs: List[MethodDefinition], args: List[Value], lineNum: Int, params: List[Value] = Nil): Value = args match
    {
        case arg :: argsTail =>
            val argIndex = params.length

            arg match
            {
                case arg if methodDefs.exists(_.params(argIndex).typeId == arg.getType) =>
                    callMethod(methodDefs, argsTail, lineNum, arg :: params)
                case SetValue(innerSet) =>
                    SetValue(innerSet.map(element =>
                    {
                        callMethod(methodDefs, argsTail, lineNum, element :: params)
                    }))
                case _ => throw new Message(Severity.Error, noMethodMessage(methodDefs.head, args), lineNum)
            }

        case Nil =>
            val methodToUse: MethodDefinition = methodDefs.find(methodDef =>
            {
                methodDef.params.zip(params).forall(x => x._1.typeId == x._2.getType)
            }).getOrElse(throw new Message(Severity.Error, noMethodMessage(methodDefs.head, args), lineNum))

            val newStack: VarStack = methodToUse.params.zip(params.reverse).map(x =>
            {
                Variable(x._1.name, x._2)
            })

            executeBlock(methodToUse.block, newStack) match
            {
                case Left(retVal) => retVal
                case Right(_) => NoValue
            }
    }

    def constructObject(typeDef: TypeDefinition, args: List[Value], lineNum: Int, params: List[Variable] = Nil): Value =
    {
        args match
        {
            case arg :: argsTail =>
                val index = params.length
                arg match
                {
                    case arg if arg.getType == typeDef.fields(index).typeId =>
                        val param = Variable(typeDef.fields(index).name, arg)
                        constructObject(typeDef, argsTail, lineNum, param :: params)
                    case SetValue(innerSet) =>
                        SetValue(innerSet.map(innerVal =>
                        {
                            val param = Variable(typeDef.fields(index).name, innerVal)
                            constructObject(typeDef, argsTail, lineNum, param :: params)
                        }))
                    case arg => throw new Message(Severity.Error, s"Type '${typeDef.name}' does not take ${arg.getType} as its argument nr. ${index + 1}", lineNum)
                }
            case Nil =>
                executeExpression(typeDef.invariant, params.reverse) match
                {
                    case BoolValue(true) => ObjectValue(typeDef.name, params.reverse.map(_.value))
                    case BoolValue(false) => NoValue
                }
        }
    }

    def defToVar(valDef: ValueDefinition, stack: VarStack): Variable = valDef match
    {
        case ValueDefinition(ValueDeclaration(name, BoolType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, IntType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, RealType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, SetType), exp) => Variable(name, executeExpression(exp, stack))
    }
}
