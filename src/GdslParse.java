
import parser.GdslBaseVisitor;
import parser.GdslLexer;
import parser.GdslParser;
import ast.*;
import parser.helpers.ParsingHelper;
import parser.helpers.ParsingHelperScala;
import scala.collection.convert.*;
import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;


public class GdslParse {

public Object parse(String someLangSourceCode) {
        CharStream charStream = new ANTLRInputStream(someLangSourceCode);
        GdslLexer lexer = new GdslLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        GdslParser parser = new GdslParser(tokens);

    ProgramEntityVisitor programEntityVisitor = new ProgramEntityVisitor();
         var traverseResult = programEntityVisitor.visit(parser.gdsl());
    ParsingHelperScala.Print(traverseResult);
         return traverseResult;
    }

public class ExpressionVisitor  extends GdslBaseVisitor<Expression> {

    //'(' expression ')' #parenthesisExp
    @Override
    public Expression visitParenthesisExp(GdslParser.ParenthesisExpContext ctx) {
        return  this.visit(ctx.expression());
    }

    // '|' expression '|' #absoluteExp
    @Override
    public Expression visitAbsoluteExp(GdslParser.AbsoluteExpContext ctx) {
        return  this.visit(ctx.expression());
    }

    //   | setL=expression operator=(UNION | DIFFERENCE| INTERSECTION) setR=expression #setOperatorExp
    @Override
    public Expression visitSetOperatorExp(GdslParser.SetOperatorExpContext ctx) {
        return super.visitSetOperatorExp(ctx);
    }

    // quantifier=QUANTIFIER '(' setElementDefinition ','  expression ')' #setQuantificationCallExp
    @Override
    public Expression visitSetQuantificationCallExp(GdslParser.SetQuantificationCallExpContext ctx) {
        return super.visitSetQuantificationCallExp(ctx);
    }

        //Selects an element from a set
        //| CHOOSE expression  #setChooseExp
    @Override
    public Expression visitSetChooseExp(GdslParser.SetChooseExpContext ctx) {
        return super.visitSetChooseExp(ctx);
    }

    //| expression POWER expression #powerExp
    @Override
    public Expression visitPowerExp(GdslParser.PowerExpContext ctx) {
        return super.visitPowerExp(ctx);
    }

    // expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
    @Override
    public Expression visitDivMulExp(GdslParser.DivMulExpContext ctx) {
        return super.visitDivMulExp(ctx);
    }

    // expression operator=(ADD | SUB) expression #addSubExp
    @Override
    public Expression visitAddSubExp(GdslParser.AddSubExpContext ctx) {
        return new Operation(ParsingHelper.operatorObject(ctx.operator.getText(),2), this.visit(ctx.expression(0)),this.visit(ctx.expression(1)));
    }

    // expression operator=COMPARISON expression #comparisonExp
    @Override
    public Expression visitComparisonExp(GdslParser.ComparisonExpContext ctx) {
        return super.visitComparisonExp(ctx);
    }

    // expression AND expression #andExp
    @Override
    public Expression visitAndExp(GdslParser.AndExpContext ctx) {
        return super.visitAndExp(ctx);
    }

    // expression OR expression #orExp
    @Override
    public Expression visitOrExp(GdslParser.OrExpContext ctx) {
        return super.visitOrExp(ctx);
    }

    // '{' setElementDefinition ('|' )? '|' expression '}'#setComprehensionExp
    @Override
    public Expression visitSetComprehensionExp(GdslParser.SetComprehensionExpContext ctx) {
        return super.visitSetComprehensionExp(ctx);
    }

    // '{' expression  (',' expression )* '}'#setLiteralExp
    @Override
    public Expression visitSetLiteralExp(GdslParser.SetLiteralExpContext ctx) {
        return super.visitSetLiteralExp(ctx);
    }

    // IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
    @Override
    public Expression visitFunctionCallExp(GdslParser.FunctionCallExpContext ctx) {
        return super.visitFunctionCallExp(ctx);
    }

    // expression ('.' IDENTIFIER)+ #dotExp
    @Override
    public Expression visitDotExp(GdslParser.DotExpContext ctx) {
        return super.visitDotExp(ctx);
    }

    // IDENTIFIER  #variableExp
    @Override
    public Expression visitVariableExp(GdslParser.VariableExpContext ctx) {
        return super.visitVariableExp(ctx);
    }

    @Override
    public Expression visitBoolExp(GdslParser.BoolExpContext ctx) {
        return super.visitBoolExp(ctx);
    }

    @Override
    public Expression visitNumberExp(GdslParser.NumberExpContext ctx) {
        //System.out.println(ctx.children.get(0).getText());
        return new IntLiteral(Integer.parseInt(ctx.children.get(0).getText()));
    }
}

private class ProgramEntityVisitor extends GdslBaseVisitor<ProgramEntity>{
    @Override
    public ProgramEntity visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
        //System.out.println(ctx.expression().getText());
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        DeclarationVisitor declarationVisitor = new DeclarationVisitor();
        return new ValueDefinition(declarationVisitor.visit(ctx.declaration()),expressionVisitor.visit(ctx.expression()));
    }
}

private class DeclarationVisitor extends GdslBaseVisitor<ValueDeclaration>{

    @Override
    public ValueDeclaration visitDeclaration(GdslParser.DeclarationContext ctx) {
        return new ValueDeclaration(ctx.id.getText(),ParsingHelperScala.typeObjectScala(ctx.type.getText()));
    }


}



}