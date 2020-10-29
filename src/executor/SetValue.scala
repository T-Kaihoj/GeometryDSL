package executor

case class SetValue(var innerSet: Set[Value] = Set()) extends Value
{
    def getType: syntaxTree.Type = syntaxTree.SetType

    innerSet = innerSet.foldLeft(Set(): Set[Value])((resSet, element) => element match
    {
        case NoValue => resSet
        case SetValue(inner) => resSet.union(inner)
        case element => resSet + element
    })

    def this(value: Value) { this(valueToSet(value)) }

    def union(that: SetValue): SetValue = { SetValue(this.innerSet.union(that.innerSet)) }
    def union(thatValue: Value): SetValue = { this.union(SetValue(valueToSet(thatValue))) }

    def map(operation: Value => Value): SetValue =
    {
        SetValue(this.innerSet.map(elem => operation(elem)))
    }

    def collect(operation: Value => Boolean): SetValue =
    {
        var resSet: Set[Value] = Set()
        this.innerSet.foreach(element =>
            {
                if(operation(element)) resSet += element
            })
        SetValue(resSet)
    }
}
