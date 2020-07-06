// Generated from Gdsl.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GdslParser}.
 */
public interface GdslListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GdslParser#gdsl}.
	 * @param ctx the parse tree
	 */
	void enterGdsl(GdslParser.GdslContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#gdsl}.
	 * @param ctx the parse tree
	 */
	void exitGdsl(GdslParser.GdslContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(GdslParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(GdslParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(GdslParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(GdslParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GdslParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GdslParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(GdslParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(GdslParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GdslParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GdslParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(GdslParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(GdslParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(GdslParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(GdslParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(GdslParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(GdslParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#iif}.
	 * @param ctx the parse tree
	 */
	void enterIif(GdslParser.IifContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#iif}.
	 * @param ctx the parse tree
	 */
	void exitIif(GdslParser.IifContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#iifElset}.
	 * @param ctx the parse tree
	 */
	void enterIifElset(GdslParser.IifElsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#iifElset}.
	 * @param ctx the parse tree
	 */
	void exitIifElset(GdslParser.IifElsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#elset}.
	 * @param ctx the parse tree
	 */
	void enterElset(GdslParser.ElsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#elset}.
	 * @param ctx the parse tree
	 */
	void exitElset(GdslParser.ElsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#setElementDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSetElementDefinition(GdslParser.SetElementDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#setElementDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSetElementDefinition(GdslParser.SetElementDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDotExp(GdslParser.DotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDotExp(GdslParser.DotExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setComprehensionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetComprehensionExp(GdslParser.SetComprehensionExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setComprehensionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetComprehensionExp(GdslParser.SetComprehensionExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExp(GdslParser.NumberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExp(GdslParser.NumberExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(GdslParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(GdslParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExp(GdslParser.FunctionCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExp(GdslParser.FunctionCallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(GdslParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(GdslParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExp(GdslParser.VariableExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExp(GdslParser.VariableExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(GdslParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(GdslParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExp(GdslParser.AddSubExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExp(GdslParser.AddSubExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setLiteralExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetLiteralExp(GdslParser.SetLiteralExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setLiteralExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetLiteralExp(GdslParser.SetLiteralExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExp(GdslParser.PowerExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExp(GdslParser.PowerExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divMulExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivMulExp(GdslParser.DivMulExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divMulExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivMulExp(GdslParser.DivMulExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExp(GdslParser.ComparisonExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExp(GdslParser.ComparisonExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setChooseExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetChooseExp(GdslParser.SetChooseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setChooseExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetChooseExp(GdslParser.SetChooseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absoluteExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteExp(GdslParser.AbsoluteExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteExp(GdslParser.AbsoluteExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExp(GdslParser.ParenthesisExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExp(GdslParser.ParenthesisExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOperatorExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetOperatorExp(GdslParser.SetOperatorExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOperatorExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetOperatorExp(GdslParser.SetOperatorExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setQuantificationCallExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantificationCallExp(GdslParser.SetQuantificationCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setQuantificationCallExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantificationCallExp(GdslParser.SetQuantificationCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GdslParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(GdslParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(GdslParser.VariablesContext ctx);
}