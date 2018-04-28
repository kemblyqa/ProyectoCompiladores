// Generated from C:/Users/Alberth/Google Drive/Desktop/TEC/Compiladores/Proyecto\projectParser.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link projectParser}.
 */
public interface projectParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code progAST}
	 * labeled alternative in {@link projectParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgAST(projectParser.ProgASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progAST}
	 * labeled alternative in {@link projectParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgAST(projectParser.ProgASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stLetAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStLetAST(projectParser.StLetASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stLetAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStLetAST(projectParser.StLetASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stReturnAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStReturnAST(projectParser.StReturnASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stReturnAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStReturnAST(projectParser.StReturnASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stExpressAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStExpressAST(projectParser.StExpressASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stExpressAST}
	 * labeled alternative in {@link projectParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStExpressAST(projectParser.StExpressASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letStatementAST}
	 * labeled alternative in {@link projectParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatementAST(projectParser.LetStatementASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letStatementAST}
	 * labeled alternative in {@link projectParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatementAST(projectParser.LetStatementASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatementAST}
	 * labeled alternative in {@link projectParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatementAST(projectParser.ReturnStatementASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatementAST}
	 * labeled alternative in {@link projectParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatementAST(projectParser.ReturnStatementASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionStatementAST}
	 * labeled alternative in {@link projectParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionStatementAST}
	 * labeled alternative in {@link projectParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link projectParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAST(projectParser.ExpressionASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link projectParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAST(projectParser.ExpressionASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonAST}
	 * labeled alternative in {@link projectParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparisonAST(projectParser.ComparisonASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonAST}
	 * labeled alternative in {@link projectParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparisonAST(projectParser.ComparisonASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additionExpressionAST}
	 * labeled alternative in {@link projectParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additionExpressionAST}
	 * labeled alternative in {@link projectParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpressionASP}
	 * labeled alternative in {@link projectParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpressionASP}
	 * labeled alternative in {@link projectParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eleExpEleAcc}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterEleExpEleAcc(projectParser.EleExpEleAccContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eleExpEleAcc}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitEleExpEleAcc(projectParser.EleExpEleAccContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eleExpCall}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterEleExpCall(projectParser.EleExpCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eleExpCall}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitEleExpCall(projectParser.EleExpCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eleExpPriOnly}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eleExpPriOnly}
	 * labeled alternative in {@link projectParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elementAccessASP}
	 * labeled alternative in {@link projectParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void enterElementAccessASP(projectParser.ElementAccessASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elementAccessASP}
	 * labeled alternative in {@link projectParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void exitElementAccessASP(projectParser.ElementAccessASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpressionASP}
	 * labeled alternative in {@link projectParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpressionASP(projectParser.CallExpressionASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpressionASP}
	 * labeled alternative in {@link projectParser#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpressionASP(projectParser.CallExpressionASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExprIntASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExprIntASP(projectParser.PExprIntASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExprIntASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExprIntASP(projectParser.PExprIntASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpStrASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpStrASP(projectParser.PExpStrASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpStrASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpStrASP(projectParser.PExpStrASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpIDASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpIDASP(projectParser.PExpIDASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpIDASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpIDASP(projectParser.PExpIDASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpTrueASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpTrueASP(projectParser.PExpTrueASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpTrueASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpTrueASP(projectParser.PExpTrueASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpFalseASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpFalseASP(projectParser.PExpFalseASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpFalseASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpFalseASP(projectParser.PExpFalseASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpParExpParASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpParExpParASP(projectParser.PExpParExpParASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpParExpParASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpArrayLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpArrayLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpArrayFuncASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpArrayFuncASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpFunLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpFunLitASP(projectParser.PExpFunLitASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpFunLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpHashLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpHashLitASP(projectParser.PExpHashLitASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpHashLitASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpPrintExpASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpPrintExpASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pExpIfASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPExpIfASP(projectParser.PExpIfASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pExpIfASP}
	 * labeled alternative in {@link projectParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPExpIfASP(projectParser.PExpIfASPContext ctx);
	/**
	 * Enter a parse tree produced by {@link projectParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunctions(projectParser.ArrayFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link projectParser#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunctions(projectParser.ArrayFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLiteralASP}
	 * labeled alternative in {@link projectParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLiteralASP}
	 * labeled alternative in {@link projectParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionLiteralASP}
	 * labeled alternative in {@link projectParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionLiteralASP}
	 * labeled alternative in {@link projectParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionParametersASP}
	 * labeled alternative in {@link projectParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParametersASP(projectParser.FunctionParametersASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionParametersASP}
	 * labeled alternative in {@link projectParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreIdentifiersASP}
	 * labeled alternative in {@link projectParser#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void enterMoreIdentifiersASP(projectParser.MoreIdentifiersASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreIdentifiersASP}
	 * labeled alternative in {@link projectParser#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void exitMoreIdentifiersASP(projectParser.MoreIdentifiersASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashLiteralASP}
	 * labeled alternative in {@link projectParser#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHashLiteralASP(projectParser.HashLiteralASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashLiteralASP}
	 * labeled alternative in {@link projectParser#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHashLiteralASP(projectParser.HashLiteralASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashContentASP}
	 * labeled alternative in {@link projectParser#hashContent}.
	 * @param ctx the parse tree
	 */
	void enterHashContentASP(projectParser.HashContentASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashContentASP}
	 * labeled alternative in {@link projectParser#hashContent}.
	 * @param ctx the parse tree
	 */
	void exitHashContentASP(projectParser.HashContentASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreHashContentASP}
	 * labeled alternative in {@link projectParser#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void enterMoreHashContentASP(projectParser.MoreHashContentASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreHashContentASP}
	 * labeled alternative in {@link projectParser#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void exitMoreHashContentASP(projectParser.MoreHashContentASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionListF}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionListF(projectParser.ExpressionListFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionListF}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionListF(projectParser.ExpressionListFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionListE}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionListE(projectParser.ExpressionListEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionListE}
	 * labeled alternative in {@link projectParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionListE(projectParser.ExpressionListEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreExpressionsASP}
	 * labeled alternative in {@link projectParser#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void enterMoreExpressionsASP(projectParser.MoreExpressionsASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreExpressionsASP}
	 * labeled alternative in {@link projectParser#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void exitMoreExpressionsASP(projectParser.MoreExpressionsASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpressionASP}
	 * labeled alternative in {@link projectParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpressionASP(projectParser.PrintExpressionASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpressionASP}
	 * labeled alternative in {@link projectParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExpressionASP}
	 * labeled alternative in {@link projectParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpressionASP(projectParser.IfExpressionASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExpressionASP}
	 * labeled alternative in {@link projectParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpressionASP(projectParser.IfExpressionASPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatementASP}
	 * labeled alternative in {@link projectParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatementASP(projectParser.BlockStatementASPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatementASP}
	 * labeled alternative in {@link projectParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatementASP(projectParser.BlockStatementASPContext ctx);
}