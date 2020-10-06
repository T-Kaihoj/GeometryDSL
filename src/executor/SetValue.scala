package executor

case class SetValue(set: Set[Value] = Set()) extends Value
{
    def this(value: Value) { this(valueToSet(value)) }

    def union(that: SetValue): SetValue = { SetValue(this.set.union(that.set)) }
    def union(thatValue: Value): SetValue = { this.union(SetValue(valueToSet(thatValue))) }
}