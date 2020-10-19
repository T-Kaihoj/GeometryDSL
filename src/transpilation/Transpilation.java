package transpilation;


import com.microsoft.z3.Lambda;
import executor.NoValue;
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
        python.add("from gdsl import *\n" +"from realNumbers import RealNumbers");
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
        //String invariant = "\t@staticmethod\n" + "\tdef Invariant("+String.join(",", name)+"):\n\t\treturn "+ convertExpression( typeDefinition.invariant());
        String equal =  "\tdef __eq__(self, other):\n\t\treturn "+ String.join(" and ", map( name ,(s ->  "self."+s+"=="+ "other."+s )));
        String notEqual =  "\tdef __ne__(self, other):\n\t\treturn  not("+ String.join(" or ", map( name ,(s ->  "self."+s+"=="+ "other."+s )))+")";
        String hash =  "\tdef __hash__(self):\n\t\treturn  hash(self.__repr__)";
        String Constructor =   "\t@staticmethod\n" + "\tdef Constructor("+String.join(",", name)+"):\n\t\tif "+convertExpression( typeDefinition.invariant()) +":\n" + "\t\t\treturn "+ typeDefinition.name()+"("+String.join(",", name)+")";
        python.add(  "class " + typeDefinition.name() + ":\n" +
            "\tdef __init__(self," + String.join(",", name) + "):\n" +
            String.join("\n", ValueDeclaration)+"\n" +
            "\tdef __repr__(self):\n" + "\t\treturn  \" "+ String.join("  ", map( name ,s ->  s + ":(% s)" ))  +"\" % ("+String.join(", ", map( name ,(s ->  "str(self."+s+ " )")))+")" );
        //python.add(invariant);
        python.add(equal);
        python.add(notEqual);
        python.add(hash);
        python.add(Constructor);
        return;
    }
    interface MapOperation {
        String operation(String a);
    }

    private List<String> map(List<String> stringList, MapOperation o) {
        List<String> list= new ArrayList<>();
        for (String s : stringList) {
            list.add(o.operation(s));
        }
        return list;
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
        python.add(s+"return "+ convertExpression(statement.exp()));
        return;
    }

    private void convertConditional(Conditional statement, String s) {
        python.add( s +"if "+ convertExpression(statement.condition())+" :");
        statement.trueBlock().foreach(v1 -> {
            convertStatement(v1, s+"\t");
            return null;
        });
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
            case TypeCheck:
                return convertExpressionTypeCheck((TypeCheck) exp);
            case SetComprehension:
                return convertExpressionSetComprehension((SetComprehension) exp,"\t");
            case Operation:
                return convertExpressionOperation((Operation) exp);
            case NoValueLiteral:
                return convertExpressionNoValueLiteral((NoValueLiteral) exp);
        }
        return null;
    }
    private String convertExpressionNoValueLiteral(NoValueLiteral exp) {
        return  "None";
    }

    private String convertExpressionIntLiteral(IntLiteral exp) {
        return  String.valueOf( exp.value());
    }

    private String convertExpressionRealLiteral(RealLiteral exp) {
        return "RealNumbers("+ String.valueOf( exp.value())+")";
    }

    private String convertExpressionOperation(Operation exp) {
        List<Expression> expressions = new ArrayList<>();
        exp.operands().foreach(v1 -> expressions.add(v1));
        String operator = transpilationScala.operatorStringScala(  exp.operator());
        if (operator.equals("MethodCall"))
            return convertMethodCall((MethodCall)exp.operator(),expressions);
        if (operator.equals("Forall"))
            return convertForall((Forall)exp.operator(),expressions);
        if (operator.equals("Exists"))
            return convertExists((Exists)exp.operator(),expressions);
        if (operator.equals("Choose"))
            return convertChoose((Choose) exp.operator(),expressions);
        if (operator.equals("Subset"))
            return convertSubset(expressions);
        if (operator.equals("Difference"))
            return convertDifference(expressions);
        if (operator.equals("Intersect"))
            return convertIntersect(expressions);
        if (operator.equals("Union"))
        return convertUnion(expressions);
        if (operator.equals("PropSubset"))
            return convertPropSubset(expressions);
        if (operator.equals("Cardinality"))
            return convertCardinality(expressions);

        if(expressions.size()==2)
            return "("+convertExpression(expressions.get(0)) +" "+transpilationScala.operatorStringScala(  exp.operator()) + " "+ convertExpression( expressions.get(1))+")";
        return "("+ transpilationScala.operatorStringScala(  exp.operator()) +" "+ convertExpression( expressions.get(0))+")";
        //return exp.toString();
    }

    private String convertPropSubset(List<Expression> expressions) {
        return "("+convertExpression(expressions.get(0))+".issubset("+convertExpression(expressions.get(1))+") and "+convertExpression(expressions.get(0))+"!="+convertExpression(expressions.get(1))+")";
    }

    private String convertUnion(List<Expression> expressions) {
        return convertExpression(expressions.get(0))+".union("+convertExpression(expressions.get(1))+")";
    }

    private String convertIntersect(List<Expression> expressions) {
        return convertExpression(expressions.get(0))+".intersection("+convertExpression(expressions.get(1))+")";
    }

    private String convertDifference(List<Expression> expressions) {
        return convertExpression(expressions.get(0))+" - "+convertExpression(expressions.get(1));
    }

    private String convertCardinality(List<Expression> expressions) {
        return  transpilationScala.expressionisSetScala(expressions.get(0),  block)? "len("+convertExpression(expressions.get(0))+")" : "abs("+convertExpression(expressions.get(0))+") " ;
    }

    private String convertExists(Exists operator, List<Expression> expressions) {
        return "exist("+convertExpression(operator.element().exp())+", lambda "+ operator.element().name() +" : " +convertExpression(expressions.get(0))+")";
    }

    private String convertSubset(List<Expression> expressions) {
        return convertExpression(expressions.get(0))+".issubset("+convertExpression(expressions.get(1))+")";
    }

    private String convertChoose(Choose operator, List<Expression> expressions) {
        return "choose("+convertExpression(operator.element().exp())+", lambda "+ operator.element().name() +" : " +convertExpression(expressions.get(0))+")";
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

        //System.out.println(call.name()+", Variable type:"+finalIsSetlist +call.name()+" Need set expansion:"+isSetlist);

        expressions.forEach(expression -> strings.add( convertExpression(expression)));
        if (isSetlist.contains(true)){
            return setApplication(call, expressions, isSetlist);
        }
        if (transpilationScala.isConstructor(call.name(),program.programDefinitions()))
            return call.name()+".Constructor(" +  String.join(",",strings)+ ")";

            return call.name()+"(" +  String.join(",",strings)+ ")";
    }
    int z =0;
    int p =0;
    private String setApplication(MethodCall call, List<Expression> expressions, List<Boolean> isSetlist) {
        p = p+1;
        int indent =1 ;
        String forString = "\t".repeat(indent)+"p"+p +"=set({})\n";
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
        forString = forString.concat("\t".repeat(indent)+"p"+p +".add("+call.name()+"("+String.join(", ",parameterString) +"))");
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
        return transpilationScala.expressionisSetScala(exp.exp(), block)? "get(" + convertExpression(exp.exp()) + ",\"" + exp.fieldName() + "\")" : convertExpression(exp.exp()) + "." + exp.fieldName() ;
    }

    private String convertExpressionTypeCheck(TypeCheck typeCheck) {
        return "type(" + convertExpression(typeCheck.exp()) + ") is " + transpilationScala.typeToString(typeCheck.typeId());
    }

    private String convertExpressionIdentifier(Identifier exp) {
        return exp.name();
    }

    private String convertExpressionSetLiteral(SetLiteral exp) {
        List<String> setLiteral = new ArrayList<>();
        exp.values().foreach(v1 -> setLiteral.add(convertExpression(v1)) );
        return "setGDSL({"+ String.join(",",setLiteral) +"})";
    }
    //todo fix
    private String convertExpressionBoolLiteral(BoolLiteral exp) {
        return (exp.value()?"True":"False");
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
        NoValueLiteral(NoValueLiteral.class,NoValueLiteral.class.getSimpleName()),
        TypeDefinition(TypeDefinition.class, TypeDefinition.class.getSimpleName()),
        ValueDefinition(ValueDefinition.class, ValueDefinition.class.getSimpleName()),
        MethodDefinition(MethodDefinition.class, MethodDefinition.class.getSimpleName()),
        BoolLiteral(BoolLiteral.class,BoolLiteral.class.getSimpleName()),
        IntLiteral(IntLiteral.class,IntLiteral.class.getSimpleName()),
        RealLiteral(RealLiteral.class,RealLiteral.class.getSimpleName()),
        SetLiteral(SetLiteral.class,SetLiteral.class.getSimpleName()),
        Identifier(Identifier.class,Identifier.class.getSimpleName()),
        MemberAccess(MemberAccess.class,MemberAccess.class.getSimpleName()),
        TypeCheck(TypeCheck.class, TypeCheck.class.getSimpleName()),
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

