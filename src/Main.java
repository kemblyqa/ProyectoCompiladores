import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        projectScanner inst = null;
        projectParser parser = null;

        ANTLRInputStream input=null;
        CommonTokenStream tokens = null;
        try {
            input = new ANTLRInputStream(new FileReader("test.txt"));
            inst = new projectScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new projectParser(tokens);
        }
        catch(Exception e){System.out.println("No hay archivo");}

        List<Token> lista = (List<Token>) inst.getAllTokens();

        for (Token t : lista)

            System.out.println(t.getType()+ ":" + t.getText() + "\n");

        inst = new projectScanner(input);
        inst.reset();

        try {
            ParseTree tree = parser.program();
            //java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
            //treeGUI.get().setVisible(true);
            System.out.println("Compilación Exitosa!!\n");
        }
        catch(RecognitionException e){
            System.out.println("Compilación Fallida!!");
        }
    }

}

//Minimo que se debe saber de un token: tipo, text (exema) , fila y columna

