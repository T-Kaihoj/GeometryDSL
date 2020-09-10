package analyzer

import com.microsoft.z3

class AstToZ3Converter(ctx: z3.Context, program: ast.Program)
{
    val typeDefinitions: List[ast.TypeDefinition] = program.program.collect
    {
        case typeDef: ast.TypeDefinition => typeDef
    }

    val sorts: List[z3.DatatypeSort] = typeDefinitions.map(
    {
        case ast.TypeDefinition(name, fields) =>
            val constructor = ctx.mkConstructor(
                name,
                "mk" + name,
                fields.map(f => f.name).toArray,
                fields.map(f => convertType(f.typeId).get).toArray,
                null)
            ctx.mkDatatypeSort(name, Array(constructor))
    })

    val globalValues: List[ast.ValueDeclaration] = program.program.collect
    {
        case ast.ValueDefinition(decl, _) => decl
    }

    def convertType(typeId: ast.Type): Option[z3.Sort] = typeId match
    {
        case ast.BoolType => Some(ctx.mkBoolSort)
        case ast.IntType => Some(ctx.mkIntSort)
        case ast.RealType => Some(ctx.mkRealSort)
        case ast.SetType => throw new Exception("Cannot convert from SetType to Z3 equivalent")
        case ast.ObjectType(typeName) => sorts.find(s => s.getName.toString == typeName)
    }

    def convertExpression(exp: ast.Expression, values: List[ast.ValueDeclaration]): z3.Expr = exp match
    {
        case ast.BoolLiteral(b) => ctx.mkBool(b)
        case ast.IntLiteral(i) => ctx.mkInt(i)
        case ast.RealLiteral(r) => ctx.mkReal(r.toString)
        case ast.SetLiteral(_) => throw new Exception("SetLiteral to Z3-Expr not supported")
        case ast.Identifier(name) => ctx.mkSymbol(name).asInstanceOf[z3.Expr]
        case ast.MemberAccess(exp, field) => convertMemberAccess(exp, field, values).get
        case ast.SetComprehension(_, _, _) => throw new Exception("SetComprehension to Z3-Expr not supported")
        case ast.Operation(operator, operands) => operator match
        {
            case ast.Negation => throw new Exception("Negation to Z3-Expr not supported")
            case ast.Not => ctx.mkNot(
                convertExpression(operands.head, values ++ globalValues).asInstanceOf[z3.BoolExpr])
            case ast.Cardinality => throw new Exception("Cardinality to Z3-Expr not supported")
            case ast.Forall(elem) => convertForall(elem, convertExpression(operands.head, values))
            case ast.Exists(_) => throw new Exception("Exists to Z3-Expr not supported")
            case ast.Add => ctx.mkAdd(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.Sub => ctx.mkSub(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.Mul => ctx.mkMul(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.Div => ctx.mkDiv(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.Pow => ctx.mkPower(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.Equal => ctx.mkEq(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.NotEqual => ctx.mkNot(ctx.mkEq(
                convertExpression(operands.head, values),
                convertExpression(operands.tail.head, values)))
            case ast.LessThan => ctx.mkLt(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.LessThanEqual => ctx.mkLe(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.GreaterThan => ctx.mkGt(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.GreaterThanEqual => ctx.mkGe(
                convertExpression(operands.head, values).asInstanceOf[z3.ArithExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArithExpr])
            case ast.And => ctx.mkAnd(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case ast.Or => ctx.mkOr(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case ast.Implies => ctx.mkImplies(
                convertExpression(operands.head, values).asInstanceOf[z3.BoolExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.BoolExpr])
            case ast.Union => ctx.mkUnion(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ReExpr])
            case ast.Intersect => ctx.mkIntersect(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ReExpr])
            case ast.Difference => ctx.mkSetDifference(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case ast.Subset => ctx.mkSetSubset(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case ast.PropSubset => ctx.mkSetSubset(
                convertExpression(operands.head, values).asInstanceOf[z3.ArrayExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case ast.InSet => ctx.mkSetMembership(
                convertExpression(operands.head, values).asInstanceOf[z3.ReExpr],
                convertExpression(operands.tail.head, values).asInstanceOf[z3.ArrayExpr])
            case ast.MethodCall(name, argumentCount) => throw new Exception("MethodCall to Z3-Expr not supported")
        }
    }

    def convertMemberAccess(exp: ast.Expression, fieldName: String, values: List[ast.ValueDeclaration]): Option[z3.Expr] = exp match
    {
        case ast.Identifier(objectName) =>
            val objectType: ast.ObjectType = values.find(v => v.name == objectName) match
            {
                case Some(ast.ValueDeclaration(_, typeId: ast.ObjectType)) => typeId
                case _ => return None
            }
            val typeDef: ast.TypeDefinition = typeDefinitions.find(typeDef => typeDef.name == objectType.typeName).getOrElse(return None)
            val objectSort: z3.DatatypeSort = sorts.find(s => s.getName.toString == typeDef.name).getOrElse(return None)
            val fieldIndex: Int = typeDef match
            {
                case ast.TypeDefinition(_, fields) => fields.indexWhere(p => p.name == fieldName)
            }
            val accessor: z3.FuncDecl = objectSort.getAccessors()(0)(fieldIndex)
            val targetObject: z3.Expr = ctx.mkConst(objectName, objectSort)
            Some(ctx.mkApp(accessor, targetObject))
        case _ => None
    }

    def convertForall(elementDefinition: ast.ElementDefinition, conditionExpression: z3.Expr): z3.Expr =
    {
        val sort: z3.Sort = elementDefinition.exp match
        {
            case ast.Identifier(name) => sorts.find(s => s.getName.toString == name).get
        }

        val forall = ctx.mkForall(
            Array(sort),
            Array(ctx.mkSymbol(elementDefinition.name)),
            conditionExpression,
            1,
            Array(),
            null,
            null,
            null)

        println(forall.toString)
        forall

    }
}
