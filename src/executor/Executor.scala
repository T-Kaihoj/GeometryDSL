package executor

import ast._

class Executor
{
    var programMemory: List[ProgramEntity] = List()
    var globalStack: VarStack = List()

    def executeProgram(program: Program, mainFuncName: String): Value = program match
    {
        case Program(entities) =>
            prepareProgramExecution(entities)
            programMemory.find(p => p match
            {
                case MethodDefinition(name, _, params, _) => name == mainFuncName && params.isEmpty
                case _ => false
            }).getOrElse(throw new Exception(s"No method named '$mainFuncName' exists")) match
            {
                case MethodDefinition(_, _, _, block) => executeBlock(block, Nil)
            }
    }

    def prepareProgramExecution(program: List[ProgramEntity]): Unit = program match
    {
        case (valDef: ValueDefinition) :: tail =>
            globalStack = defToVar(valDef, globalStack) :: globalStack
            prepareProgramExecution(tail)
        case (methodDef: MethodDefinition) :: tail =>
            programMemory = methodDef :: programMemory
            prepareProgramExecution(tail)
        case (typeDef: TypeDefinition) :: tail =>
            programMemory = typeDef :: programMemory
            prepareProgramExecution(tail)
        case Nil => None
    }

    def executeBlock(block: Block, stack: VarStack): Value = block match
    {
        case Nil => NoValue
        case Return(exp) :: _ => executeExpression(exp, stack)
        case h :: t => executeBlock(t, executeStatement(h, stack))
    }

    def executeStatement(stm: Statement, stack: VarStack): VarStack = stm match
    {
        case ValueDefinition(decl, exp) => Variable(decl.name, executeExpression(exp, stack)) :: stack
        case Conditional(cond, trueBlock, falseBlock) => executeExpression(cond, stack) match
        {
            case BoolValue(true) => executeBlock(trueBlock, stack); stack
            case BoolValue(false) => executeBlock(falseBlock, stack); stack
            case IntValue(0) => executeBlock(falseBlock, stack); stack
            case IntValue(_) => executeBlock(trueBlock, stack); stack
            case RealValue(0.0) => executeBlock(falseBlock, stack); stack
            case x => throw new Exception(s"Conditionals on ${x.getClass} is not supported")
        }
        case Return(_) => throw new Exception("Should not happen")
    }

    def executeExpression(exp: Expression, stack: VarStack): Value = exp match
    {
        case BoolLiteral(b) => BoolValue(b)
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => RealValue(r)
        case SetLiteral(s) => SetValue(s.toSet.map(exp => executeExpression(exp, stack)))
        case Identifier(name) => executeIdentifier(name, stack)
        case MemberAccess(exp, field) => executeMemberAccess(exp, field, stack)
        case SetComprehension(elem, check, app) => throw new NotImplementedError("SetComprehension execution not implemented")
        case Operation(operator, operands) => executeOperation(operator, operands, stack)
    }

    def executeIdentifier(name: String, stack: VarStack): Value =
    {
        stack.find(v => v.name == name).getOrElse(
            globalStack.find(v => v.name == name).getOrElse(
                throw new Exception(s"No variable with name '$name' exists"))
        ).value
    }

    def executeMemberAccess(exp: Expression, fieldName: String, stack: VarStack): Value = executeExpression(exp, stack) match
    {
        case ObjectValue(typeName, fields) =>
            programMemory.find
            {
                case TypeDefinition(name, _) if typeName == name => true
                case _ => false
            }.getOrElse(throw new Exception(s"No type definition called '$typeName' exists'")) match
            {
                case TypeDefinition(_, fieldsDef) => fields.apply(fieldsDef.indexWhere(f => f.name == fieldName))
                case _ => throw new Exception("Should not happen")
            }
        case value => throw new Exception(s"'$value' is not an object")
    }

    def executeSetComprehension(elem: ElementDefinition, cond: Expression, app: Expression, stack: VarStack): Value =
    {
        executeExpression(elem.exp, stack) match
        {
            case SetValue(set) => SetValue(set.foldLeft(Set(): Set[Value])((s, elemVal) => s.union(
                executeExpression(cond, Variable(elem.name, elemVal) :: stack) match
                {
                    case BoolValue(true) => Set(executeExpression(app, Variable(elem.name, elemVal) :: stack))
                    case BoolValue(false) => Set()
                    case _ => throw new Exception("Condition of set comprehension does not result in a boolean value")
                }
            )))
            case _ => throw new Exception("Element is not in a set")
        }
    }

    def executeOperation(operator: Operator, operands: List[Expression], stack: VarStack): Value = operator match
    {
        case Negation => OperationExecutor.negation(executeExpression(operands.head, stack))
        case Not => OperationExecutor.not(executeExpression(operands.head, stack))
        case Cardinality => OperationExecutor.cardinality(executeExpression(operands.head, stack))
        case Forall(element) => executeForall(element, operands.head, stack)
        case Exists(element) => executeExists(element, operands.head, stack)
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
        case MethodCall(name, arity) => executeMethodCall(name, arity, operands, stack)
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

    def executeMethodCall(methodName: String, arity: Int, args: List[Expression], stack: VarStack): Value =
    {
        programMemory.find{
            case MethodDefinition(name, _, params, _) if name == methodName && params.size == arity => true
            case TypeDefinition(name, fields) if name == methodName && fields.size == arity => true
            case _ => false
        }.getOrElse(throw new Exception(s"No method or type called '$methodName' exists'")) match
        {
            case MethodDefinition(name, _, params, block) => callMethod(name, params, args, block, stack)
            case TypeDefinition(name, fields) => callConstructor(name, fields, args, stack)
            case _ => throw new Exception("Should not happen")
        }
    }

    def callMethod(name: String,
                   params: List[ValueDeclaration],
                   args: List[Expression],
                   block: Block,
                   oldStack: VarStack,
                   newStack: VarStack = Nil): Value = (params, args) match
    {
        case (ValueDeclaration(paramName, paramType) :: paramsTail,
              (arg: Expression) :: argsTail) =>
            val argValue = executeExpression(arg, oldStack)
            (paramType, argValue) match
            {
                case (SetType, SetValue(_)) =>
                    callMethod(name, paramsTail, argsTail, block, oldStack, Variable(paramName, argValue) :: newStack)
                case (_, SetValue(s)) =>
                    SetValue(s.foldLeft(Set(): Set[Value])((s, e) => s.union(
                        callMethod(name, paramsTail, argsTail, block, oldStack, Variable(paramName, e) :: newStack) match
                        {
                            case SetValue(x) => x
                            case x => Set(x)
                        }
                    )))
                case (paramType, argValue) if compareType(paramType, argValue) =>
                    callMethod(name, paramsTail, argsTail, block, oldStack, Variable(paramName, argValue) :: newStack)
                case _ => throw new Exception(s"'$argValue' is not of type '$paramType'")
            }
        case (Nil, Nil) => executeBlock(block, newStack)
        case _ => throw new Exception(s"Wrong number of arguments for calling method '$name")
    }

    def callConstructor(name: String,
                        fields: List[ValueDeclaration],
                        args: List[Expression],
                        stack: VarStack,
                        objFields: List[Value] = Nil): Value = (fields, args) match
    {
        case (ValueDeclaration(_, fieldType) :: fieldsTail,
              (arg: Expression) :: argsTail) =>
            val argValue = executeExpression(arg, stack)
            (fieldType, argValue) match
            {
                case (SetType, SetValue(s)) => callConstructor(name, fieldsTail, argsTail, stack, SetValue(s) :: objFields)
                case (_, SetValue(s)) =>
                    SetValue(s.foldLeft(Set(): Set[Value])((s, e) => s.union(
                        callConstructor(name, fieldsTail, argsTail, stack, e :: objFields) match
                        {
                            case SetValue(x) => x
                            case x => Set(x)
                        }
                    )))
                case (ft, av) if compareType(ft, av) => callConstructor(name, fieldsTail, argsTail, stack, av :: objFields)
                case _ => throw new Exception(s"'$argValue' is not of type '$fieldType'")
            }
        case (Nil, Nil) => ObjectValue(name, objFields.reverse)
        case _ => throw new Exception(s"Wrong number of arguments for constructing '$name'")
    }

    def defToVar(valDef: ValueDefinition, stack: VarStack): Variable = valDef match
    {
        case ValueDefinition(ValueDeclaration(name, BoolType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, IntType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, RealType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, SetType), exp) => Variable(name, executeExpression(exp, stack))
    }
}
