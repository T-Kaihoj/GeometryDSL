package optimizer
import syntaxTree._

object ReflexiveMethodCallRemover extends OperationTransformer
{
    override def transform(operation: Operation, context: ProgramContext): Expression = operation match
    {
        case Operation(MethodCall(methodName, 2), List(leftOp, rightOp)) =>
            val methodDef: MethodDefinition = Helper.getMethodDefinition(methodName, List(leftOp, rightOp), context).getOrElse({
                logger.Logger.log(logger.Severity.Info,  s"No method called '$methodName' found", 0)
                return operation
            })

            if(methodDef.tags.contains("prop:reflexive") && leftOp == rightOp)
            {
                BoolLiteral(true)
            }
            else
            {
                operation
            }
        case op => op
    }
}
