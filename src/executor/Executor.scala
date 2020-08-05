package executor

import ast._

object Executor
{
    def executeProgram(prog: Program, mainFuncName: String): Value = prog match
    {
        case Program(entities) =>
            val globalState = prepareExecutionState(entities)
            val progMem = globalState._1
            val globalStack = globalState._2
            val mainFunc = progMem.find(p => p match
            {
                case MethodDefinition(name, _, params, _) => name == mainFuncName && params.isEmpty
                case _ => false
            })
            throw new NotImplementedError("Program execution not implemented")
    }

    @scala.annotation.tailrec
    def prepareExecutionState(prog: List[ProgramEntity], programMem: List[ProgramEntity] = Nil, globalStack: VarStack = Nil): (List[ProgramEntity], VarStack) = prog match
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
        case Conditional(cond, tb, fb) => throw new NotImplementedError("Conditional execution not implemented")
        case Return(exp) => throw new NotImplementedError("Return execution not implemented") //executeExpression(exp, stack) :: stack
    }

    def executeExpression(exp: Expression, stack: VarStack = Nil): Value = exp match
    {
        case BoolLiteral(b) => BoolValue(b)
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => RealValue(r)
        case SetLiteral(s) => SetValue(s.toSet.map(exp => executeExpression(exp, stack)))
        case Identifier(name) => throw new NotImplementedError("Identifier execution not implemented")
        case MemberAccess(exp, field) => throw new NotImplementedError("MemberAccess execution not implemented")
        case SetComprehension(elem, check, app) => throw new NotImplementedError("SetComprehension execution not implemented")
        case Operation(operator, operands) => executeOperation(operator, operands)
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
