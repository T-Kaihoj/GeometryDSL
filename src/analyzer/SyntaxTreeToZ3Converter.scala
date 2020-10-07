package analyzer

import com.microsoft.z3

class SyntaxTreeToZ3Converter(ctx: z3.Context, program: syntaxTree.Program)
{
    val typeDefinitions: List[syntaxTree.TypeDefinition] = program.programDefinitions.collect
    {
        case typeDef: syntaxTree.TypeDefinition => typeDef
    }

    val sorts: List[z3.DatatypeSort] = typeDefinitions.map(
    {
        case syntaxTree.TypeDefinition(name, fields, _) =>
            val constructor = ctx.mkConstructor(
                name,
                "mk" + name,
                fields.map(f => f.name).toArray,
                fields.map(f => convertType(f.typeId).get).toArray,
                null)
            ctx.mkDatatypeSort(name, Array(constructor))
    })

    val globalValues: List[syntaxTree.ValueDeclaration] = program.programDefinitions.collect
    {
        case syntaxTree.ValueDefinition(decl, _) => decl
    }

    def convertType(typeId: syntaxTree.Type): Option[z3.Sort] = typeId match
    {
        case syntaxTree.BoolType => Some(ctx.mkBoolSort)
        case syntaxTree.IntType => Some(ctx.mkIntSort)
        case syntaxTree.RealType => Some(ctx.mkRealSort)
        case syntaxTree.SetType => throw new Exception("Cannot convert from SetType to Z3 equivalent")
        case syntaxTree.ObjectType(typeName) => sorts.find(s => s.getName.toString == typeName)
    }

    def convertExpression(exp: syntaxTree.Expression, values: List[syntaxTree.ValueDeclaration]): z3.Expr = exp match
    {
        case syntaxTree.BoolLiteral(b) => ctx.mkBool(b)
        case syntaxTree.IntLiteral(i) => ctx.mkInt(i)
        case syntaxTree.RealLiteral(r) => ctx.mkReal(r.toString)
        case syntaxTree.SetLiteral(_) => throw new Exception("SetLiteral to Z3-Expr not supported")
        case syntaxTree.Identifier(name) => ctx.mkConst(name, convertType(values.find(v => v.name == name).get.typeId).get)
        case syntaxTree.MemberAccess(exp, field) => convertMemberAccess(exp, field, values).get
        case syntaxTree.SetComprehension(_, _, _) => throw new Exception("SetComprehension to Z3-Expr not supported")
        case syntaxTree.Operation(operator, operands) => operator match
        {
            case syntaxTree.Negation => throw new Exception("Negation to Z3-Expr not supported")
            case syntaxTree.Not => ctx.mkNot(
                convertExpression(operands.head, values ++ globalValues).asInstanceOf[z3.BoolExpr])
            case syntaxTree.Cardinality => throw new Exception("Cardinality to Z3-Expr not supported")
            case syntaxTree.Forall(elem) => throw new Exception("Forall to Z3-Expr not supported")
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

    def convertMemberAccess(exp: syntaxTree.Expression, fieldName: String, values: List[syntaxTree.ValueDeclaration]): Option[z3.Expr] = exp match
    {
        case syntaxTree.Identifier(objectName) =>
            val objectType: syntaxTree.ObjectType = values.find(v => v.name == objectName) match
            {
                case Some(syntaxTree.ValueDeclaration(_, typeId: syntaxTree.ObjectType)) => typeId
                case _ => return None
            }
            val typeDef: syntaxTree.TypeDefinition = typeDefinitions.find(typeDef => typeDef.name == objectType.typeName).getOrElse(return None)
            val objectSort: z3.DatatypeSort = sorts.find(s => s.getName.toString == typeDef.name).getOrElse(return None)
            val fieldIndex: Int = typeDef match
            {
                case syntaxTree.TypeDefinition(_, fields, _) => fields.indexWhere(p => p.name == fieldName)
            }
            val accessor: z3.FuncDecl = objectSort.getAccessors()(0)(fieldIndex)
            val targetObject: z3.Expr = ctx.mkConst(objectName, objectSort)
            Some(ctx.mkApp(accessor, targetObject))
        case _ => None
    }
}
