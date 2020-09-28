package parser.helpers

import parser.GdslLexer

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
        case "union" => syntaxTree.Union
        case "inter" => syntaxTree.Intersect
        case "diff" => syntaxTree.Difference
        case "Subset" => syntaxTree.Subset
        case "PropSubset" => syntaxTree.PropSubset
        case "InSet" => syntaxTree.InSet
        case "Cardinality"=>syntaxTree.Cardinality
        case x => syntaxTree.MethodCall(x, arity)
    }

    def operatorObjectScala(op: Int, arity: Int): syntaxTree.Operator = op match
    {
            /*
        case GdslLexer.ADD => syntaxTree.Add
        case -1 => syntaxTree.Sub
        case -1 => syntaxTree.Mul
        case -1 => syntaxTree.Div
        case -1 => syntaxTree.Pow
        case -1 => syntaxTree.Equal
        case -1 => syntaxTree.NotEqual
        case -1 => syntaxTree.LessThan
        case -1 => syntaxTree.LessThanEqual
        case ">" => syntaxTree.GreaterThan
        case ">=" => syntaxTree.GreaterThanEqual
        case "And" => syntaxTree.And
        case "Or" => syntaxTree.Or
        case "Not" => syntaxTree.Not
             */

        case GdslLexer.UNION => syntaxTree.Union
        case GdslLexer.INTERSECTION => syntaxTree.Intersect
        case GdslLexer.DIFFERENCE => syntaxTree.Difference
        case GdslLexer.SUBSET => syntaxTree.Subset
        case GdslLexer.PROPERSUBSET => syntaxTree.PropSubset
        //case GdslLexer.IN => syntaxTree.InSet
    }

    def print(entity: syntaxTree.ProgramDefinition): Unit =
    {
        println(entity);
    }
}
