// Generated from D:/ProyectoCompiladores\projectParser.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link projectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface projectParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code progAST}
	 * labeled alternative in {@link projectParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgAST(projectParser.ProgASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stLetAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStLetAST(projectParser.StLetASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stReturnAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStReturnAST(projectParser.StReturnASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stExpressAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStExpressAST(projectParser.StExpressASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letStatementAST}
	 * labeled alternative in {@link projectParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatementAST(projectParser.LetStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatementAST}
	 * labeled alternative in {@link projectParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStatementAST}
	 * labeled alternative in {@link projectParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link projectParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(projectParser.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonAST}
	 * labeled alternative in {@link projectParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonAST(projectParser.ComparisonASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additionExpressionAST}
	 * labeled alternative in {@link projectParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additionFactorAST}
	 * labeled alternative in {@link projectParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionFactorAST(projectParser.AdditionFactorASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpressionASP}
	 * labeled alternative in {@link projectParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationFactorASP}
	 * labeled alternative in {@link projectParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationFactorASP(projectParser.MultiplicationFactorASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eleExpEleAcc}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eleExpCall}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEleExpCall(projectParser.EleExpCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eleExpPriOnly}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elementAccessASP}
	 * labeled alternative in {@link projectParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAccessASP(projectParser.ElementAccessASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpressionASP}
	 * labeled alternative in {@link projectParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpressionASP(projectParser.CallExpressionASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExprIntASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExprIntASP(projectParser.PExprIntASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpStrASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpStrASP(projectParser.PExpStrASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpIDASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpIDASP(projectParser.PExpIDASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpTrueASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpTrueASP(projectParser.PExpTrueASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpFalseASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpFalseASP(projectParser.PExpFalseASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpParExpParASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpArrayLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpArrayFuncASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpFunLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpHashLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpPrintExpASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pExpIfASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPExpIfASP(projectParser.PExpIfASPContext ctx);
	/**
	 * Visit a parse tree produced by {@link projectParser#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctions(projectParser.ArrayFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteralASP}
	 * labeled alternative in {@link projectParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionLiteralASP}
	 * labeled alternative in {@link projectParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionParametersASP}
	 * labeled alternative in {@link projectParser#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreIdentifiersASP}
	 * labeled alternative in {@link projectParser#moreIdentifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreIdentifiersASP(projectParser.MoreIdentifiersASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashLiteralASP}
	 * labeled alternative in {@link projectParser#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashLiteralASP(projectParser.HashLiteralASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashContentASP}
	 * labeled alternative in {@link projectParser#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashContentASP(projectParser.HashContentASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreHashContentASP}
	 * labeled alternative in {@link projectParser#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreHashContentASP(projectParser.MoreHashContentASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionListF}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListF(projectParser.ExpressionListFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionListE}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionListE(projectParser.ExpressionListEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreExpressionsASP}
	 * labeled alternative in {@link projectParser#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpressionsASP(projectParser.MoreExpressionsASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpressionASP}
	 * labeled alternative in {@link projectParser#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpressionASP}
	 * labeled alternative in {@link projectParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpressionASP(projectParser.IfExpressionASPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatementASP}
	 * labeled alternative in {@link projectParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatementASP(projectParser.BlockStatementASPContext ctx);
}