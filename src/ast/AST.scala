package ast

object AST
{
    @scala.annotation.tailrec
    def containsExpression(block: Block, targetExp: Expression): Boolean = block match
    {
        case h :: t => containsExpression(h, targetExp) || containsExpression(t, targetExp)
        case Nil => false
    }

    def containsExpression(stm: Statement, targetExp: Expression): Boolean = stm match
    {
        case Conditional(cond, t, f,_) => containsExpression(cond, targetExp) ||
                                        containsExpression(t, targetExp) ||
                                        containsExpression(f, targetExp)
        case ValueDefinition(_, exp,_) => containsExpression(exp, targetExp)
        case Return(exp,_) => containsExpression(exp, targetExp)
    }

    def containsExpression(exp: Expression, targetExp: Expression): Boolean =
    {
        if(exp == targetExp) true
        else exp match
        {
            case SetLiteral(l) => l.exists(x => containsExpression(x, targetExp))
    //        case Operation(Forall(ElementDefinition(_, elem)), ops) => containsExpression(elem, targetExp) || ops.exists(x => containsExpression(x, targetExp))
    //        case Operation(Exists(ElementDefinition(_, elem)), ops) => containsExpression(elem, targetExp) || ops.exists(x => containsExpression(x, targetExp))
    //        case Operation(_, ops) => ops.exists(x => containsExpression(x, targetExp))
            case MemberAccess(exp, _) => containsExpression(exp, targetExp)
            case SetComprehension(ElementDefinition(_, element), check, app) =>
                containsExpression(element, targetExp) ||
                containsExpression(check, targetExp) ||
                containsExpression(app, targetExp)
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
        case Conditional(cond, t, f,info) => Conditional(replaceExpression(cond, oldExp, newExp), replaceExpression(t, oldExp, newExp), replaceExpression(f, oldExp, newExp),info)
        case ValueDefinition(decl, exp,info) => ValueDefinition(decl, replaceExpression(exp, oldExp, newExp),info)
        case _ => stm
    }

    def replaceExpression(exp: Expression, oldExp: Expression, newExp: Expression): Expression =
    {
        if(exp == oldExp) newExp
        else exp match
        {
            case SetLiteral(l) => SetLiteral(l.map(s => replaceExpression(s, oldExp, newExp)))
            //case Operation(op, operands) => Operation(op, operands.map(x => replaceExpression(x, oldExp, newExp)))
            case MemberAccess(exp, field) => MemberAccess(replaceExpression(exp, oldExp, newExp), field)
            case SetComprehension(ElementDefinition(name, exp), check, app) => SetComprehension(
                ElementDefinition(name, replaceExpression(exp, oldExp, newExp)),
                replaceExpression(check, oldExp, newExp),
                replaceExpression(app, oldExp, newExp))
            case _ => exp
        }
    }

}
