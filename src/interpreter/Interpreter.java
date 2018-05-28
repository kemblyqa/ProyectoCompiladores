package interpreter;

import generated.projectParser;

public class Interpreter extends generated.projectParserBaseVisitor{
    private DataStorage dataS = null;
    private EvaluationStack evalStack=null;
    public Interpreter(){
        this.dataS=new DataStorage();
        this.evalStack = new EvaluationStack();
    }

    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {
        return super.visitProgAST(ctx);
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {
        return super.visitStLetAST(ctx);
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {
        return super.visitStReturnAST(ctx);
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx) {
        return super.visitStExpressAST(ctx);
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {
        return super.visitLetStatementAST(ctx);
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {
        return super.visitReturnStatementAST(ctx);
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {
        return super.visitExpressionStatementAST(ctx);
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {
        return super.visitExpressionAST(ctx);
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {
        return super.visitAdditionExpressionAST(ctx);
    }

    @Override
    public Object visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx) {
        return super.visitMultiplicationExpressionASP(ctx);
    }

    @Override
    public Object visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx) {
        return super.visitEleExpEleAcc(ctx);
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {
        return super.visitEleExpCall(ctx);
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {
        return super.visitEleExpPriOnly(ctx);
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {
        return super.visitElementAccessASP(ctx);
    }

    @Override
    public Object visitCallExpressionASP(projectParser.CallExpressionASPContext ctx) {
        return super.visitCallExpressionASP(ctx);
    }

    @Override
    public Object visitPExprIntASP(projectParser.PExprIntASPContext ctx) {
        return super.visitPExprIntASP(ctx);
    }

    @Override
    public Object visitPExpStrASP(projectParser.PExpStrASPContext ctx) {
        return super.visitPExpStrASP(ctx);
    }

    @Override
    public Object visitPExpIDASP(projectParser.PExpIDASPContext ctx) {
        return super.visitPExpIDASP(ctx);
    }

    @Override
    public Object visitPExpTrueASP(projectParser.PExpTrueASPContext ctx) {
        return super.visitPExpTrueASP(ctx);
    }

    @Override
    public Object visitPExpFalseASP(projectParser.PExpFalseASPContext ctx) {
        return super.visitPExpFalseASP(ctx);
    }

    @Override
    public Object visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx) {
        return super.visitPExpParExpParASP(ctx);
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {
        return super.visitPExpArrayLitASP(ctx);
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {
        return super.visitPExpArrayFuncASP(ctx);
    }

    @Override
    public Object visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx) {
        return super.visitPExpFunLitASP(ctx);
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {
        return super.visitPExpHashLitASP(ctx);
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {
        return super.visitPExpPrintExpASP(ctx);
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {
        return super.visitPExpIfASP(ctx);
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {
        return super.visitArrayFunctions(ctx);
    }

    @Override
    public Object visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx) {
        return super.visitArrayLiteralASP(ctx);
    }

    @Override
    public Object visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx) {
        return super.visitFunctionLiteralASP(ctx);
    }

    @Override
    public Object visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx) {
        return super.visitFunctionParametersASP(ctx);
    }

    @Override
    public Object visitHashLiteralASP(projectParser.HashLiteralASPContext ctx) {
        return super.visitHashLiteralASP(ctx);
    }

    @Override
    public Object visitHashContentASP(projectParser.HashContentASPContext ctx) {
        return super.visitHashContentASP(ctx);
    }

    @Override
    public Object visitExpressionListF(projectParser.ExpressionListFContext ctx) {
        return super.visitExpressionListF(ctx);
    }

    @Override
    public Object visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx) {
        return super.visitPrintExpressionASP(ctx);
    }

    @Override
    public Object visitIfExpressionASP(projectParser.IfExpressionASPContext ctx) {
        return super.visitIfExpressionASP(ctx);
    }

    @Override
    public Object visitBlockStatementASP(projectParser.BlockStatementASPContext ctx) {
        return super.visitBlockStatementASP(ctx);
    }
}
