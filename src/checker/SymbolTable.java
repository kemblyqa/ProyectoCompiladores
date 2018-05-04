package checker;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class SymbolTable {
    private ArrayList<Element> tabla;
    private Integer nivel;
    public static SymbolTable actual;
    private SymbolTable parent;
    private SymbolTable child;

    public static class Element{
        Token tok;
        ParserRuleContext decl;
        public Element(Token t, ParserRuleContext d) {
            tok = t;
            decl = d;
        }
        public Token getToken(){
            return tok;
        }
        public int getType(){
            return tok.getType();
        }
        public String toString(){
            return this.tok.getText() + "," + this.decl.getText();
        }
    }

    public SymbolTable(SymbolTable parent)
    {
        SymbolTable.actual = this;
        this.nivel=0;
        this.tabla = new ArrayList<>();
        this.parent = parent;
    }

    public Element insertar(String nombre, int type, ParserRuleContext declaracion)
    {
        Token token = new CommonToken(type,nombre);
        Element i = new Element(token,declaracion);
        for(int j=0;j<this.tabla.size();j++){
            if(this.tabla.get(j).tok.getText().equals(token.getText())){
                this.tabla.remove(j);
                System.out.println("El identificador " + nombre + " ya ha sido declarado, pero le cayó encima");
                break;
            }
        }
        this.tabla.add(i);
        return this.tabla.get(this.tabla.size()-1);
    }

    public void openScope(){
        this.child = new SymbolTable(this);
        SymbolTable.actual=this.child;
        this.nivel++;
    }

    public void closeScope(){
        SymbolTable.actual=this.parent;
        this.parent.child=null;
        this.nivel--;
    }

    public Element buscar(String nombre)
    {
        Element temp=null;
        for(Element id : this.tabla) {
            if (id.tok.getText().equals(nombre)) {
                temp = id;
                break;
            }
        }
        if(temp==null && this.parent!=null)
            temp=this.parent.buscar(nombre);
        return temp;
    }

    public Element buscarLocal(String nombre)
    {
        Element temp=null;
        for(Element id : this.tabla) {
            if (id.tok.getText().equals(nombre)) {
                temp = id;
                break;
            }
        }
        return temp;
    }

    public void imprimir() {
        if (this.parent!=null)
            this.parent.imprimir();
        System.out.println("****** ESTADO DE TABLA DE SÍMBOLOS DE NIVEL " + this.nivel + " ******");
        if (!this.tabla.isEmpty()) {
            for (Element i : this.tabla) {
                System.out.println(nivel + " Nombre: " + i.tok.getText());
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Tabla vacía");
    }

    public ArrayList<Element> getTabla() {
        return this.tabla;
    }
}
