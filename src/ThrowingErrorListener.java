import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;


public class ThrowingErrorListener extends BaseErrorListener {

    //instancia global del listener
    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
    //cola de errores
    public static String errorList = "";
    //sobrescritura del metodo syntaxError
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
    {
        //apilamiento de
        System.out.println();
        errorList= errorList + ("\nlinea " + line + ":" + charPositionInLine + " " + msg);
    }
}