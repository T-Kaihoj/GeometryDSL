package executor

import ast._

class Executor
{
    var programMemory: List[ProgramEntity] = List()
    var globalStack: VarStack = List()

    def executeProgram(program: Program, mainFuncName: String): Value = program match
    {
        case Program(entities) =>
            val globalState = prepareExecutionState(entities)
            programMemory = globalState._1
            globalStack = globalState._2
            val mainFunc = programMemory.find(p => p match
            {
                case MethodDefinition(name, _, params, _) => name == mainFuncName && params.isEmpty
                case _ => false
            })

            mainFunc.get match
            {
                case MethodDefinition(_, _, _, block) => executeBlock(block)
            }
    }

    @scala.annotation.tailrec
    final def prepareExecutionState(program: List[ProgramEntity], programMem: List[ProgramEntity] = Nil, globalStack: VarStack = Nil): (List[ProgramEntity], VarStack) = program match
    {
        case (valDef: ValueDefinition) :: t =>
            prepareExecutionState(t, programMem, defToVar(valDef, globalStack) :: globalStack)
        case (methodDef: MethodDefinition) :: t =>
            prepareExecutionState(t, methodDef :: programMem, globalStack)
        case (typeDef: TypeDefinition) :: t =>
            prepareExecutionState(t, typeDef :: programMem, globalStack)
        case Nil => (programMem, globalStack)
    }

    def executeBlock(block: Block, stack: VarStack = Nil): Value = block match
    {
        case Nil      => NoValue
        case Return(exp) :: _ => executeExpression(exp, stack)
        case h :: t   => executeBlock(t, executeStatement(h, stack))
    }

    def executeStatement(stm: Statement, stack: VarStack = Nil): VarStack = stm match
    {
        case valDef: ValueDefinition => defToVar(valDef) :: stack
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

    def executeExpression(exp: Expression, stack: VarStack = Nil): Value = exp match
    {
        case BoolLiteral(b) => BoolValue(b)
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => RealValue(r)
        case SetLiteral(s) => SetValue(s.toSet.map(exp => executeExpression(exp, stack)))
        case Identifier(name) => executeIdentifier(name, stack)
        case MemberAccess(exp, field) => throw new NotImplementedError("MemberAccess execution not implemented")
        case SetComprehension(elem, check, app) => throw new NotImplementedError("SetComprehension execution not implemented")
        case Operation(operator, operands) => executeOperation(operator, operands)
    }

    def executeIdentifier(name: String, stack: VarStack): Value =
    {
        stack.find(v => v.name == name).getOrElse(
            globalStack.find(v => v.name == name).getOrElse(
                throw new Exception(s"No variable with name '${name}' exists"))
        ).value
    }

    def executeMemberAccess(exp: Expression, field: String, stack: VarStack): Value =
    {
        executeExpression(exp, stack) match
        {
            //case obj: ObjectValue => obj.fields.find(f => f.name)
            case _ => NoValue
        }
    }

    def executeOperation(operator: Operator, operands: List[Expression], stack: VarStack = Nil): Value = operator match
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
        case MethodCall(name, arity) => throw new NotImplementedError("MethodCall execution not implemented")
    }

    def executeForall(element: ElementDefinition, check: Expression, stack: VarStack = Nil): BoolValue = executeExpression(element.exp, stack) match
    {
        case SetValue(s) => BoolValue(s.forall(elem => executeExpression(check, Variable(element.name, elem) :: stack) match
        {
            case BoolValue(b) => b
            case _ => throw new Exception("Execution of check expression does not result in a boolean")
        }))
        case _ => throw new Exception("Execution of element definition does not result in a set")
    }

    def executeExists(element: ElementDefinition, check: Expression, stack: VarStack = Nil): BoolValue = executeExpression(element.exp, stack) match
    {
        case SetValue(s) => BoolValue(s.exists(elem => executeExpression(check, Variable(element.name, elem) :: stack) match
        {
            case BoolValue(b) => b
            case _ => throw new Exception("Execution of check expression does not result in a boolean")
        }))
        case _ => throw new Exception("Execution of element definition does not result in a set")
    }

    def defToVar(valDef: ValueDefinition, stack: VarStack = Nil): Variable = valDef match
    {
        case ValueDefinition(ValueDeclaration(name, BoolType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, IntType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, RealType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, SetType), exp) => Variable(name, executeExpression(exp, stack))
    }
}
