package transpilation;


import syntaxTree.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Transpilation {

    public String convert(syntaxTree.Program ast) {
        List<String> python = new LinkedList<>();
        ast.program().foreach(v1 -> python.add(convertProgramEntity(v1)));
        return String.join("\n", python);
    }

    final static String classNameTypeDefinition = TypeDefinition.class.getName();

    public String convertProgramEntity(syntaxTree.ProgramEntity programEntity) {

        //return convertTypeDefinition((TypeDefinition)programEntity);
        switch (ClassNames.valueOf(programEntity.getClass().getSimpleName())) {
            case TypeDefinition:
                return convertTypeDefinition((TypeDefinition) programEntity);
            case MethodDefinition:
                return convertMethodDefinition((MethodDefinition) programEntity);
            case ValueDefinition:
                return convertValueDefinition((ValueDefinition) programEntity, "\n");
            default:
                throw new IllegalStateException("Unexpected value: " + programEntity.getClass().getName());
        }
    }


    public String convertTypeDefinition(syntaxTree.TypeDefinition typeDefinition) {
        List<String> ValueDeclaration = new ArrayList();
        List<String> name = new ArrayList<>();
        typeDefinition.fields().foreach(v1 -> name.add(v1.name()));
        typeDefinition.fields().foreach(v1 -> ValueDeclaration.add("\t\t self." + v1.name() + "=" + v1.name()));
        return "class " + typeDefinition.name() + ":\n" +
                "\tdef __init__(self," + String.join(",", name) + "):\n" +
                String.join("\n", ValueDeclaration);
    }

    public String convertValueDefinition(ValueDefinition valueDefinition, String s ) {

        return s+valueDefinition.decl().name() + " = "+ convertExpression(valueDefinition.exp())  ;
    }

    private String convertStatement(Statement statement, String s) {
        switch (ClassNames.valueOf(statement.getClass().getSimpleName())) {
            case ValueDefinition:
                return convertValueDefinition((ValueDefinition) statement,s);
            case Conditional:
                return convertConditional((Conditional) statement,s);
            case Return:
                return convertReturn((Return) statement,s);
        }
        return null;
    }

    private String convertReturn(Return statement, String s) {
        return "\treturn "+ convertExpression(statement.exp());
    }

    private String convertConditional(Conditional statement, String s) {
        return "convertConditional";
    }


    public String convertExpression(Expression exp) {
        switch (ClassNames.valueOf(exp.getClass().getSimpleName())) {
            case TypeDefinition:
                return convertTypeDefinition((TypeDefinition) exp);
            case BoolLiteral:
                return convertExpressionBoolLiteral((BoolLiteral) exp);
            case IntLiteral:
                return convertExpressionIntLiteral((IntLiteral) exp);
            case RealLiteral:
                return convertExpressionRealLiteral((RealLiteral) exp);
            case SetLiteral:
                return convertExpressionSetLiteral((SetLiteral) exp);
            case Identifier:
                return convertExpressionIdentifier((Identifier) exp);
            case MemberAccess:
                return convertExpressionMemberAccess((MemberAccess) exp);
            case SetComprehension:
                return convertExpressionSetComprehension((SetComprehension) exp,"\t");
            case Operation:
                return convertExpressionOperation((Operation) exp);
        }
        return null;
    }

    private String convertExpressionIntLiteral(IntLiteral exp) {
        return  String.valueOf( exp.value());
    }

    private String convertExpressionRealLiteral(RealLiteral exp) {
        return  String.valueOf( exp.value());
    }

    private String convertExpressionOperation(Operation exp) {
        List<Expression> expressions = new ArrayList<>();
        exp.operands().foreach(v1 -> expressions.add(v1));
        String operator = transpilationScala.operatorStringScala(  exp.operator());
        if (operator.equals("MethodCall"))
            return convertMethodCall((MethodCall)exp.operator(),expressions);
        if (operator.equals("Forall"))
            return convertForall((Forall)exp.operator(),expressions);

        if(expressions.size()==2)
            return "("+convertExpression(expressions.get(0)) +" "+transpilationScala.operatorStringScala(  exp.operator()) + " "+ convertExpression( expressions.get(1))+")";
        return exp.toString();


    }

    private String convertForall(Forall operator, List<Expression> expressions) {

        return "Forall("+convertExpression(operator.element().exp())+", lambda "+ operator.element().name() +" : " +convertExpression(expressions.get(0))+")";
    }

    private String convertMethodCall(MethodCall call, List<Expression> expressions) {
        List<String> strings = new ArrayList<>();
        expressions.forEach(expression -> strings.add( convertExpression(expression)));
        return call.name()+"(" +  String.join(",",strings)+ ")";
    }


    //todo fix element: ElementDefinition, condition: Expression, application: Expression
    private String convertExpressionSetComprehension(SetComprehension exp, String s) {
         String expression = convertExpression(exp.element().exp());
        return "select("+expression+", lambda "+ exp.element().name() +" : " +convertExpression(exp.condition())+" , lambda "+ exp.element().name() +" : " +convertExpression(exp.application())+")";
    }

    private String convertExpressionMemberAccess(MemberAccess exp) {
        return convertExpression(exp.exp())+"."+exp.field() ;
    }

    private String convertExpressionIdentifier(Identifier exp) {
        return exp.name();
    }

    private String convertExpressionSetLiteral(SetLiteral exp) {
        List<String> setLiteral = new ArrayList<>();
        exp.values().foreach(v1 -> setLiteral.add(convertExpression(v1)) );
        return "["+ String.join(",",setLiteral) +"]";
    }
    //todo fix
    private String convertExpressionBoolLiteral(BoolLiteral exp) {
        return "Expression BoolLiteral";
    }

    public String convertMethodDefinition(syntaxTree.MethodDefinition methodDefinition) {
        List<String> stringList = new ArrayList();
        List<String> statement = new ArrayList();
        methodDefinition.params().foreach(v1 -> stringList.add(v1.name()));
        methodDefinition.block().foreach(v1 -> statement.add(convertStatement(v1,"\t")));
        return "def "+methodDefinition.name()+"("+ String.join(",", stringList) +"):\n"+String.join("\n",statement);
    }



    enum ClassNames {
        TypeDefinition(TypeDefinition.class, TypeDefinition.class.getSimpleName()),
        ValueDefinition(ValueDefinition.class, ValueDefinition.class.getSimpleName()),
        MethodDefinition(MethodDefinition.class, MethodDefinition.class.getSimpleName()),
        BoolLiteral(BoolLiteral.class,BoolLiteral.class.getSimpleName()),
        IntLiteral(IntLiteral.class,IntLiteral.class.getSimpleName()),
        RealLiteral(RealLiteral.class,RealLiteral.class.getSimpleName()),
        SetLiteral(SetLiteral.class,SetLiteral.class.getSimpleName()),
        Identifier(Identifier.class,Identifier.class.getSimpleName()),
        MemberAccess(MemberAccess.class,MemberAccess.class.getSimpleName()),
        SetComprehension(SetComprehension.class,SetComprehension.class.getSimpleName()),
        Operation(Operation.class,Operation.class.getSimpleName()),
        Return(Return.class,Return.class.getSimpleName()),
        Conditional(Conditional.class,Conditional.class.getSimpleName());
        private Class typeName;
        private String simpleName;

        ClassNames(Class typeName, String simpleName) {
            this.typeName = typeName;
            this.simpleName = simpleName;
        }
    }
}

