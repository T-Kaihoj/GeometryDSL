import org.antlr.v4.runtime.*;
import parser.GdslBaseVisitor;
import parser.GdslLexer;
import parser.GdslParser;
import ast.*;
import parser.helpers.ParsingHelper;
import parser.helpers.ParsingHelperScala;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GdslParse {

    public Program parse(String someLangSourceCode) {
        CharStream charStream = new ANTLRInputStream(someLangSourceCode);
        GdslLexer lexer = new GdslLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        GdslParser parser = new GdslParser(tokens);

        ProgramVisitor programVisitor = new ProgramVisitor();
        var traverseResult = programVisitor.visit(parser.gdsl());
        //ParsingHelperScala.Print(traverseResult);
        return traverseResult;
    }

    public Program parse(InputStream inputStream ) throws IOException {
        CharStream charStream = CharStreams.fromStream(inputStream);
        GdslLexer lexer = new GdslLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        GdslParser parser = new GdslParser(tokens);

        ProgramVisitor programVisitor = new ProgramVisitor();
        var traverseResult = programVisitor.visit(parser.gdsl());
        //ParsingHelperScala.Print(traverseResult);
        return traverseResult;
    }

        private class ProgramVisitor  extends GdslBaseVisitor<Program> {
            @Override
            public Program visitGdsl(GdslParser.GdslContext ctx) {
                ProgramEntityVisitor programEntityVisitor = new ProgramEntityVisitor();
                List<ProgramEntity> programEntities =new ArrayList<>();
                ctx.children.forEach(declarationContext -> programEntities.add( programEntityVisitor.visit(declarationContext)));
                return new Program(ParsingHelper.scalaList( programEntities));
            }
        }

        private class ExpressionVisitor  extends GdslBaseVisitor<Expression> {

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
            return new Operation(ParsingHelper.operatorObject(ctx.operator.getText(),2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // quantifier=QUANTIFIER '(' setElementDefinition ','  expression ')' #setQuantificationCallExp
        @Override
        public Expression visitSetQuantificationCallExp(GdslParser.SetQuantificationCallExpContext ctx) {
            SetElementDefinitionVisitor setElementDefinitionVisitor = new SetElementDefinitionVisitor();
            if(ctx.quantifier.getText().equals("exist"))
                return new Operation(new Exists(setElementDefinitionVisitor.visit(ctx.setElementDefinition())), ParsingHelper.scalaList(this.visit(ctx.expression())));
            else if(ctx.quantifier.getText().equals("all"))
                return new Operation(new Forall(setElementDefinitionVisitor.visit(ctx.setElementDefinition())), ParsingHelper.scalaList(this.visit(ctx.expression())));
            else if(ctx.quantifier.getText().equals( "select")) {
                ElementDefinition elementDefinition = setElementDefinitionVisitor.visit(ctx.setElementDefinition());
                return new SetComprehension(elementDefinition, this.visit(ctx.expression()), new Identifier (elementDefinition.name()));
            }
            else
                return super.visitSetQuantificationCallExp(ctx);

        }

            //Selects an element from a set
            //| CHOOSE expression  #setChooseExp
        //TODO: fix
        @Override
        public Expression visitSetChooseExp(GdslParser.SetChooseExpContext ctx) {
            return super.visitSetChooseExp(ctx);
        }

        //| expression POWER expression #powerExp
        @Override
        public Expression visitPowerExp(GdslParser.PowerExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject("Pow",2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
        @Override
        public Expression visitDivMulExp(GdslParser.DivMulExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject(ctx.operator.getText(),2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression operator=(ADD | SUB) expression #addSubExp
        @Override
        public Expression visitAddSubExp(GdslParser.AddSubExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject(ctx.operator.getText(),2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression operator=COMPARISON expression #comparisonExp
        @Override
        public Expression visitComparisonExp(GdslParser.ComparisonExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject(ctx.operator.getText(),2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression AND expression #andExp
        @Override
        public Expression visitAndExp(GdslParser.AndExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject("And",2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression OR expression #orExp
        @Override
        public Expression visitOrExp(GdslParser.OrExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject("Or",2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // '{' setElementDefinition ('|'expression )? '|' expression '}'#setComprehensionExp
        @Override
        public Expression visitSetComprehensionExp(GdslParser.SetComprehensionExpContext ctx) {
            SetElementDefinitionVisitor setElementDefinitionVisitor = new SetElementDefinitionVisitor();
            ElementDefinition elementDefinition = setElementDefinitionVisitor.visit(ctx.setElementDefinition());
            if (ctx.expression().size()==1)
                return new SetComprehension(elementDefinition, new BoolLiteral(true),this.visit(ctx.expression(0)));
            return new SetComprehension(elementDefinition, this.visit(ctx.expression(0)),this.visit(ctx.expression(1)));
        }

        // '{' expression  (',' expression )* '}'#setLiteralExp
        @Override
        public Expression visitSetLiteralExp(GdslParser.SetLiteralExpContext ctx) {
            List<Expression> expressions =new ArrayList<>();
            ctx.expression().forEach(expressionContext -> expressions.add( this.visit(expressionContext)));
            return new SetLiteral(ParsingHelper.scalaList(expressions));
        }

        // IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
        @Override
        public Expression visitFunctionCallExp(GdslParser.FunctionCallExpContext ctx) {
            List<Expression> expressions = new ArrayList<>();
            ctx.expression().forEach(expressionContext -> expressions.add( this.visit(expressionContext)));
            return new Operation(new MethodCall(ctx.IDENTIFIER().getText(), ctx.expression().size()), ParsingHelper.scalaList(expressions));
        }

        // expression ('.' IDENTIFIER)+ #dotExp
        @Override
        public Expression visitDotExp(GdslParser.DotExpContext ctx) {

            return new MemberAccess(this.visit(ctx.expression()),ctx.IDENTIFIER().getText());
        }

        // IDENTIFIER  #variableExp
        @Override
        public Expression visitVariableExp(GdslParser.VariableExpContext ctx) {
            return new Identifier(ctx.IDENTIFIER().getText());
        }

        @Override
        public Expression visitBoolExp(GdslParser.BoolExpContext ctx) {
            if("true".equals(ctx.bool.getText()))
                return new BoolLiteral(true);
            if("false".equals(ctx.bool.getText()))
                return new BoolLiteral(false);
            return super.visitBoolExp(ctx);
        }

        @Override
        public Expression visitNumberExp(GdslParser.NumberExpContext ctx) {
            return new IntLiteral(Integer.parseInt(ctx.children.get(0).getText()));
        }

    }

    //(typeDefinition | functionDefinition | variableDefinition)*
    private class ProgramEntityVisitor extends GdslBaseVisitor<ProgramEntity>{
        @Override
        public ProgramEntity visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            ValueDefinition valDef = new ValueDefinition(declarationVisitor.visit(ctx.declaration()), expressionVisitor.visit(ctx.expression()));
            valDef.info_$eq(ParsingHelper.info(ctx));
            return valDef;
        }

        @Override
        public ProgramEntity visitFunctionDefinition(GdslParser.FunctionDefinitionContext ctx) {
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            List<ValueDeclaration> valueDeclarations =new ArrayList<>();
            ctx.declaration().forEach(declarationContext -> valueDeclarations.add( declarationVisitor.visit(declarationContext)));

            ScopeVisitor scopeVisitor = new ScopeVisitor();
            List<Statement> statements = new ArrayList<>();

            return new MethodDefinition(ctx.functionId.getText(), ParsingHelper.typeObject( ctx.retType.getText()),ParsingHelper.scalaList(valueDeclarations),ParsingHelper.scalaList( scopeVisitor.visit( ctx.scope())));
        }

        @Override
        public ProgramEntity visitTypeDefinition(GdslParser.TypeDefinitionContext ctx) {
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            List<ValueDeclaration> valueDeclarations =new ArrayList<>();
            ctx.declaration().forEach(declarationContext -> valueDeclarations.add( declarationVisitor.visit(declarationContext)));
            return new TypeDefinition(ctx.id.getText(),ParsingHelper.scalaList(valueDeclarations));
        }
    }


    private class DeclarationVisitor extends GdslBaseVisitor<ValueDeclaration>{
        @Override
        public ValueDeclaration visitDeclaration(GdslParser.DeclarationContext ctx) {
            return new ValueDeclaration(ctx.id.getText(),ParsingHelperScala.typeObjectScala(ctx.type.getText()));
        }
    }

    private class ScopeVisitor extends GdslBaseVisitor<List<Statement>>{
        @Override
        public List<Statement> visitScope(GdslParser.ScopeContext ctx) {
            StatementVisitor statementVisitor = new StatementVisitor();
            List<Statement> statements =new ArrayList<>();
            ctx.statement().forEach(declarationContext -> statements.add( statementVisitor.visit(declarationContext)));
            return statements;
        }
    }

    private class StatementVisitor extends GdslBaseVisitor<Statement>{
        @Override
        public Statement visitIfStatement(GdslParser.IfStatementContext ctx){
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            ScopeVisitor scopeVisitor = new ScopeVisitor();
            Conditional cond = new Conditional(
                    expressionVisitor.visit(ctx.condition),
                    ParsingHelper.scalaList(scopeVisitor.visitScope(ctx.trueBranch)),
                    ParsingHelper.scalaList());
            cond.info_$eq(ParsingHelper.info(ctx));
            return cond;
        }

        @Override
        public Statement visitIfElseStatement(GdslParser.IfElseStatementContext ctx){
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            StatementVisitor statementVisitor = new StatementVisitor();
            ScopeVisitor scopeVisitor = new ScopeVisitor();
            if(ctx.elseIfStatement != null){
                Conditional cond = new Conditional(
                        expressionVisitor.visit(ctx.condition),
                        ParsingHelper.scalaList(scopeVisitor.visitScope(ctx.trueBranch)),
                        ParsingHelper.scalaList());
                cond.info_$eq(ParsingHelper.info(ctx));
                return cond;
            }else{
                Conditional cond = new Conditional(
                        expressionVisitor.visit(ctx.condition),
                        ParsingHelper.scalaList(scopeVisitor.visitScope(ctx.trueBranch)),
                        ParsingHelper.scalaList());
                cond.info_$eq(ParsingHelper.info(ctx));
                return cond;
            }
        }

        //TODO Fix
        @Override
        public Statement visitSwitchCase(GdslParser.SwitchCaseContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            ScopeVisitor scopeVisitor = new ScopeVisitor();

            Conditional conditional =null;
            if (ctx.defaultscope != null) //Creates default path
                conditional = new Conditional(
                        new BoolLiteral(true),
                        ParsingHelper.scalaList(scopeVisitor.visit(ctx.defaultscope)),
                        ParsingHelper.scalaList());
                conditional.info_$eq(ParsingHelper.info(ctx.defaultscope,"SwitchCase"));
            for (int i = ctx.expression().size() - 1; i >= 0; i--) {
                conditional = new Conditional(
                        expressionVisitor.visit(ctx.expression(i)),
                        ParsingHelper.scalaList(scopeVisitor.visit(ctx.scope(i))),
                        ParsingHelper.scalaList( conditional));
                conditional.info_$eq(ParsingHelper.info(ctx,"SwitchCase"));
            }

            return conditional;
        }

        @Override
        public Statement visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            ValueDefinition valDef = new ValueDefinition(declarationVisitor.visit(ctx.declaration()), expressionVisitor.visit(ctx.expression()));
            valDef.info_$eq(ParsingHelper.info(ctx));
            return valDef;
        }

        @Override
        public Statement visitReturnStatement(GdslParser.ReturnStatementContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            Return ret = new Return(expressionVisitor.visit(ctx.expression()));
            ret.info_$eq(ParsingHelper.info(ctx));
            return ret;
        }
    }

    private class SetElementDefinitionVisitor extends GdslBaseVisitor<ElementDefinition>{

        @Override
        public ElementDefinition visitSetElementDefinition(GdslParser.SetElementDefinitionContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            return new ElementDefinition(ctx.localName.getText(),expressionVisitor.visit(ctx.globalName));
        }
    }
}