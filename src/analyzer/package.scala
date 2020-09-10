import com.microsoft.z3._

package object analyzer
{
    def checkSatisfiability(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Status =
    {
        val solver: Solver = ctx.mkSolver()
        val params: Params = ctx.mkParams()

        // Dont know what this does, has only seen it been done with false.
        params.add("mbqi", false)

        solver.setParameters(params)
        assumptions.foreach(a => solver.add(a))
        solver.add(conjecture)

        solver.check()
    }

    def prove(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Boolean =
    {
        checkSatisfiability(ctx, ctx.mkNot(conjecture), assumptions:_*) match
        {
            case Status.UNKNOWN => false
            case Status.SATISFIABLE => false
            case Status.UNSATISFIABLE => true
        }
    }

    def disprove(ctx: Context, conjecture: BoolExpr, assumptions: BoolExpr*): Boolean =
    {
        checkSatisfiability(ctx, ctx.mkNot(conjecture), assumptions:_*) match
        {
            case Status.UNKNOWN => false
            case Status.SATISFIABLE => true
            case Status.UNSATISFIABLE => false
        }
    }
}
