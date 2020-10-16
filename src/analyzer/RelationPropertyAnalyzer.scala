package analyzer

import syntaxTree._
import logger.{Logger, Severity}

trait RelationPropertyAnalyzer extends ProgramDefinitionTransformer
{
    /**
     * Name of the property
     */
    def relation: String

    /**
     * Checks relation for its property.
     * @return Some(true) if the relation has the given property.
     *         Some(false) if the relation does not have the given property.
     *         None if it undetermined whether the relation has the given property.
     */
    def checkRelation(methodDef: MethodDefinition, context: ProgramContext): Option[Boolean]

    def tag: String = "prop:" + relation

    override def transform(programDefinition: ProgramDefinition, context: ProgramContext): ProgramDefinition =
    {
        programDefinition match
        {
            case m: MethodDefinition => transform(m, context)
            case _ => programDefinition
        }
    }

    def transform(methodDef: MethodDefinition, context: ProgramContext): MethodDefinition =
    {
        checkRelation(methodDef, context) match
        {
            case Some(true) =>
                methodDef.tags = tag :: methodDef.tags
                logger.Logger.log(logger.Severity.Info, s"Method '${methodDef.name}' is " + relation, methodDef.lineNumber)
            case Some(false) => Logger.log(Severity.Info,s"Method '${methodDef.name}' is NOT " + relation, methodDef.lineNumber)
            case None => Logger.log(Severity.Info, s"Undetermined whether '${methodDef.name}' is " + relation, methodDef.lineNumber)
        }
        methodDef
    }
}
