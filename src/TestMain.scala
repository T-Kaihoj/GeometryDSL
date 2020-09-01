import analyser.RelationChecker
import ast._
import javax.lang.model.`type`.NoType

object TestMain
{
    def main(): Unit =
    {
        val program: Program = Program(List(
            TypeDefinition("Circle", List(
                ValueDeclaration("x", RealType),
                ValueDeclaration("y", RealType),
                ValueDeclaration("r", RealType))),
            MethodDefinition("intersects", BoolType, List(
                ValueDeclaration("a", ObjectType("Circle")),
                ValueDeclaration("b", ObjectType("Circle"))), List(
                Return(Operation(Not, List(Operation(GreaterThan, List(
                    Operation(Add, List(
                        Operation(Mul, List(
                            Operation(Sub, List(MemberAccess(Identifier("a"), "x"), MemberAccess(Identifier("b"), "x"))),
                            Operation(Sub, List(MemberAccess(Identifier("a"), "x"), MemberAccess(Identifier("b"), "x")))
                        )),
                        Operation(Mul, List(
                            Operation(Sub, List(MemberAccess(Identifier("a"), "y"), MemberAccess(Identifier("b"), "y"))),
                            Operation(Sub, List(MemberAccess(Identifier("a"), "y"), MemberAccess(Identifier("b"), "y")))
                        )))),
                    Operation(Mul, List(
                        Operation(Add, List(MemberAccess(Identifier("a"), "r"), MemberAccess(Identifier("b"), "r"))),
                        Operation(Add, List(MemberAccess(Identifier("a"), "r"), MemberAccess(Identifier("b"), "r")))
                    ))
                )))),
                    StatementInfo(0, Nil)))),
            MethodDefinition("main", ObjectType("Circle"), List(), List(
                ValueDefinition(ValueDeclaration("C", ObjectType("Circle")), Operation(MethodCall("Circle", 3), List(RealLiteral(4.1), RealLiteral(2.78), RealLiteral(1.12))), StatementInfo(0, Nil)),
                Return(Operation(MethodCall("intersects", 2), List(Identifier("C"), Identifier("C"))), StatementInfo(0, Nil))))))


        val newProgram = RelationChecker.checkRelations(program)
    }
}
