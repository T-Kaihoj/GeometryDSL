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
            getTypeOf(invariant, Nil) match
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
                val expResType = getTypeOf(exp, Nil).getOrElse(return)
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
            val expResType = getTypeOf(exp, Nil).getOrElse(return)
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
            getTypeOf(condition, Nil) match
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
            getTypeOf(exp, Nil) match
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
            getTypeOf(exp, Nil) match
            {
                case None =>
                case Some(resType) if resType != SetType =>
            }

            getTypeOf(condition, Nil) match
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

    def getTypeOf(exp: Expression, context: ProgramContext): Option[Type] = exp match
    {
        case NoValueLiteral() => None
        case BoolLiteral(_) => Some(BoolType)
        case IntLiteral(_) =>  Some(IntType)
        case RealLiteral(_) => Some(RealType)
        case SetLiteral(_) => Some(SetType)
        case Identifier(name) => context.collectFirst{ case ValueDefinition(ValueDeclaration(valueName, typeId), _) if valueName == name => typeId }
        case MemberAccess(innerExp, fieldName) => getTypeOfMemberExpression(innerExp, fieldName, context)
        case TypeCheck(_, _) => Some(BoolType)
        case SetComprehension(_, _, _) => Some(SetType)
        case Operation(operator, operands) => operator match
        {
            case Negation => getTypeOf(operands.head, context) match
            {
                case Some(IntType) => Some(IntType)
                case Some(RealType) => Some(IntType)
                case _ => None
            }
            case Not => Some(BoolType)
            case Cardinality => Some(IntType)
            case Forall(_) => Some(BoolType)
            case Exists(_) => Some(BoolType)
            case Choose(_) => None
            case Add => binaryOperationResultingType(operands.head, operands.tail.head, context)
            case Sub => binaryOperationResultingType(operands.head, operands.tail.head, context)
            case Mul => binaryOperationResultingType(operands.head, operands.tail.head, context)
            case Div => binaryOperationResultingType(operands.head, operands.tail.head, context)
            case Pow => getTypeOf(operands.head, context)
            case Equal => Some(BoolType)
            case NotEqual => Some(BoolType)
            case LessThan => Some(BoolType)
            case LessThanEqual => Some(BoolType)
            case GreaterThan => Some(BoolType)
            case GreaterThanEqual => Some(BoolType)
            case And => Some(BoolType)
            case Or => Some(BoolType)
            case Implies => Some(BoolType)
            case Union => Some(SetType)
            case Intersect => Some(SetType)
            case Difference => Some(SetType)
            case Subset => Some(BoolType)
            case PropSubset => Some(BoolType)
            case InSet => Some(BoolType)
            case MethodCall(methodName, _) => Some(Helper.getMethodDefinition(methodName, operands, context).getOrElse(return None).retType)
        }
    }

    private def getTypeOfMemberExpression(exp: Expression, fieldName: String, context: ProgramContext): Option[Type] =
    {
        val innerExpType: ObjectType = getTypeOf(exp, context) match
        {
            case Some(objType: ObjectType) => objType
            case _ => return None
        }

        val typeDef: TypeDefinition = context.collectFirst
        {
            case typeDef: TypeDefinition if typeDef.name == innerExpType.typeName => typeDef
        }.get

        Some(typeDef.fields.find(f => f.name == fieldName).get.typeId)
    }

    private def binaryOperationResultingType(leftExp: Expression, rightExp: Expression, context: ProgramContext): Option[Type] =
    {
        (getTypeOf(leftExp, context), getTypeOf(rightExp, context)) match
        {
            case (Some(IntType), Some(IntType)) => Some(IntType)
            case (Some(RealType), Some(RealType)) => Some(RealType)
            case (Some(RealType), Some(IntType)) => Some(RealType)
            case (Some(IntType), Some(RealType)) => Some(RealType)
            case _ => None
        }
    }
}
