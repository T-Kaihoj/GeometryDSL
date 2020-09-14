package transpilation
import syntaxTree.{Add, And, Cardinality, Difference, Div, Equal, Exists, Forall, GreaterThan, GreaterThanEqual, Implies, InSet, Intersect, LessThan, LessThanEqual, MethodCall, Mul, Negation, Not, NotEqual, Or, Pow, PropSubset, Sub, Subset, Union}

object transpilationScala
{
    def operatorStringScala(o: syntaxTree.Operator): String = o match
    {
        case Add => "+";
        case Or => "or";
        case And => "and"
        case Div => "/"
        case Mul => "*"
        case Not => "!"
        case Pow => "**"
        case Sub => "-"
        case Equal => "=="
        case InSet => null
        case Union => null
        case Subset => null
        case Implies => null
        case Negation => null
        case NotEqual => "!="
        case Intersect => null
        case Difference => null
        case PropSubset => null
        case Cardinality => null
        case GreaterThan => ">"
        case LessThan => "<"
        case LessThanEqual =>"<="
        case Exists(element) => "Exists"
        case Forall(element) => "Forall"
        case GreaterThanEqual => "<="
        case MethodCall(name, argumentCount) => "MethodCall"


    }

}