package analyzer

import syntaxTree._
import com.microsoft.z3

object ReflexivityTransformer extends RelationPropertyAnalyzer
{
    def relation: String = "reflexive"

    def checkRelation(methodDef: MethodDefinition, context: ProgramContext): Option[Boolean] = methodDef match
    {
        case MethodDefinition(_, BoolType, List(leftOp, rightOp), Return(retExp) :: Nil) if leftOp.typeId == rightOp.typeId =>
            val ctx = new z3.Context()
            val converter = new SyntaxTreeToZ3Converter(ctx, Program(context))
            val methodExp: z3.Expr =
                try
                {
                    converter.convertExpression(retExp, List(leftOp, rightOp))
                }
                catch
                {
                    case e: Exception => return None
                }

            val typeName = leftOp.typeId match
            {
                case ObjectType(typeName) => typeName
            }
            assert(converter.typeDefinitions.exists(td => td.name == typeName))

            val sort: z3.Sort = converter.sorts.find(s => s.getName.toString == typeName).get
            val check: z3.BoolExpr = ctx.mkForall(
                Array(sort),
                Array(ctx.mkSymbol("theObject")),
                methodExp
                    .substitute(ctx.mkConst(leftOp.name, sort), ctx.mkConst("theObject", sort))
                    .substitute(ctx.mkConst(rightOp.name, sort), ctx.mkConst("theObject", sort)),
                1,
                null, null, null, null)

            Some(prove(ctx, check))
        case _ => Some(false)
    }
}
