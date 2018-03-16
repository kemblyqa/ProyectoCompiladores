// Generated from D:/ProyectoCompiladores\projectScanner.g4 by ANTLR 4.7
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
		WS=1, LINE_COMMENT=2, FULL_COMMENT=3, TRUE=4, FALSE=5, LET=6, RETURN=7, 
		PyCOMMA=8, ASSIGN=9, PIZQ=10, PDER=11, PCIZQ=12, PCDER=13, LLAVEIZQ=14, 
		LLAVEDER=15, VIR=16, DOSPUN=17, COMMA=18, LEN=19, FIRST=20, LAST=21, REST=22, 
		PUSH=23, FN=24, PUTS=25, IF=26, ELSE=27, SUM=28, SUB=29, MUL=30, DIV=31, 
		MENOR=32, MENORIGUAL=33, MAYOR=34, MAYORIGUAL=35, IGUAL=36, DISTINTO=37, 
		ARRAY=38, STRING=39, INTEGER=40, IDENTIFIER=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "LINE_COMMENT", "FULL_COMMENT", "TRUE", "FALSE", "LET", "RETURN", 
		"PyCOMMA", "ASSIGN", "PIZQ", "PDER", "PCIZQ", "PCDER", "LLAVEIZQ", "LLAVEDER", 
		"VIR", "DOSPUN", "COMMA", "LEN", "FIRST", "LAST", "REST", "PUSH", "FN", 
		"PUTS", "IF", "ELSE", "SUM", "SUB", "MUL", "DIV", "MENOR", "MENORIGUAL", 
		"MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", "ARRAY", "STRING", "INTEGER", 
		"IDENTIFIER", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'true'", "'false'", "'let'", "'return'", "';'", 
		"'='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'~'", "':'", "','", 
		"'len'", "'first'", "'last'", "'rest'", "'push'", "'fn'", "'puts'", "'if'", 
		"'else'", "'+'", "'-'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", 
		"'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "LINE_COMMENT", "FULL_COMMENT", "TRUE", "FALSE", "LET", "RETURN", 
		"PyCOMMA", "ASSIGN", "PIZQ", "PDER", "PCIZQ", "PCDER", "LLAVEIZQ", "LLAVEDER", 
		"VIR", "DOSPUN", "COMMA", "LEN", "FIRST", "LAST", "REST", "PUSH", "FN", 
		"PUTS", "IF", "ELSE", "SUM", "SUB", "MUL", "DIV", "MENOR", "MENORIGUAL", 
		"MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", "ARRAY", "STRING", "INTEGER", 
		"IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0111\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\6\2[\n\2\r\2\16\2\\\3\2\3\2\3\3\3\3\3\3\3\3\7\3e\n\3\f\3\16\3"+
		"h\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3"+
		"\'\3\'\3\'\5\'\u00ea\n\'\3\'\3\'\3\'\5\'\u00ef\n\'\7\'\u00f1\n\'\f\'\16"+
		"\'\u00f4\13\'\3\'\3\'\3(\3(\7(\u00fa\n(\f(\16(\u00fd\13(\3(\3(\3)\6)\u0102"+
		"\n)\r)\16)\u0103\3*\3*\3*\7*\u0109\n*\f*\16*\u010c\13*\3+\3+\3,\3,\4q"+
		"\u00fb\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2\3\2\5\5\2\13\f\17\17\"\"\4"+
		"\2\f\f\17\17\5\2C\\aac|\2\u0118\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3Z\3\2\2\2\5`\3\2\2\2\7k\3\2\2\2\ty\3\2"+
		"\2\2\13~\3\2\2\2\r\u0084\3\2\2\2\17\u0088\3\2\2\2\21\u008f\3\2\2\2\23"+
		"\u0091\3\2\2\2\25\u0093\3\2\2\2\27\u0095\3\2\2\2\31\u0097\3\2\2\2\33\u0099"+
		"\3\2\2\2\35\u009b\3\2\2\2\37\u009d\3\2\2\2!\u009f\3\2\2\2#\u00a1\3\2\2"+
		"\2%\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a9\3\2\2\2+\u00af\3\2\2\2-\u00b4"+
		"\3\2\2\2/\u00b9\3\2\2\2\61\u00be\3\2\2\2\63\u00c1\3\2\2\2\65\u00c6\3\2"+
		"\2\2\67\u00c9\3\2\2\29\u00ce\3\2\2\2;\u00d0\3\2\2\2=\u00d2\3\2\2\2?\u00d4"+
		"\3\2\2\2A\u00d6\3\2\2\2C\u00d8\3\2\2\2E\u00db\3\2\2\2G\u00dd\3\2\2\2I"+
		"\u00e0\3\2\2\2K\u00e3\3\2\2\2M\u00e6\3\2\2\2O\u00f7\3\2\2\2Q\u0101\3\2"+
		"\2\2S\u0105\3\2\2\2U\u010d\3\2\2\2W\u010f\3\2\2\2Y[\t\2\2\2ZY\3\2\2\2"+
		"[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\b\2\2\2_\4\3\2\2\2`a\7\61"+
		"\2\2ab\7\61\2\2bf\3\2\2\2ce\n\3\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3"+
		"\2\2\2gi\3\2\2\2hf\3\2\2\2ij\b\3\2\2j\6\3\2\2\2kl\7\61\2\2lm\7,\2\2mq"+
		"\3\2\2\2np\13\2\2\2on\3\2\2\2ps\3\2\2\2qr\3\2\2\2qo\3\2\2\2rt\3\2\2\2"+
		"sq\3\2\2\2tu\7,\2\2uv\7\61\2\2vw\3\2\2\2wx\b\4\2\2x\b\3\2\2\2yz\7v\2\2"+
		"z{\7t\2\2{|\7w\2\2|}\7g\2\2}\n\3\2\2\2~\177\7h\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7n\2\2\u0081\u0082\7u\2\2\u0082\u0083\7g\2\2\u0083\f\3\2\2\2\u0084"+
		"\u0085\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7v\2\2\u0087\16\3\2\2\2\u0088"+
		"\u0089\7t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7v\2\2\u008b\u008c\7w\2\2"+
		"\u008c\u008d\7t\2\2\u008d\u008e\7p\2\2\u008e\20\3\2\2\2\u008f\u0090\7"+
		"=\2\2\u0090\22\3\2\2\2\u0091\u0092\7?\2\2\u0092\24\3\2\2\2\u0093\u0094"+
		"\7*\2\2\u0094\26\3\2\2\2\u0095\u0096\7+\2\2\u0096\30\3\2\2\2\u0097\u0098"+
		"\7]\2\2\u0098\32\3\2\2\2\u0099\u009a\7_\2\2\u009a\34\3\2\2\2\u009b\u009c"+
		"\7}\2\2\u009c\36\3\2\2\2\u009d\u009e\7\177\2\2\u009e \3\2\2\2\u009f\u00a0"+
		"\7\u0080\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7<\2\2\u00a2$\3\2\2\2\u00a3\u00a4"+
		"\7.\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac"+
		"\7t\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7v\2\2\u00ae*\3\2\2\2\u00af\u00b0"+
		"\7n\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7v\2\2\u00b3"+
		",\3\2\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7v\2\2\u00b8.\3\2\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7w\2\2\u00bb"+
		"\u00bc\7u\2\2\u00bc\u00bd\7j\2\2\u00bd\60\3\2\2\2\u00be\u00bf\7h\2\2\u00bf"+
		"\u00c0\7p\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7r\2\2\u00c2\u00c3\7w\2\2\u00c3"+
		"\u00c4\7v\2\2\u00c4\u00c5\7u\2\2\u00c5\64\3\2\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7h\2\2\u00c8\66\3\2\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\u00cc\7u\2\2\u00cc\u00cd\7g\2\2\u00cd8\3\2\2\2\u00ce\u00cf\7-\2\2\u00cf"+
		":\3\2\2\2\u00d0\u00d1\7/\2\2\u00d1<\3\2\2\2\u00d2\u00d3\7,\2\2\u00d3>"+
		"\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5@\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7"+
		"B\3\2\2\2\u00d8\u00d9\7>\2\2\u00d9\u00da\7?\2\2\u00daD\3\2\2\2\u00db\u00dc"+
		"\7@\2\2\u00dcF\3\2\2\2\u00dd\u00de\7@\2\2\u00de\u00df\7?\2\2\u00dfH\3"+
		"\2\2\2\u00e0\u00e1\7?\2\2\u00e1\u00e2\7?\2\2\u00e2J\3\2\2\2\u00e3\u00e4"+
		"\7#\2\2\u00e4\u00e5\7?\2\2\u00e5L\3\2\2\2\u00e6\u00e9\7]\2\2\u00e7\u00ea"+
		"\5Q)\2\u00e8\u00ea\5O(\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00f2\3\2\2\2\u00eb\u00ee\7.\2\2\u00ec\u00ef\5Q)\2\u00ed\u00ef\5O(\2"+
		"\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00eb"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7_\2\2\u00f6N\3\2\2\2\u00f7"+
		"\u00fb\7$\2\2\u00f8\u00fa\13\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00ff\7$\2\2\u00ffP\3\2\2\2\u0100\u0102\5W,\2\u0101"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104R\3\2\2\2\u0105\u010a\5U+\2\u0106\u0109\5U+\2\u0107\u0109\5"+
		"W,\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010bT\3\2\2\2\u010c\u010a\3\2\2\2"+
		"\u010d\u010e\t\4\2\2\u010eV\3\2\2\2\u010f\u0110\4\62;\2\u0110X\3\2\2\2"+
		"\r\2\\fq\u00e9\u00ee\u00f2\u00fb\u0103\u0108\u010a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}