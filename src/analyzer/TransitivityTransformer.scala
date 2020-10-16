package analyzer

import syntaxTree._
import com.microsoft.z3

object TransitivityTransformer extends ProgramDefinitionTransformer
{
        override def transform(programDefinition: ProgramDefinition, context: ProgramContext): ProgramDefinition = programDefinition match
        {
                case m: MethodDefinition => transform(m, context)
                case _ => programDefinition
        }

        def transform(methodDef: MethodDefinition, context: ProgramContext): MethodDefinition =
        {
                if(checkTransitivity(Program(context), methodDef))
                {
                        logger.Logger.log(logger.Severity.Info, s"Method '${methodDef.name}' is Transitivity", methodDef.lineNumber)
                        methodDef.tags=  "prop:Transitivity" :: methodDef.tags
                }
                else
                {
                        logger.Logger.log(logger.Severity.Info,s"Method '${methodDef.name}' is NOT Transitivity", methodDef.lineNumber)
                }

                methodDef
        }

        def checkTransitivity(program: Program, methodDef: MethodDefinition): Boolean = methodDef match
        {

                case MethodDefinition(_, BoolType, List(left, right), Return(retExp) :: Nil) if left.typeId == right.typeId =>
                        val ctx = new z3.Context()
                        val converter = new SyntaxTreeToZ3Converter(ctx, program)
                        val methodExp: z3.Expr = converter.convertExpression(retExp, List(left, right))

                        val typeName = left.typeId match
                        {
                                case ObjectType(typeName) => typeName
                        }
                        assert(converter.typeDefinitions.exists(td => td.name == typeName))

                        val sort: z3.Sort = converter.sorts.find(s => s.getName.toString == typeName).get

                        val ab = methodExp
                            .substitute(ctx.mkConst(left.name, sort), ctx.mkConst("a", sort))
                            .substitute(ctx.mkConst(right.name, sort), ctx.mkConst("b", sort)).asInstanceOf[z3.BoolExpr]
                        val bc = methodExp
                            .substitute(ctx.mkConst(left.name, sort), ctx.mkConst("b", sort))
                            .substitute(ctx.mkConst(right.name, sort), ctx.mkConst("c", sort)).asInstanceOf[z3.BoolExpr]
                        val ac = methodExp
                            .substitute(ctx.mkConst(left.name, sort), ctx.mkConst("a", sort))
                            .substitute(ctx.mkConst(right.name, sort), ctx.mkConst("c", sort)).asInstanceOf[z3.BoolExpr]

                        val check: z3.BoolExpr = ctx.mkImplies(ctx.mkAnd(ab, bc),  ac);


                        prove(ctx, check)
                case _ => false
        }
}
