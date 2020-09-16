package optimizer
import syntaxTree._

object ReflexiveMethodCallRemover extends OperationTransformer
{
    def transform(program: Program, block: Block, statement: Statement, operation: Operation): Expression = operation match
    {
        case Operation(MethodCall(methodName, 2), List(leftOp, rightOp)) =>

            val methodDef: MethodDefinition = Helper.getMethodDefinition(program, methodName).getOrElse({
                logger.Logger.log(logger.Severity.Info,  s"No method called '$methodName' found", statement.lineNumber)
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
