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
		INTEGER=8, STRING=9, IDENTIFIER=10, LEN=11, FIRST=12, LAST=13, REST=14, 
		PUSH=15, FN=16, PyCOMMA=17, ASSIGN=18, PIZQ=19, PDER=20, PCIZQ=21, PCDER=22, 
		LLAVEIZQ=23, LLAVEDER=24, PUTS=25, IF=26, ELSE=27, VIR=28, DOSPUN=29, 
		COMMA=30, SUM=31, SUB=32, MUL=33, DIV=34, MENOR=35, MENORIGUAL=36, MAYOR=37, 
		MAYORIGUAL=38, IGUAL=39, DISTINTO=40, ARRAY=41, TySTRING=42, TyINTEGER=43, 
		LETTER=44, DIGIT=45, ID=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "LINE_COMMENT", "FULL_COMMENT", "TRUE", "FALSE", "LET", "RETURN", 
		"INTEGER", "STRING", "IDENTIFIER", "LEN", "FIRST", "LAST", "REST", "PUSH", 
		"FN", "PyCOMMA", "ASSIGN", "PIZQ", "PDER", "PCIZQ", "PCDER", "LLAVEIZQ", 
		"LLAVEDER", "PUTS", "IF", "ELSE", "VIR", "DOSPUN", "COMMA", "SUM", "SUB", 
		"MUL", "DIV", "MENOR", "MENORIGUAL", "MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", 
		"ARRAY", "TySTRING", "TyINTEGER", "LETTER", "DIGIT", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'true'", "'false'", "'let'", "'return'", "'Integer'", 
		"'String'", "'identifier'", "'len'", "'first'", "'last'", "'rest'", "'push'", 
		"'fn'", "';'", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'puts'", 
		"'if'", "'else'", "'~'", "':'", "','", "'+'", "'-'", "'*'", "'/'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "LINE_COMMENT", "FULL_COMMENT", "TRUE", "FALSE", "LET", "RETURN", 
		"INTEGER", "STRING", "IDENTIFIER", "LEN", "FIRST", "LAST", "REST", "PUSH", 
		"FN", "PyCOMMA", "ASSIGN", "PIZQ", "PDER", "PCIZQ", "PCDER", "LLAVEIZQ", 
		"LLAVEDER", "PUTS", "IF", "ELSE", "VIR", "DOSPUN", "COMMA", "SUM", "SUB", 
		"MUL", "DIV", "MENOR", "MENORIGUAL", "MAYOR", "MAYORIGUAL", "IGUAL", "DISTINTO", 
		"ARRAY", "TySTRING", "TyINTEGER", "LETTER", "DIGIT", "ID"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 45:
			ID_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ID_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			LETTER | DIGIT
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u012c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\6\2a\n\2\r\2\16\2b\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\7\3k\n\3\f\3\16\3n\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4v\n\4\f\4\16\4y"+
		"\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\5*\u010a"+
		"\n*\3*\3*\3*\5*\u010f\n*\7*\u0111\n*\f*\16*\u0114\13*\3*\3*\3+\3+\7+\u011a"+
		"\n+\f+\16+\u011d\13+\3+\3+\3,\6,\u0122\n,\r,\16,\u0123\3-\3-\3.\3.\3/"+
		"\3/\3/\4w\u011b\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\6\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\6\2\"\"C\\aac|\3\2\62;\2\u0133\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3`\3\2\2\2\5f\3\2\2\2\7q\3\2"+
		"\2\2\t\177\3\2\2\2\13\u0084\3\2\2\2\r\u008a\3\2\2\2\17\u008e\3\2\2\2\21"+
		"\u0095\3\2\2\2\23\u009d\3\2\2\2\25\u00a4\3\2\2\2\27\u00af\3\2\2\2\31\u00b3"+
		"\3\2\2\2\33\u00b9\3\2\2\2\35\u00be\3\2\2\2\37\u00c3\3\2\2\2!\u00c8\3\2"+
		"\2\2#\u00cb\3\2\2\2%\u00cd\3\2\2\2\'\u00cf\3\2\2\2)\u00d1\3\2\2\2+\u00d3"+
		"\3\2\2\2-\u00d5\3\2\2\2/\u00d7\3\2\2\2\61\u00d9\3\2\2\2\63\u00db\3\2\2"+
		"\2\65\u00e0\3\2\2\2\67\u00e3\3\2\2\29\u00e8\3\2\2\2;\u00ea\3\2\2\2=\u00ec"+
		"\3\2\2\2?\u00ee\3\2\2\2A\u00f0\3\2\2\2C\u00f2\3\2\2\2E\u00f4\3\2\2\2G"+
		"\u00f6\3\2\2\2I\u00f8\3\2\2\2K\u00fb\3\2\2\2M\u00fd\3\2\2\2O\u0100\3\2"+
		"\2\2Q\u0103\3\2\2\2S\u0106\3\2\2\2U\u0117\3\2\2\2W\u0121\3\2\2\2Y\u0125"+
		"\3\2\2\2[\u0127\3\2\2\2]\u0129\3\2\2\2_a\t\2\2\2`_\3\2\2\2ab\3\2\2\2b"+
		"`\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\b\2\2\2e\4\3\2\2\2fg\7\61\2\2gh\7\61\2"+
		"\2hl\3\2\2\2ik\n\3\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2"+
		"\2nl\3\2\2\2op\b\3\2\2p\6\3\2\2\2qr\7\61\2\2rs\7,\2\2sw\3\2\2\2tv\13\2"+
		"\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7,"+
		"\2\2{|\7\61\2\2|}\3\2\2\2}~\b\4\2\2~\b\3\2\2\2\177\u0080\7v\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7w\2\2\u0082\u0083\7g\2\2\u0083\n\3\2\2\2\u0084"+
		"\u0085\7h\2\2\u0085\u0086\7c\2\2\u0086\u0087\7n\2\2\u0087\u0088\7u\2\2"+
		"\u0088\u0089\7g\2\2\u0089\f\3\2\2\2\u008a\u008b\7n\2\2\u008b\u008c\7g"+
		"\2\2\u008c\u008d\7v\2\2\u008d\16\3\2\2\2\u008e\u008f\7t\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7v\2\2\u0091\u0092\7w\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7p\2\2\u0094\20\3\2\2\2\u0095\u0096\7K\2\2\u0096\u0097\7p\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7i\2\2\u009a\u009b\7g\2\2"+
		"\u009b\u009c\7t\2\2\u009c\22\3\2\2\2\u009d\u009e\7U\2\2\u009e\u009f\7"+
		"v\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3"+
		"\7i\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7h\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7t\2\2"+
		"\u00ae\26\3\2\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7"+
		"p\2\2\u00b2\30\3\2\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6"+
		"\7t\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7v\2\2\u00b8\32\3\2\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7v\2\2\u00bd"+
		"\34\3\2\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\36\3\2\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5\7w\2\2\u00c5"+
		"\u00c6\7u\2\2\u00c6\u00c7\7j\2\2\u00c7 \3\2\2\2\u00c8\u00c9\7h\2\2\u00c9"+
		"\u00ca\7p\2\2\u00ca\"\3\2\2\2\u00cb\u00cc\7=\2\2\u00cc$\3\2\2\2\u00cd"+
		"\u00ce\7?\2\2\u00ce&\3\2\2\2\u00cf\u00d0\7*\2\2\u00d0(\3\2\2\2\u00d1\u00d2"+
		"\7+\2\2\u00d2*\3\2\2\2\u00d3\u00d4\7]\2\2\u00d4,\3\2\2\2\u00d5\u00d6\7"+
		"_\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7}\2\2\u00d8\60\3\2\2\2\u00d9\u00da\7"+
		"\177\2\2\u00da\62\3\2\2\2\u00db\u00dc\7r\2\2\u00dc\u00dd\7w\2\2\u00dd"+
		"\u00de\7v\2\2\u00de\u00df\7u\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00e2\7h\2\2\u00e2\66\3\2\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7n\2\2\u00e5"+
		"\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e78\3\2\2\2\u00e8\u00e9\7\u0080\2"+
		"\2\u00e9:\3\2\2\2\u00ea\u00eb\7<\2\2\u00eb<\3\2\2\2\u00ec\u00ed\7.\2\2"+
		"\u00ed>\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef@\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1"+
		"B\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3D\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f5"+
		"F\3\2\2\2\u00f6\u00f7\7>\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7>\2\2\u00f9\u00fa"+
		"\7?\2\2\u00faJ\3\2\2\2\u00fb\u00fc\7@\2\2\u00fcL\3\2\2\2\u00fd\u00fe\7"+
		"@\2\2\u00fe\u00ff\7?\2\2\u00ffN\3\2\2\2\u0100\u0101\7?\2\2\u0101\u0102"+
		"\7?\2\2\u0102P\3\2\2\2\u0103\u0104\7#\2\2\u0104\u0105\7?\2\2\u0105R\3"+
		"\2\2\2\u0106\u0109\7]\2\2\u0107\u010a\5W,\2\u0108\u010a\5U+\2\u0109\u0107"+
		"\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u0112\3\2\2\2\u010b\u010e\7.\2\2\u010c"+
		"\u010f\5W,\2\u010d\u010f\5U+\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2"+
		"\u010f\u0111\3\2\2\2\u0110\u010b\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0116\7_\2\2\u0116T\3\2\2\2\u0117\u011b\7$\2\2\u0118\u011a\13\2\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u011c\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7$\2\2\u011f"+
		"V\3\2\2\2\u0120\u0122\5[.\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124X\3\2\2\2\u0125\u0126\t\4\2\2"+
		"\u0126Z\3\2\2\2\u0127\u0128\t\5\2\2\u0128\\\3\2\2\2\u0129\u012a\5Y-\2"+
		"\u012a\u012b\b/\3\2\u012b^\3\2\2\2\13\2blw\u0109\u010e\u0112\u011b\u0123"+
		"\4\b\2\2\3/\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}