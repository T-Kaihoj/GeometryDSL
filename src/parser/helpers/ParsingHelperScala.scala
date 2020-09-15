package parser.helpers

object ParsingHelperScala
{
    def typeObjectScala(t: String): syntaxTree.Type = t match
    {
        case "bool" => syntaxTree.BoolType
        case "int" => syntaxTree.IntType
        case "real" => syntaxTree.RealType
        case "set" => syntaxTree.SetType
        case x => syntaxTree.ObjectType(x)
    }

    def operatorObjectScala(op: String, arity: Int): syntaxTree.Operator = op match
    {
        case "+" => syntaxTree.Add
        case "-" => syntaxTree.Sub
        case "*" => syntaxTree.Mul
        case "/" => syntaxTree.Div
        case "Pow" => syntaxTree.Pow
        case "==" => syntaxTree.Equal
        case "!=" => syntaxTree.NotEqual
        case "<" => syntaxTree.LessThan
        case "<=" => syntaxTree.LessThanEqual
        case ">" => syntaxTree.GreaterThan
        case ">=" => syntaxTree.GreaterThanEqual
        case "And" => syntaxTree.And
        case "Or" => syntaxTree.Or
        case "Not" => syntaxTree.Not
        case "Implies" => syntaxTree.Implies
        case "Union" => syntaxTree.Union
        case "Intersect" => syntaxTree.Intersect
        case "Difference" => syntaxTree.Difference
        case "Subset" => syntaxTree.Subset
        case "PropSubset" => syntaxTree.PropSubset
        case "InSet" => syntaxTree.InSet
        case x => syntaxTree.MethodCall(x, arity)
    }

    def print(entity: syntaxTree.ProgramEntity): Unit =
    {
        println(entity);
    }
}
