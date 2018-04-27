package checker;

import generated.projectParser;
import generated.projectParserBaseVisitor;

public class Checker extends projectParserBaseVisitor {
    private SymbolTable tableIDs = null;
    public Checker() { this.tableIDs = new SymbolTable(); }

    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {
        for (projectParser.StatementContext ele : ctx.statement())
            visit(ele);
        return null;
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {
        // System.out.println(ctx.getClass().getSimpleName()+"\n");
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");
        visit(ctx.expressionStatement());
        return null;
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");

        /*
         * identifier = expression ( ; | ε)
         * */

        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");

        /*
         * expression ( ; | ε)
         * */
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");
        /*
         * expression ( ; | ε)
         * */
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");
        /*
         * additionExpression comparison
         * */
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        return null;
    }

    @Override
    public Object visitComparisonAST(projectParser.ComparisonASTContext ctx) {
        //System.out.println(ctx.getClass().getSimpleName()+"\n");
        /*
         * ((<|>|<=|>=|==) additionExpression)*
         * */
        for (projectParser.AdditionExpressionContext ele : ctx.additionExpression())
            visit(ele);
        return null;
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {
        int type = (Integer) visit(ctx.multiplicationExpression(0));
        if (type==-1) return -1;
        if (type==-1 || (type==6 && ctx.ADDOPERATOR().size()>0)) return -1;
        for (int x=1;x<ctx.multiplicationExpression().size();x++){
            int nextType = (Integer) visit(ctx.multiplicationExpression(x));
            if(type!=2 && ctx.ADDOPERATOR(x - 1).getText().equals("-"))
                return -1;
            if(type != nextType){
                if(!ctx.ADDOPERATOR(x - 1).getText().equals(""))
                    return -1;
                else if(type==3 && nextType==2)
                    type=4;
                else if(type==4){
                    if(nextType==2)
                        type=4;
                    else if(nextType==3)
                        type=4;
                    else return -1;
                }
                else
                    return -1;
            }
        }
        return type;
    }

    @Override
    public Object visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx) {
        int type = (Integer) visit(ctx.elementExpression(0));
        if (type==-1 || (type==6 && ctx.MULOPERATOR().size()>0)) return -1;
        for (int x=1;x<ctx.elementExpression().size();x++){
            int nextType = (Integer) visit(ctx.elementExpression(x));
            if(type!=2 && ctx.MULOPERATOR(x - 1).getText().equals("/"))
                return -1;
            if(type != nextType){
                if(!ctx.MULOPERATOR(x - 1).getText().equals("-"))
                    return -1;
                else if(type==2)
                    if(nextType==3)
                        type=4;
                    else if(nextType==4)
                        type=4;
                    else if(nextType==5)
                        type=5;
                    else
                        return -1;
                else
                    return -1;
            }
        }
        return type;
    }

    @Override
    public Object visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx) {
        System.out.println(ctx.getClass().getSimpleName()+"\n");
        return null;
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {
        System.out.println(ctx.getClass().getSimpleName()+"\n");
        return null;
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {
        System.out.println(ctx.getClass().getSimpleName()+"\n");
        visit(ctx.primitiveExpression());
        return null;
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {
        System.out.println(ctx.getClass().getSimpleName()+"\n");
        return null;
    }

    @Override
    public Object visitCallExpressionASP(projectParser.CallExpressionASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExprIntASP(projectParser.PExprIntASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpStrASP(projectParser.PExpStrASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpIDASP(projectParser.PExpIDASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpTrueASP(projectParser.PExpTrueASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpFalseASP(projectParser.PExpFalseASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx) {
        return null;
    }

    @Override
    public Object visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx) {
        return null;
    }

    @Override
    public Object visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreIdentifiersASP(projectParser.MoreIdentifiersASPContext ctx) {
        return null;
    }

    @Override
    public Object visitHashLiteralASP(projectParser.HashLiteralASPContext ctx) {
        return null;
    }

    @Override
    public Object visitHashContentASP(projectParser.HashContentASPContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreHashContentASP(projectParser.MoreHashContentASPContext ctx) {
        return null;
    }

    @Override
    public Object visitExpressionListF(projectParser.ExpressionListFContext ctx) {
        return null;
    }

    @Override
    public Object visitExpressionListE(projectParser.ExpressionListEContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreExpressionsASP(projectParser.MoreExpressionsASPContext ctx) {
        return null;
    }

    @Override
    public Object visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx) {
        return null;
    }

    @Override
    public Object visitIfExpressionASP(projectParser.IfExpressionASPContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockStatementASP(projectParser.BlockStatementASPContext ctx) {
        return null;
    }
}