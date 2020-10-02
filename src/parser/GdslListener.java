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
	 * Enter a parse tree produced by {@link GdslParser#typeInvariant}.
	 * @param ctx the parse tree
	 */
	void enterTypeInvariant(GdslParser.TypeInvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#typeInvariant}.
	 * @param ctx the parse tree
	 */
	void exitTypeInvariant(GdslParser.TypeInvariantContext ctx);
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
	 * Enter a parse tree produced by {@link GdslParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(GdslParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GdslParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(GdslParser.NumberContext ctx);
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
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(GdslParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(GdslParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(GdslParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(GdslParser.IfElseStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExp(GdslParser.MulDivExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExp(GdslParser.MulDivExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setExtractionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExtractionExp(GdslParser.SetExtractionExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setExtractionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExtractionExp(GdslParser.SetExtractionExpContext ctx);
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
	 * Enter a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(GdslParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(GdslParser.NotExpContext ctx);
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
	 * Enter a parse tree produced by the {@code setQuantificationExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantificationExp(GdslParser.SetQuantificationExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setQuantificationExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantificationExp(GdslParser.SetQuantificationExpContext ctx);
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
	 * Enter a parse tree produced by the {@code negativeNumberExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegativeNumberExp(GdslParser.NegativeNumberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeNumberExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegativeNumberExp(GdslParser.NegativeNumberExpContext ctx);
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
}