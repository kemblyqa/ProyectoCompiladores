package interpreter;

import javax.xml.crypto.Data;
import java.util.LinkedList;

public class DataStorage {
    private LinkedList<Value> data;
    private int actualIndex;
    private DataStorage padre;
    public Integer scope;
    public static DataStorage actual;

    public class Value{
        String name;
        Object value;
        int index;

        public Value(String n, Object v, int i) {
            this.name = n;
            this.value = v;
            this.index = i;
        }
    }

    public DataStorage(DataStorage padre)
    {
        if(padre==null){
            DataStorage.actual=this;
            this.scope=0;
        }
        else{
            this.padre=padre;
            this.scope=padre.scope+1;
        }
        this.actualIndex = 0;
        this.data = new LinkedList<Value>();
    }

    public void addData(String nombre, Object value)
    {
        Integer index=null;
        for(int x = 0;x<this.data.size();x++){
           if(this.data.get(x).name.equals(nombre))
               index=x;
        }
        if(index!=null){
            Value v = new Value(nombre,value,index);
            this.data.set(index,v);
        }
        else{
            Value v = new Value(nombre,value,this.actualIndex);
            this.data.add(v);
            this.actualIndex++;
        }
    }

    public Value getData(int index, int scope) {
        if(scope!=this.scope)
            if (this.padre!=null){
                return this.padre.getData(index,scope-1);}
            else {return null;}
        else if (this.data.size()<=index) return null;
        else return this.data.get(index);
    }

    public Object getData(String name) {
        //se debe buscar en la tabla pero por nombre
        for (Value aData : this.data) {
            if (aData.name.equals(name))
                return aData.value;
        }
        if(this.padre==null)return null;
        return this.padre.getData(name);
    }

    public void cleanData(){
        while (this.data.size()!=0)
            this.data.pop();
        this.actualIndex=0;
    }

    public String toString() {
        String message = new String("");
        message += "****** ESTADO DE DATA STORAGE ******\n";
        if (!this.data.isEmpty()) {
            for (Value i : this.data) {
                message += i.name + " --> " + i.value.toString() + "\n";
            }
            message += "------------------------------------------";
        } else
            message += "Data Storage is Empty!!";
        if (this.padre!=null)
            message+="\n"+this.padre.toString();
        return message;
    }

    public int getActualStorageIndex(){
        return this.actualIndex;
    }
    public LinkedList<Value> getData() {
        return this.data;
    }
    public void openScope(){
        DataStorage.actual = new DataStorage(this);
    }
    public void closeScope(){
        if(this.padre!=null)
            DataStorage.actual = this.padre;
        else
            System.out.println("\nSe ha intentado subir más allá del scope principal");
    }
}
