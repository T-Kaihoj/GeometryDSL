package syntaxTree

import logger.{Logger, Severity}

object TypeChecker
{
    def check(program: Program): Unit =
    {
        program.programDefinitions.foreach(pd => check(pd))
    }

    def check(programDefinition: ProgramDefinition): Unit = programDefinition match
    {
        case typeDef: TypeDefinition => check(typeDef)
        case methodDef: MethodDefinition => check(methodDef)
        case valueDef: ValueDefinition => check(valueDef)
    }

    def check(typeDefinition: TypeDefinition): Unit = typeDefinition match
    {
        case TypeDefinition(typeName, _, invariant) =>
            resultsInValueOfType(invariant) match
            {
                case None =>
                    Logger.log(
                        Severity.Info,
                        s"Could not determine resulting type of invariant for '${typeToString(ObjectType(typeName))}' type",
                        typeDefinition.lineNumber)
                case Some(BoolType) =>  // Nothing
                case Some(resType) if resType != BoolType =>
                    Logger.log(
                        Severity.Error,
                        s"Invariant for type * $typeName' does not result in value of type '${typeToString(BoolType)}' but instead results in value of type '${typeToString(resType)}'",
                        typeDefinition.lineNumber)
            }
    }

    def check(methodDefinition: MethodDefinition): Unit = methodDefinition match
    {
        case MethodDefinition(name, retType, _, block) => block.last match
        {
            case Return(exp) =>
                val expResType = resultsInValueOfType(exp).getOrElse(return)
                if(expResType != retType)
                {
                    Logger.log(Severity.Error, s"Method '$name' does not return a value of type '${typeToString(retType)}' but instead returns '${typeToString(expResType)}'", methodDefinition.lineNumber)
                }
                check(block)
        }
    }

    def check(valueDefinition: ValueDefinition): Unit = valueDefinition match
    {
        case ValueDefinition(ValueDeclaration(name, typeId), exp) =>
            val expResType = resultsInValueOfType(exp).getOrElse(return)
            if(expResType != typeId)
            {
                Logger.log(Severity.Error, s"Value '$name' is not assigned a value of type '${typeToString(typeId)}' but is instead assigned a value of type '${typeToString(expResType)}'", valueDefinition.lineNumber)
            }
    }

    def check(block: Block): Unit = block match
    {
        case head :: tail => check(head); check(tail)
        case Nil =>
    }

    def check(statement: Statement): Unit = statement match
    {
        case valueDefinition: ValueDefinition => check(valueDefinition)
        case conditional: Conditional => check(conditional)
        case Return(exp) => check(exp, statement.lineNumber)
        case _ =>
    }

    def check(conditional: Conditional): Unit = conditional match
    {
        case Conditional(condition, _, _) =>
            resultsInValueOfType(condition) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of conditional",
                    conditional.lineNumber
                )
                case Some(BoolType) => // Nothing
                case Some(condType) if condType != BoolType => Logger.log(
                    Severity.Error,
                    s"Condition does not result in a '${typeToString(BoolType)}' but instead a '${typeToString(condType)}'",
                    conditional.lineNumber
                )

                    check(condition, conditional.lineNumber)
            }
    }

    def check(expression: Expression, lineNumber: Int): Unit = expression match
    {
        case NoValueLiteral() =>
        case BoolLiteral(_) =>
        case IntLiteral(_) =>
        case RealLiteral(_) =>
        case SetLiteral(_) =>
        case Identifier(_) =>
        case memberAccess: MemberAccess => check(memberAccess, lineNumber)
        case typeCheck: TypeCheck =>
        case setComprehension: SetComprehension => check(setComprehension, lineNumber)
        case Operation(_, _) =>
    }

    def check(memberAccess: MemberAccess, lineNumber: Int): Unit = memberAccess match
    {
        case MemberAccess(exp, _) =>
            resultsInValueOfType(exp) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of member access expression",
                    lineNumber)
                case Some(ObjectType(_)) => // Check whether the specified type has a field with the correct name.
                case Some(typeId) => Logger.log(
                    Severity.Error,
                    s"Member access expression does not result in a value of the correct type but instead '${typeToString(typeId)}'",
                    lineNumber)
            }
            check(exp, lineNumber)
    }

    def check(typeCheck: TypeCheck, lineNumber: Int): Unit = typeCheck match
    {
        case TypeCheck(exp, _) => check(exp, lineNumber)
    }

    def check(setComprehension: SetComprehension, lineNumber: Int): Unit = setComprehension match
    {
        case SetComprehension(ElementDefinition(_, exp), condition, _) =>
            resultsInValueOfType(exp) match
            {
                case None =>
                case Some(resType) if resType != SetType =>
            }

            resultsInValueOfType(condition) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of conditional",
                    lineNumber
                )
                case Some(BoolType) => // Nothing
                case Some(condType) if condType != BoolType => Logger.log(
                    Severity.Error,
                    s"Condition does not result in a '${typeToString(BoolType)}' but instead a '${typeToString(condType)}'",
                    lineNumber
                )
            }
    }

    def resultsInValueOfType(expression: Expression): Option[Type] = expression match
    {
        case NoValueLiteral() => None
        case BoolLiteral(_) => Some(BoolType)
        case IntLiteral(_) => Some(IntType)
        case RealLiteral(_) => Some(RealType)
        case SetLiteral(_) => Some(SetType)
        case Identifier(_) => None
        case MemberAccess(_, _) => None
        case TypeCheck(_, _) => Some(BoolType)
        case SetComprehension(_, _, _) => Some(SetType)
        case Operation(operator, operands) => (operator, operands) match
        {
            case (Negation, List(_)) => None
            case (Not, List(_)) => Some(BoolType)
            case (Cardinality, List(_)) => Some(IntType)
            case (Forall(_), List(_)) => Some(BoolType)
            case (Exists(_), List(_)) => Some(BoolType)
            case (Choose(_), List(_)) => None
            case (Add, List(_, _)) => None
            case (Sub, List(_, _)) => None
            case (Mul, List(_, _)) => None
            case (Div, List(_, _)) => None
            case (Pow, List(_, _)) => None
            case (Equal, List(_, _)) => Some(BoolType)
            case (NotEqual, List(_, _)) => Some(BoolType)
            case (LessThan, List(_, _)) => Some(BoolType)
            case (LessThanEqual, List(_, _)) => Some(BoolType)
            case (GreaterThan, List(_, _)) => Some(BoolType)
            case (GreaterThanEqual, List(_, _)) => Some(BoolType)
            case (And, List(_, _)) => Some(BoolType)
            case (Or, List(_, _)) => Some(BoolType)
            case (Implies, List(_, _)) => Some(BoolType)
            case (Union, List(_, _)) => Some(SetType)
            case (Intersect, List(_, _)) => Some(SetType)
            case (Difference, List(_, _)) => Some(SetType)
            case (Subset, List(_, _)) => Some(BoolType)
            case (PropSubset, List(_, _)) => Some(BoolType)
            case (InSet, List(_, _)) => Some(BoolType)
            case (MethodCall(_, _), _) => None
        }
    }
}
