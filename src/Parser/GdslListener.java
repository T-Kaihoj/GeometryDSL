// Generated from gdsl.g4 by ANTLR 4.8
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gdslParser}.
 */
public interface gdslListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gdslParser#gdsl}.
	 * @param ctx the parse tree
	 */
	void enterGdsl(gdslParser.GdslContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#gdsl}.
	 * @param ctx the parse tree
	 */
	void exitGdsl(gdslParser.GdslContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(gdslParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(gdslParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(gdslParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(gdslParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(gdslParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(gdslParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(gdslParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(gdslParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(gdslParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(gdslParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(gdslParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(gdslParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(gdslParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(gdslParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(gdslParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(gdslParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(gdslParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(gdslParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#iif}.
	 * @param ctx the parse tree
	 */
	void enterIif(gdslParser.IifContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#iif}.
	 * @param ctx the parse tree
	 */
	void exitIif(gdslParser.IifContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#iifElset}.
	 * @param ctx the parse tree
	 */
	void enterIifElset(gdslParser.IifElsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#iifElset}.
	 * @param ctx the parse tree
	 */
	void exitIifElset(gdslParser.IifElsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#elset}.
	 * @param ctx the parse tree
	 */
	void enterElset(gdslParser.ElsetContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#elset}.
	 * @param ctx the parse tree
	 */
	void exitElset(gdslParser.ElsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#setElementDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSetElementDefinition(gdslParser.SetElementDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#setElementDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSetElementDefinition(gdslParser.SetElementDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDotExp(gdslParser.DotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDotExp(gdslParser.DotExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setComprehensionExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetComprehensionExp(gdslParser.SetComprehensionExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setComprehensionExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetComprehensionExp(gdslParser.SetComprehensionExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExp(gdslParser.NumberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExp(gdslParser.NumberExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(gdslParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(gdslParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExp(gdslParser.FunctionCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExp(gdslParser.FunctionCallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(gdslParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(gdslParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExp(gdslParser.VariableExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExp(gdslParser.VariableExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(gdslParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(gdslParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExp(gdslParser.AddSubExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExp(gdslParser.AddSubExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setLiteralExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetLiteralExp(gdslParser.SetLiteralExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setLiteralExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetLiteralExp(gdslParser.SetLiteralExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExp(gdslParser.PowerExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExp(gdslParser.PowerExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divMulExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivMulExp(gdslParser.DivMulExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divMulExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivMulExp(gdslParser.DivMulExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExp(gdslParser.ComparisonExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExp(gdslParser.ComparisonExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setChooseExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetChooseExp(gdslParser.SetChooseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setChooseExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetChooseExp(gdslParser.SetChooseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absoluteExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteExp(gdslParser.AbsoluteExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteExp(gdslParser.AbsoluteExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExp(gdslParser.ParenthesisExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExp(gdslParser.ParenthesisExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOperatorExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetOperatorExp(gdslParser.SetOperatorExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOperatorExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetOperatorExp(gdslParser.SetOperatorExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setQuantificationCallExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantificationCallExp(gdslParser.SetQuantificationCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setQuantificationCallExp}
	 * labeled alternative in {@link gdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantificationCallExp(gdslParser.SetQuantificationCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gdslParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(gdslParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gdslParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(gdslParser.VariablesContext ctx);
}