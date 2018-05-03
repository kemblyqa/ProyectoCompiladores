// Generated from C:/Users/kembl/Desktop/ProyectoCompiladores\projectScanner.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class projectScanner extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, LET=3, RETURN=4, PyCOMMA=5, ASSIGN=6, PIZQ=7, PDER=8, 
		PCIZQ=9, PCDER=10, LLAVEIZQ=11, LLAVEDER=12, VIR=13, DOSPUN=14, COMMA=15, 
		COMILLA=16, WS=17, FULL_COMMENT=18, LINE_COMMENT=19, LEN=20, FIRST=21, 
		LAST=22, REST=23, PUSH=24, FN=25, PUTS=26, IF=27, ELSE=28, ADDOPERATOR=29, 
		MULOPERATOR=30, COMPARATOR=31, STRING=32, INTEGER=33, IDENTIFIER=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "LET", "RETURN", "PyCOMMA", "ASSIGN", "PIZQ", "PDER", 
		"PCIZQ", "PCDER", "LLAVEIZQ", "LLAVEDER", "VIR", "DOSPUN", "COMMA", "COMILLA", 
		"WS", "FULL_COMMENT", "LINE_COMMENT", "LEN", "FIRST", "LAST", "REST", 
		"PUSH", "FN", "PUTS", "IF", "ELSE", "ADDOPERATOR", "MULOPERATOR", "COMPARATOR", 
		"STRING", "INTEGER", "IDENTIFIER", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'let'", "'return'", "';'", "'='", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "'~'", "':'", "','", "'\"'", null, null, null, 
		"'len'", "'first'", "'last'", "'rest'", "'push'", "'fn'", "'puts'", "'if'", 
		"'else'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "LET", "RETURN", "PyCOMMA", "ASSIGN", "PIZQ", "PDER", 
		"PCIZQ", "PCDER", "LLAVEIZQ", "LLAVEDER", "VIR", "DOSPUN", "COMMA", "COMILLA", 
		"WS", "FULL_COMMENT", "LINE_COMMENT", "LEN", "FIRST", "LAST", "REST", 
		"PUSH", "FN", "PUTS", "IF", "ELSE", "ADDOPERATOR", "MULOPERATOR", "COMPARATOR", 
		"STRING", "INTEGER", "IDENTIFIER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public projectScanner(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "projectScanner.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\6\22{\n\22\r\22\16\22|\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\7\23\u0086\n\23\f\23\16\23\u0089\13\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\7\24\u0094\n\24\f\24\16\24\u0097\13\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00d3\n \3"+
		"!\3!\3!\3!\7!\u00d9\n!\f!\16!\u00dc\13!\3!\3!\3\"\6\"\u00e1\n\"\r\"\16"+
		"\"\u00e2\3#\3#\3#\7#\u00e8\n#\f#\16#\u00eb\13#\3$\3$\3%\3%\4\u0087\u0095"+
		"\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G\2I\2\3\2\b\5\2\13\f\17\17\"\"\4\2--//\4\2,,\61\61\4\2"+
		">>@@\5\2\f\f\17\17$$\5\2C\\aac|\2\u00fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3K\3\2\2\2\5P\3\2\2\2\7V\3\2\2\2\tZ\3"+
		"\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3\2\2\2\25k"+
		"\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!"+
		"w\3\2\2\2#z\3\2\2\2%\u0080\3\2\2\2\'\u008f\3\2\2\2)\u009c\3\2\2\2+\u00a0"+
		"\3\2\2\2-\u00a6\3\2\2\2/\u00ab\3\2\2\2\61\u00b0\3\2\2\2\63\u00b5\3\2\2"+
		"\2\65\u00b8\3\2\2\2\67\u00bd\3\2\2\29\u00c0\3\2\2\2;\u00c5\3\2\2\2=\u00c7"+
		"\3\2\2\2?\u00d2\3\2\2\2A\u00d4\3\2\2\2C\u00e0\3\2\2\2E\u00e4\3\2\2\2G"+
		"\u00ec\3\2\2\2I\u00ee\3\2\2\2KL\7v\2\2LM\7t\2\2MN\7w\2\2NO\7g\2\2O\4\3"+
		"\2\2\2PQ\7h\2\2QR\7c\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\6\3\2\2\2VW\7n\2"+
		"\2WX\7g\2\2XY\7v\2\2Y\b\3\2\2\2Z[\7t\2\2[\\\7g\2\2\\]\7v\2\2]^\7w\2\2"+
		"^_\7t\2\2_`\7p\2\2`\n\3\2\2\2ab\7=\2\2b\f\3\2\2\2cd\7?\2\2d\16\3\2\2\2"+
		"ef\7*\2\2f\20\3\2\2\2gh\7+\2\2h\22\3\2\2\2ij\7]\2\2j\24\3\2\2\2kl\7_\2"+
		"\2l\26\3\2\2\2mn\7}\2\2n\30\3\2\2\2op\7\177\2\2p\32\3\2\2\2qr\7\u0080"+
		"\2\2r\34\3\2\2\2st\7<\2\2t\36\3\2\2\2uv\7.\2\2v \3\2\2\2wx\7$\2\2x\"\3"+
		"\2\2\2y{\t\2\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177"+
		"\b\22\2\2\177$\3\2\2\2\u0080\u0081\7\61\2\2\u0081\u0082\7,\2\2\u0082\u0087"+
		"\3\2\2\2\u0083\u0086\5%\23\2\u0084\u0086\13\2\2\2\u0085\u0083\3\2\2\2"+
		"\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0088\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7,\2\2\u008b"+
		"\u008c\7\61\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\23\2\2\u008e&\3\2\2"+
		"\2\u008f\u0090\7\61\2\2\u0090\u0091\7\61\2\2\u0091\u0095\3\2\2\2\u0092"+
		"\u0094\13\2\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0096\3"+
		"\2\2\2\u0095\u0093\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\7\f\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\24\2\2\u009b(\3\2\2\2"+
		"\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e\u009f\7p\2\2\u009f*\3\2\2"+
		"\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4"+
		"\7u\2\2\u00a4\u00a5\7v\2\2\u00a5,\3\2\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8"+
		"\7c\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7v\2\2\u00aa.\3\2\2\2\u00ab\u00ac"+
		"\7t\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7v\2\2\u00af"+
		"\60\3\2\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7u\2\2\u00b3"+
		"\u00b4\7j\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7p\2\2\u00b7"+
		"\64\3\2\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		"\u00bc\7u\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7h\2\2\u00bf"+
		"8\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7u\2\2\u00c3"+
		"\u00c4\7g\2\2\u00c4:\3\2\2\2\u00c5\u00c6\t\3\2\2\u00c6<\3\2\2\2\u00c7"+
		"\u00c8\t\4\2\2\u00c8>\3\2\2\2\u00c9\u00d3\t\5\2\2\u00ca\u00cb\7>\2\2\u00cb"+
		"\u00d3\7?\2\2\u00cc\u00cd\7@\2\2\u00cd\u00d3\7?\2\2\u00ce\u00cf\7?\2\2"+
		"\u00cf\u00d3\7?\2\2\u00d0\u00d1\7#\2\2\u00d1\u00d3\7?\2\2\u00d2\u00c9"+
		"\3\2\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3@\3\2\2\2\u00d4\u00da\5!\21\2\u00d5\u00d9\n\6\2\2"+
		"\u00d6\u00d7\7$\2\2\u00d7\u00d9\7$\2\2\u00d8\u00d5\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\5!\21\2\u00deB\3\2\2\2"+
		"\u00df\u00e1\5I%\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3D\3\2\2\2\u00e4\u00e9\5G$\2\u00e5\u00e8"+
		"\5G$\2\u00e6\u00e8\5I%\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00eaF\3\2\2\2"+
		"\u00eb\u00e9\3\2\2\2\u00ec\u00ed\t\7\2\2\u00edH\3\2\2\2\u00ee\u00ef\4"+
		"\62;\2\u00efJ\3\2\2\2\r\2|\u0085\u0087\u0095\u00d2\u00d8\u00da\u00e2\u00e7"+
		"\u00e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}