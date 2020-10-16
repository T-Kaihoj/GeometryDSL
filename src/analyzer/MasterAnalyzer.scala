package analyzer

import syntaxTree._

object MasterAnalyzer extends ProgramTransformer
{
    var programAnalyzers: List[ProgramTransformer] = List(
        ReflexivityTransformer,
        SymmetryTransformer,
        TransitivityTransformer
    )

    override def transform(program: Program): Program =
    {
        programAnalyzers.foldLeft[Program](program)((program, analyzer) => analyzer.transform(program))
    }
}
