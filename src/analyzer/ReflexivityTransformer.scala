package analyzer

import syntaxTree._
import com.microsoft.z3
import logger.{Logger, Severity}

object ReflexivityTransformer extends ProgramDefinitionTransformer
{
    override def transform(programDefinition: ProgramDefinition, context: ProgramContext): ProgramDefinition = programDefinition match
    {
        case methodDef: MethodDefinition =>
            if (checkReflexivity(methodDef, context))
            {
                methodDef.tags = "prop:reflexive" :: methodDef.tags
                Logger.log(Severity.Info, s"Method '${methodDef.name}' is reflexive", methodDef.lineNumber)
            }
            else
            {
                Logger.log(Severity.Info, s"Method '${methodDef.name}' is NOT reflexive", methodDef.lineNumber)
            }
            methodDef
        case _ => programDefinition
    }

    def checkReflexivity(methodDef: MethodDefinition, context: ProgramContext): Boolean = methodDef match
    {
        case MethodDefinition(_, BoolType, List(leftOp, rightOp), Return(retExp) :: Nil) if leftOp.typeId == rightOp.typeId =>
            val ctx = new z3.Context()
            val converter = new SyntaxTreeToZ3Converter(ctx, Program(context))
            val methodExp: z3.Expr = converter.convertExpression(retExp, List(leftOp, rightOp))

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

            prove(ctx, check)
        case _ => false
    }
}
