package syntaxTree

trait ProgramTransformer{ def transform(program: Program): Program }

trait MethodDefinitionTransformer { def transform(program: Program, methodDef: MethodDefinition): MethodDefinition }
trait TypeDefinitionTransformer { def transform(program: Program, methodDef: TypeDefinition): TypeDefinition }
trait ValueDefinitionTransformer { def transform(program: Program, methodDef: ValueDefinition): ValueDefinition }

trait StatementTransformer { def transform(program: Program, block: Block, methodDef: Statement): Statement }
trait ExpressionTransformer { def transform(program: Program, block: Block, methodDef: Expression): Expression }
