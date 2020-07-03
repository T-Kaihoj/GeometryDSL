
import parser.GdslBaseVisitor;
import parser.GdslLexer;
import parser.GdslParser;
import ast.*;
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

    ProgramEntityVisitor expressionAntlrToAbstractSyntaxTree = new ProgramEntityVisitor();
         var traverseResult = expressionAntlrToAbstractSyntaxTree.visit(parser.expression());
        return traverseResult;
    }

public class ExpressionVisitor  extends GdslBaseVisitor<Expression> {


    @Override
    public Expression visitAddSubExp(GdslParser.AddSubExpContext ctx) {
        System.out.println(ctx.expression().size());

        return super.visitAddSubExp(ctx);
    }
}

private class ProgramEntityVisitor extends GdslBaseVisitor<ast.ast.ProgramEntity>{
    @Override
    public ProgramEntity visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
        System.out.println(ctx.expression().toString());
        //ctx.expression()
        return super.visitVariableDefinition(ctx);
    }
}


}