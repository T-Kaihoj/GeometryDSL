package analyzer

import syntaxTree._

object RelationChecker extends ProgramTransformer
{
    override def transform(program: Program): Program =
    {
        Program(program.program.map
        {
            case m: MethodDefinition =>
                ReflexivityTransformer.transform(program,
                SymmetryTransformer.transform(program, m))
            case x => x
        })
    }
}
