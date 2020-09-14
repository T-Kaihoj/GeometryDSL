package analyzer

import syntaxTree._
import com.microsoft.z3

object RelationChecker
{
    def checkRelations(program: Program): Program =
    {
        Program(program.program.map
        {
            case t: TypeDefinition => t
            case m: MethodDefinition => checkMethodReflexivity(program, m)
            case v: ValueDefinition => v
        })
    }

    def checkMethodReflexivity(program: Program, methodDefinition: MethodDefinition): MethodDefinition = methodDefinition match
    {
        case MethodDefinition(name, retType, params, block)
            if params.length == 2 &&
               params.head.typeId == params.tail.head.typeId =>
            block match
            {
                case Return(retExp) :: Nil =>
                    val ctx = new z3.Context()
                    val converter = new SyntaxTreeToZ3Converter(ctx, program)
                    val methodExp: z3.Expr = converter.convertExpression(retExp, params)

                    val typeName: String = converter.typeDefinitions.find(td => td.name == (params.head.typeId match
                    {
                        case ObjectType(name) => name
                    })).get.name

                    val sort: z3.Sort = converter.sorts.find(s => s.getName.toString == typeName).get

                    val forall: z3.BoolExpr = ctx.mkForall(
                        Array(sort),
                        Array(ctx.mkSymbol("theObject")),
                        methodExp
                            .substitute(ctx.mkConst(params.head.name, sort), ctx.mkConst("theObject", sort))
                            .substitute(ctx.mkConst(params.tail.head.name, sort), ctx.mkConst("theObject", sort)),
                        1,
                        Array(),
                        null, null, null)

                    if(prove(ctx, forall)) {println(s"Relation '${name}' is reflexive!")}
                    else {println(s"Relation '${name}' is NOT reflexive!")}

                case _ => MethodDefinition(name, retType, params, block)
            }

            MethodDefinition(name, retType, params, block)
        case x => x
    }
}
