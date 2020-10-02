package syntaxTree

object TypeChecker
{
    sealed trait TypeReturned[+A]
    {
        import TypeReturned._

        def map[B](f: A => B): TypeReturned[B] = this match
        {
            case SomeType(a) => SomeType(f(a))
            case UnknownType => UnknownType
        }
    }

    object TypeReturned
    {
        case class SomeType[+A](a: A) extends TypeReturned[A]
        case object UnknownType extends TypeReturned[Nothing]
    }

    def check(program: Program): Boolean = {
        program.programDefinitions.forall(pd => check(pd))
    }

    def check(programDefinition: ProgramDefinition): Boolean = programDefinition match
    {
        case TypeDefinition(name, fields, invariant) => false
        case MethodDefinition(name, retType, params, block) => false
        case ValueDefinition(decl, exp) => false
    }

    def check(typeDefinition: TypeDefinition): Boolean = typeDefinition match
    {
        case TypeDefinition(_, _, invariant) => resultsInValueOfType(invariant).getOrElse(true) == BoolType
    }

    def check(methodDefinition: MethodDefinition): Boolean = methodDefinition match
    {
        case MethodDefinition(_, retType, _, block) => block.last match {
            case Return(exp) => resultsInValueOfType(exp).getOrElse(true) == retType
        }
    }

    def resultsInValueOfType(expression: Expression): TypeReturned[Type] = expression match
    {
        case BoolLiteral(_) => TypeReturned(BoolType)
        case IntLiteral(_) => TypeReturned(IntType)
        case RealLiteral(_) => TypeReturned(RealType)
        case SetLiteral(_) => TypeReturned(SetType)
        case Identifier(_) => UnknownType
        case MemberAccess(_, _) => UnknownType
        case SetComprehension(_, _, _) => TypeReturned(SetType)
        case Operation(operator, operands) => (operator, operands) match
        {
            case (Negation, List(_)) => UnknownType
            case (Not, List(_)) => TypeReturned(BoolType)
            case (Cardinality, List(_)) => TypeReturned(IntType)
            case (Forall(_), List(_)) => TypeReturned(BoolType)
            case (Exists(_), List(_)) => TypeReturned(BoolType)
            case (Choose(_), List(_)) => UnknownType
            case (Add, List(_, _)) => UnknownType
            case (Sub, List(_, _)) => UnknownType
            case (Mul, List(_, _)) => UnknownType
            case (Div, List(_, _)) => UnknownType
            case (Pow, List(_, _)) => UnknownType
            case (Equal, List(_, _)) => TypeReturned(BoolType)
            case (NotEqual, List(_, _)) => TypeReturned(BoolType)
            case (LessThan, List(_, _)) => TypeReturned(BoolType)
            case (LessThanEqual, List(_, _)) => TypeReturned(BoolType)
            case (GreaterThan, List(_, _)) => TypeReturned(BoolType)
            case (GreaterThanEqual, List(_, _)) => TypeReturned(BoolType)
            case (And, List(_, _)) => TypeReturned(BoolType)
            case (Or, List(_, _)) => TypeReturned(BoolType)
            case (Implies, List(_, _)) => TypeReturned(BoolType)
            case (Union, List(_, _)) => TypeReturned(SetType)
            case (Intersect, List(_, _)) => TypeReturned(SetType)
            case (Difference, List(_, _)) => TypeReturned(SetType)
            case (Subset, List(_, _)) => TypeReturned(BoolType)
            case (PropSubset, List(_, _)) => TypeReturned(BoolType)
            case (InSet, List(_, _)) => TypeReturned(BoolType)
            case (MethodCall(_, _), _) => UnknownType
        }
    }
}
