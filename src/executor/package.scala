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

    def valueToSet(value: Value = NoValue): Set[Value] = value match
    {
        case NoValue => Set()
        case SetValue(innerSet) => innerSet
        case x => Set(x)
    }
}

package executor
{
    trait Value { def getType: Type }
    case object NoValue extends Value { def getType: Type = NoType }
    case class BoolValue(value: Boolean) extends Value  { def getType: Type = BoolType}
    case class IntValue(value: Long) extends Value { def getType: Type = IntType}
    case class RealValue(value: Double) extends Value { def getType: Type = RealType}
    case class ObjectValue(typeName: String, fields: List[Value]) extends Value { def getType: Type = ObjectType(typeName)}

    sealed case class Variable(name: String, value: Value)
}
