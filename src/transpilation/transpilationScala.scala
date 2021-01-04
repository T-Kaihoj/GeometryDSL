package transpilation
import syntaxTree.{_}

object transpilationScala
{
    def operatorStringScala(o: syntaxTree.Operator): String = o match
    {
        case Add => "+";
        case Or => "or";
        case And => "and"
        case Div => "/"
        case Mul => "*"
        case Not => "not"
        case Pow => "**"
        case Sub => "-"
        case Equal => "=="
        case InSet => "InSet"
        case Union => "Union"
        case Subset => "Subset"
        case Implies => "Implies"
        case Negation => "Negation"
        case NotEqual => "!="
        case Intersect => "Intersect"
        case Difference => "Difference"
        case PropSubset => "PropSubset"
        case Cardinality => "Cardinality"
        case GreaterThan => ">"
        case LessThan => "<"
        case LessThanEqual =>"<="
        case Exists(element) => "Exists"
        case Forall(element) => "Forall"
        case GreaterThanEqual => ">="
        case MethodCall(name, argumentCount) => "MethodCall"
        case Choose(element) => "Choose"
    }

    def isIdentifierSet(name: String, block:Block): Boolean =
    {
        syntaxTree.TypeOfHelp.getTypeOf(Identifier(name), block.collect{case valDef: ValueDefinition => valDef}).getOrElse(false) match
        {
            case syntaxTree.SetType => true
            case _ => false
        }
    }
    def appendBlock(block:Block,values: List[syntaxTree.ValueDeclaration]): Block =
    {
        val valDefs: List[syntaxTree.Statement] = values.map(value => ValueDefinition(value, Identifier(value.name)))
        valDefs ::: block
    }

    def isConstructor(methodName:String, program:List[ProgramDefinition]): Boolean = program match
    {
        case MethodDefinition(name, retType, params, block):: _  if methodName == name => false
        case TypeDefinition(name, fields, _):: _ if methodName == name => true
        case _ :: rest  => isConstructor(methodName,rest)
    }

    def expressionisSetScala(o: syntaxTree.Expression, block:Block): Boolean = o match
    {
        case BoolLiteral(_) => false
        case IntLiteral(_) => false
        case RealLiteral(_) => false
        case SetLiteral(_) => true
        case Identifier(name) => isIdentifierSet(name, block)
        case MemberAccess(exp, _) => expressionisSetScala(exp, block)
        case TypeCheck(exp, _) => expressionisSetScala(exp, block)
        case SetComprehension(_, _, _) => true
        case Operation(operator, _) => operationisSetScala(operator)
    }

    def methodCallisSetScala(methodName:String, program:Program):List[Boolean] =
        {
            program.programDefinitions.collectFirst(p => p match
            {
                case MethodDefinition(name, retType, params, block) if methodName == name => params
                case TypeDefinition(name, fields, _) if methodName == name => fields
            })
        }.get.map(f => f.asInstanceOf[ValueDeclaration].typeId.getClass == SetType.getClass)

    def operationisSetScala(o: Operator): Boolean = o match
    {
        case Add => false;
        case Or => false;
        case And => false
        case Div => false
        case Mul => false
        case Not => false
        case Pow => false
        case Sub => false
        case Equal => false
        case InSet => false
        case Union => true
        case Subset => false
        case Implies => false
        case Negation => false
        case NotEqual => false
        case Intersect => true
        case Difference => true
        case PropSubset => false
        case Cardinality => false
        case GreaterThan => false
        case LessThan => false
        case LessThanEqual =>false
        case Exists(element) => false
        case Forall(element) => false
        case GreaterThanEqual => false
        case MethodCall(name, argumentCount) => false
    }

    def typeToString(typeId: Type): String = typeId match
    {
        case BoolType => "bool"
        case IntType => "int"
        case RealType => "RealNumbers"
        case SetType => "Set"
        case ObjectType(typeName) => typeName
    }
}