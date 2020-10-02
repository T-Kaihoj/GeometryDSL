package parser.helpers

import analyzer.SyntaxTreeToZ3Converter
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
        case "Neg" => syntaxTree.Negation
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
        case "Cardinality"=>syntaxTree.Cardinality
        case x => syntaxTree.MethodCall(x, arity)
    }

    def getNoValueLiteral: syntaxTree.Expression = syntaxTree.NoValueLiteral


    def print(entity: syntaxTree.ProgramDefinition): Unit =
    {
        println(entity)
    }
}
