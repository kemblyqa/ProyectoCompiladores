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
		STRING=38, INTEGER=39, IDENTIFIER=40;
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
		"MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", "STRING", "INTEGER", "IDENTIFIER", 
		"LETTER", "DIGIT"
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
		"MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", "STRING", "INTEGER", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\6\2Y\n\2\r\2\16\2Z\3\2\3\2\3\3\3\3\3\3\3\3\7\3c\n\3\f\3\16\3f\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\7\4n\n\4\f\4\16\4q\13\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\7"+
		"\'\u00e7\n\'\f\'\16\'\u00ea\13\'\3\'\3\'\3(\6(\u00ef\n(\r(\16(\u00f0\3"+
		")\3)\3)\7)\u00f6\n)\f)\16)\u00f9\13)\3*\3*\3+\3+\4o\u00e8\2,\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S\2U\2\3\2\5\5\2\13\f\17\17\"\"\4\2\f\f\17\17\5\2C\\a"+
		"ac|\2\u0102\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3X"+
		"\3\2\2\2\5^\3\2\2\2\7i\3\2\2\2\tw\3\2\2\2\13|\3\2\2\2\r\u0082\3\2\2\2"+
		"\17\u0086\3\2\2\2\21\u008d\3\2\2\2\23\u008f\3\2\2\2\25\u0091\3\2\2\2\27"+
		"\u0093\3\2\2\2\31\u0095\3\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2\2\37\u009b"+
		"\3\2\2\2!\u009d\3\2\2\2#\u009f\3\2\2\2%\u00a1\3\2\2\2\'\u00a3\3\2\2\2"+
		")\u00a7\3\2\2\2+\u00ad\3\2\2\2-\u00b2\3\2\2\2/\u00b7\3\2\2\2\61\u00bc"+
		"\3\2\2\2\63\u00bf\3\2\2\2\65\u00c4\3\2\2\2\67\u00c7\3\2\2\29\u00cc\3\2"+
		"\2\2;\u00ce\3\2\2\2=\u00d0\3\2\2\2?\u00d2\3\2\2\2A\u00d4\3\2\2\2C\u00d6"+
		"\3\2\2\2E\u00d9\3\2\2\2G\u00db\3\2\2\2I\u00de\3\2\2\2K\u00e1\3\2\2\2M"+
		"\u00e4\3\2\2\2O\u00ee\3\2\2\2Q\u00f2\3\2\2\2S\u00fa\3\2\2\2U\u00fc\3\2"+
		"\2\2WY\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\b"+
		"\2\2\2]\4\3\2\2\2^_\7\61\2\2_`\7\61\2\2`d\3\2\2\2ac\n\3\2\2ba\3\2\2\2"+
		"cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\b\3\2\2h\6\3\2\2"+
		"\2ij\7\61\2\2jk\7,\2\2ko\3\2\2\2ln\13\2\2\2ml\3\2\2\2nq\3\2\2\2op\3\2"+
		"\2\2om\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7,\2\2st\7\61\2\2tu\3\2\2\2uv\b\4"+
		"\2\2v\b\3\2\2\2wx\7v\2\2xy\7t\2\2yz\7w\2\2z{\7g\2\2{\n\3\2\2\2|}\7h\2"+
		"\2}~\7c\2\2~\177\7n\2\2\177\u0080\7u\2\2\u0080\u0081\7g\2\2\u0081\f\3"+
		"\2\2\2\u0082\u0083\7n\2\2\u0083\u0084\7g\2\2\u0084\u0085\7v\2\2\u0085"+
		"\16\3\2\2\2\u0086\u0087\7t\2\2\u0087\u0088\7g\2\2\u0088\u0089\7v\2\2\u0089"+
		"\u008a\7w\2\2\u008a\u008b\7t\2\2\u008b\u008c\7p\2\2\u008c\20\3\2\2\2\u008d"+
		"\u008e\7=\2\2\u008e\22\3\2\2\2\u008f\u0090\7?\2\2\u0090\24\3\2\2\2\u0091"+
		"\u0092\7*\2\2\u0092\26\3\2\2\2\u0093\u0094\7+\2\2\u0094\30\3\2\2\2\u0095"+
		"\u0096\7]\2\2\u0096\32\3\2\2\2\u0097\u0098\7_\2\2\u0098\34\3\2\2\2\u0099"+
		"\u009a\7}\2\2\u009a\36\3\2\2\2\u009b\u009c\7\177\2\2\u009c \3\2\2\2\u009d"+
		"\u009e\7\u0080\2\2\u009e\"\3\2\2\2\u009f\u00a0\7<\2\2\u00a0$\3\2\2\2\u00a1"+
		"\u00a2\7.\2\2\u00a2&\3\2\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7g\2\2\u00a5"+
		"\u00a6\7p\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7t\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7v\2\2\u00ac*\3\2\2\2\u00ad"+
		"\u00ae\7n\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7v\2\2"+
		"\u00b1,\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7u\2"+
		"\2\u00b5\u00b6\7v\2\2\u00b6.\3\2\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7"+
		"w\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7j\2\2\u00bb\60\3\2\2\2\u00bc\u00bd"+
		"\7h\2\2\u00bd\u00be\7p\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7r\2\2\u00c0\u00c1"+
		"\7w\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7u\2\2\u00c3\64\3\2\2\2\u00c4\u00c5"+
		"\7k\2\2\u00c5\u00c6\7h\2\2\u00c6\66\3\2\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9"+
		"\7n\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7g\2\2\u00cb8\3\2\2\2\u00cc\u00cd"+
		"\7-\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7/\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7"+
		",\2\2\u00d1>\3\2\2\2\u00d2\u00d3\7\61\2\2\u00d3@\3\2\2\2\u00d4\u00d5\7"+
		">\2\2\u00d5B\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7\u00d8\7?\2\2\u00d8D\3\2"+
		"\2\2\u00d9\u00da\7@\2\2\u00daF\3\2\2\2\u00db\u00dc\7@\2\2\u00dc\u00dd"+
		"\7?\2\2\u00ddH\3\2\2\2\u00de\u00df\7?\2\2\u00df\u00e0\7?\2\2\u00e0J\3"+
		"\2\2\2\u00e1\u00e2\7#\2\2\u00e2\u00e3\7?\2\2\u00e3L\3\2\2\2\u00e4\u00e8"+
		"\7$\2\2\u00e5\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ec\7$\2\2\u00ecN\3\2\2\2\u00ed\u00ef\5U+\2\u00ee\u00ed\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"P\3\2\2\2\u00f2\u00f7\5S*\2\u00f3\u00f6\5S*\2\u00f4\u00f6\5U+\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8R\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb"+
		"\t\4\2\2\u00fbT\3\2\2\2\u00fc\u00fd\4\62;\2\u00fdV\3\2\2\2\n\2Zdo\u00e8"+
		"\u00f0\u00f5\u00f7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}