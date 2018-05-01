package checker;

import generated.projectParser;
import generated.projectParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Checker extends projectParserBaseVisitor {
    private SymbolTable tableIDs = null;
    public String errorList="";
    public Checker() { this.tableIDs = new SymbolTable(null); }
    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {
        for (projectParser.StatementContext ele : ctx.statement())
            visit(ele);
        return makeElement(0,ctx);
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {
        visit(ctx.letStatement());
        return makeElement(0,ctx);
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {
        visit(ctx.returnStatement());
        return makeElement(0,ctx);
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx) {
        visit(ctx.expressionStatement());
        return makeElement(0,ctx);
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {
        int tipo = getElementType(ctx.expression());
        if (tipo==-1)
            this.errorList+="\nError de asignación, en linea " + ctx.ASSIGN().getSymbol().getLine() + ", columna " + ctx.ASSIGN().getSymbol().getCharPositionInLine() + "; Expresión invalida";
        if (SymbolTable.actual.insertar(ctx.IDENTIFIER().getText(),tipo,ctx)==null)
            this.errorList+="\nError de asignación, en linea " + ctx.IDENTIFIER().getSymbol().getLine() + ", columna " + ctx.IDENTIFIER().getSymbol().getCharPositionInLine() + "; El identificador ya existe en este contexto";
        return makeElement(0,ctx);
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {
        visit(ctx.expression());
        return makeElement(0,ctx);
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {
        visit(ctx.expression());
        return makeElement(0,ctx);
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {
        int addExpType = getElementType(ctx.additionExpression());
        if(addExpType==-1) return addExpType;
        int comp = getElementType(ctx.comparison());

        if(comp==-1 || comp!=addExpType){
            return makeElement(-1,ctx);
        } else {
            return makeElement(addExpType,ctx);
        }
    }

    @Override
    public Object visitComparisonAST(projectParser.ComparisonASTContext ctx) {
        /**SOLO ENTEROS SE COMPARAN, EL == ES CON CUALQUIER TIPO BASICO**/
        int addExpType = getElementType(ctx.additionExpression(0));
        if(addExpType==-1) return makeElement(-1,ctx);
        for (projectParser.AdditionExpressionContext ele : ctx.additionExpression())
            if(getElementType(ele)==(addExpType)){
                return makeElement(-1,ctx);
            }
        return makeElement(addExpType,ctx);
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {
        int type = getElementType(ctx.multiplicationExpression(0));
        if (type==-1) return makeElement(-1,ctx);
        if (type==-1 || ((type==7 || type==6) && ctx.ADDOPERATOR().size()>0)) return makeElement(-1,ctx);
        for (Integer x=1;x<ctx.multiplicationExpression().size();x++){
            int nextType = getElementType(ctx.multiplicationExpression(x));
            if(!(type==2 || type==-2) && ctx.ADDOPERATOR(x - 1).getText().equals("-"))
                return makeElement(-1,ctx);
            if(type != nextType){
                if(!ctx.ADDOPERATOR(x - 1).getText().equals("-") && !(nextType==2 || nextType==-2))
                    return makeElement(-1,ctx);
                else if(type==2){
                    if(nextType==3)
                        type=3;
                    else return makeElement(-1,ctx);
                }
                else
                    return makeElement(-1,ctx);
            }
        }
        return type;
    }

    @Override
    public Object visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx) {
        int type = getElementType(ctx.elementExpression(0));
        if (type==-1 || ((type==7 || type==6) && ctx.MULOPERATOR().size()>0)) return makeElement(-1,ctx);
        for (Integer x=1;x<ctx.elementExpression().size();x++){
            int nextType = getElementType(ctx.elementExpression(x));
            if(!(type==2 || type==-2) && ctx.MULOPERATOR(x - 1).getText().equals("/"))
                return makeElement(-1,ctx);
            if(type != nextType){
                if(!ctx.MULOPERATOR(x - 1).getText().equals("/") && !(nextType==2 || nextType==-2))
                    return makeElement(-1,ctx);
                else if(type==2)
                    if(nextType==3)
                        type=4;
                    else if(nextType==4)
                        type=4;
                    else
                        return makeElement(-1,ctx);
                else
                    return makeElement(-1,ctx);
            }
        }
        return makeElement(type, ctx);
    }

    @Override
    public Object visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx) {
        int primExpType = getElementType(ctx.primitiveExpression());
        if(primExpType!=4 && primExpType!=5 && primExpType!=-2) return makeElement(-1,ctx);

        Integer elAccType = getElementType(ctx.elementAccess());
        if (elAccType.equals(2)){
            return makeElement(-2,ctx);
        } else {
            return makeElement(-1,ctx);
        }
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {
        int primExpType = getElementType(ctx.primitiveExpression());
        if(primExpType!=6 && primExpType!=-2) return makeElement(-1,ctx);

        if(primExpType == 6){
            projectParser.CallExpressionASPContext elCallExp =(projectParser.CallExpressionASPContext) ((SymbolTable.Element) visit(ctx.callExpression())).decl;
            int elAccExpSize = ((projectParser.ExpressionListFContext) elCallExp.expressionList().getRuleContext()).expression().size();

            projectParser.PExpFunLitASPContext funcLitExp = (projectParser.PExpFunLitASPContext) ((SymbolTable.Element) visit(ctx.primitiveExpression())).decl;
            projectParser.FunctionParametersASPContext funcParamsEpx = ((projectParser.FunctionParametersASPContext)((projectParser.FunctionLiteralASPContext) funcLitExp.functionLiteral().getRuleContext()).functionParameters());
            int funcParamsSize = funcParamsEpx.IDENTIFIER().size();

            if(elAccExpSize == funcParamsSize){
                return makeElement(0,ctx);
            } else {
                this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; No se tiene la cantidad de parámetros requeridos.";
                return makeElement(-1, ctx);
            }
        } else {
            int callExp = getElementType(ctx.callExpression());
            if (callExp == -1){
                this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Error en datos expression";
                return makeElement(-1,ctx);
            } else {
                return makeElement(0,ctx);
            }
        }
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {
        return visit(ctx.primitiveExpression());
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {
        if(getElementType(ctx.expression()) == -1){
            return makeElement(-1,ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitCallExpressionASP(projectParser.CallExpressionASPContext ctx) {
        if(getElementType(ctx.expressionList()) == -1){
            return makeElement(-1,ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitPExprIntASP(projectParser.PExprIntASPContext ctx) {
        return makeElement(2,ctx);
    }

    @Override
    public Object visitPExpStrASP(projectParser.PExpStrASPContext ctx) {
        return makeElement(3,ctx);
    }

    @Override
    public Object visitPExpIDASP(projectParser.PExpIDASPContext ctx) {
        SymbolTable.Element resul = SymbolTable.actual.buscar(ctx.IDENTIFIER().getText());
        if (resul!=null)
            return makeElement(resul.getType(),resul.decl);
        return makeElement(0,ctx);
    }

    @Override
    public Object visitPExpTrueASP(projectParser.PExpTrueASPContext ctx) {
        return makeElement(1,ctx);
    }

    @Override
    public Object visitPExpFalseASP(projectParser.PExpFalseASPContext ctx) {
        return makeElement(1,ctx);
    }

    @Override
    public Object visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx){
        return visit(ctx.expression());
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {
        return makeElement(4,ctx);
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {
        switch (ctx.arrayFunctions().getText()){
            case "len":
                return makeElement(2,ctx);
            case "first":
                return makeElement(-2,ctx);
            case "last":
                return makeElement(-2,ctx);
            case "rest":
                return makeElement(4,ctx);
            case "push":
                return makeElement(0,ctx);
        }
        return makeElement(-1,ctx);
    }

    @Override
    public Object visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx) {
        return makeElement(6,ctx);
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {
        return makeElement(5,ctx);
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {
        return visit(ctx.printExpression());
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {
        return visit(ctx.ifExpression());
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {
        return makeElement(0,ctx);
    }

    @Override
    public Object visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx) {
        if(getElementType(ctx.expressionList())==-1)
            return  makeElement(-1,ctx);
        return makeElement(4,ctx);
    }

    @Override
    public Object visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx) {
        if(getElementType(ctx.functionParameters())==-1){
            return makeElement(-1,ctx);
        }
        else if(getElementType(ctx.blockStatement())==-1){
            return makeElement(-1,ctx);
        }
        return makeElement(6,ctx);
    }

    @Override
    public Object visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx) {
        Integer error=0;
        for(TerminalNode ele : ctx.IDENTIFIER()){
            if(((SymbolTable.Element)visit(ele)).getType()!=-1){
                this.errorList+="\nError: parametros de función, linea " +ele.getSymbol().getLine() + " columna " +ele.getSymbol().getCharPositionInLine() + " parametro invalido";
                error=-1;
            }
        }
        return makeElement(error,ctx);
    }
    @Override
    public Object visitHashLiteralASP(projectParser.HashLiteralASPContext ctx) {
        for(projectParser.HashContentContext ele : ctx.hashContent()){
            int hashContType = getElementType(ele);
            if(hashContType == -1) return makeElement(hashContType, ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitHashContentASP(projectParser.HashContentASPContext ctx) {
        if (getElementType(ctx.expression(0))!=2){
            this.errorList+="\nError en la linea " + ctx.DOSPUN().getSymbol().getLine() + ", columna " + ctx.DOSPUN().getSymbol().getCharPositionInLine() + "; Error, la clave especificada no es de tipo numerico";
            makeElement(-1,ctx);
        }
        else if(getElementType(ctx.expression(1))==-1 || getElementType(ctx.expression(0))==0){
            this.errorList+="\nError en la linea " + ctx.DOSPUN().getSymbol().getLine() + ", columna " + ctx.DOSPUN().getSymbol().getCharPositionInLine() + "; Error, el valor asignado a la clave no es valido";
            return makeElement(-1,ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitExpressionListF(projectParser.ExpressionListFContext ctx) {
        for(projectParser.ExpressionContext ele: ctx.expression()){
            int expType = getElementType(ele);
            if(expType == -1) {
                this.errorList+="\nError de expresión, en linea " + ele.getStart().getLine() + ", columna " + ele.getStart().getCharPositionInLine() + "; Expresión invalida";
                return makeElement(expType, ctx);
            }
        }
        return makeElement(0,ctx);
    }


    @Override
    public Object visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx) {
        Integer type = getElementType(ctx.expression());
        if (type == 0 || type ==-1){
            this.errorList+="\nError: PUTS() linea " + ctx.PIZQ().getSymbol().getLine() + " columna " + ctx.PIZQ().getSymbol().getCharPositionInLine() + " expresión";
            return makeElement(-1,ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitIfExpressionASP(projectParser.IfExpressionASPContext ctx) {
        if(getElementType(ctx.expression())!=1){
            this.errorList+="\nError IF() linea " + ctx.expression().getStart().getLine() + " columna " + ctx.expression().getStart().getCharPositionInLine() + " la expresión debe ser booleano";
            return makeElement(-1,ctx);
        }
        else if (getElementType(ctx.blockStatement(0))==-1)
            return visit(ctx.blockStatement(0));
        else if (getElementType(ctx.blockStatement(ctx.blockStatement().size()-1))==-1)
            return visit(ctx.blockStatement(1));
        else
            return makeElement(0,ctx);
    }

    @Override
    public Object visitBlockStatementASP(projectParser.BlockStatementASPContext ctx) {
        for(projectParser.StatementContext ele : ctx.statement()){
            int stType = getElementType(ele);
            if(stType == -1){
                this.errorList+="\nError de expresión, en linea " + ele.getStart().getLine() + ", columna " + ele.getStart().getCharPositionInLine() + "; Expresión invalida en statement";
                return makeElement(stType,ctx);
            }
        }
        return makeElement(0, ctx);
    }

    private SymbolTable.Element makeElement(int type, ParserRuleContext ctx){
        return new SymbolTable.Element(new CommonToken(type,""),ctx);
    }
    private int getElementType(ParserRuleContext ctx){
        return ((SymbolTable.Element) visit(ctx)).getType();
    }
}