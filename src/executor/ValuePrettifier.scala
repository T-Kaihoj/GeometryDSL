package executor

object ValuePrettifier
{
    val indent = "    "


    /**
     * Will generate a prettified string of a value.
     */
    def toString(value: Value, indentLvl: Int = 0): String = value match
    {
        case NoValue => "(NoValue)"
        case BoolValue(value) => value.toString
        case IntValue(value) => value.toString
        case RealValue(value) => value.toString
        case SetValue(set) =>
            val list = set.toList
            if(4 < list.size)
            {
                "\n" + indent.repeat(indentLvl) + "{\n" +
                    list.tail.map(v => toString(v, indentLvl + 1))
                        .foldLeft(indent.repeat(indentLvl + 1) + toString(list.head, indentLvl + 1))((a, b) => a + ",\n" + indent.repeat(indentLvl + 1) + b) +
                    "\n" + indent.repeat(indentLvl) + "}"
            }
            else
            {
                "{" + list.tail
                        .map(v => toString(v, indentLvl))
                        .foldLeft(toString(list.head, indentLvl))((a, b: String) => a + ", " + b) + "}"
            }
        case ObjectValue(typeName, fields) => typeName + "(" +
            fields.tail
                .map(f => toString(f, indentLvl))
                .foldLeft(toString(fields.head, indentLvl))((a, b) => a + ", " + b) + ")"
    }
}
