// Generated from Gdsl.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GdslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, TYPE=13, BOOL=14, QUANTIFIER=15, EXTRACTOR=16, 
		IF=17, ELSE=18, RETURN=19, COMPARISON=20, ADD=21, SUB=22, DIVISION=23, 
		MULTIPLICATION=24, POWER=25, AND=26, OR=27, NOT=28, ASSIGNMENT=29, UNION=30, 
		DIFFERENCE=31, INTERSECTION=32, PROPERSUBSET=33, SUBSET=34, IN=35, INTEGER=36, 
		FLOAT=37, IDENTIFIER=38, WS=39, COMMENTS=40, COMMENTANALYZE=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "TYPE", "BOOL", "QUANTIFIER", "EXTRACTOR", 
			"IF", "ELSE", "RETURN", "COMPARISON", "ADD", "SUB", "DIVISION", "MULTIPLICATION", 
			"POWER", "AND", "OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", 
			"PROPERSUBSET", "SUBSET", "IN", "INTEGER", "FLOAT", "IDENTIFIER", "WS", 
			"COMMENTS", "COMMENTANALYZE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'switch'", "'case'", "'=>'", "'default'", 
			"'|'", "'.'", "'{'", "'}'", "'type'", null, null, null, "'if'", "'else'", 
			"'return'", null, "'+'", "'-'", "'/'", "'*'", null, null, null, null, 
			"':='", "'union'", "'diff'", null, "'propersubset'", "'subset'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TYPE", "BOOL", "QUANTIFIER", "EXTRACTOR", "IF", "ELSE", "RETURN", 
			"COMPARISON", "ADD", "SUB", "DIVISION", "MULTIPLICATION", "POWER", "AND", 
			"OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", "PROPERSUBSET", 
			"SUBSET", "IN", "INTEGER", "FLOAT", "IDENTIFIER", "WS", "COMMENTS", "COMMENTANALYZE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GdslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gdsl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u0155\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u008b\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0095\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00a3\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00bd\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32"+
		"\u00ca\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u00d1\n\33\3\34\3\34\3\34\3"+
		"\34\5\34\u00d7\n\34\3\35\3\35\3\35\3\35\5\35\u00dd\n\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u00fe\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\6%\u0118\n%\r"+
		"%\16%\u0119\3&\7&\u011d\n&\f&\16&\u0120\13&\3&\3&\6&\u0124\n&\r&\16&\u0125"+
		"\3\'\6\'\u0129\n\'\r\'\16\'\u012a\3\'\7\'\u012e\n\'\f\'\16\'\u0131\13"+
		"\'\3(\6(\u0134\n(\r(\16(\u0135\3(\3(\3)\3)\3)\3)\6)\u013e\n)\r)\16)\u013f"+
		"\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\6*\u0150\n*\r*\16*\u0151\3"+
		"*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\t\4\2>>@@\3\2\62;\4\2C\\c|\6"+
		"\2\62;C\\aac|\5\2\13\f\17\17\"\"\3\2\f\f\4\2pptt\2\u0168\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3"+
		"\2\2\2\7Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\rd\3\2\2\2\17i\3\2\2\2\21l\3"+
		"\2\2\2\23t\3\2\2\2\25v\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33|\3\2\2\2\35"+
		"\u008a\3\2\2\2\37\u0094\3\2\2\2!\u00a2\3\2\2\2#\u00a4\3\2\2\2%\u00a7\3"+
		"\2\2\2\'\u00ac\3\2\2\2)\u00bc\3\2\2\2+\u00be\3\2\2\2-\u00c0\3\2\2\2/\u00c2"+
		"\3\2\2\2\61\u00c4\3\2\2\2\63\u00c9\3\2\2\2\65\u00d0\3\2\2\2\67\u00d6\3"+
		"\2\2\29\u00dc\3\2\2\2;\u00de\3\2\2\2=\u00e1\3\2\2\2?\u00e7\3\2\2\2A\u00fd"+
		"\3\2\2\2C\u00ff\3\2\2\2E\u010c\3\2\2\2G\u0113\3\2\2\2I\u0117\3\2\2\2K"+
		"\u011e\3\2\2\2M\u0128\3\2\2\2O\u0133\3\2\2\2Q\u0139\3\2\2\2S\u0143\3\2"+
		"\2\2UV\7*\2\2V\4\3\2\2\2WX\7.\2\2X\6\3\2\2\2YZ\7+\2\2Z\b\3\2\2\2[\\\7"+
		"<\2\2\\\n\3\2\2\2]^\7u\2\2^_\7y\2\2_`\7k\2\2`a\7v\2\2ab\7e\2\2bc\7j\2"+
		"\2c\f\3\2\2\2de\7e\2\2ef\7c\2\2fg\7u\2\2gh\7g\2\2h\16\3\2\2\2ij\7?\2\2"+
		"jk\7@\2\2k\20\3\2\2\2lm\7f\2\2mn\7g\2\2no\7h\2\2op\7c\2\2pq\7w\2\2qr\7"+
		"n\2\2rs\7v\2\2s\22\3\2\2\2tu\7~\2\2u\24\3\2\2\2vw\7\60\2\2w\26\3\2\2\2"+
		"xy\7}\2\2y\30\3\2\2\2z{\7\177\2\2{\32\3\2\2\2|}\7v\2\2}~\7{\2\2~\177\7"+
		"r\2\2\177\u0080\7g\2\2\u0080\34\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083"+
		"\7t\2\2\u0083\u0084\7w\2\2\u0084\u008b\7g\2\2\u0085\u0086\7h\2\2\u0086"+
		"\u0087\7c\2\2\u0087\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089\u008b\7g\2\2"+
		"\u008a\u0081\3\2\2\2\u008a\u0085\3\2\2\2\u008b\36\3\2\2\2\u008c\u008d"+
		"\7g\2\2\u008d\u008e\7z\2\2\u008e\u008f\7k\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0095\7v\2\2\u0091\u0092\7c\2\2\u0092\u0093\7n\2\2\u0093\u0095\7n\2\2"+
		"\u0094\u008c\3\2\2\2\u0094\u0091\3\2\2\2\u0095 \3\2\2\2\u0096\u0097\7"+
		"u\2\2\u0097\u0098\7g\2\2\u0098\u0099\7n\2\2\u0099\u009a\7g\2\2\u009a\u009b"+
		"\7e\2\2\u009b\u00a3\7v\2\2\u009c\u009d\7e\2\2\u009d\u009e\7j\2\2\u009e"+
		"\u009f\7q\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a3\7g\2\2"+
		"\u00a2\u0096\3\2\2\2\u00a2\u009c\3\2\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7"+
		"k\2\2\u00a5\u00a6\7h\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9"+
		"\7n\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2\u00ab&\3\2\2\2\u00ac\u00ad"+
		"\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7w\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7p\2\2\u00b2(\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4"+
		"\u00bd\7?\2\2\u00b5\u00b6\7#\2\2\u00b6\u00bd\7?\2\2\u00b7\u00b8\7@\2\2"+
		"\u00b8\u00bd\7?\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bd\7?\2\2\u00bb\u00bd"+
		"\t\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd*\3\2\2\2\u00be\u00bf\7-\2\2\u00bf"+
		",\3\2\2\2\u00c0\u00c1\7/\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7\61\2\2\u00c3"+
		"\60\3\2\2\2\u00c4\u00c5\7,\2\2\u00c5\62\3\2\2\2\u00c6\u00ca\7`\2\2\u00c7"+
		"\u00c8\7,\2\2\u00c8\u00ca\7,\2\2\u00c9\u00c6\3\2\2\2\u00c9\u00c7\3\2\2"+
		"\2\u00ca\64\3\2\2\2\u00cb\u00cc\7(\2\2\u00cc\u00d1\7(\2\2\u00cd\u00ce"+
		"\7c\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d1\7f\2\2\u00d0\u00cb\3\2\2\2\u00d0"+
		"\u00cd\3\2\2\2\u00d1\66\3\2\2\2\u00d2\u00d3\7~\2\2\u00d3\u00d7\7~\2\2"+
		"\u00d4\u00d5\7q\2\2\u00d5\u00d7\7t\2\2\u00d6\u00d2\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d78\3\2\2\2\u00d8\u00dd\7#\2\2\u00d9\u00da\7p\2\2\u00da\u00db"+
		"\7q\2\2\u00db\u00dd\7v\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd"+
		":\3\2\2\2\u00de\u00df\7<\2\2\u00df\u00e0\7?\2\2\u00e0<\3\2\2\2\u00e1\u00e2"+
		"\7w\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7q\2\2\u00e5"+
		"\u00e6\7p\2\2\u00e6>\3\2\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9\7k\2\2\u00e9"+
		"\u00ea\7h\2\2\u00ea\u00eb\7h\2\2\u00eb@\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed"+
		"\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7g\2\2\u00f0\u00fe\7t\2\2"+
		"\u00f1\u00f2\7K\2\2\u00f2\u00f3\7P\2\2\u00f3\u00f4\7V\2\2\u00f4\u00f5"+
		"\7G\2\2\u00f5\u00f6\7T\2\2\u00f6\u00f7\7U\2\2\u00f7\u00f8\7G\2\2\u00f8"+
		"\u00f9\7E\2\2\u00f9\u00fa\7V\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc\7Q\2\2"+
		"\u00fc\u00fe\7P\2\2\u00fd\u00ec\3\2\2\2\u00fd\u00f1\3\2\2\2\u00feB\3\2"+
		"\2\2\u00ff\u0100\7r\2\2\u0100\u0101\7t\2\2\u0101\u0102\7q\2\2\u0102\u0103"+
		"\7r\2\2\u0103\u0104\7g\2\2\u0104\u0105\7t\2\2\u0105\u0106\7u\2\2\u0106"+
		"\u0107\7w\2\2\u0107\u0108\7d\2\2\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2"+
		"\u010a\u010b\7v\2\2\u010bD\3\2\2\2\u010c\u010d\7u\2\2\u010d\u010e\7w\2"+
		"\2\u010e\u010f\7d\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111\u0112"+
		"\7v\2\2\u0112F\3\2\2\2\u0113\u0114\7k\2\2\u0114\u0115\7p\2\2\u0115H\3"+
		"\2\2\2\u0116\u0118\t\3\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011aJ\3\2\2\2\u011b\u011d\t\3\2\2"+
		"\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0123\7\60\2\2"+
		"\u0122\u0124\t\3\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126L\3\2\2\2\u0127\u0129\t\4\2\2\u0128"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012f\3\2\2\2\u012c\u012e\t\5\2\2\u012d\u012c\3\2\2\2\u012e"+
		"\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130N\3\2\2\2"+
		"\u0131\u012f\3\2\2\2\u0132\u0134\t\6\2\2\u0133\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0138\b(\2\2\u0138P\3\2\2\2\u0139\u013a\7\61\2\2\u013a\u013b\7\61\2\2"+
		"\u013b\u013d\3\2\2\2\u013c\u013e\n\7\2\2\u013d\u013c\3\2\2\2\u013e\u013f"+
		"\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0142\b)\2\2\u0142R\3\2\2\2\u0143\u0144\7\61\2\2\u0144\u0145\7\61\2\2"+
		"\u0145\u0146\7\u00a6\2\2\u0146\u0147\7C\2\2\u0147\u0148\7P\2\2\u0148\u0149"+
		"\7C\2\2\u0149\u014a\7N\2\2\u014a\u014b\7[\2\2\u014b\u014c\7\\\2\2\u014c"+
		"\u014d\7G\2\2\u014d\u014f\3\2\2\2\u014e\u0150\n\b\2\2\u014f\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\b*\3\2\u0154T\3\2\2\2\25\2\u008a\u0094\u00a2"+
		"\u00bc\u00c9\u00d0\u00d6\u00dc\u00fd\u0119\u011e\u0125\u0128\u012a\u012f"+
		"\u0135\u013f\u0151\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}