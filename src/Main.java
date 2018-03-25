import generated.projectParser;
import generated.projectScanner;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Principal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    static projectScanner inst = null;
    static projectParser parser = null;

    static ANTLRInputStream input=null;
    static CommonTokenStream tokens = null;
    static ParseTree tree = null;

    Editor mainView;
    JFrame treeFrame;

    public String fileLoad() throws FileNotFoundException {
        FileDialog dialog = new FileDialog((Frame)null, "Seleccione un archivo .txt");
        dialog.setMode(FileDialog.LOAD);
        dialog.setFile("*.txt");
        dialog.setVisible(true);
        String fullpath = dialog.getDirectory() + dialog.getFile();
        return new Scanner(new File(fullpath)).useDelimiter("\\Z").next();
    }
    public void compile() {
        try {
            ThrowingErrorListener.errorList="";
            input = new ANTLRInputStream(mainView.codeEditor.getText());
            inst = new projectScanner(input);
            inst.removeErrorListeners();
            inst.addErrorListener(ThrowingErrorListener.INSTANCE);
            tokens = new CommonTokenStream(inst);
            parser = new projectParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            tree = parser.program();
            if (Objects.equals(ThrowingErrorListener.errorList, ""))
                mainView.compDetails.setText("Compilación Exitosa!!" );
            else
                mainView.compDetails.setText(ThrowingErrorListener.errorList);

        }
        catch(Exception exc){
            mainView.compDetails.setText("ERROR: "+exc.getMessage()+ "\nCAUSA: "+exc.getCause());
        }
    }
    public void genTree() {
        compile();
        if (!Objects.equals(ThrowingErrorListener.errorList, ""))
                return;
        try {
            if (treeFrame!=null){
                treeFrame.setVisible(false);
                treeFrame.dispose();
                treeFrame = null;
            }
            treeFrame = new JFrame("Arbol Generado");
            JPanel panel = new JPanel(new BorderLayout(0, 0));
            TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),tree);
            JScrollPane scrollPane = new JScrollPane(viewr);
            panel.add(scrollPane, BorderLayout.CENTER);
            treeFrame.add(panel);
            treeFrame.setSize(1000,500);
            treeFrame.setVisible(true);
        } catch (Exception exc) {
            mainView.compDetails.setText("ERROR: " + exc.getMessage() + "\nCAUSA: " + exc.getCause());
        }
    }
    public void showMain(){
        mainView.frame.setVisible(true);
    }
    public static void main (String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
        Main Principal = new Main();
        Principal.mainView = new Editor(Principal);
        Principal.showMain();
    }
}
