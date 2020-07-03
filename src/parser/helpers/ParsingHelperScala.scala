package parser.helpers

import ast._

object ParsingHelperScala
{
    def typeObjectScala(t: String): ast.Type = t match
    {
        case "bool" => BoolType
        case "int" => IntType
        case "real" => RealType
        case "set" => SetType
        case x => ObjectType(x)
    }

    def operatorObjectScala(op: String, arity: Int): ast.Operator = op match
    {
        case "Add" => Add
        case "Sub" => Sub
        case "Mul" => Mul
        case "Div" => Div
        case "Pow" => Pow
        case "Equal" => Equal
        case "NotEqual" => NotEqual
        case "LessThan" => LessThan
        case "LessThanEqual" => LessThanEqual
        case "GreaterThan" => GreaterThan
        case "GreaterThanEqual" => GreaterThanEqual
        case "And" => And
        case "Or" => Or
        case "Implies" => Implies
        case "Union" => Union
        case "Intersect" => Intersect
        case "Difference" => Difference
        case "Subset" => Subset
        case "PropSubset" => PropSubset
        case "InSet" => InSet
        case x => MethodCall(x, arity)
    }
}
