import com.microsoft.z3._

package object analyser
{
    def check(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Status =
    {
        val solver: Solver = ctx.mkSolver()
        val params: Params = ctx.mkParams()

        // Dont know what this does, has only seen it been done with false.
        params.add("mbqi", false)

        solver.setParameters(params)
        assumptions.foreach(a => solver.add(a))
        solver.add(ctx.mkNot(conjecture))

        solver.check()
    }

    def prove(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Boolean =
    {
        check(ctx, conjecture, assumptions:_*) match
        {
            case Status.UNKNOWN => false
            case Status.SATISFIABLE => false
            case Status.UNSATISFIABLE => true
        }
    }

    def disprove(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Boolean =
    {
        check(ctx, conjecture, assumptions:_*) match
        {
            case Status.UNKNOWN => false
            case Status.SATISFIABLE => true
            case Status.UNSATISFIABLE => false
        }
    }

    def typeToSort(ctx: Context, typeId: ast.Type): com.microsoft.z3.Sort = typeId match
    {
        case ast.BoolType => ctx.mkBoolSort
        case ast.IntType => ctx.mkIntSort
        case ast.RealType => ctx.mkRealSort
        case ast.SetType => ctx.mkRealSort()
        case ast.ObjectType(typeName) => ctx.mkDatatypeSort(typeName, Array())
    }
}
