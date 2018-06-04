import generated.projectParser;
import generated.projectScanner;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Editor {
    JTextArea codeEditor;
    JTextArea compDetails;
    private JButton btnCompilar;
    private JButton btnGen;
    private JButton btnCargar;
    private JPanel Principal;
    private JLabel cursorStatus;
    JTextField console;
    JButton consoleBtn;
    private Main creator;

    JFrame frame;

    Editor(Main m) {
        //instanciación del frame
        frame = new JFrame("Editor");
        frame.setContentPane(this.Principal);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        //referencia a Main
        creator = m;
        //añade listener de movimiento de carro
        codeEditor.addCaretListener(e -> {
            JTextArea editArea = (JTextArea)e.getSource();
            //contador de linea y columna
            int linenum = 1;
            int columnnum = 1;
            try {
                //asignacion de los valores de linea y columna
                int caretpos = editArea.getCaretPosition();
                linenum = editArea.getLineOfOffset(caretpos);
                columnnum = caretpos - editArea.getLineStartOffset(linenum);

                linenum += 1;
            }
            catch(Exception ignored) { }
            //asignacion de texto al label declarado
            cursorStatus.setText("Linea:"+linenum + ":"+columnnum);
        });
        //los botones llaman acciones en main
        btnCargar.addActionListener(e -> {
            try {
                codeEditor.setText(creator.fileLoad());
            } catch (FileNotFoundException e1) {
                compDetails.setText("El archivo no se ha cargado correctamente");
            }
        });
        btnCompilar.addActionListener(e -> creator.compile());
        btnGen.addActionListener(e -> creator.genTree());
        consoleBtn.addActionListener(e -> creator.enterCommand(console.getText()));
    }

    public static void main(String[] args) {

    }
}
