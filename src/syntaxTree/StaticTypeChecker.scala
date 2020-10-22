package syntaxTree

import logger.{Logger, Severity}

object StaticTypeChecker
{
    var program :Program = null
    def check(p: Program): Unit =
    {
        program =p;
        p.programDefinitions.foreach(pd => check(pd))
    }

    def check(programDefinition: ProgramDefinition): Unit = programDefinition match
    {
        case typeDef: TypeDefinition => check(typeDef)
        case methodDef: MethodDefinition => check(methodDef)
        case valueDef: ValueDefinition => check(valueDef)
    }

    def check(typeDefinition: TypeDefinition): Unit = typeDefinition match
    {
        case TypeDefinition(typeName, _, invariant) =>
            TypeOfHelp.getTypeOf(invariant, Nil) match
            {
                case None =>
                    Logger.log(
                        Severity.Info,
                        s"Could not determine resulting type of invariant for '${typeToString(ObjectType(typeName))}' type",
                        typeDefinition.lineNumber)
                case Some(BoolType) =>  // Nothing
                    //todo ask what this is
                case Some(resType) if resType != BoolType =>
                    Logger.log(
                        Severity.Error,
                        s"Invariant for type * $typeName' does not result in value of type '${typeToString(BoolType)}' but instead results in value of type '${typeToString(resType)}'",
                        typeDefinition.lineNumber)
            }
    }

    def check(methodDefinition: MethodDefinition): Unit = methodDefinition match
    {
        case MethodDefinition(name, retType, _, block) => block.last match
        {
            case Return(exp) =>
                val expResType: Type = TypeOfHelp.getTypeOf (exp, getProgramContext(name,program.programDefinitions,Nil)).getOrElse({Logger.log(Severity.Warning, s"Unable to determine, return type in '${name}' ", methodDefinition.lineNumber)
                NoType
                })
                if(expResType != NoType && expResType != retType )
                {
                    Logger.log(Severity.Error, s"Method '$name' does not return a value of type '${typeToString(retType)}' but instead returns '${typeToString(expResType)}'", methodDefinition.lineNumber)
                }
                check(block)
        }
    }

    def typeExists(typeId: Type) :Boolean = typeId match
    {
        case BoolType => true
        case IntType =>true
        case RealType =>true
        case SetType =>true
        case ObjectType(typeName) => program.programDefinitions.exists(p => p match
        {
            case TypeDefinition(name, fields, invariant) => name == typeName
            case MethodDefinition(name, retType, params, block) =>false
            case ValueDefinition(decl, exp) =>false
        })
    }

    def check(valueDefinition: ValueDefinition): Unit = valueDefinition match
    {
        case ValueDefinition(ValueDeclaration(name, typeId), exp) =>
            val expResType = TypeOfHelp.getTypeOf(exp,getProgramContext(name,program.programDefinitions, Nil)).getOrElse({
                Logger.log(Severity.Warning, s"Unable to determine, Type in '${name}' ", valueDefinition.lineNumber)
                NoType
            })
            if(expResType != typeId)
            {
                Logger.log(Severity.Error, s"Value '$name' is not assigned a value of type '${typeToString(typeId)}' but is instead assigned a value of type '${typeToString(expResType)}'", valueDefinition.lineNumber)
            }
            if( !typeExists(typeId))
            Logger.log(Severity.Error, s"Type '${typeToString(typeId)}' does not exist", valueDefinition.lineNumber)
    }

    def check(block: Block): Unit = block match
    {
        case head :: tail => check(head); check(tail)
        case Nil =>
    }

    def check(statement: Statement): Unit = statement match
    {
        case valueDefinition: ValueDefinition => check(valueDefinition)
        case conditional: Conditional => check(conditional)
        case Return(exp) => check(exp, statement.lineNumber)
        case _ =>
    }

    def check(conditional: Conditional): Unit = conditional match
    {
        case Conditional(condition, _, _) =>
            TypeOfHelp.getTypeOf(condition, Nil) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of conditional",
                    conditional.lineNumber
                )
                case Some(BoolType) => // Nothing
                case Some(condType) if condType != BoolType => Logger.log(
                    Severity.Error,
                    s"Condition does not result in a '${typeToString(BoolType)}' but instead a '${typeToString(condType)}'",
                    conditional.lineNumber
                )

                    check(condition, conditional.lineNumber)
            }
    }

    def check(expression: Expression, lineNumber: Int): Unit = expression match
    {
        case NoValueLiteral() =>
        case BoolLiteral(_) =>
        case IntLiteral(_) =>
        case RealLiteral(_) =>
        case SetLiteral(_) =>
        case Identifier(_) =>
        case memberAccess: MemberAccess => check(memberAccess, lineNumber)
        case typeCheck: TypeCheck =>
        case setComprehension: SetComprehension => check(setComprehension, lineNumber)
        case Operation(_, _) =>
    }

    def check(memberAccess: MemberAccess, lineNumber: Int): Unit = memberAccess match
    {
        case MemberAccess(exp, _) =>
            TypeOfHelp.getTypeOf(exp, Nil) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of member access expression",
                    lineNumber)
                case Some(ObjectType(_)) => // Check whether the specified type has a field with the correct name.
                case Some(typeId) => Logger.log(
                    Severity.Error,
                    s"Member access expression does not result in a value of the correct type but instead '${typeToString(typeId)}'",
                    lineNumber)
            }
            check(exp, lineNumber)
    }

    def check(typeCheck: TypeCheck, lineNumber: Int): Unit = typeCheck match
    {
        case TypeCheck(exp, _) => check(exp, lineNumber)
    }

    def check(setComprehension: SetComprehension, lineNumber: Int): Unit = setComprehension match
    {
        case SetComprehension(ElementDefinition(_, exp), condition, _) =>
            TypeOfHelp.getTypeOf(exp, Nil) match
            {
                case None =>
                case Some(resType) if resType != SetType =>
            }

            TypeOfHelp.getTypeOf(condition, Nil) match
            {
                case None => Logger.log(
                    Severity.Info,
                    s"Could not determine resulting type of conditional",
                    lineNumber
                )
                case Some(BoolType) => // Nothing
                case Some(condType) if condType != BoolType => Logger.log(
                    Severity.Error,
                    s"Condition does not result in a '${typeToString(BoolType)}' but instead a '${typeToString(condType)}'",
                    lineNumber
                )
            }
    }

    private def getProgramContextMethod(params: List[ValueDeclaration], block: Block, context:List[ProgramDefinition]): ProgramContext = block match
    {
        case ::(head, next) => head match
        {
            case (valDef: ValueDefinition) => getProgramContextMethod(params,next,valDef::context)
            case Conditional(condition, trueBlock, falseBlock) =>getProgramContextMethod(params,next,context)
            case _ =>getProgramContextMethod(params,next,context)
        }
        case Nil =>params.map(f => ValueDefinition(f,Identifier(f.name)))++ context
    }

    def getProgramContext(method: String, program: List[ProgramDefinition], context:ProgramContext): ProgramContext = program match
    {
        case ::(head, next) => head match
        {
            case MethodDefinition(name,retType , params, block) if name == method => getProgramContext(name,next,MethodDefinition(name,retType , params, block)::getProgramContextMethod(params, block, context))
            case (methodDef: MethodDefinition)  => getProgramContext(method,next,methodDef::context)
            case (valDef: ValueDefinition)  =>getProgramContext(method,next,valDef::context)
            case (typeDef:TypeDefinition) => getProgramContext(method,next,typeDef::context)
        }
        case Nil => context
    }

}
