package checker;

import generated.projectParser;
import generated.projectParserBaseVisitor;

import java.util.ArrayList;

public class Checker extends projectParserBaseVisitor {
    private SymbolTable tableIDs = null;
    public String errorList="";
    public Checker() { this.tableIDs = new SymbolTable(null); }
    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {
        for (projectParser.StatementContext ele : ctx.statement())
            visit(ele);
        return null;
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {
        System.out.println("let");
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {
        System.out.println("ret");
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx) {
        visit(ctx.expressionStatement());
        return null;
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {
        int tipo = (Integer) visit(ctx.expression());
        if (tipo==-1)
            this.errorList+="Error de asignación, en linea " + ctx.ASSIGN().getSymbol().getLine() + ", columna " + ctx.ASSIGN().getSymbol().getCharPositionInLine() + "; Expresión invalida";
        if (SymbolTable.actual.insertar(ctx.IDENTIFIER().getText(),tipo,ctx)==null)
            this.errorList+="Error de asignación, en linea " + ctx.IDENTIFIER().getSymbol().getLine() + ", columna " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine() + "; El identificador ya existe en este contexto";
        return null;
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {
        Integer addExpType = (Integer) visit(ctx.additionExpression());
        if(addExpType==-1) return addExpType;
        Integer comp = (Integer) visit(ctx.comparison());

        if(comp==-1 || comp!=addExpType){
            return -1;
        } else {
            return addExpType;
        }
    }

    @Override
    public Object visitComparisonAST(projectParser.ComparisonASTContext ctx) {
        /**SOLO ENTEROS SE COMPARAN, EL == ES CON CUALQUIER TIPO BASICO**/
        Integer addExpType = (Integer) visit(ctx.additionExpression(0));
        if(addExpType==-1) return addExpType;
        for (projectParser.AdditionExpressionContext ele : ctx.additionExpression())
            if(visit(ele).equals(addExpType)){
                return -1;
            }
        return addExpType;
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {
        int type = (Integer) visit(ctx.multiplicationExpression(0));
        if (type==-1) return -1;
        if (type==-1 || ((type==7 || type==6) && ctx.ADDOPERATOR().size()>0)) return -1;
        for (int x=1;x<ctx.multiplicationExpression().size();x++){
            int nextType = (Integer) visit(ctx.multiplicationExpression(x));
            if(!(type==2 || type==-2) && ctx.ADDOPERATOR(x - 1).getText().equals("-"))
                return -1;
            if(type != nextType){
                if(!ctx.ADDOPERATOR(x - 1).getText().equals("-") && !(nextType==2 || nextType==-2))
                    return -1;
                else if(type==2){
                    if(nextType==3)
                        type=3;
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
        if (type==-1 || ((type==7 || type==6) && ctx.MULOPERATOR().size()>0)) return -1;
        for (int x=1;x<ctx.elementExpression().size();x++){
            int nextType = (Integer) visit(ctx.elementExpression(x));
            if(!(type==2 || type==-2) && ctx.MULOPERATOR(x - 1).getText().equals("/"))
                return -1;
            if(type != nextType){
                if(!ctx.MULOPERATOR(x - 1).getText().equals("/") && !(nextType==2 || nextType==-2))
                    return -1;
                else if(type==2)
                    if(nextType==3)
                        type=4;
                    else if(nextType==4)
                        type=4;
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
        Integer primExpType = (Integer) visit(ctx.primitiveExpression());
        if(primExpType==-1) return primExpType;

        if(primExpType.equals(4) || primExpType.equals(5)){
            String elAccType = (String) visit(ctx.elementAccess());
            if (elAccType.equals(2)){
                return primExpType;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {
        /**DUDA EN SI SERA NECESARIO DEVOLVER ALGO MAS**/
        Integer primExpType = (Integer) visit(ctx.primitiveExpression());
        if(primExpType==-1) return primExpType;

        if(primExpType.equals(6)){ //func en callexp
            visit(ctx.callExpression());
            return primExpType;
        } else {
            return -1;
        }
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {
        visit(ctx.primitiveExpression());
        return null;
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitCallExpressionASP(projectParser.CallExpressionASPContext ctx) {
        //todavia no se sabe a ciencia cierta el tipo
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPExprIntASP(projectParser.PExprIntASPContext ctx) {
        System.out.println(2);
        return 2;
    }

    @Override
    public Object visitPExpStrASP(projectParser.PExpStrASPContext ctx) {
        System.out.println(3);
        return 3;
    }

    @Override
    public Object visitPExpIDASP(projectParser.PExpIDASPContext ctx) {
        SymbolTable.Element resul = SymbolTable.actual.buscar(ctx.IDENTIFIER().getText());
        if (resul!=null)
            return resul.getType();
        return -1;
    }

    @Override
    public Object visitPExpTrueASP(projectParser.PExpTrueASPContext ctx) {
        return 1;
    }

    @Override
    public Object visitPExpFalseASP(projectParser.PExpFalseASPContext ctx) {
        return 1;
    }

    @Override
    public Object visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx){
        return visit(ctx.expression());
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {
        return 4;
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {
        return visit(ctx.arrayFunctions());
    }

    @Override
    public Object visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx) {
        return 6;
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {
        return 5;
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {
        visit(ctx.printExpression());
        return "void";
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {
        visit(ctx.ifExpression());
        return "void";
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {
        // switch con token
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
        for(projectParser.ExpressionContext ele: ctx.expression()){
            visit(ele);
        }
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