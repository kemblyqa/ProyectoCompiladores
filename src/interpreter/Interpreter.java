package interpreter;

import generated.projectParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Interpreter extends generated.projectParserBaseVisitor{
    private DataStorage dataS;
    private EvaluationStack evalStack;
    public String errorList;
    public String log;
    private int callcounter=0;
    public Interpreter(){
        DataStorage.actual=new DataStorage(null);
        this.evalStack = new EvaluationStack();
        this.errorList="";
        this.log="";
    }

    @Override
    public Object visitProgAST(projectParser.ProgASTContext ctx) {//ok
        for (projectParser.StatementContext ele : ctx.statement()){
            visit(ele);
            if(!this.errorList.equals(""))
                return null;
        }
        return null;
    }

    @Override
    public Object visitStLetAST(projectParser.StLetASTContext ctx) {//ok
        visit(ctx.letStatement());
        return null;
    }

    @Override
    public Object visitStReturnAST(projectParser.StReturnASTContext ctx) {//ok
        if(this.callcounter==0){
            addError(ctx.RETURN().getSymbol(),"Retorno fuera de llamada a una función");
            return null;
        }
        visit(ctx.returnStatement());
        return null;
    }

    @Override
    public Object visitStExpressAST(projectParser.StExpressASTContext ctx){//ok
        visit(ctx.expressionStatement());
        return null;
    }

    @Override
    public Object visitLetStatementAST(projectParser.LetStatementASTContext ctx) {//ok
        visit(ctx.expression());
        Object temp = this.evalStack.popValue();
        if(temp!=null)
            DataStorage.actual.addData(ctx.IDENTIFIER().getText(),temp);
        else
            addError(ctx.IDENTIFIER().getSymbol(),"se ha intentado asignar un valor nulo a una variable");
        return null;
    }

    @Override
    public Object visitReturnStatementAST(projectParser.ReturnStatementASTContext ctx) {//ok
        visit(ctx.expression());
        Object value = this.evalStack.popValue();
        if(value==null){
            addError(ctx.expression().getStart(),"Valor de retorno no encontrado");
            return null;
        }
        DataStorage.actual.addData("return",value);
        return null;
    }

    @Override
    public Object visitExpressionStatementAST(projectParser.ExpressionStatementASTContext ctx) {//ok
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitExpressionAST(projectParser.ExpressionASTContext ctx) {//ok
        if(ctx.additionExpression().size()>1){
            Boolean status = true;
            for(int x = 0 ; x + 1 < ctx.additionExpression().size();x++){
                visit(ctx.additionExpression(x));
                visit(ctx.additionExpression(x+1));
                Object last = this.evalStack.popValue();
                Object first = this.evalStack.popValue();
                if(last==null || first==null){
                    this.addError(ctx.COMPARATOR(x).getSymbol(),"Comparación con valores no validos");
                    return null;
                }
                switch (ctx.COMPARATOR(x).getSymbol().getText()){
                    case "==":
                        if(!last.equals(first))
                            status = false;
                        break;
                    case "!=":
                        if(last.equals(first))
                            status = false;
                        break;
                    case "<=":
                        if(!first.equals(last)&&(!(isInteger(first)&&isInteger(last)) || (Integer)first>(Integer)last))
                            status = false;
                        break;
                    case "<":
                        if(!(isInteger(first)&&isInteger(last)) || (Integer)first>(Integer)last)
                            status = false;
                        break;
                    case ">=":
                        if(!first.equals(last)&&(!(isInteger(first)&&isInteger(last)) || (Integer)first<(Integer)last))
                            status = false;
                        break;
                    case ">":
                        if(!(isInteger(first)&&isInteger(last)) || (Integer)first<(Integer)last)
                            status = false;
                        break;
                }
            }
            this.evalStack.pushValue(status);
        }
        else{
            visit(ctx.additionExpression(0));
        }
        return null;
    }

    @Override
    public Object visitAdditionExpressionAST(projectParser.AdditionExpressionASTContext ctx) {//ok
        visit(ctx.multiplicationExpression(0));
        if(ctx.multiplicationExpression().size()==ctx.ADDOPERATOR().size()){
            if (ctx.ADDOPERATOR(0).getSymbol().getText().equals("-")){
                Object value = this.evalStack.popValue();
                if(value==null){
                    this.addError(ctx.multiplicationExpression(0).start,"Valor invalido");
                }
                else if(!value.getClass().getSimpleName().equals("Integer")){
                    addError(ctx.ADDOPERATOR(0).getSymbol(),"resta numerica con un valor no numerico");
                    this.evalStack.pushValue(null);
                }
                else{
                    Integer nvalue = (Integer) value;
                    this.evalStack.pushValue(-1*nvalue);
                }
            }
            ctx.ADDOPERATOR().remove(0);
        }
        for(Integer x = 1;x<ctx.multiplicationExpression().size();x++){
            Object first = this.evalStack.popValue();
            visit(ctx.multiplicationExpression(x));
            Object last = this.evalStack.popValue();
            if(last==null || first==null){
                this.addError(ctx.multiplicationExpression(x).getStart(),"Adición con valores no validos");
                return null;
            }
            org.antlr.v4.runtime.Token ops = ctx.ADDOPERATOR(x-1).getSymbol();
            if(ops.getText().equals("-")){
                if(isInteger(first)&&isInteger(last)){
                    Integer iFirst = (Integer)first;
                    Integer iLast = (Integer)last;
                    this.evalStack.pushValue(iFirst-iLast);
                }
                else{
                    addError(ctx.ADDOPERATOR(x-1).getSymbol(),"Error restando tipos:"+first.getClass().getSimpleName()+","+last.getClass().getSimpleName());
                    this.evalStack.pushValue(null);
                }
            }
            else {
                Object res;
                if(first.getClass().getSimpleName().equals("Boolean")){
                    res = boolPlus((Boolean)first,last);
                }
                else if(first.getClass().getSimpleName().equals("Integer")){
                    res = intPlus((Integer) first,last);
                }
                else if(first.getClass().getSimpleName().equals("String")){
                    res = strPlus((String) first,last);
                }
                else if(first.getClass().getSimpleName().equals("Character")){
                    res = charPlus((Character) first,last);
                }
                else if(first.getClass().getSimpleName().equals("ArrayList")){
                    res = arrPlus((ArrayList) first,last);
                }
                else{
                    res = hashPlus((HashMap) first,last);
                }
                if(res==null)
                    addError(ops,"Error de tipos en adicion"+first.getClass().getSimpleName()+","+last.getClass().getSimpleName());
                this.evalStack.pushValue(res);
            }
        }
        return null;
    }

    @Override
    public Object visitMultiplicationExpressionASP(projectParser.MultiplicationExpressionASPContext ctx) {
        visit(ctx.elementExpression(0));
        for(int x=1;x<ctx.elementExpression().size();x++){
            Object res=null;
            Object first=this.evalStack.popValue();
            visit(ctx.elementExpression(x));
            Object last = this.evalStack.popValue();

            if(last==null || first==null){
                this.addError(ctx.MULOPERATOR(x-1).getSymbol(),"Multiplicacion con valores no validos");
                return null;
            }
            else if(ctx.MULOPERATOR(x-1).getSymbol().getText().equals("/")){
                if(first.getClass().getSimpleName().equals("Integer") && last.getClass().getSimpleName().equals("Integer"))
                    res = (Integer)first/(Integer)last;
                else
                    addError(ctx.MULOPERATOR(x-1).getSymbol(),"Error al dividir valores no numericos");
            }
            else{
                if(first.getClass().getSimpleName().equals("Boolean") && last.getClass().getSimpleName().equals("Boolean"))
                    res = (Boolean)first && (Boolean)last;
                else if(first.getClass().getSimpleName().equals("Integer"))
                    res = nTimes((Integer)first,last);
                else if(last.getClass().getSimpleName().equals("Integer"))
                    res = nTimes((Integer)last,first);
                if(res==null)
                    addError(ctx.MULOPERATOR(x-1).getSymbol(),"Error operando valores incompatibles: " + first.getClass().getSimpleName()+","+last.getClass().getSimpleName());
            }
            this.evalStack.pushValue(res);
        }
        return null;
    }

    @Override
    public Object visitEleExpEleAcc(projectParser.EleExpEleAccContext ctx) {//ok
        visit(ctx.elementAccess());
        Integer access = (Integer) this.evalStack.popValue();
        if(access==null)
            return null;
        visit(ctx.elementExpression());
        Object map = this.evalStack.popValue();
        if(map==null){
            this.addError(ctx.elementExpression().start,"Error obteniendo el Mapa/Lista");
            return null;
        }
        switch (map.getClass().getSimpleName()) {
            case "HashMap":
                HashMap h = (HashMap) map;
                this.evalStack.pushValue(h.get(access));
                break;
            case "ArrayList":
                ArrayList a = (ArrayList) map;
                this.evalStack.pushValue(a.get(access));
                break;
            default:
                this.addError(ctx.elementExpression().start, "El elemento solicitado no es de tipo accesible");
                this.evalStack.pushValue(null);
                break;
        }
        return null;
    }

    @Override
    public Object visitEleExpCall(projectParser.EleExpCallContext ctx) {//ok
        visit(ctx.callExpression());
        visit(ctx.elementExpression());
        Object rawFunction = this.evalStack.popValue();
        if(rawFunction==null){
            this.addError(ctx.elementExpression().start,"Error obteniendo función");
            return null;
        }
        else if(rawFunction.getClass().getSimpleName().equals("FunctionLiteralASPContext")){
            this.callcounter++;
            DataStorage.actual.openScope();
            projectParser.FunctionLiteralASPContext function = (projectParser.FunctionLiteralASPContext) rawFunction;
            List<TerminalNode> parameters = ((projectParser.FunctionParametersASPContext)function.functionParameters()).IDENTIFIER();

            Object c = this.evalStack.popValue();
            if(c==null || !c.getClass().getSimpleName().equals("Integer")){
                this.addError(ctx.start,"Error interpretando elemento de la lista");
                return null;
            }
            Integer counter = (Integer) c;
            for(int x = counter-1;x >= 0;x--){
                Object parametro = this.evalStack.popValue();
                if(parametro==null){
                    this.addError(parameters.get(x).getSymbol(),"Error obteniendo parametros");
                    return null;
                }
                DataStorage.actual.addData(parameters.get(x).getText(),parametro);
            }
            visit(function.blockStatement());
            if(DataStorage.actual.getData("return")!=null)
                this.evalStack.pushValue(DataStorage.actual.getData("return"));
            DataStorage.actual.closeScope();
            this.callcounter--;
        }
        else{
            this.evalStack.pushValue(null);
            addError(ctx.elementExpression().stop,"Llamada a un valor que no es función: " + rawFunction.getClass().getSimpleName());
        }
        return null;
    }

    @Override
    public Object visitEleExpPriOnly(projectParser.EleExpPriOnlyContext ctx) {//ok
        visit(ctx.primitiveExpression());
        return null;
    }

    @Override
    public Object visitElementAccessASP(projectParser.ElementAccessASPContext ctx) {//ok
        visit(ctx.expression());
        Object access = this.evalStack.popValue();
        if(access==null){
            addError(ctx.expression().getStart(),"Error obteniendo elementAccess");
            return null;
        }
        else if(!access.getClass().getSimpleName().equals("Integer")){
            addError(ctx.expression().start,"Valor no numerico como indice de acceso");
            this.evalStack.pushValue(null);
        }
        else
            this.evalStack.pushValue(access);
        return null;
    }

    @Override
    public Object visitCallExpressionASP(projectParser.CallExpressionASPContext ctx) {//ok
        visit(ctx.expressionList());
        return null;
    }

    @Override
    public Object visitPExprIntASP(projectParser.PExprIntASPContext ctx) {//ok
        this.evalStack.pushValue(Integer.parseInt(ctx.INTEGER().getSymbol().getText()));
        return null;
    }

    @Override
    public Object visitPExpStrASP(projectParser.PExpStrASPContext ctx) {//ok
        this.evalStack.pushValue(ctx.STRING().getSymbol().getText());
        return null;
    }

    @Override
    public Object visitPExpIDASP(projectParser.PExpIDASPContext ctx) {//ok
        Object value = DataStorage.actual.getData(ctx.IDENTIFIER().getSymbol().getText());
        if(value==null){
            this.addError(ctx.IDENTIFIER().getSymbol(),"Identificador no declarado");
            return null;
        }
        this.evalStack.pushValue(value);
        return null;
    }

    @Override
    public Object visitPExpTrueASP(projectParser.PExpTrueASPContext ctx) {//ok
        this.evalStack.pushValue(true);
        return null;
    }

    @Override
    public Object visitPExpFalseASP(projectParser.PExpFalseASPContext ctx) {//ok
        this.evalStack.pushValue(true);
        return null;
    }

    @Override
    public Object visitPExpParExpParASP(projectParser.PExpParExpParASPContext ctx) {//ok
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitPExpArrayLitASP(projectParser.PExpArrayLitASPContext ctx) {//ok
        visit(ctx.arrayLiteral());
        Object array = this.evalStack.popValue();
        if(array==null){
            this.addError(ctx.arrayLiteral().start,"Error obteniendo la lista");
            return null;
        }
        this.evalStack.pushValue(((ArrayList)array));
        return null;
    }

    @Override
    public Object visitPExpArrayFuncASP(projectParser.PExpArrayFuncASPContext ctx) {//ok
        visit(ctx.expressionList());
        visit(ctx.arrayFunctions());
        return null;
    }

    @Override
    public Object visitPExpFunLitASP(projectParser.PExpFunLitASPContext ctx) {//ok
        this.evalStack.pushValue(ctx.functionLiteral());
        return null;
    }

    @Override
    public Object visitPExpHashLitASP(projectParser.PExpHashLitASPContext ctx) {//ok
        visit(ctx.hashLiteral());
        return null;
    }

    @Override
    public Object visitPExpPrintExpASP(projectParser.PExpPrintExpASPContext ctx) {//ok
        visit(ctx.printExpression());
        return null;
    }

    @Override
    public Object visitPExpIfASP(projectParser.PExpIfASPContext ctx) {//ok
        visit(ctx.ifExpression());
        return null;
    }

    @Override
    public Object visitArrayFunctions(projectParser.ArrayFunctionsContext ctx) {//ok
        ArrayList explist = new ArrayList();
        Object c = this.evalStack.popValue();
        if(c==null || !c.getClass().getSimpleName().equals("Integer")){
            this.addError(ctx.start,"Error interpretando elemento de la lista");
            return null;
        }
        Integer counter = (Integer) c;
        for(int x=0;x<counter;x++){
            Object item = this.evalStack.popValue();
            if(item==null){
                this.addError(ctx.getStart(),"Parametro de operacion no valido");
                return null;
            }
            explist.add(0,item);
        }
        if(!explist.get(0).getClass().getSimpleName().equals("ArrayList")){

            addError(ctx.getStart(),"El primer parametro debe de ser una lista: "+explist.get(0).getClass().getSimpleName());
            this.evalStack.pushValue(null);
            return null;
        }
        ArrayList a = ((ArrayList)explist.get(0));
        switch (ctx.getStart().getText()){
            case "len":
                this.evalStack.pushValue(a.size());
                break;
            case "first":
                this.evalStack.pushValue(a.get(0));
                break;
            case "last":
                this.evalStack.pushValue(a.get(a.size()-1));
                break;
            case "rest":
                ArrayList res=new ArrayList();
                for(int x = 1;x<a.size();x++)
                    res.add(a.get(x));
                this.evalStack.pushValue(res);
                break;
            case "push":
                a.add(explist.get(1));
                this.evalStack.pushValue(a);
                break;
        }
        return null;
    }

    @Override
    public Object visitArrayLiteralASP(projectParser.ArrayLiteralASPContext ctx) {//ok
        visit(ctx.expressionList());
        ArrayList result = new ArrayList();
        Object c = this.evalStack.popValue();
        if(c==null || !c.getClass().getSimpleName().equals("Integer")){
            this.addError(ctx.expressionList().start,"Error interpretando elemento de la lista");
            return null;
        }
        Integer counter = (Integer) c;
        for(int x=0;x<counter;x++){
            Object item = this.evalStack.popValue();
            if(item == null){
                this.addError(ctx.expressionList().start,"Error interpretando elemento de la lista");
                return null;
            }
            result.add(0,item);
        }
        this.evalStack.pushValue(result);
        return null;
    }

    @Override
    public Object visitFunctionLiteralASP(projectParser.FunctionLiteralASPContext ctx) {//ok
        this.evalStack.pushValue(ctx);
        return null;
    }

    @Override
    public Object visitFunctionParametersASP(projectParser.FunctionParametersASPContext ctx) {//ok
        return null;
    }

    @Override
    public Object visitHashLiteralASP(projectParser.HashLiteralASPContext ctx) {//ok
        HashMap res = new HashMap();
        for(projectParser.HashContentContext x : ctx.hashContent()){
            visit(x);
            Object value = this.evalStack.popValue();
            Object key = this.evalStack.popValue();
            if(key==null || value==null){
                addError(x.getStart(),"Tupla clave:valor invalida: " +key+":"+value);
                return null;
            }
            res.put(key,value);
        }
        this.evalStack.pushValue(res);
        return null;
    }

    @Override
    public Object visitHashContentASP(projectParser.HashContentASPContext ctx) {
        visit(ctx.expression(0));
        Object key = this.evalStack.popValue();
        if(key==null){
            this.addError(ctx.expression(0).getStart(),"Error interpretando clave de hash");
        }
        else if(!key.getClass().getSimpleName().equals("Integer")){
            addError(ctx.expression(0).start,"Valor de clave de hash no numerico");
        }
        else{
            this.evalStack.pushValue(key);
            visit(ctx.expression(1));
        }
        return null;
    }

    @Override
    public Object visitExpressionListF(projectParser.ExpressionListFContext ctx) {
        Integer c=0;
        for(projectParser.ExpressionContext e:ctx.expression()){
            visit(e);
            c++;
        }
        this.evalStack.pushValue(c);
        return null;
    }

    @Override
    public Object visitPrintExpressionASP(projectParser.PrintExpressionASPContext ctx) {
        visit(ctx.expression());
        Object text = this.evalStack.popValue();
        if(text==null){
            this.addError(ctx.expression().getStart(),"Error interpretando valor a imprimir");
            return null;
        }
        this.log+=String.valueOf(text);
        return null;
    }

    @Override
    public Object visitIfExpressionASP(projectParser.IfExpressionASPContext ctx) {
        visit(ctx.expression());
        Object rawConditional = this.evalStack.popValue();
        if(rawConditional==null){
            this.addError(ctx.expression().getStart(),"Error interpretando condicional");
        }
        else if(rawConditional.getClass().getSimpleName().equals("Boolean")){
            Boolean conditional = (Boolean) rawConditional;
            if(conditional){
                visit(ctx.blockStatement(0));
            }
            else
                visit(ctx.blockStatement(1));
        }
        else
            this.addError(ctx.expression().start,"Expresión no booleana como condicional");
        return null;
    }

    @Override
    public Object visitBlockStatementASP(projectParser.BlockStatementASPContext ctx) {
        for (projectParser.StatementContext ele : ctx.statement()){
            visit(ele);
            if(!this.errorList.equals("") || DataStorage.actual.getData("return")!=null)
                return null;
        }
        return null;
    }
    private Boolean isInteger(Object object){
        return object.getClass().getSimpleName().equals("Integer");
    }
    private void addError(org.antlr.v4.runtime.Token pos, String msg){
        this.errorList += "\nError: linea " + pos.getLine() + "; columna " + pos.getCharPositionInLine() +"; " + msg;
    }
    private Object boolPlus(Boolean b, Object o){
        String s = o.getClass().getSimpleName();
        if ("Boolean".equals(s)) {
            return (b || (Boolean) o);
        }
        return null;
    }
    private Object intPlus(Integer i, Object o){
        switch (o.getClass().getSimpleName()){
            case "Integer":
                return i+(Integer)o;
            case "Character":
                return i+""+ o;
            case "String":
                return i + (String)o;
        }
        return null;
    }
    private Object charPlus(Character c, Object o){
        switch (o.getClass().getSimpleName()){
            case "Integer":
                return intPlus((Integer) o,c);
            case "Character":
                return c+""+o;
            case "String":
                return c+(String)o;
        }
        return null;
    }
    private Object strPlus(String s, Object o){
        switch (o.getClass().getSimpleName()){
            case "Integer":
                return s+o;
            case "Character":
                return s+o;
            case "String":
                return s+o;
        }
        return null;
    }
    private Object arrPlus(ArrayList a, Object o){
        switch (o.getClass().getSimpleName()){
            case "ArrayList":
                a.addAll((ArrayList)o);
                return a;
        }
    return null;
    }
    private Object hashPlus(HashMap h, Object o){
        switch (o.getClass().getSimpleName()){
            case "HashMap":
                h.putAll((HashMap)o);
                return h;
        }
        return null;
    }
    private Object nTimes(Integer n, Object o){
        String res="";
        switch (o.getClass().getSimpleName()){
            case "Integer":
                return n*(Integer)o;
            case "Character":
                for(int x=0;x<n;x++)
                    res+=(Character)o;
                return res;
            case "String":
                for(int x=0;x<n;x++)
                    res+=(String) o;
                return res;
            case "ArrayList":
                ArrayList temp=new ArrayList();
                for(int x=0;x<n;x++)
                    temp.addAll((ArrayList) o);
                return temp;
        }
        return null;
    }
}