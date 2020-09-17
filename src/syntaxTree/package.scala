package object syntaxTree
{
    type Block = List[Statement]

    type ProgramContext = List[ProgramDefinition]
}

package syntaxTree
{
    abstract sealed class ProgramEntity(ln : Int = 0)
    {
        var lineNumber: Int = ln
        var tags: List[String] = List()
    }

    sealed trait ProgramDefinition extends ProgramEntity
    sealed case class Program(programDefinitions: List[ProgramDefinition])

    sealed trait Type
    case object BoolType extends Type
    case object IntType extends Type
    case object RealType extends Type
    case object SetType extends Type
    case class ObjectType(typeName: String) extends Type

    sealed case class ValueDeclaration(name: String, typeId: Type)
    sealed case class ElementDefinition(name: String, exp: Expression)
    sealed case class MethodDefinition(name: String, retType: Type, params: List[ValueDeclaration], block: Block) extends ProgramDefinition
    sealed case class TypeDefinition(name: String, fields: List[ValueDeclaration]) extends ProgramDefinition

    sealed class Statement extends ProgramEntity
    case class ValueDefinition(decl: ValueDeclaration, exp: Expression) extends Statement with ProgramDefinition
    case class Conditional(condition: Expression, trueBlock: Block, falseBlock: Block) extends Statement
    case class Return(exp: Expression) extends Statement

    sealed trait Expression
    case class BoolLiteral(value: Boolean) extends Expression
    case class IntLiteral(value: Long) extends Expression
    case class RealLiteral(value: Double) extends Expression
    case class SetLiteral(values: List[Expression]) extends Expression
    case class Identifier(name: String) extends Expression
    case class MemberAccess(exp: Expression, field: String) extends Expression
    case class SetComprehension(element: ElementDefinition, condition: Expression, application: Expression) extends Expression
    case class Operation(operator: Operator, operands: List[Expression]) extends Expression

    abstract sealed class Operator(val arity: Int)
    case object Negation extends Operator(1)
    case object Not extends Operator(1)
    case object Cardinality extends Operator(1)
    case class Forall(element: ElementDefinition) extends Operator(1)
    case class Exists(element: ElementDefinition) extends Operator(1)

    case object Add extends Operator(2)
    case object Sub extends Operator(2)
    case object Mul extends Operator(2)
    case object Div extends Operator(2)
    case object Pow extends Operator(2)
    case object Equal extends Operator(2)
    case object NotEqual extends Operator(2)
    case object LessThan extends Operator(2)
    case object LessThanEqual extends Operator(2)
    case object GreaterThan extends Operator(2)
    case object GreaterThanEqual extends Operator(2)
    case object And extends Operator(2)
    case object Or extends Operator(2)
    case object Implies extends Operator(2)
    case object Union extends Operator(2)
    case object Intersect extends Operator(2)
    case object Difference extends Operator(2)
    case object Subset extends Operator(2)
    case object PropSubset extends Operator(2)
    case object InSet extends Operator(2)

    case class MethodCall(name: String, argumentCount: Int) extends Operator(argumentCount)

    sealed trait OperationProperty

    case object Commutative extends OperationProperty
    case object Associative extends OperationProperty
    case class LeftDistributive(op: Operation) extends OperationProperty
    case class RightDistributive(op: Operation) extends OperationProperty
    case object Idempotence extends OperationProperty
}
