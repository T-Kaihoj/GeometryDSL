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
        //case Return(exp) => executeExpression(exp, stack) :: stack
    }

    def executeExpression(exp: Expression, stack: VarStack = Nil): Value = exp match
    {
        case BoolLiteral(b) => BoolValue(b)
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => RealValue(r)
        case SetLiteral(s) => throw new NotImplementedError("SetLiteral execution not implemented")
        case Identifier(name) => throw new NotImplementedError("Identifier execution not implemented")
        case MemberAccess(exp, field) => throw new NotImplementedError("MemberAccess execution not implemented")
        case SetComprehension(elem, check, app) => throw new NotImplementedError("SetComprehension execution not implemented")
        case Operation(operator, operands) => executeOperation(operator, operands.map(exp => executeExpression(exp, stack)))
    }

    def executeOperation(operator: Operator, operands: List[Value]): Value = operator match
    {
        case Negation => OperationExecutor.negation(operands.head)
        case Not => OperationExecutor.not(operands.head)
        case Cardinality => OperationExecutor.cardinality(operands.head)
        case Forall(elems) => throw new NotImplementedError("Forall execution not implemented")
        case Exists(elems) => throw new NotImplementedError("Exists execution not implemented")
        case Add => OperationExecutor.add(operands.head, operands.tail.head)
        case Sub => OperationExecutor.sub(operands.head, operands.tail.head)
        case Mul => OperationExecutor.mul(operands.head, operands.tail.head)
        case Div => OperationExecutor.div(operands.head, operands.tail.head)
        case Pow => OperationExecutor.pow(operands.head, operands.tail.head)
        case Equal => OperationExecutor.equal(operands.head, operands.tail.head)
        case NotEqual => OperationExecutor.notEqual(operands.head, operands.tail.head)
        case LessThan => OperationExecutor.lessThan(operands.head, operands.tail.head)
        case LessThanEqual => OperationExecutor.lessThanEqual(operands.head, operands.tail.head)
        case GreaterThan => OperationExecutor.greaterThan(operands.head, operands.tail.head)
        case GreaterThanEqual => OperationExecutor.greaterThanEqual(operands.head, operands.tail.head)
        case And => OperationExecutor.and(operands.head, operands.tail.head)
        case Or => OperationExecutor.or(operands.head, operands.tail.head)
        case Implies => OperationExecutor.implies(operands.head, operands.tail.head)
        case Union => OperationExecutor.union(operands.head, operands.tail.head)
        case Intersect => OperationExecutor.intersect(operands.head, operands.tail.head)
        case Difference => OperationExecutor.difference(operands.head, operands.tail.head)
        case Subset => OperationExecutor.subset(operands.head, operands.tail.head)
        case PropSubset => OperationExecutor.propSubset(operands.head, operands.tail.head)
        case InSet => OperationExecutor.inSet(operands.head, operands.tail.head)
        case MethodCall(name, arity) => throw new NotImplementedError("MethodCall execution not implemented")
    }

    def defToVar(valDef: ValueDefinition, stack: VarStack = Nil): Variable = valDef match
    {
        case ValueDefinition(ValueDeclaration(name, BoolType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, IntType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, RealType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, SetType), exp) => Variable(name, executeExpression(exp, stack))
    }
}
