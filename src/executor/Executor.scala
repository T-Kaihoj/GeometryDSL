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
        case BoolLiteral(b) => throw new NotImplementedError("BoolLiteral execution not implemented")
        case IntLiteral(i) => IntValue(i)
        case RealLiteral(r) => throw new NotImplementedError("RealLiteral execution not implemented")
        case SetLiteral(s) => throw new NotImplementedError("SetLiteral execution not implemented")
        case Identifier(name) => throw new NotImplementedError("Identifier execution not implemented")
        case MemberAccess(exp, field) => throw new NotImplementedError("MemberAccess execution not implemented")
        case SetComprehension(elem, check, app) => throw new NotImplementedError("SetComprehension execution not implemented")
        case Operation(operator, oprands) => throw new NotImplementedError("Operation execution not implemented")
    }

    def executeOperation(operator: Operator, operands: List[Expression]): Value = operator match
    {
        case Negation => throw new NotImplementedError("Negation execution not implemented")
        case Not => throw new NotImplementedError("Not execution not implemented")
        case Cardinality => throw new NotImplementedError("Cardinality execution not implemented")
        case Forall(elems) => throw new NotImplementedError("Forall execution not implemented")
        case Exists(elems) => throw new NotImplementedError("Exists execution not implemented")
        case Add => operands.map(op => executeExpression(op, Nil))
            .foldLeft(IntValue(0): Value)((x, y) => add(x, y))
        case Sub => throw new NotImplementedError("Sub execution not implemented")
        case Mul => throw new NotImplementedError("Mul execution not implemented")
        case Div => throw new NotImplementedError("Div execution not implemented")
        case Pow => throw new NotImplementedError("Pow execution not implemented")
        case Equal => throw new NotImplementedError("Equal execution not implemented")
        case NotEqual => throw new NotImplementedError("NotEqual execution not implemented")
        case LessThan => throw new NotImplementedError("LessThan execution not implemented")
        case LessThanEqual => throw new NotImplementedError("LessThanEqual execution not implemented")
        case GreaterThan => throw new NotImplementedError("GreaterThan execution not implemented")
        case GreaterThanEqual => throw new NotImplementedError("GreaterThanEqual execution not implemented")
        case And => throw new NotImplementedError("And execution not implemented")
        case Or => throw new NotImplementedError("Or execution not implemented")
        case Implies => throw new NotImplementedError("Implies execution not implemented")
        case Union => throw new NotImplementedError("Union execution not implemented")
        case Intersect => throw new NotImplementedError("Intersect execution not implemented")
        case Difference => throw new NotImplementedError("Difference execution not implemented")
        case Subset => throw new NotImplementedError("Subset execution not implemented")
        case PropSubset => throw new NotImplementedError("PropSubset execution not implemented")
        case InSet => throw new NotImplementedError("InSet execution not implemented")
        case MethodCall(name, arity) => throw new NotImplementedError("MethodCall execution not implemented")
    }

    def add(left: Value, right: Value): Value = (left, right) match
    {
        case (IntValue(l), IntValue(r)) => IntValue(l + r)
        case (RealValue(l), RealValue(r)) => RealValue(l + r)
        case _ => throw new Exception(s"Addition of ${left.getClass} and ${right.getClass} is not supported")
    }

    def defToVar(valDef: ValueDefinition, stack: VarStack = Nil): Variable = valDef match
    {
        case ValueDefinition(ValueDeclaration(name, BoolType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, IntType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, RealType), exp) => Variable(name, executeExpression(exp, stack))
        case ValueDefinition(ValueDeclaration(name, SetType), exp) => Variable(name, executeExpression(exp, stack))
    }
}
