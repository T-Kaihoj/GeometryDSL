package analyzer

import ast._
import com.microsoft.z3

object RelationChecker
{
    def checkRelations(program: Program): Program =
    {
        Program(program.program.map
        {
            case t: TypeDefinition => t
            case m: MethodDefinition => checkRelation(program, m)
            case v: ValueDefinition => v
        })
    }

    def checkRelation(program: Program, methodDef: MethodDefinition): MethodDefinition = methodDef match
    {
        case MethodDefinition(name, BoolType, params, block)
            if  params.length == 2 &&
                params.head.typeId == params.tail.head.typeId => if(checkReflexivity(program, params, block))
            {
                println(s"Method '${name}' is reflexive!")
            }
            else
            {
                println(s"Method '${name}' is NOT reflexive!")
            }; methodDef
        case _ => methodDef
    }

    def checkReflexivity(program: Program, params: List[ValueDeclaration], block: Block): Boolean =
    {
        val ctx = new z3.Context()
        val converter = new AstToZ3Converter(ctx, program)

        val expression: z3.BoolExpr = block match
        {
            case Return(exp) :: Nil => converter.convertExpression(reflexivityConjecture(ObjectType("Circle"), exp), params) match
            {
                case b: z3.BoolExpr => println(reflexivityConjecture(ObjectType("Circle"), exp)); b
                case _ => throw new Exception("Conversion does not result in a BoolExpr")
            }
            case (stm: Statement) :: _ => throw new Exception("checkReflexivity only works with a single return statement " + stm.info)
        }

        println(expression.toString)

        val assumption = ctx.mkBool(true)

        prove(ctx, expression)
    }

    def reflexivityConjecture(objType: ObjectType, exp: Expression): Expression =
    {
        val objectName: String = "theObject"
        Operation(Forall(ElementDefinition(objectName, Identifier(objType.typeName))), List(
            ast.AST.replaceExpression(
                ast.AST.replaceExpression(exp,
                    Identifier("a"),
                    Identifier(objectName)),
                Identifier("b"),
                Identifier(objectName))
        ))
    }

    def run(): Unit =
    {
        val ctx = new z3.Context()

        val circleConstructor =
            ctx.mkConstructor(
                "Circle",
                "Circle",
                Array("x", "yy", "r"),
                Array(ctx.mkRealSort, ctx.mkRealSort, ctx.mkRealSort),
                null)

        val circleSort: z3.DatatypeSort =
            ctx.mkDatatypeSort(ctx.mkSymbol("Circle"), Array(circleConstructor))

        val getX: z3.FuncDecl = circleSort.getAccessors()(0)(0)
        val getY: z3.FuncDecl = circleSort.getAccessors()(0)(1)
        val getR: z3.FuncDecl = circleSort.getAccessors()(0)(2)

        val intersects: z3.BoolExpr =
            ctx.mkNot(ctx.mkGt(
                ctx.mkAdd(
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getX, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                            ctx.mkApp(getX, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getX, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                            ctx.mkApp(getX, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr])),
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getY, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                            ctx.mkApp(getY, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getY, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                            ctx.mkApp(getY, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr]))),
                ctx.mkMul(
                    ctx.mkAdd(
                        ctx.mkApp(getR, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                        ctx.mkApp(getR, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr]),
                    ctx.mkAdd(
                        ctx.mkApp(getR, ctx.mkConst("a", circleSort)).asInstanceOf[z3.ArithExpr],
                        ctx.mkApp(getR, ctx.mkConst("b", circleSort)).asInstanceOf[z3.ArithExpr]))))

        val constCircle = ctx.mkConst("circle", circleSort)

        val conjecture = intersects
            .substitute(ctx.mkConst("a", circleSort), constCircle)
            .substitute(ctx.mkConst("b", circleSort), constCircle).asInstanceOf[z3.BoolExpr]

        println(prove(ctx, conjecture))
    }
}
