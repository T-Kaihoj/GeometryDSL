package analyzer

import syntaxTree._
import com.microsoft.z3

object SymmetryTransformer extends ProgramDefinitionTransformer
{
    override def transform(programDefinition: ProgramDefinition, context: ProgramContext): ProgramDefinition = programDefinition match
    {
        case m: MethodDefinition => transform(m, context)
        case _ => programDefinition
    }

    def transform(methodDef: MethodDefinition, context: ProgramContext): MethodDefinition =
    {
        checkSymmetry(Program(context), methodDef) match
        {
            case Some(true) =>
                logger.Logger.log(logger.Severity.Info, s"Method '${methodDef.name}' is symmetric", methodDef.lineNumber)
                methodDef.tags=  "prop:symmetric" :: methodDef.tags
            case Some(false) =>
                logger.Logger.log(logger.Severity.Info,s"Method '${methodDef.name}' is NOT symmetric", methodDef.lineNumber)
            case None =>
                logger.Logger.log(logger.Severity.Info,s"Was not able determine whether '${methodDef.name}' is symmetric", methodDef.lineNumber)
        }

        methodDef
    }

    def checkSymmetry(program: Program, methodDef: MethodDefinition): Option[Boolean] = methodDef match
    {
        case MethodDefinition(_, BoolType, List(left, right), Return(retExp) :: Nil) if left.typeId == right.typeId =>
            val ctx = new z3.Context()
            val converter = new SyntaxTreeToZ3Converter(ctx, program)


            val methodExp: z3.Expr =
                try
                {
                    converter.convertExpression(retExp, List(left, right))
                }
                catch
                {
                    case _: Exception => return None
                }

            val typeName = left.typeId match
            {
                case ObjectType(typeName) => typeName
            }
            assert(converter.typeDefinitions.exists(td => td.name == typeName))

            val sort: z3.Sort = converter.sorts.find(s => s.getName.toString == typeName).get

            val leftSub = ctx.mkSymbol("left")
            val rightSub = ctx.mkSymbol("right")

            val methodExpLeftRight = methodExp
                .substitute(ctx.mkConst(left.name, sort), ctx.mkConst(leftSub, sort))
                .substitute(ctx.mkConst(right.name, sort), ctx.mkConst(rightSub, sort)).asInstanceOf[z3.BoolExpr]
            val methodExpRightLeft = methodExp
                .substitute(ctx.mkConst(left.name, sort), ctx.mkConst(rightSub, sort))
                .substitute(ctx.mkConst(right.name, sort), ctx.mkConst(leftSub, sort)).asInstanceOf[z3.BoolExpr]

            val check: z3.BoolExpr = ctx.mkForall(
                Array(sort, sort),
                Array(leftSub, rightSub),
                ctx.mkAnd(
                    ctx.mkImplies(methodExpLeftRight, methodExpRightLeft),
                    ctx.mkImplies(methodExpRightLeft, methodExpLeftRight)),
                1,
                null, null, null, null)

            Some(prove(ctx, check))
        case _ => Some(false)
    }
}
