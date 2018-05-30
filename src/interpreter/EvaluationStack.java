package interpreter;

import java.util.Stack;

public class EvaluationStack {
    private Stack<Object> evalStack;

    public EvaluationStack(){
        this.evalStack= new Stack<Object>();
    }

    public void pushValue(Object elem){
        this.evalStack.push(elem);
    }

    public Object popValue(){
        if(this.evalStack.empty()){
            System.out.println("Se intentó hacer pop a evaluationstack vacio");
            return null;
        }
        return this.evalStack.pop();
    }
    public Integer len(){
        return evalStack.size();
    }
}