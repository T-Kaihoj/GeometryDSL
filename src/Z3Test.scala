import com.microsoft.z3._

import scala.collection.mutable
import scala.jdk.javaapi.CollectionConverters

object Z3Test
{
    val x: String =
        "(declare-const x Real)\n" +
        "(define-fun conjecture () Bool\n" +
        "    (= (^ x 2) x)\n" +
        ")\n" +
        "\n" +
        "(assert (not conjecture))\n" +
        "(check-sat) ; Should be sat, as it is not valid\n" +
        "(get-model)\n"

    def run(): Unit =
    {
        val cfg = CollectionConverters.asJava(new mutable.HashMap[String, String])
        cfg.put("model", "true")
        val ctx: Context = new Context(cfg)

        //quantifierExample1(ctx)
        //quantifierExample2(ctx)
        //quantifierExample3(ctx)
        //parserExample1(ctx)
        //treeExample(ctx)
        //forrestExample(ctx)
        //translationExample()
        circleIntersection(ctx)
        improvedCircleIntersection(ctx)

    }

    def prove(ctx: Context, f: BoolExpr, useMBQI: Boolean, assumptions: BoolExpr*): Unit =
    {
        println("Proving: " + f)
        val s: Solver = ctx.mkSolver()
        val p: Params = ctx.mkParams()
        p.add("mbqi", useMBQI)
        s.setParameters(p)
        assumptions.foreach(a => s.add(a))
        s.add(ctx.mkNot(f))
        val q: Status = s.check()

        q match
        {
            case Status.UNKNOWN => println("Unknown because: " + s.getReasonUnknown)
            case Status.SATISFIABLE => throw new Exception("Test failed")
            case Status.UNSATISFIABLE => println("OK, proof: ")
        }
    }

    def disprove(ctx: Context, f: BoolExpr, useMBQI: false, assumptions: BoolExpr*): Unit =
    {
        println("Disproving: " + f)
        val s: Solver = ctx.mkSolver()
        val p: Params = ctx.mkParams()
        p.add("mbqi", useMBQI)
        assumptions.foreach(a => s.add(a))
        s.add(ctx.mkNot(f))
        val q: Status = s.check()

        q match
        {
            case Status.UNKNOWN => print("Unknown because: " + s.getReasonUnknown)
            case Status.SATISFIABLE => println("OK, model: " + s.getModel)
            case Status.UNSATISFIABLE => throw new Exception("Test failed")
        }
    }

    def check(ctx: Context, f: BoolExpr, sat: Status): Model =
    {
        val s: Solver = ctx.mkSolver()
        s.add(f)
        if(s.check() != sat)
        {
            throw new Exception
        }

        if(sat == Status.SATISFIABLE)
        {
            s.getModel
        }
        else
        {
            null
        }
    }

    def injAxiom(ctx: Context, f: FuncDecl, i: Int): BoolExpr =
    {
        val domain: Array[Sort] = f.getDomain
        val domainSize: Int = f.getDomainSize

        if(i >= domainSize)
        {
            println("failed to create inj axiom")
            return null
        }

        val finv_domain: Sort = f.getRange
        val finv_range: Sort = domain(i)
        val finv: FuncDecl = ctx.mkFuncDecl("f_fresh", finv_domain, finv_range)

        val xs: Array[Expr] = new Array[Expr](domainSize)
        val names: Array[Symbol] = new Array[Symbol](domainSize)
        val types: Array[Sort] = new Array[Sort](domainSize)


        for(j <- 0 until domainSize)
        {
            types(j) = domain(j)
            names(j) = ctx.mkSymbol("x_" + Integer.toString(j))
            xs(j) = ctx.mkBound(j, types(j))
        }

        val x_i: Expr = xs(i)
        val fxs: Expr = f.apply(xs:_*)
        val finv_fxs: Expr = finv.apply(fxs)
        val eq: Expr = ctx.mkEq(finv_fxs, x_i)
        val p: Pattern = ctx.mkPattern(fxs)
        val q: BoolExpr = ctx.mkForall(types, names, eq, 1, Array(p), null, null, null)
        q
    }

    def quantifierExample1(ctx: Context): Unit =
    {
        println("--- Quantifier Example 1 ---")

        val types: Array[Sort] = new Array[Sort](3)
        val xs: Array[IntExpr] = new Array[IntExpr](3)
        val names: Array[Symbol] = new Array[Symbol](3)
        val vars: Array[IntExpr] = new Array[IntExpr](3)

        for(i <- 0 until 3)
        {
            types(i) = ctx.getIntSort
            names(i) = ctx.mkSymbol("x_" + Integer.toString(i))
            xs(i) = ctx.mkConst(names(i), types(i)).asInstanceOf[IntExpr]
            vars(i) = ctx.mkBound(2 - i, types(i)).asInstanceOf[IntExpr]
        }

        val body_vars: Expr = ctx.mkAnd(
            ctx.mkEq(ctx.mkAdd(vars(0), ctx.mkInt(1)), ctx.mkInt(2)),
            ctx.mkEq(ctx.mkAdd(vars(1), ctx.mkInt(2)), ctx.mkAdd(vars(2), ctx.mkInt(3))))

        val body_const: Expr = ctx.mkAnd(
            ctx.mkEq(ctx.mkAdd(xs(0), ctx.mkInt(1)), ctx.mkInt(2)),
            ctx.mkEq(ctx.mkAdd(xs(1), ctx.mkInt(2)), ctx.mkAdd(xs(2), ctx.mkInt(3))))

        val x: Expr = ctx.mkForall(types, names, body_vars, 1, null, null, ctx.mkSymbol("Q1"), ctx.mkSymbol("skid1"))
        println("Quantifier X: " + x.toString)

        val y: Expr = ctx.mkForall(xs.asInstanceOf[Array[Expr]], body_const, 1, null, null, ctx.mkSymbol("Q2"), ctx.mkSymbol("skid2"))
        println("Qunatifier Y: " + y.toString)
    }

    def quantifierExample2(ctx: Context): Unit =
    {
        println("--- Quantifier Example 2 ---")

        var q1, q2: Expr = null
        val f: FuncDecl = ctx.mkFuncDecl("f", ctx.getIntSort, ctx.getIntSort)
        val g: FuncDecl = ctx.mkFuncDecl("g", ctx.getIntSort, ctx.getIntSort)

        {
            val x: Expr = ctx.mkConst("x", ctx.getIntSort)
            val y: Expr = ctx.mkConst("y", ctx.getIntSort)
            val f_x: Expr = ctx.mkApp(f, x)
            val f_y: Expr = ctx.mkApp(f, y)
            val g_y: Expr = ctx.mkApp(g, y)

            //val pats: Array[Pattern] = Array(ctx.mkPattern(f_x, g_y))
            val no_pats: Array[Expr] = Array(f_y)
            val bound: Array[Expr] = Array(x, y)
            val body: Expr = ctx.mkAnd(ctx.mkEq(f_x, f_y), ctx.mkEq(f_x, g_y))

            q1 = ctx.mkForall(bound, body, 1, null, no_pats, ctx.mkSymbol("q"), ctx.mkSymbol("sk"))

            println(q1)
        }

        {
            val x: Expr = ctx.mkBound(1, ctx.getIntSort)
            val y: Expr = ctx.mkBound(0, ctx.getIntSort)
            val f_x: Expr = ctx.mkApp(f, x)
            val f_y: Expr = ctx.mkApp(f, y)
            val g_y: Expr = ctx.mkApp(g, y)

            val no_pats: Array[Expr] = Array(f_y)
            val names: Array[Symbol] = Array(ctx.mkSymbol("x"), ctx.mkSymbol("y"))
            val sorts: Array[Sort] = Array(ctx.getIntSort, ctx.getIntSort)
            val body: Expr = ctx.mkAnd(ctx.mkEq(f_x, f_y), ctx.mkEq(f_y, g_y))

            q2 = ctx.mkForall(sorts, names, body, 1, null, no_pats, ctx.mkSymbol("q"), ctx.mkSymbol("sk"))

            println(q2)
        }

        println(q1.equals(q2))
    }

    def quantifierExample3(ctx: Context): Unit =
    {
        println("--- Quantifier Example 3 ---")

        val I: Sort = ctx.getIntSort
        val f: FuncDecl = ctx.mkFuncDecl("f", Array(I, I), I)

        val inj: BoolExpr = injAxiom(ctx, f, 1)

        val x: Expr = ctx.mkIntConst("x")
        val y: Expr = ctx.mkIntConst("y")
        val v: Expr = ctx.mkIntConst("v")
        val w: Expr = ctx.mkIntConst("w")
        val fxy: Expr = ctx.mkApp(f, x ,y)
        val fwv: Expr = ctx.mkApp(f, w, v)

        val p1: BoolExpr = ctx.mkEq(fxy, fwv)

        val p2: BoolExpr = ctx.mkEq(y, v)
        //prove(ctx, p2, false, Array(inj, p1):_*)

        val p3: BoolExpr = ctx.mkEq(x ,w)
        //disprove(ctx, p3, false, Array(inj, p1):_*)
    }

    def parserExample1(ctx: Context): Unit =
    {
        println("--- Parser Example 1 ---")

        // IMPORTANT: string has to include an assert statement
        val f: BoolExpr = ctx.parseSMTLIB2String(
            "(declare-const x Int) (declare-const y Int) (assert (and (> x y) (> x 0)))",
            null, null,null,null)(0)
        println("formula " + f)

        val m: Model = check(ctx, f, Status.SATISFIABLE)
    }

    def treeExample(ctx: Context): Unit =
    {
        println("--- Tree Example ---")

        val head_tail: Array[String] = Array("car", "cdr")
        val sorts: Array[Sort] = Array(null, null)
        val sort_refs: Array[Int] = Array(0, 0)

        val nil_con = ctx.mkConstructor("nil", "is_nil", null, null, null)
        val cons_con = ctx.mkConstructor("cons", "is_cons", head_tail, sorts, sort_refs)

        val constructors: Array[Constructor] = Array(nil_con, cons_con)

        val cell: Sort = ctx.mkDatatypeSort("cell",  constructors)

        val nil_decl = nil_con.ConstructorDecl
        val is_nil_decl = nil_con.getTesterDecl
        val cons_decl = cons_con.ConstructorDecl
        val is_cons_decl = cons_con.getTesterDecl

        val cons_accessors = cons_con.getAccessorDecls
        val car_decl = cons_accessors(0)
        val cdr_decl = cons_accessors(1)

        val nil = ctx.mkConst(nil_decl)
        val l = ctx.mkApp(cons_decl, nil, nil)

        prove(ctx, ctx.mkNot(ctx.mkEq(nil, l)), false)

        val u = ctx.mkConst("u", cell)
        val v = ctx.mkConst("v", cell)
        val x = ctx.mkConst("x", cell)
        val y = ctx.mkConst("y", cell)
        val l1 = ctx.mkApp(cons_decl, x, u)
        val l2 = ctx.mkApp(cons_decl, y, v)
        prove(ctx, ctx.mkImplies(ctx.mkEq(l1, l2), ctx.mkEq(u, v)), false)
        prove(ctx, ctx.mkImplies(ctx.mkEq(l1, l2), ctx.mkEq(x, y)), false)

        prove(ctx, ctx.mkOr(ctx.mkApp(is_nil_decl, u).asInstanceOf[BoolExpr], ctx.mkApp(is_cons_decl, u).asInstanceOf[BoolExpr]), false)

        prove(ctx, ctx.mkNot(ctx.mkEq(u, l1)), false)

        val fml1 = ctx.mkEq(u, ctx.mkApp(cons_decl, ctx.mkApp(car_decl, u), ctx.mkApp(cdr_decl, u)))
        val fml = ctx.mkImplies(ctx.mkApp(is_cons_decl, u).asInstanceOf[BoolExpr], fml1)
        System.out.println("Formula " + fml)
        prove(ctx, fml, false)

        disprove(ctx, fml1, false)
    }

    def forrestExample(ctx: Context): Unit =
    {
        println("--- Forrest Example ---")

        val head_tail1: Array[Symbol] = Array(ctx.mkSymbol("head"), ctx.mkSymbol("tail"))
        val sorts1: Array[Sort] = Array(null, null)
        val sort1_refs: Array[Int] = Array(1, 0)

        val head_tail2: Array[Symbol] = Array(ctx.mkSymbol("car"), ctx.mkSymbol("cdr"))
        val sorts2: Array[Sort] = Array(null, null)
        val sort2_refs: Array[Int] = Array(0, 0)

        val sort_names: Array[Symbol] = Array(ctx.mkSymbol("forrest"), ctx.mkSymbol("tree"))

        val nil1_con = ctx.mkConstructor(ctx.mkSymbol("nil"), ctx.mkSymbol("is_nil"), null, null, null)
        val cons1_con = ctx.mkConstructor(ctx.mkSymbol("cons1"), ctx.mkSymbol("is_cons1"), head_tail1, sorts1, sort1_refs)

        val nil2_con = ctx.mkConstructor(ctx.mkSymbol("nil2"), ctx.mkSymbol("is_nil2"), null, null, null)
        val cons2_con = ctx.mkConstructor(ctx.mkSymbol("cons2"), ctx.mkSymbol("is_cons2"), head_tail2, sorts2, sort2_refs)

        val clists: Array[Array[Constructor]] = Array(Array(nil1_con, cons1_con), Array(nil2_con, cons2_con))

        val sorts: Array[Sort] = ctx.mkDatatypeSorts(sort_names, clists).asInstanceOf[Array[Sort]]
        val forest = sorts(0)
        val tree = sorts(1)

        val nil1_decl = nil1_con.ConstructorDecl()
        val is_nil1_decl = nil1_con.getTesterDecl
        val cons1_decl = cons1_con.ConstructorDecl()
        val is_cons1_decl = cons1_con.getTesterDecl
        val cons1_accessors = cons1_con.getAccessorDecls
        val car1_decl = cons1_accessors(0)
        val cdr1_decl = cons1_accessors(1)
    }

    def translationExample(): Unit =
    {
        val ctx1: Context = new Context()
        val ctx2: Context = new Context()

        val s1: Sort = ctx1.getIntSort
        val s2: Sort = ctx2.getIntSort
        val s3: Sort = s1.translate(ctx2)

        println(s1 == s2)
        println(s1.equals(s2))
        println(s2.equals(s3))
        println(s1.equals(s3))

        val e1: Expr = ctx1.mkIntConst("e1")
        val e2: Expr = ctx2.mkIntConst("e1")
        val e3: Expr = e1.translate(ctx2)

        println(e1 == e2)
        println(e1.equals(e2))
        println(e2.equals(e3))
        println(e1.equals(e3))
    }

    def circleIntersection(ctx: Context): Unit =
    {
        println("--- Circle Intersection Example ---")

        val func: BoolExpr = ctx.parseSMTLIB2String(
            "(declare-datatypes () ((Circle (Circle (x Real) (y Real) (r Real)))))" +
                "(define-fun intersects ((a Circle) (b Circle)) Bool (not (> (+ (* (- (x a) (x b)) (- (x a) (x b))) (* (- (y a) (y b)) (- (y a) (y b)))) (* (+ (r a) (r b)) (+ (r a) (r b))))))" +
                "(declare-const C Circle)" +
                "(assert (not (intersects C C)))",
            null,
            null,
            null,
            null)(0)

        println(func)

        val m: Model = check(ctx, func, Status.UNSATISFIABLE)
        println(m)
    }

    def improvedCircleIntersection(ctx: Context): Unit =
    {
        println("--- Improved Circle Intersection Example ---")

        val circleConstructor = ctx.mkConstructor(
            "Circle",
            "Circle",
            Array("x", "y", "r"),
            Array(ctx.mkRealSort, ctx.mkRealSort, ctx.mkRealSort),
            null)

        val circleSort: DatatypeSort = ctx.mkDatatypeSort(
            ctx.mkSymbol("Circle"), Array(circleConstructor))

        val getX: FuncDecl = circleSort.getAccessors()(0)(0)
        val getY: FuncDecl = circleSort.getAccessors()(0)(1)
        val getR: FuncDecl = circleSort.getAccessors()(0)(2)

        val intersectionFunc: FuncDecl = ctx.mkFuncDecl(
            ctx.mkSymbol("intersects"),
            Array(circleSort, circleSort).asInstanceOf[Array[Sort]],
            ctx.getBoolSort)

        val constCircle = ctx.mkConst("theCircle", circleSort)

        val x = ctx.mkApp(getX, constCircle)


        val intersects: BoolExpr =
            ctx.mkNot(ctx.mkGt(
                ctx.mkAdd(
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getX, constCircle).asInstanceOf[ArithExpr],
                            ctx.mkApp(getX, constCircle).asInstanceOf[ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getX, constCircle).asInstanceOf[ArithExpr],
                            ctx.mkApp(getX, constCircle).asInstanceOf[ArithExpr])),
                    ctx.mkMul(
                        ctx.mkSub(
                            ctx.mkApp(getY, constCircle).asInstanceOf[ArithExpr],
                            ctx.mkApp(getY, constCircle).asInstanceOf[ArithExpr]),
                        ctx.mkSub(
                            ctx.mkApp(getY, constCircle).asInstanceOf[ArithExpr],
                            ctx.mkApp(getY, constCircle).asInstanceOf[ArithExpr]))),
                ctx.mkMul(
                    ctx.mkAdd(
                        ctx.mkApp(getR, constCircle).asInstanceOf[ArithExpr],
                        ctx.mkApp(getR, constCircle).asInstanceOf[ArithExpr]),
                    ctx.mkAdd(
                        ctx.mkApp(getR, constCircle).asInstanceOf[ArithExpr],
                        ctx.mkApp(getR, constCircle).asInstanceOf[ArithExpr]))))

        val Oldintersects: BoolExpr =
            ctx.mkNot(ctx.mkGt(
                ctx.mkAdd(
                    ctx.mkMul(
                        ctx.mkSub(ctx.mkRealConst("ax"), ctx.mkRealConst("bx")),
                        ctx.mkSub(ctx.mkRealConst("ax"), ctx.mkRealConst("bx"))),
                    ctx.mkMul(
                        ctx.mkSub(ctx.mkRealConst("ay"), ctx.mkRealConst("by")),
                        ctx.mkSub(ctx.mkRealConst("ay"), ctx.mkRealConst("by")))
                ),
                ctx.mkMul(
                    ctx.mkAdd(ctx.mkRealConst("ar"), ctx.mkRealConst("br")),
                    ctx.mkAdd(ctx.mkRealConst("ar"), ctx.mkRealConst("br"))
                )))

        val conjecture = ctx.mkNot(intersects)

        disprove(ctx, conjecture, false)

        //println(intersectionFunc)
        //println(constCircle)

        //println(getX)
        //println(getY)
        //println(getR)
        //val circle = ctx.mkConst("C", ctx.mkSort)
    }
}
