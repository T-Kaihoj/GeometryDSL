package optimizer

import syntaxTree.{Program, ProgramTransformer}

object MasterOptimizer extends ProgramTransformer
{
    var programOptimizers: List[ProgramTransformer] = List(
        ReflexiveMethodCallRemover
    )

    override def transform(program: Program): Program =
    {
        programOptimizers.foldLeft[Program](program)((program, optimizer) => optimizer.transform(program))
    }
}
