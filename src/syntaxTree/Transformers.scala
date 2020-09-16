package syntaxTree

/**
 *
 */
trait ProgramTransformer
{
    def transform(program: Program): Program
}

/**
 *
 */
trait ProgramDefinitionTransformer extends ProgramTransformer
{
    def transform(program: Program, programDefinition: ProgramDefinition): ProgramDefinition

    override def transform(program: Program): Program =
    {
        Program(program.program.map(pd => transform(program, pd)))
    }
}

/**
 *
 */
trait BlockTransformer extends ProgramDefinitionTransformer
{
    def transform(program: Program, block: Block): Block

    override def transform(program: Program, progDef: ProgramDefinition): ProgramDefinition = progDef match
    {
        case TypeDefinition(name, fields) => TypeDefinition(name, fields)
        case MethodDefinition(name, retType, params, block) => MethodDefinition(name, retType, params, transform(program, block))
        case ValueDefinition(decl, exp) => ValueDefinition(decl, exp)
    }
}

/**
 *
 */
trait StatementTransformer extends BlockTransformer
{
    def transform(program: Program, block: Block, statement: Statement): Statement

    override def transform(program: Program, block: Block): Block = block match
    {
        case head :: tail => transform(program, block, head) :: transform(program, tail)
        case Nil => Nil
    }
}

/**
 *
 */
trait ExpressionTransformer extends StatementTransformer
{
    def transform(program: Program, block: Block, statement: Statement, expression: Expression): Expression

    override def transform(program: Program, block: Block, statement: Statement): Statement = statement match
    {
        case ValueDefinition(decl, exp) => ValueDefinition(decl, transform(program, block, statement, exp))
        case Conditional(condition, trueBlock, falseBlock) => Conditional(transform(program, block, statement, condition),
                                                                          transform(program, trueBlock),
                                                                          transform(program, falseBlock))
        case Return(exp) => Return(transform(program, block, statement, exp))
        case _ => statement
    }
}

/**
 *
 */
trait OperationTransformer extends ExpressionTransformer
{
    def transform(program: Program, block: Block, statement: Statement, operation: Operation): Expression

    override def transform(program: Program, block: Block, statement: Statement, expression: Expression): Expression = expression match
    {
        case BoolLiteral(value) => BoolLiteral(value)
        case IntLiteral(value) => IntLiteral(value)
        case RealLiteral(value) => RealLiteral(value)
        case SetLiteral(values) => SetLiteral(values)
        case Identifier(name) => Identifier(name)
        case MemberAccess(exp, field) => MemberAccess(transform(program, block, statement, exp), field)
        case SetComprehension(ElementDefinition(name, exp), condition, application) => SetComprehension(
            ElementDefinition(name, transform(program, block, statement, exp)),
            transform(program, block, statement, condition),
            transform(program, block, statement, application))
        case Operation(operator, operands) => transform(program, block, statement, Operation(operator, operands))
    }
}
