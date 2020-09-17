package analyzer

import syntaxTree._

object RelationChecker extends ProgramTransformer
{
    override def transform(program: Program): Program =
    {
        Program(program.programDefinitions.map
        {
            case m: MethodDefinition =>
                ReflexivityTransformer.transform(program,
                SymmetryTransformer.transform(m, program.programDefinitions))
            case x => x
        })
    }
}
