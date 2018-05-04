package checker;

import generated.projectParser;
import generated.projectParser.ExpressionContext;
import generated.projectParserBaseVisitor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Checker extends projectParserBaseVisitor {
    public String errorList="";
    private int isInsideFuncLit = 0;

    public Checker() {
        SymbolTable tableIDs = new SymbolTable(null);
    }
    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {
        Integer type = 0;
        for (projectParser.StatementContext ele : ctx.statement()){
            if (-1 == getElementType(ele)){
                type=-1;
                //this.errorList+="\nError de Statement encontrado";
            }
        }
        return makeElement(type,ctx);
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {
        return makeElement(getElementType(ctx.letStatement()),ctx);
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {
        return makeElement(getElementType(ctx.returnStatement()),ctx);
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx) {
        return makeElement(getElementType(ctx.expressionStatement()),ctx);
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {
        if(isReserved(ctx.IDENTIFIER())) return makeElement(-1,ctx);
        SymbolTable.Element expType = (SymbolTable.Element) visit(ctx.expression());

        System.out.println("assign .. "+ctx.IDENTIFIER().getSymbol().getText()+" let exp -- " + expType);

        if (expType.getType() == -1){
            //this.errorList+="\nError de asignación, en linea " + ctx.ASSIGN().getSymbol().getLine() + ", columna " + ctx.ASSIGN().getSymbol().getCharPositionInLine() + "; Expresión invalida.";
            return makeElement(-1,ctx);

        }
        else if(expType.getType() == 0){
            this.errorList+="\nError de asignación, en linea " + ctx.ASSIGN().getSymbol().getLine() + ", columna " + ctx.ASSIGN().getSymbol().getCharPositionInLine() + "; Expresión sin tipo.";
            return makeElement(-1,ctx);
        }
        else {
            SymbolTable.actual.insertar(ctx.IDENTIFIER().getSymbol().getText(), expType.getType(),expType.decl);
            SymbolTable.actual.imprimir();
            return makeElement(0,ctx);
        }
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {
        if(isInsideFuncLit > 0){
            int type = getElementType(ctx.expression());
            if(type != 0 && type != -1){
                return makeElement(-2,ctx);
            } else {
                this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Error, la expresión a retornar no tiene tipo.";
                return makeElement(-1,ctx);
            }
        }
        this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Error, return debe estar dentro de una función.";
        return makeElement(-1,ctx);
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {
        int type = getElementType(ctx.expression());
        if(type != 0){
            this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Expresión invalida, debe estar contenida en una variable o expresión correcta.";
            return makeElement(-1,ctx);
        }
        return makeElement(0, ctx);
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {
        SymbolTable.Element addExp = (SymbolTable.Element) visit(ctx.additionExpression());
        int addExpType=addExp.getType();
        if(-1 == addExpType) {
            return makeElement(addExp.getType(), addExp.decl);
        }

        SymbolTable.Element comp = (SymbolTable.Element) visit(ctx.comparison());
        if (comp.getType()==0){
            return makeElement(addExpType,addExp.decl);
        }
        else if(-1 == comp.getType()){
            addExpType=-1;
        }
        else if (comp.getType() != addExpType && !(comp.getType() == -2 || addExpType ==-2)){
            this.errorList+="\nError linea " + ctx.getStart().getLine() + " comparación entre tipos distintos";
            addExpType=-1;
        }
        else if (!((projectParser.ComparisonASTContext) comp.decl).COMPARATOR(0).getSymbol().getText().equals("==") && ((addExpType!=2 && addExpType!=-2) || (comp.getType()!=2 && comp.getType()!=-2))) {
            this.errorList+="\nError linea " + ctx.getStart().getLine() + " comparación invalida entre tipos no numericos";
            addExpType=-1;
        }
        return makeElement(addExpType,ctx);
    }

    @Override
    public Object visitComparisonAST(projectParser.ComparisonASTContext ctx) {
        if(ctx.additionExpression().size()==0){
            return makeElement(0,ctx);
        }
        SymbolTable.Element addExp = (SymbolTable.Element) visit(ctx.additionExpression(0));
        int addExpType = addExp.getType();
        if (-1 == addExpType) {
            return makeElement(-1, ctx);
        } else if(addExpType==0) {
            this.errorList+="\nError linea " + ctx.getStart() + " comparación invalida";
            return makeElement(-1, ctx);
        }
        for (int x=1;x<ctx.additionExpression().size();x++) {
            int temporalType = getElementType(ctx.additionExpression(x));
            if(temporalType!=(addExpType) && !(addExpType==-2 || temporalType==-2)){
                this.errorList+="\nError linea " + ctx.getStart() + " comparación entre tipos distintos";
                return makeElement(-1,ctx);
            }
            if(!ctx.COMPARATOR(x-1).getSymbol().getText().equals("==") && addExpType!=2 && addExpType!=-2){
                this.errorList+="\nError linea " + ctx.getStart() + " comparación invalida entre tipos no numericos";
                return makeElement(-1,ctx);
            }
            if(addExpType==-2 && temporalType!=-2)
                addExpType=temporalType;
        }
        return makeElement(addExpType,ctx);
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {
        SymbolTable.Element multExp = (SymbolTable.Element) visit(ctx.multiplicationExpression(0));
        int type = multExp.getType();
        if (-1 == type) {
            return makeElement(-1,ctx);
        }
        if ((type >3) && ctx.ADDOPERATOR().size() > 0) {
            this.errorList+="\nError: linea " + ctx.getStart().getLine() + " operación con tipos incompatibles";
            return makeElement(-1,ctx);
        }
        for (Integer x=1;x<ctx.multiplicationExpression().size();x++){
            int nextType = getElementType(ctx.multiplicationExpression(x));
            if(!(type==2 || type==-2) && ctx.ADDOPERATOR(x - 1).getText().equals("-")) {
                errorList+="\nError: linea " + ctx.multiplicationExpression(x-1).getStart().getLine() + " columna " + ctx.multiplicationExpression(x).getStart().getCharPositionInLine() + " resta con tipos no numericos";
                return makeElement(-1,ctx);
            }
            if(type != nextType){
                if(ctx.ADDOPERATOR(x - 1).getText().equals("-") && !(nextType==2 || nextType==-2)) {
                    errorList+="\nError: linea " + ctx.multiplicationExpression(x-1).getStart().getLine() + " columna " + ctx.multiplicationExpression(x).getStart().getCharPositionInLine() + " resta con tipos no numericos";
                    return makeElement(-1,ctx);
                }
                else if(type==2 && nextType==3)
                        type=3;
                else if (type != 3 || nextType != 2) {
                    this.errorList+="Error: linea " + ctx.getStart().getLine() + ", columna " + ctx.multiplicationExpression(x).getStart().getCharPositionInLine() + " adición entre tipos incompatibles";
                    return makeElement(-1,ctx);
                }
            }
        }
        return makeElement(type, multExp.decl);
    }

    @Override
    public Object visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx) {
        SymbolTable.Element eleExp= (SymbolTable.Element) visit(ctx.elementExpression(0));
        int type = eleExp.getType();
        if (-1 == type) return makeElement(-1,ctx);
        else if ((type>3) && ctx.MULOPERATOR().size()>0){
            this.errorList+="\nError: linea " + ctx.getStart().getLine() + " operación con tipos incompatibles";
            return makeElement(-1,ctx);
        }
        for (Integer x=1;x<ctx.elementExpression().size();x++){
            int nextType = getElementType(ctx.elementExpression(x));
            if(!(type==2 || type==-2) && ctx.MULOPERATOR(x - 1).getText().equals("/")) {
                errorList+="\nError: linea " + ctx.elementExpression(x-1).getStart().getLine() + " columna " + ctx.elementExpression(x-1).getStart().getCharPositionInLine() + " división con tipos no numericos";
                return makeElement(-1,ctx);
            }
            if(type != nextType){
                if(!ctx.MULOPERATOR(x - 1).getText().equals("/") && !(nextType==2 || nextType==-2)) {
                    errorList+="\nError: linea " + ctx.elementExpression(x).getStart().getLine() + " columna " + ctx.elementExpression(x).getStart().getCharPositionInLine() + " división con tipos no numericos";
                    return makeElement(-1,ctx);
                }
                else if(type==2 && (nextType==3 || nextType==4))
                    type=4;
                else if(nextType==2 && (type==3 || type==4))
                    type=4;
                else {
                    errorList+="\nError: linea " + ctx.elementExpression(x-1).getStart().getLine() + " columna " + ctx.elementExpression(x).getStart().getCharPositionInLine() + " multiplicacióon con tipos incompatibles";
                    return makeElement(-1,ctx);
                }
            }
        }
        return makeElement(type, eleExp.decl);
    }

    @Override
    public Object visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx) {
        SymbolTable.Element priExp = (SymbolTable.Element) visit(ctx.primitiveExpression());
        int primExpType = priExp.getType();
        if(primExpType!=4 && primExpType!=5 && primExpType!=-2) return makeElement(-1,ctx);

        if (getElementType(ctx.elementAccess()) != -1){
            return makeElement(-2,ctx);
        } else {
            return makeElement(-1,ctx);
        }
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {
        int primExpType = getElementType(ctx.primitiveExpression());
        if(primExpType!=6 && primExpType!=-2) return makeElement(-1,ctx);

        projectParser.CallExpressionASPContext elCallExp =(projectParser.CallExpressionASPContext) ((SymbolTable.Element) visit(ctx.callExpression())).decl;

        int elAccExpSize = ((projectParser.ExpressionListFContext) elCallExp.expressionList().getRuleContext()).expression().size();
        projectParser.FunctionLiteralASPContext funcLitExp = (projectParser.FunctionLiteralASPContext) ((SymbolTable.Element) visit(ctx.primitiveExpression())).decl;
        projectParser.FunctionParametersASPContext funcParamsEpx = ((projectParser.FunctionParametersASPContext) funcLitExp.functionParameters());
        int funcParamsSize = funcParamsEpx.IDENTIFIER().size();

        if(elAccExpSize == funcParamsSize){
            if(funcLitExp.blockStatement().returns){
                System.out.println("BlockStatement Retorna");
                return makeElement(-2,ctx);
            }
            return makeElement(0,ctx);
        } else {
            this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; No se tiene la cantidad de parámetros requeridos.";
            return makeElement(-1, ctx);
        }
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {
        SymbolTable.Element priExp = (SymbolTable.Element) visit(ctx.primitiveExpression());
        return makeElement(priExp.getType(),priExp.decl);
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {
        int expType = getElementType(ctx.expression());
        if(expType != 2 && expType!=-2){
            this.errorList+="\nError de expresión, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Los índices solo aceptan enteros.";
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
        if (isReserved(ctx.IDENTIFIER()))
            return makeElement(-1,ctx);
        SymbolTable.Element resul = SymbolTable.actual.buscar(ctx.IDENTIFIER().getSymbol().getText());
        if (resul!=null)
            return makeElement(resul.getType(),resul.decl);
        this.errorList+="\nError de asignación, en linea " + ctx.getStart().getLine() + ", columna " + ctx.getStart().getCharPositionInLine() + "; Variable no existe en este contexto.";
        return makeElement(-1,ctx);
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
        SymbolTable.Element Exp = (SymbolTable.Element) visit(ctx.expression());
        return makeElement(Exp.getType(),Exp.decl);
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {
        return makeElement(4,ctx);
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {
        if (-1 == ((SymbolTable.Element) visit(ctx.expressionList())).getType()){
            return makeElement(-1,ctx);
        }
        switch (ctx.arrayFunctions().getStart().getText()){
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
        return visit(ctx.functionLiteral());
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {
        return visit(ctx.hashLiteral());
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {
        return visit(ctx.printExpression());
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {
        SymbolTable.Element ifType = (SymbolTable.Element) visit(ctx.ifExpression());
        if(ifType.getType() == -1){
            return makeElement(-1, ctx);
        }
        return ifType;
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {
        return makeElement(0,ctx);
    }

    @Override
    public Object visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx) {
        if(-1 == getElementType(ctx.expressionList()))
            return  makeElement(-1,ctx);
        return makeElement(4,ctx);
    }

    @Override
    public Object visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx) {
        SymbolTable.actual.openScope();isInsideFuncLit++;
        int paramsFunc = getElementType(ctx.functionParameters());
        SymbolTable.Element blockSt =(SymbolTable.Element) visit(ctx.blockStatement());
        SymbolTable.actual.closeScope();isInsideFuncLit--;
        if(ctx.blockStatement().returns)
            System.out.println("Retorna");
        if(paramsFunc == -1 || blockSt.getType() == -1) return makeElement(-1,ctx);
        return makeElement(6,ctx);
    }

    @Override
    public Object visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx) {
        Integer status=0;
        for(TerminalNode ele : ctx.IDENTIFIER()){
            if (isReserved(ele) || SymbolTable.actual.buscarLocal(ele.getSymbol().getText())!=null) {
                this.errorList+="\nError: parametros de función, linea " +ele.getSymbol().getLine() + " columna " +ele.getSymbol().getCharPositionInLine() + " parametro invalido o duplicado.";
                return makeElement(-1,ctx);
            }
            else {
                SymbolTable.actual.insertar(ele.getSymbol().getText(),-2,ctx);
            }
        }
        return makeElement(status,ctx);
    }
    @Override
    public Object visitHashLiteralASP(projectParser.HashLiteralASPContext ctx) {
        int type = 5;
        System.out.println(ctx.hashContent().size());
        if(ctx.hashContent().size() == 0){
            this.errorList+="\nError en la linea " + ctx.LLAVEIZQ().getSymbol().getLine() + ", columna " + ctx.LLAVEIZQ().getSymbol().getCharPositionInLine() + "; Error, hash sin contenido.";
            makeElement(-1,ctx);
        }
        for(projectParser.HashContentContext ele : ctx.hashContent()){
            int hashContType = getElementType(ele);
            if(hashContType == -1) {
                return makeElement(-1,ctx);
            }
        }
        return makeElement(type,ctx);
    }

    @Override
    public Object visitHashContentASP(projectParser.HashContentASPContext ctx) {
        if(ctx.expression().size() == 0){
            this.errorList+="\nError en la linea " + ctx.DOSPUN().getSymbol().getLine() + ", columna " + ctx.DOSPUN().getSymbol().getCharPositionInLine() + "; Error, no se puede declarar un elemento hash vacío.";
            return makeElement(-1,ctx);
        }
        if (getElementType(ctx.expression(0))!=2){
            this.errorList+="\nError en la linea " + ctx.DOSPUN().getSymbol().getLine() + ", columna " + ctx.DOSPUN().getSymbol().getCharPositionInLine() + "; Error, la clave especificada no es de tipo numerico.";
            makeElement(-1,ctx);
        }
        else if(-1 == getElementType(ctx.expression(1)))
            return makeElement(-1,ctx);
        else if(getElementType(ctx.expression(0))==0){
            this.errorList+="\nError en la linea " + ctx.DOSPUN().getSymbol().getLine() + ", columna " + ctx.DOSPUN().getSymbol().getCharPositionInLine() + "; Error, el valor asignado a la clave no es valido";
            return makeElement(-1,ctx);
        }
        return makeElement(0,ctx);
    }

    @Override
    public Object visitExpressionListF(projectParser.ExpressionListFContext ctx) {
        int type = 0;
        for(ExpressionContext ele: ctx.expression()){
            int expType = getElementType(ele);
            if(expType == -1) {
                this.errorList+="\nError de expresión, en linea " + ele.getStart().getLine() + ", columna " + ele.getStart().getCharPositionInLine() + "; Expresión invalida";
                return makeElement(-1,ctx);
            }
        }
        return makeElement(type,ctx);
    }


    @Override
    public Object visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx) {
        Integer type = getElementType(ctx.expression());
        if (-1 == type)
            return makeElement(-1,ctx);
        else if (type == 0 ){
            this.errorList+="\nError: PUTS() linea " + ctx.PIZQ().getSymbol().getLine() + " columna " + ctx.PIZQ().getSymbol().getCharPositionInLine() + " expresión inválida para método puts()";
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
        else if (-1 == getElementType(ctx.blockStatement(0)) || -1 == getElementType(ctx.blockStatement(ctx.blockStatement().size() - 1))) {
            return makeElement(-1,ctx);
        } else
            return makeElement(0,ctx);
    }

    @Override
    public Object visitBlockStatementASP(projectParser.BlockStatementASPContext ctx) {
        int typeErr = 0;
        for(projectParser.StatementContext ele : ctx.statement()){
            int stType = getElementType(ele);
            if(stType == -1){
                return makeElement(-1,ctx);
            }
            if(stType != 0){
                ctx.returns=true;
                typeErr = stType;
                }
        }
        return makeElement(typeErr, ctx);
    }

    private SymbolTable.Element makeElement(int type, ParserRuleContext ctx){
        return new SymbolTable.Element(new CommonToken(type,""),ctx);
    }
    private Integer getElementType(ParserRuleContext ctx){
        return ((SymbolTable.Element) visit(ctx)).getType();
    }
    private boolean isReserved(TerminalNode ID){
        if (ID.getSymbol().getText().matches("len|first|last|rest|push|fn|puts|if|else")) {
            this.errorList+="\nError de identificador, en la linea " +ID.getSymbol().getLine() + " columna " + ID.getSymbol().getCharPositionInLine() + "; El identificador no puede ser una palabra reservada";
            return true;
        }
        return false;
    }
}