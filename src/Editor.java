import generated.projectParser;
import generated.projectScanner;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class Editor {
    private JEditorPane codeEditor;
    private JTextArea compDetails;
    private JButton btnCompilar;
    private JButton btnGen;
    private JButton btnCargar;
    private JPanel Principal;

    //variables
    projectScanner inst = null;
    projectParser parser = null;

    ANTLRInputStream input=null;
    CommonTokenStream tokens = null;
    ParseTree tree = null;

    private void initComponents() {

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Editor");
        Editor editor = new Editor();
        editor.btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileDialog dialog = new FileDialog((Frame)null, "Seleccione un archivo .txt");
                    dialog.setMode(FileDialog.LOAD);
                    dialog.setFile("*.txt");
                    dialog.setVisible(true);
                    String fullpath = dialog.getDirectory() + dialog.getFile();
                    editor.codeEditor.setText(new Scanner(new File(fullpath)).useDelimiter("\\Z").next());
                } catch (Exception el) {
                    editor.compDetails.setText("ERROR: "+el.getMessage()+ "\nCAUSA: "+el.getCause());
                }
            }
        });
        editor.btnCompilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editor.input = new ANTLRInputStream(editor.codeEditor.getText());
                    editor.inst = new projectScanner(editor.input);
                    editor.tokens = new CommonTokenStream(editor.inst);
                    editor.parser = new projectParser(editor.tokens);
                }
                catch(Exception exc){

                }

                try {
                    editor.parser.removeErrorListeners();
                    editor.parser.addErrorListener(ThrowingErrorListener.INSTANCE);
                    editor.tree = editor.parser.program();
                    editor.compDetails.setText("Compilación Exitosa!!" );
                }
                catch (ParseCancellationException exc){
                    editor.compDetails.setText(exc.getMessage());
                }
            }
        });
        editor.btnGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (editor.tree ==null){
                        editor.compDetails.setText("No se ha compilado aún!!");
                        return;
                    }
                    java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(editor.tree,editor.parser);
                    treeGUI.get().setVisible(true);
                    editor.compDetails.setText("Arbol Generado!!\n");
                }
                catch (Exception exc){
                    editor.compDetails.setText("ERROR: "+exc.getMessage()+ "\nCAUSA: "+exc.getCause());
                }
            }
        });
        frame.setContentPane(editor.Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
