package analyzer

import syntaxTree._
import com.microsoft.z3
import logger.{Logger, Message}

object ReflexivityTransformer extends syntaxTree.MethodDefinitionTransformer
{
    override def transform(program: Program, methodDef: MethodDefinition): MethodDefinition =
    {
        if(checkReflexivity(program, methodDef))
        {
            methodDef.tags = "prop:reflexive" :: methodDef.tags
            Logger.log(Message.Severity.Info, s"Method '${methodDef.name}' is reflexive", methodDef.lineNumber)
        }
        else
        {
            Logger.log(Message.Severity.Info, s"Method '${methodDef.name}' is NOT reflexive", methodDef.lineNumber)
        }

        methodDef
    }

    def checkReflexivity(program: Program, methodDef: MethodDefinition): Boolean = methodDef match
    {
        case MethodDefinition(_, BoolType, List(left, right), Return(retExp) :: Nil) =>
            val ctx = new z3.Context()
            val converter = new SyntaxTreeToZ3Converter(ctx, program)
            val methodExp: z3.Expr = converter.convertExpression(retExp, List(left, right))

            val typeName = left.typeId match
            {
                case ObjectType(typeName) => typeName
            }
            assert(converter.typeDefinitions.exists(td => td.name == typeName))

            val sort: z3.Sort = converter.sorts.find(s => s.getName.toString == typeName).get

            val check: z3.BoolExpr = ctx.mkForall(
                Array(sort),
                Array(ctx.mkSymbol("theObject")),
                methodExp
                    .substitute(ctx.mkConst(left.name, sort), ctx.mkConst("theObject", sort))
                    .substitute(ctx.mkConst(right.name, sort), ctx.mkConst("theObject", sort)),
                1,
                null, null, null, null)

            prove(ctx, check)
        case _ => false
    }
}
