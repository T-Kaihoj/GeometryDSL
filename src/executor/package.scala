import syntaxTree._

package object executor
{
    type VarStack = List[Variable]

    def compareType(t: Type, v: Value): Boolean = (t, v) match
    {
        case (BoolType, BoolValue(_)) => true
        case (IntType, IntValue(_)) => true
        case (RealType, RealValue(_)) => true
        case (SetType, SetValue(_)) => true
        case (ObjectType(typeName), ObjectValue(valName, _)) if typeName == valName => true
        case _ => false
    }
}

package executor
{
    sealed trait Value
    case object NoValue extends Value
    case class BoolValue(value: Boolean) extends Value
    case class IntValue(value: Long) extends Value
    case class RealValue(value: Double) extends Value
    case class SetValue(set: Set[Value]) extends Value
    case class ObjectValue(typeName: String, fields: List[Value]) extends Value

    sealed case class Variable(name: String, value: Value)
}
