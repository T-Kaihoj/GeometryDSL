package syntaxTree

import scala.annotation.tailrec

object Helper
{
    @scala.annotation.tailrec
    def containsExpression(block: Block, targetExp: Expression): Boolean = block match
    {
        case h :: t => containsExpression(h, targetExp) || containsExpression(t, targetExp)
        case Nil => false
    }

    def containsExpression(stm: Statement, targetExp: Expression): Boolean = stm match
    {
        case Conditional(cond, t, f) => containsExpression(cond, targetExp) ||
                                        containsExpression(t, targetExp) ||
                                        containsExpression(f, targetExp)
        case ValueDefinition(_, exp) => containsExpression(exp, targetExp)
        case Return(exp) => containsExpression(exp, targetExp)
    }

    def containsExpression(exp: Expression, targetExp: Expression): Boolean =
    {
        if(exp == targetExp) true
        else exp match
        {
            case SetLiteral(list) => list.exists(x => containsExpression(x, targetExp))
            case MemberAccess(exp, _) => containsExpression(exp, targetExp)
            case TypeCheck(exp, _) => containsExpression(exp, targetExp)
            case SetComprehension(ElementDefinition(_, element), check, app) =>
                containsExpression(element, targetExp) ||
                containsExpression(check, targetExp) ||
                containsExpression(app, targetExp)
            case Operation(Forall(ElementDefinition(_, exp)), operands) => containsExpression(exp, targetExp) || operands.exists(e => containsExpression(e, targetExp))
            case Operation(Exists(ElementDefinition(_, exp)), operands) => containsExpression(exp, targetExp) || operands.exists(e => containsExpression(e, targetExp))
            case Operation(Choose(ElementDefinition(_, exp)), operands) => containsExpression(exp, targetExp) || operands.exists(e => containsExpression(e, targetExp))
            case Operation(_, operands) => operands.exists(e => containsExpression(e, targetExp))
            case _ => false
        }
    }

    def replaceExpression(block: Block, oldExp: Expression, newExp: Expression): Block = block match
    {
        case h :: t => replaceExpression(h, oldExp, newExp) :: replaceExpression(t, oldExp, newExp)
        case Nil => Nil
    }

    def replaceExpression(stm: Statement, oldExp: Expression, newExp: Expression): Statement = stm match
    {
        case Conditional(cond, t, f) => Conditional(replaceExpression(cond, oldExp, newExp), replaceExpression(t, oldExp, newExp), replaceExpression(f, oldExp, newExp))
        case ValueDefinition(decl, exp) => ValueDefinition(decl, replaceExpression(exp, oldExp, newExp))
        case _ => stm
    }

    def replaceExpression(exp: Expression, oldExp: Expression, newExp: Expression): Expression =
    {
        if(exp == oldExp) newExp
        else exp match
        {
            case SetLiteral(l) => SetLiteral(l.map(s => replaceExpression(s, oldExp, newExp)))
            case Operation(operator, operands) => Operation(operator, operands.map(x => replaceExpression(x, oldExp, newExp)))
            case MemberAccess(exp, field) => MemberAccess(replaceExpression(exp, oldExp, newExp), field)
            case TypeCheck(exp, typeId) => TypeCheck(replaceExpression(exp, oldExp, newExp), typeId)
            case SetComprehension(ElementDefinition(name, exp), check, app) => SetComprehension(
                ElementDefinition(name, replaceExpression(exp, oldExp, newExp)),
                replaceExpression(check, oldExp, newExp),
                replaceExpression(app, oldExp, newExp))
            case _ => exp
        }
    }

    // TODO: Remove
    @tailrec
    def getTypeOf(name: String, block: Block): Option[Type] = block match
    {
        case head :: tail => head match
        {
            case ValueDefinition(ValueDeclaration(n, typeId), _) if n == name => Some(typeId)
            case _ => getTypeOf(name, tail)
        }
        case Nil => None
    }

    def getMethodDefinition(methodName: String, operands: List[Expression], context: ProgramContext): Option[MethodDefinition] = context match
    {
        case head :: tail => head match
        {
            case methodDef: MethodDefinition
                if methodDef.name == methodName &&
                   operands.map(op => TypeChecker.getTypeOf(op, context).get) == methodDef.params.map(param => param.typeId) =>
                Some(methodDef)
            case _ => getMethodDefinition(methodName, operands, tail)
        }
        case Nil => None
    }

    def getTypeDefinition(typeName: String, context: ProgramContext): Option[TypeDefinition] = context match
    {
        case head :: tail => head match
        {
            case t: TypeDefinition if t.name == typeName => Some(t)
            case _ => getTypeDefinition(typeName, tail)
        }
        case _ => None
    }
}
