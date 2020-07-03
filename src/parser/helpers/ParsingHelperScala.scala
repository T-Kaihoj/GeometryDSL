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
}
