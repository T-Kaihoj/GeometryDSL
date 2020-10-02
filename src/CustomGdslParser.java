import org.antlr.v4.runtime.*;
import parser.GdslBaseVisitor;
import parser.GdslLexer;
import parser.GdslParser;
import syntaxTree.*;
import parser.helpers.ParsingHelper;
import parser.helpers.ParsingHelperScala;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomGdslParser {

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
                List<ProgramDefinition> programEntities =new ArrayList<>();
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

            return new Operation( ParsingHelper.operatorObject("Cardinality",1), ParsingHelper.scalaList( this.visit(ctx.expression())));

        }

        //   | setL=expression operator=(UNION | DIFFERENCE| INTERSECTION) setR=expression #setOperatorExp
        @Override
        public Expression visitSetOperatorExp(GdslParser.SetOperatorExpContext ctx) {
            return new Operation(ParsingHelperScala.operatorObjectScala(ctx.operator.getType(),2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // quantifier=QUANTIFIER '(' setElementDefinition ','  expression ')' #setQuantificationCallExp
        @Override
        public Expression visitSetQuantificationExp(GdslParser.SetQuantificationExpContext ctx) {
            SetElementDefinitionVisitor setElementDefinitionVisitor = new SetElementDefinitionVisitor();
            ElementDefinition elementDef = setElementDefinitionVisitor.visitSetElementDefinition(ctx.setElementDefinition());

            Operator op;
            if (ctx.quantifier.getText().equals("exist")) {
                op = new Exists(elementDef);
            } else if (ctx.quantifier.getText().equals("all")) {
                op = new Forall(elementDef);
            } else {
                return super.visitSetQuantificationExp(ctx);
            }

            return new Operation(op, ParsingHelper.scalaList(this.visit(ctx.expression())));
        }

        @Override
        public Expression visitSetExtractionExp(GdslParser.SetExtractionExpContext ctx) {
            SetElementDefinitionVisitor setElementDefinitionVisitor = new SetElementDefinitionVisitor();
            ElementDefinition elementDef = setElementDefinitionVisitor.visitSetElementDefinition(ctx.setElementDefinition());

            Expression exp;
            if (ctx.extractor.getText().equals("select")) {
                exp = new SetComprehension(elementDef, this.visit(ctx.expression()), new Identifier(elementDef.name()));
            } else if (ctx.extractor.getText().equals("choose")) {
                exp = new Operation(new Choose(elementDef), ParsingHelper.scalaList(this.visit(ctx.expression())));
            } else {
                exp = super.visitSetExtractionExp(ctx);
            }

            return exp;
        }

        //| expression POWER expression #powerExp
        @Override
        public Expression visitPowerExp(GdslParser.PowerExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject("Pow",2), ParsingHelper.scalaList(this.visit(ctx.expression(0)), this.visit(ctx.expression(1))));
        }

        // expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
        @Override
        public Expression visitMulDivExp(GdslParser.MulDivExpContext ctx) {
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

        // not expression #notExp
        @Override
        public Expression visitNotExp(GdslParser.NotExpContext ctx) {
            return new Operation(ParsingHelper.operatorObject("Not", 1), ParsingHelper.scalaList(this.visit(ctx.expression())));
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
        public Expression visitNegativeExp(GdslParser.NegativeExpContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            return new Operation(ParsingHelper.operatorObject("Neg", 1), ParsingHelper.scalaList(expressionVisitor.visit(ctx.expression())));
        }

        @Override
        public Expression visitNumberExp(GdslParser.NumberExpContext ctx) {
            if(ctx.num.start.getType() == GdslLexer.INTEGER) {
                return new IntLiteral(Integer.parseInt(ctx.num.getText()));
            } else if(ctx.num.start.getType() == GdslLexer.FLOAT) {
                return new RealLiteral(Float.parseFloat(ctx.num.getText()));
            } else {
                return super.visitNumberExp(ctx);
            }
        }

        @Override
        public Expression visitNoValueExp(GdslParser.NoValueExpContext ctx) {
            return ParsingHelper.getNoValueLiteral();
        }
    }

    //(typeDefinition | functionDefinition | variableDefinition)*
    private class ProgramEntityVisitor extends GdslBaseVisitor<ProgramDefinition>{
        @Override
        public ProgramDefinition visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            ValueDefinition valDef = new ValueDefinition(declarationVisitor.visit(ctx.declaration()), expressionVisitor.visit(ctx.expression()));
            valDef.lineNumber_$eq(ctx.start.getLine());
            return valDef;
        }

        @Override
        public ProgramDefinition visitFunctionDefinition(GdslParser.FunctionDefinitionContext ctx) {
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            List<ValueDeclaration> valueDeclarations = new ArrayList<>();
            ctx.declaration().forEach(declarationContext -> valueDeclarations.add(declarationVisitor.visit(declarationContext)));

            ScopeVisitor scopeVisitor = new ScopeVisitor();

            MethodDefinition methDef = new MethodDefinition(
                ctx.functionId.getText(),
                ParsingHelper.typeObject(ctx.retType.getText()),
                ParsingHelper.scalaList(valueDeclarations),
                ParsingHelper.scalaList(scopeVisitor.visit(ctx.scope())));
            methDef.lineNumber_$eq(ctx.start.getLine());
            return methDef;
        }

        @Override
        public ProgramDefinition visitTypeDefinition(GdslParser.TypeDefinitionContext ctx) {
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();

            List<ValueDeclaration> valueDeclarations = new ArrayList<>();
            ctx.declaration().forEach(declarationContext -> valueDeclarations.add(declarationVisitor.visit(declarationContext)));

            List<Expression> invariantExps = new ArrayList<>();
            ctx.typeInvariant().forEach(invExp -> invariantExps.add(expressionVisitor.visit(invExp)));

            Collections.reverse(invariantExps);

            Expression typeInvariant;
            if(invariantExps.isEmpty()) {
                typeInvariant = new BoolLiteral(true);
            } else {
                typeInvariant = invariantExps.get(0);
                for(Expression invExp: invariantExps.subList(1, invariantExps.size())) {
                    typeInvariant = new Operation(ParsingHelper.operatorObject("And",2), ParsingHelper.scalaList(invExp, typeInvariant));
                }
            }

            TypeDefinition typeDef = new TypeDefinition(ctx.id.getText(), ParsingHelper.scalaList(valueDeclarations), typeInvariant);
            typeDef.lineNumber_$eq(ctx.start.getLine());
            return typeDef;
        }
    }

    private class DeclarationVisitor extends GdslBaseVisitor<ValueDeclaration>{
        @Override
        public ValueDeclaration visitDeclaration(GdslParser.DeclarationContext ctx) {
            ValueDeclaration valDecl = new ValueDeclaration(
                ctx.id.getText(),
                ParsingHelperScala.typeObjectScala(ctx.type.getText()));
            return valDecl;
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
            cond.lineNumber_$eq(ctx.start.getLine());
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
                cond.lineNumber_$eq(ctx.start.getLine());
                return cond;
            }else{
                Conditional cond = new Conditional(
                        expressionVisitor.visit(ctx.condition),
                        ParsingHelper.scalaList(scopeVisitor.visitScope(ctx.trueBranch)),
                        ParsingHelper.scalaList());
                cond.lineNumber_$eq(ctx.start.getLine());
                return cond;
            }
        }

        //TODO Fix
        @Override
        public Statement visitSwitchCase(GdslParser.SwitchCaseContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            ScopeVisitor scopeVisitor = new ScopeVisitor();

            Conditional conditional = null;
            if (ctx.defaultscope != null) //Creates default path
                conditional = new Conditional(
                        new BoolLiteral(true),
                        ParsingHelper.scalaList(scopeVisitor.visit(ctx.defaultscope)),
                        ParsingHelper.scalaList());
            for (int i = ctx.expression().size() - 1; i >= 0; i--) {
                conditional = new Conditional(
                        expressionVisitor.visit(ctx.expression(i)),
                        ParsingHelper.scalaList(scopeVisitor.visit(ctx.scope(i))),
                        ParsingHelper.scalaList(conditional));
                conditional.lineNumber_$eq(ctx.start.getLine());
                conditional.tags_$eq(ParsingHelper.scalaList("SwitchCase"));
            }

            return conditional;
        }

        @Override
        public Statement visitVariableDefinition(GdslParser.VariableDefinitionContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            DeclarationVisitor declarationVisitor = new DeclarationVisitor();
            ValueDefinition valDef = new ValueDefinition(declarationVisitor.visit(ctx.declaration()), expressionVisitor.visit(ctx.expression()));
            valDef.lineNumber_$eq(ctx.start.getLine());
            return valDef;
        }

        @Override
        public Statement visitReturnStatement(GdslParser.ReturnStatementContext ctx) {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor();
            Return ret = new Return(expressionVisitor.visit(ctx.expression()));
            ret.lineNumber_$eq(ctx.start.getLine());
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