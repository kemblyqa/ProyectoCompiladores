import generated.projectParser;
import generated.projectScanner;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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
    private Main creator;

    JFrame frame;
    private void initComponents() {

    }

    public Editor(Main m) {
        frame = new JFrame("Editor");
        frame.setContentPane(this.Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        creator = m;
        codeEditor.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linenum = 1;
                int columnnum = 1;
                try {
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);

                    linenum += 1;
                }
                catch(Exception ignored) { }
                cursorStatus.setText("Linea:"+linenum + ":"+columnnum);
            }
        });
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    codeEditor.setText(creator.fileLoad());
                } catch (FileNotFoundException e1) {
                    compDetails.setText(e1.getStackTrace().toString());
                }
            }
        });
        btnCompilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creator.compile();
            }
        });
        btnGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creator.genTree();
            }
        });
    }

    public static void main(String[] args) {

    }
}
