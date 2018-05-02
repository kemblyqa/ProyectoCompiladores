import checker.Checker;
import generated.projectParser;
import generated.projectScanner;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    //declaracion del parser
    private static projectParser parser = null;
    //declaracion del arbol
    private static ParseTree tree = null;
    //declaracion de la vista
    private Editor mainView;
    //declaracion de la vista del arbol
    private JFrame treeFrame;

    //carga un archivo en el editor
    public String fileLoad() throws FileNotFoundException {
        //muestra un selector de archivos
        FileDialog dialog = new FileDialog((Frame) null, "Seleccione un archivo .txt");
        dialog.setMode(FileDialog.LOAD);
        dialog.setFile("*.txt");
        dialog.setVisible(true);
        //obtiene la direccion del archivo seleccionado
        String fullpath = dialog.getDirectory() + dialog.getFile();
        //retorna el scanner listo para el archivo seleccionado
        return new Scanner(new File(fullpath)).useDelimiter("\\Z").next();
    }

    //analiza el codigo en el editor
    public void compile() {
        try {
            //limpia la cola de errores
            ThrowingErrorListener.errorList = "";
            //obtiene la cadena de texto del editor
            ANTLRInputStream input = new ANTLRInputStream(mainView.codeEditor.getText());
            //declaracion del scanner
            projectScanner inst = new projectScanner(input);
            //añadir un listener de errores personalizado
            inst.removeErrorListeners();
            inst.addErrorListener(ThrowingErrorListener.INSTANCE);
            //declaracion de la cadena de tokens
            CommonTokenStream tokens = new CommonTokenStream(inst);
            //declaracion del parser y cambiar el listener de errores
            parser = new projectParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            //obtencion del arbol de codigo
            tree = parser.program();

            //checker
            Checker v = new Checker();
            v.visit(tree);
            ThrowingErrorListener.errorList = v.errorList;

            //comprobacion de errores
            if (Objects.equals(ThrowingErrorListener.errorList, ""))
                mainView.compDetails.setText("Compilación Exitosa!!");
            else
                mainView.compDetails.setText(ThrowingErrorListener.errorList);

        } catch (Exception exc) {
            mainView.compDetails.setText("ERROR: " + exc.getMessage() + "\nCAUSA: " + exc.getCause());
        }
    }

    public void genTree() {
        //compilacion previa del codigo
        compile();
        //comprobacion de errores
        if (!Objects.equals(ThrowingErrorListener.errorList, ""))
            return;
        try {
            //control de instancias del frame
            if (treeFrame != null) {
                treeFrame.setVisible(false);
                treeFrame.dispose();
                treeFrame = null;
            }
            //generacion del frame
            treeFrame = new JFrame("Arbol Generado");
            JPanel panel = new JPanel(new BorderLayout(0, 0));
            //declaracion del visor de arboles
            TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()), tree);
            JScrollPane scrollPane = new JScrollPane(viewr);
            panel.add(scrollPane, BorderLayout.CENTER);
            //estructurizacion y muestra del frame
            treeFrame.add(panel);
            treeFrame.setSize(1000, 500);
            treeFrame.setVisible(true);
        } catch (Exception exc) {
            mainView.compDetails.setText("ERROR: " + exc.getMessage() + "\nCAUSA: " + exc.getCause());
        }
    }

    private void showMain() {
        mainView.frame.setVisible(true);
    }

    public static void main(String[] args) {
        //inicializacion de interfaz
        Main Principal = new Main();
        Principal.mainView = new Editor(Principal);
        Principal.showMain();
    }
}
