// Generated from Gdsl.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GdslParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GdslVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GdslParser#gdsl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGdsl(GdslParser.GdslContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#typeInvariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInvariant(GdslParser.TypeInvariantContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(GdslParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(GdslParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(GdslParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GdslParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(GdslParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GdslParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(GdslParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(GdslParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#switchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(GdslParser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(GdslParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link GdslParser#conditionalIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(GdslParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GdslParser#setElementDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetElementDefinition(GdslParser.SetElementDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeCheckExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCheckExp(GdslParser.TypeCheckExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExp(GdslParser.DotExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setComprehensionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetComprehensionExp(GdslParser.SetComprehensionExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExp(GdslParser.NumberExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(GdslParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExp(GdslParser.FunctionCallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExp(GdslParser.MulDivExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setExtractionExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExtractionExp(GdslParser.SetExtractionExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(GdslParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExp(GdslParser.VariableExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noValueExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoValueExp(GdslParser.NoValueExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExp(GdslParser.OrExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExp(GdslParser.NotExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExp(GdslParser.AddSubExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeExp(GdslParser.NegativeExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setLiteralExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetLiteralExp(GdslParser.SetLiteralExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setQuantificationExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantificationExp(GdslParser.SetQuantificationExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExp(GdslParser.PowerExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExp(GdslParser.ComparisonExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absoluteExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteExp(GdslParser.AbsoluteExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExp(GdslParser.ParenthesisExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setOperatorExp}
	 * labeled alternative in {@link GdslParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOperatorExp(GdslParser.SetOperatorExpContext ctx);
}