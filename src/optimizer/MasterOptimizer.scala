package optimizer

import syntaxTree.{Program, ProgramTransformer}

object MasterOptimizer extends ProgramTransformer
{
    var programOptimizers: List[ProgramTransformer] = List(
        ReflexiveMethodCallRemover
    )

    def addOptimizer(programTransformer: ProgramTransformer): Unit =
    {
        programOptimizers = programTransformer :: programOptimizers
    }

    override def transform(program: Program): Program =
    {
        programOptimizers.foldLeft[Program](program)((program, optimizer) => optimizer.transform(program))
    }
}
