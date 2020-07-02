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
            case SetLiteral(l) => l.exists(x => containsExpression(x, targetExp))
            case Operation(Forall(ElementDefinition(_, elem)), ops) => containsExpression(elem, targetExp) || ops.exists(x => containsExpression(x, targetExp))
            case Operation(Exists(ElementDefinition(_, elem)), ops) => containsExpression(elem, targetExp) || ops.exists(x => containsExpression(x, targetExp))
            case Operation(_, ops) => ops.exists(x => containsExpression(x, targetExp))
            case MemberAccess(exp, _) => containsExpression(exp, targetExp)
            case SetComprehension(ElementDefinition(_, element), check, app) =>
                containsExpression(element, targetExp) ||
                containsExpression(check, targetExp) ||
                containsExpression(app, targetExp)
            case _ => false
        }
    }



}
