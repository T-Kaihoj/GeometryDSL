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
    def transform(programDefinition: ProgramDefinition, context: ProgramContext): ProgramDefinition

    override def transform(program: Program): Program =
    {
        def transformProgDefs(progDefs: List[ProgramDefinition], context: ProgramContext): ProgramContext = progDefs match
        {
            case head :: tail =>
                val newProgDef = transform(head, context)
                newProgDef :: transformProgDefs(tail, newProgDef :: context)
            case Nil => Nil
        }

        Program(transformProgDefs(program.programDefinitions, Nil))
    }
}

/**
 *
 */
trait BlockTransformer extends ProgramDefinitionTransformer
{
    def transform(block: Block, context: ProgramContext): Block

    override def transform(progDef: ProgramDefinition, context: ProgramContext): ProgramDefinition = progDef match
    {
        case methDef: MethodDefinition =>
            val newMethodDef = MethodDefinition(methDef.name, methDef.retType, methDef.params,
                transform(methDef.block, methDef.params.map(param => ValueDefinition(param, Identifier(param.name))) ++ context))
            // FIXME: The method parameters are passed along the context as references to them self (int a = a).
            //        This is kinda weird, but im not sure how fix it, as transforming a block might utilize the
            //        local variable in that block scope.
            newMethodDef.lineNumber = methDef.lineNumber
            newMethodDef.tags = methDef.tags
            newMethodDef
        case x => x
    }
}

/**
 *
 */
trait StatementTransformer extends BlockTransformer
{
    def transform(statement: Statement, context: ProgramContext): Statement

    override def transform(block: Block, context: ProgramContext): Block = block match
    {
        case (valDef: ValueDefinition) :: tail => transform(valDef, context) :: transform(tail, valDef :: context)
        case head :: tail => transform(head, context) :: transform(tail, context)
        case Nil => Nil
    }
}

/**
 *
 */
trait ExpressionTransformer extends StatementTransformer
{
    def transform(expression: Expression, context: ProgramContext): Expression

    override def transform(statement: Statement, context: ProgramContext): Statement = statement match
    {
        case valDef: ValueDefinition =>
            val newValDef = ValueDefinition(valDef.decl, transform(valDef.exp, context))
            newValDef.lineNumber = valDef.lineNumber
            newValDef.tags = valDef.tags
            newValDef
        case cond: Conditional =>
            val newCond = Conditional(transform(cond.condition, context),
                transform(cond.trueBlock, context),
                transform(cond.falseBlock, context))
            newCond.lineNumber = cond.lineNumber
            newCond.tags = cond.tags
            newCond
        case ret: Return =>
            val newRet = Return(transform(ret.exp, context))
            newRet.lineNumber = ret.lineNumber
            newRet.tags = ret.tags
            newRet
        case _ => statement
    }
}

/**
 *
 */
trait OperationTransformer extends ExpressionTransformer
{
    def transform(operation: Operation, context: ProgramContext): Expression

    override def transform(expression: Expression, context: ProgramContext): Expression = expression match
    {
        case BoolLiteral(value) => BoolLiteral(value)
        case IntLiteral(value) => IntLiteral(value)
        case RealLiteral(value) => RealLiteral(value)
        case SetLiteral(values) => SetLiteral(values)
        case Identifier(name) => Identifier(name)
        case MemberAccess(exp, field) => MemberAccess(transform(exp, context), field)
        case SetComprehension(ElementDefinition(name, exp), condition, application) =>
            SetComprehension(ElementDefinition(name, transform(exp, context)), transform(condition, context), transform(application, context))
        case Operation(operator, operands) => transform(Operation(operator, operands.map(op => transform(op, context))), context)
    }
}
