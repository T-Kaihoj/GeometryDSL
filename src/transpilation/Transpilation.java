package transpilation;


import syntaxTree.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Transpilation {
    scala.collection.immutable.List<Statement> block;
    Program program;
    List<String> python = new LinkedList<>();
    public String convert(Program program) {
        this.program = program;

        program.programDefinitions().foreach(v1 -> {convertProgramEntity(v1);
            return null;
        });
        return String.join("\n", python);
    }

    final static String classNameTypeDefinition = TypeDefinition.class.getName();

    public void convertProgramEntity(ProgramDefinition programDefinition) {

        //return convertTypeDefinition((TypeDefinition)programEntity);
        switch (ClassNames.valueOf(programDefinition.getClass().getSimpleName())) {
            case TypeDefinition:
                convertTypeDefinition((TypeDefinition) programDefinition);
                return;
            case MethodDefinition:
                convertMethodDefinition((MethodDefinition) programDefinition);
                return;
            case ValueDefinition:
                convertValueDefinition((ValueDefinition) programDefinition, "\n");
                return ;
            default:
                throw new IllegalStateException("Unexpected value: " + programDefinition.getClass().getName());
        }
    }


    public void convertTypeDefinition(TypeDefinition typeDefinition) {
        List<String> ValueDeclaration = new ArrayList();
        List<String> name = new ArrayList<>();
        typeDefinition.fields().foreach(v1 -> name.add(v1.name()));
        typeDefinition.fields().foreach(v1 -> ValueDeclaration.add("\t\t self." + v1.name() + "=" + v1.name()));
           python.add(  "class " + typeDefinition.name() + ":\n" +
                "\tdef __init__(self," + String.join(",", name) + "):\n" +
                String.join("\n", ValueDeclaration));
        return;
    }

    public void convertValueDefinition(ValueDefinition valueDefinition, String s ) {

         python.add( s+valueDefinition.decl().name() + " = "+ convertExpression(valueDefinition.exp()))  ;
        return ;
    }

    private void convertStatement(Statement statement, String s) {
        switch (ClassNames.valueOf(statement.getClass().getSimpleName())) {
            case ValueDefinition:
                convertValueDefinition((ValueDefinition) statement,s);
                break;
            case Conditional:
                convertConditional((Conditional) statement,s);
                break;
            case Return:
                convertReturn((Return) statement,s);
                break;
        }
        return;
    }

    private void convertReturn(Return statement, String s) {
        python.add("\treturn "+ convertExpression(statement.exp()));
        return;
    }

    private void convertConditional(Conditional statement, String s) {
        python.add( s + "convertConditional");
    }


    public String convertExpression(Expression exp) {
        switch (ClassNames.valueOf(exp.getClass().getSimpleName())) {
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
        return "("+ transpilationScala.operatorStringScala(  exp.operator()) + convertExpression( expressions.get(0))+")";
        //return exp.toString();


    }

    private String convertForall(Forall operator, List<Expression> expressions) {

        return "all("+convertExpression(operator.element().exp())+", lambda "+ operator.element().name() +" : " +convertExpression(expressions.get(0))+")";
    }

    private String convertMethodCall(MethodCall call, List<Expression> expressions) {
        List<String> strings = new ArrayList<>();
        List<Boolean> isSetlist = new ArrayList<>();
        List<Boolean> finalIsSetlist = isSetlist;

        expressions.forEach(expression -> finalIsSetlist.add(transpilationScala.expressionisSetScala(expression,  block)));

        isSetlist = methodCallIsSet(call,expressions, finalIsSetlist);

        System.out.println(call.name()+", Variable type:"+finalIsSetlist +call.name()+" Need set expansion:"+isSetlist);

        expressions.forEach(expression -> strings.add( convertExpression(expression)));
        if (isSetlist.contains(true)){
            return setApplication(call, expressions, isSetlist);
        }
        return call.name()+"(" +  String.join(",",strings)+ ")";
    }
    int z =0;
    int p =0;
    private String setApplication(MethodCall call, List<Expression> expressions, List<Boolean> isSetlist) {
        p = p+1;
        int indent =1 ;
        String forString = "\t".repeat(indent)+"p"+p +"=[]\n";
        List<String> parameterString = new ArrayList<>();

        for (int i = 0; i < isSetlist.size() ; i++) {
            if (isSetlist.get(i)){
                forString = forString.concat( "\t".repeat(indent)+"for z"+z + " in "+ convertExpression(expressions.get(i)) +":\n");
                parameterString.add("z"+z);
                indent = indent+1;
                z= z + 1;
            }
            else
                parameterString.add(convertExpression(expressions.get(i)));
        }
        forString = forString.concat("\t".repeat(indent)+"p"+p +".append("+call.name()+"("+String.join(", ",parameterString) +"))");
        python.add(forString);

        return "p"+p;
    }

    private List<Boolean> methodCallIsSet(MethodCall call, List<Expression> expressions, List<Boolean> isSetlist) {
        List<Boolean> booleanList =new ArrayList<>();
        List<Boolean> list =new ArrayList<>();
        transpilationScala.methodCallisSetScala(call.name(), program).foreach(b -> list.add((Boolean) b));
        for (int i = 0; i < expressions.size(); i++) {
             booleanList.add( !list.get(i)&&  isSetlist.get(i));
        }
        return booleanList;
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

    public void convertMethodDefinition(MethodDefinition methodDefinition) {
        List<String> stringList = new ArrayList();
        List<String> statement = new ArrayList();
        block = methodDefinition.block();
        methodDefinition.params().foreach(v1 -> stringList.add(v1.name()));
        python.add("def "+methodDefinition.name()+"("+ String.join(",", stringList) +"):");
        methodDefinition.block().foreach(v1 -> {
            convertStatement(v1,"\t");
            return null;
        });

        return ;//"def "+methodDefinition.name()+"("+ String.join(",", stringList) +"):\n"+String.join("\n",statement);
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

