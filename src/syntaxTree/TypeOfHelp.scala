package syntaxTree

object TypeOfHelp
{
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
            case MethodCall(methodName, _) => Some(getMethodCallRetType(methodName, operands, context).getOrElse(return None))
        }
    }

    private def isSetApplication(operands: List[Expression], params: List[ValueDeclaration], context:ProgramContext): Boolean = operands match
    {
        case ::(head, next) =>
            var operandsType: Type = TypeOfHelp.getTypeOf(head, context).getOrElse(return false)
            params match
        {
            case ::(h, n) if operandsType == h =>isSetApplication(next,n, context)
            case ::(h, n) if operandsType == SetType => true || isSetApplication(next,n, context)
            case _  =>false
            case Nil => false
        }
        case Nil =>false
    }

    private def getMethodCallRetType(methodName: String, operands: List[Expression], context: ProgramContext): Option[Type] = context match
    {
        case head :: tail => head match
        {
            case methodDef: MethodDefinition
                if methodDef.name == methodName &&
                    operands.map(op => TypeOfHelp.getTypeOf(op, context).get) == methodDef.params.map(param => param.typeId) =>
                Some(methodDef.retType)
            case TypeDefinition(name, fields, invariant) if name == methodName=> Some(ObjectType( name))
            case methodDef: MethodDefinition
                if methodDef.name == methodName && isSetApplication(operands, methodDef.params, context) =>
                Some(SetType)
            case _ => getMethodCallRetType(methodName, operands, tail)
        }
        case Nil =>
            println(methodName)
            None
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
