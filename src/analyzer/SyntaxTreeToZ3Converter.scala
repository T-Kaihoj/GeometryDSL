package analyzer

import com.microsoft.z3
import syntaxTree.{Expression, Identifier, MemberAccess, ObjectType, TypeDefinition, ValueDeclaration, ValueDefinition}

class SyntaxTreeToZ3Converter(ctx: z3.Context, program: syntaxTree.Program)
{
    val typeDefinitions: List[syntaxTree.TypeDefinition] = program.programDefinitions.collect
    {
        case typeDef: syntaxTree.TypeDefinition => typeDef
    }.reverse

    val sorts: List[z3.DatatypeSort] = typeDefinitions.foldLeft(Nil: List[z3.DatatypeSort])((sorts, typeDef) =>
    {
        val constructor = ctx.mkConstructor(
            typeDef.name, "mk" + typeDef.name, typeDef.fields.map(f => f.name).toArray,
            typeDef.fields.map(f => convertType(sorts, f.typeId).get).toArray, null)
        ctx.mkDatatypeSort(typeDef.name, Array(constructor)) :: sorts
    })

    val globalValues: List[syntaxTree.ValueDeclaration] = program.programDefinitions.collect
    {
        case syntaxTree.ValueDefinition(decl, _) => decl
    }

    def convertType(sorts:List[z3.DatatypeSort], typeId: syntaxTree.Type): Option[z3.Sort] = typeId match
    {
        case syntaxTree.BoolType => Some(ctx.mkBoolSort)
        case syntaxTree.IntType => Some(ctx.mkIntSort)
        case syntaxTree.RealType => Some(ctx.mkRealSort)
        case syntaxTree.SetType => throw new Exception("Cannot convert from SetType to Z3 equivalent")
        case syntaxTree.ObjectType(typeName) =>sorts.find(s => s.getName.toString == typeName)
    }

    def convertExpression(exp: syntaxTree.Expression, values: List[syntaxTree.ValueDeclaration]): z3.Expr = exp match
    {
        case syntaxTree.BoolLiteral(b) => ctx.mkBool(b)
        case syntaxTree.IntLiteral(i) => ctx.mkInt(i)
        case syntaxTree.RealLiteral(r) => ctx.mkReal(r.toString)
        case syntaxTree.SetLiteral(_) => throw new Exception("SetLiteral to Z3-Expr not supported")
        case syntaxTree.Identifier(name) => ctx.mkConst(name, convertType(sorts, values.find(v => v.name == name).get.typeId).get)
        case syntaxTree.MemberAccess(innerExp, field) => convertMemberAccess(innerExp, field, values).get
        case syntaxTree.TypeCheck(_, _) => throw new Exception("TypeCheck to Z3-Expr not supported")
        case syntaxTree.SetComprehension(_, _, _) => throw new Exception("SetComprehension to Z3-Expr not supported")
        case syntaxTree.Operation(operator, operands) => operator match
        {
            case syntaxTree.Negation => throw new Exception("Negation to Z3-Expr not supported")
            case syntaxTree.Not => ctx.mkNot(
                convertExpression(operands.head, values ++ globalValues).asInstanceOf[z3.BoolExpr])
            case syntaxTree.Cardinality => throw new Exception("Cardinality to Z3-Expr not supported")
            case syntaxTree.Forall(_) => throw new Exception("Forall to Z3-Expr not supported")
            case syntaxTree.Exists(_) => throw new Exception("Exists to Z3-Expr not supported")
            case syntaxTree.Add => ctx.mkAdd(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.Sub => ctx.mkSub(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.Mul => ctx.mkMul(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.Div => ctx.mkDiv(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.Pow => ctx.mkPower(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.Equal => ctx.mkEq(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.NotEqual => ctx.mkNot(ctx.mkEq(
                convertExpression(operands.head, values),
                convertExpression(operands.tail.head, values)))
            case syntaxTree.LessThan => ctx.mkLt(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.LessThanEqual => ctx.mkLe(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.GreaterThan => ctx.mkGt(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.GreaterThanEqual => ctx.mkGe(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case syntaxTree.And => ctx.mkAnd(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case syntaxTree.Or => ctx.mkOr(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case syntaxTree.Implies => ctx.mkImplies(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case syntaxTree.Union => ctx.mkUnion(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ReExpr])
            case syntaxTree.Intersect => ctx.mkIntersect(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ReExpr])
            case syntaxTree.Difference => ctx.mkSetDifference(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case syntaxTree.Subset => ctx.mkSetSubset(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case syntaxTree.PropSubset => ctx.mkSetSubset(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case syntaxTree.InSet => ctx.mkSetMembership(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case syntaxTree.MethodCall(_, _) => throw new Exception("MethodCall to Z3-Expr not supported")
        }
    }

    def getObjectType(memberExp: Expression, values: List[ValueDeclaration]): ObjectType = memberExp match
    {
        case Identifier(name) => values.find(v => v.name == name).get.typeId.asInstanceOf[ObjectType]
    }

    def getTypeDefinition(memberExp: Expression, values: List[ValueDeclaration]): TypeDefinition =
    {
        val objectType: syntaxTree.ObjectType = getObjectType(memberExp, values)
        typeDefinitions.find(typeDef => typeDef.name == objectType.typeName).get
    }

    def convertMemberAccess(innerExp: syntaxTree.Expression, fieldName: String, values: List[syntaxTree.ValueDeclaration]): Option[z3.Expr] =
    {
        val valDefs: List[syntaxTree.ProgramDefinition] = values.map(value => ValueDefinition(value, Identifier(value.name)))

        val programContext: List[syntaxTree.ProgramDefinition] = valDefs ++ program.programDefinitions

        val innerExpType: syntaxTree.ObjectType = syntaxTree.TypeOfHelp.getTypeOf(innerExp, programContext) match
        {
            case Some(objType: ObjectType) => objType
            case _ => return None
        }
        val typeDef: syntaxTree.TypeDefinition = syntaxTree.Helper.getTypeDefinition(innerExpType.typeName, program.programDefinitions).get
        val fieldIndex: Int = typeDef.fields.indexWhere(p => p.name == fieldName)

        val objectSort: z3.DatatypeSort = sorts.find(s => s.getName.toString == typeDef.name).getOrElse(return None)

        val accessor: z3.FuncDecl = objectSort.getAccessors()(0)(fieldIndex)
        val targetObject: z3.Expr = convertExpression(innerExp, values)

        val app = ctx.mkApp(accessor, targetObject)
        Some(app)
    }
}
