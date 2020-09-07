package analyser

import ast._
import com.microsoft.z3._

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
                params.head.typeId == params.tail.head.typeId => checkReflexivity(program, params, block); methodDef
        case _ => methodDef
    }

    def checkReflexivity(program: Program, params: List[ValueDeclaration], block: Block): Unit =
    {
        val paramNames = params.map(p => p.name)
        val paramTypes = params.map(p => p.typeId)
        val ctx = new Context()
        val converter = new AstToZ3Converter(ctx, program)

        block match
        {
            case Return(exp) :: Nil => converter.convert(exp, params)
            case (stm: Statement) :: _ => throw new Exception("checkReflexivity only works with a single return statement " + stm.info)
        }
    }

    def run(): Unit =
    {
        val ctx = new Context()

        val circleConstructor =
            ctx.mkConstructor(
                "Circle",
                "Circle",
                Array("x", "yy", "r"),
                Array(ctx.mkRealSort, ctx.mkRealSort, ctx.mkRealSort),
                null)

        val circleSort: DatatypeSort =
            ctx.mkDatatypeSort(ctx.mkSymbol("Circle"), Array(circleConstructor))

        val getX: FuncDecl = circleSort.getAccessors()(0)(0)
        val getY: FuncDecl = circleSort.getAccessors()(0)(1)
        val getR: FuncDecl = circleSort.getAccessors()(0)(2)

        val intersects: BoolExpr =
            ctx.mkNot(ctx.mkGt(
                ctx.mkAdd(
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getX, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                            ctx.mkApp(getX, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getX, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                            ctx.mkApp(getX, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr])),
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getY, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                            ctx.mkApp(getY, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getY, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                            ctx.mkApp(getY, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr]))),
                ctx.mkMul(
                    ctx.mkAdd(
                        ctx.mkApp(getR, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                        ctx.mkApp(getR, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr]),
                    ctx.mkAdd(
                        ctx.mkApp(getR, ctx.mkConst("a", circleSort)).asInstanceOf[ArithExpr],
                        ctx.mkApp(getR, ctx.mkConst("b", circleSort)).asInstanceOf[ArithExpr]))))

        val constCircle = ctx.mkConst("circle", circleSort)

        val conjecture = intersects
            .substitute(ctx.mkConst("a", circleSort), constCircle)
            .substitute(ctx.mkConst("b", circleSort), constCircle).asInstanceOf[BoolExpr]

        println(prove(ctx, conjecture))
    }
}
