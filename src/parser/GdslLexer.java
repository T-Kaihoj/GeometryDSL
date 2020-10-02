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
		T__9=10, T__10=11, T__11=12, INV=13, TYPE=14, BOOL=15, QUANTIFIER=16, 
		EXTRACTOR=17, IF=18, ELSE=19, RETURN=20, COMPARISON=21, ADD=22, SUB=23, 
		DIVISION=24, MULTIPLICATION=25, POWER=26, AND=27, OR=28, NOT=29, ASSIGNMENT=30, 
		UNION=31, DIFFERENCE=32, INTERSECTION=33, PROPERSUBSET=34, SUBSET=35, 
		IN=36, INTEGER=37, FLOAT=38, IDENTIFIER=39, WS=40, COMMENTS=41, COMMENTANALYZE=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "INV", "TYPE", "BOOL", "QUANTIFIER", "EXTRACTOR", 
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
			"'|'", "'.'", "'{'", "'}'", "'inv'", "'type'", null, null, null, "'if'", 
			"'else'", "'return'", null, "'+'", "'-'", "'/'", "'*'", null, null, null, 
			null, "':='", "'union'", "'diff'", null, "'propersubset'", "'subset'", 
			"'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INV", "TYPE", "BOOL", "QUANTIFIER", "EXTRACTOR", "IF", "ELSE", 
			"RETURN", "COMPARISON", "ADD", "SUB", "DIVISION", "MULTIPLICATION", "POWER", 
			"AND", "OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", 
			"PROPERSUBSET", "SUBSET", "IN", "INTEGER", "FLOAT", "IDENTIFIER", "WS", 
			"COMMENTS", "COMMENTANALYZE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0162\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0091\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u009b\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00a9\n\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u00c3\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\33\5\33\u00d0\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u00d7"+
		"\n\34\3\35\3\35\3\35\3\35\5\35\u00dd\n\35\3\36\3\36\3\36\3\36\5\36\u00e3"+
		"\n\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0104\n\"\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&"+
		"\5&\u011e\n&\3&\6&\u0121\n&\r&\16&\u0122\3\'\5\'\u0126\n\'\3\'\7\'\u0129"+
		"\n\'\f\'\16\'\u012c\13\'\3\'\3\'\6\'\u0130\n\'\r\'\16\'\u0131\3(\6(\u0135"+
		"\n(\r(\16(\u0136\3(\7(\u013a\n(\f(\16(\u013d\13(\3)\6)\u0140\n)\r)\16"+
		")\u0141\3)\3)\3*\3*\3*\3*\6*\u014a\n*\r*\16*\u014b\3*\3*\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\6+\u015d\n+\r+\16+\u015e\3+\3+\2\2,\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,\3\2\t\4\2>>@@\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2"+
		"\13\f\17\17\"\"\3\2\f\f\4\2pptt\2\u0177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2"+
		"\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\rf\3\2\2\2\17k\3\2\2\2\21n\3\2\2"+
		"\2\23v\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31|\3\2\2\2\33~\3\2\2\2\35\u0082"+
		"\3\2\2\2\37\u0090\3\2\2\2!\u009a\3\2\2\2#\u00a8\3\2\2\2%\u00aa\3\2\2\2"+
		"\'\u00ad\3\2\2\2)\u00b2\3\2\2\2+\u00c2\3\2\2\2-\u00c4\3\2\2\2/\u00c6\3"+
		"\2\2\2\61\u00c8\3\2\2\2\63\u00ca\3\2\2\2\65\u00cf\3\2\2\2\67\u00d6\3\2"+
		"\2\29\u00dc\3\2\2\2;\u00e2\3\2\2\2=\u00e4\3\2\2\2?\u00e7\3\2\2\2A\u00ed"+
		"\3\2\2\2C\u0103\3\2\2\2E\u0105\3\2\2\2G\u0112\3\2\2\2I\u0119\3\2\2\2K"+
		"\u011d\3\2\2\2M\u0125\3\2\2\2O\u0134\3\2\2\2Q\u013f\3\2\2\2S\u0145\3\2"+
		"\2\2U\u014f\3\2\2\2WX\7*\2\2X\4\3\2\2\2YZ\7.\2\2Z\6\3\2\2\2[\\\7+\2\2"+
		"\\\b\3\2\2\2]^\7<\2\2^\n\3\2\2\2_`\7u\2\2`a\7y\2\2ab\7k\2\2bc\7v\2\2c"+
		"d\7e\2\2de\7j\2\2e\f\3\2\2\2fg\7e\2\2gh\7c\2\2hi\7u\2\2ij\7g\2\2j\16\3"+
		"\2\2\2kl\7?\2\2lm\7@\2\2m\20\3\2\2\2no\7f\2\2op\7g\2\2pq\7h\2\2qr\7c\2"+
		"\2rs\7w\2\2st\7n\2\2tu\7v\2\2u\22\3\2\2\2vw\7~\2\2w\24\3\2\2\2xy\7\60"+
		"\2\2y\26\3\2\2\2z{\7}\2\2{\30\3\2\2\2|}\7\177\2\2}\32\3\2\2\2~\177\7k"+
		"\2\2\177\u0080\7p\2\2\u0080\u0081\7x\2\2\u0081\34\3\2\2\2\u0082\u0083"+
		"\7v\2\2\u0083\u0084\7{\2\2\u0084\u0085\7r\2\2\u0085\u0086\7g\2\2\u0086"+
		"\36\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u008a\7w\2\2\u008a"+
		"\u0091\7g\2\2\u008b\u008c\7h\2\2\u008c\u008d\7c\2\2\u008d\u008e\7n\2\2"+
		"\u008e\u008f\7u\2\2\u008f\u0091\7g\2\2\u0090\u0087\3\2\2\2\u0090\u008b"+
		"\3\2\2\2\u0091 \3\2\2\2\u0092\u0093\7g\2\2\u0093\u0094\7z\2\2\u0094\u0095"+
		"\7k\2\2\u0095\u0096\7u\2\2\u0096\u009b\7v\2\2\u0097\u0098\7c\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009b\7n\2\2\u009a\u0092\3\2\2\2\u009a\u0097\3\2\2"+
		"\2\u009b\"\3\2\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\u009f\7"+
		"n\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a9\7v\2\2\u00a2\u00a3"+
		"\7e\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\u00a9\7g\2\2\u00a8\u009c\3\2\2\2\u00a8\u00a2\3\2\2"+
		"\2\u00a9$\3\2\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7h\2\2\u00ac&\3\2\2\2"+
		"\u00ad\u00ae\7g\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1(\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5"+
		"\7v\2\2\u00b5\u00b6\7w\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7p\2\2\u00b8"+
		"*\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba\u00c3\7?\2\2\u00bb\u00bc\7#\2\2\u00bc"+
		"\u00c3\7?\2\2\u00bd\u00be\7@\2\2\u00be\u00c3\7?\2\2\u00bf\u00c0\7>\2\2"+
		"\u00c0\u00c3\7?\2\2\u00c1\u00c3\t\2\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00bb"+
		"\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3"+
		",\3\2\2\2\u00c4\u00c5\7-\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7/\2\2\u00c7\60"+
		"\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7,\2\2\u00cb"+
		"\64\3\2\2\2\u00cc\u00d0\7`\2\2\u00cd\u00ce\7,\2\2\u00ce\u00d0\7,\2\2\u00cf"+
		"\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\7(\2\2"+
		"\u00d2\u00d7\7(\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d7"+
		"\7f\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d78\3\2\2\2\u00d8\u00d9"+
		"\7~\2\2\u00d9\u00dd\7~\2\2\u00da\u00db\7q\2\2\u00db\u00dd\7t\2\2\u00dc"+
		"\u00d8\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd:\3\2\2\2\u00de\u00e3\7#\2\2\u00df"+
		"\u00e0\7p\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e3\7v\2\2\u00e2\u00de\3\2\2"+
		"\2\u00e2\u00df\3\2\2\2\u00e3<\3\2\2\2\u00e4\u00e5\7<\2\2\u00e5\u00e6\7"+
		"?\2\2\u00e6>\3\2\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea"+
		"\7k\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7p\2\2\u00ec@\3\2\2\2\u00ed\u00ee"+
		"\7f\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7h\2\2\u00f0\u00f1\7h\2\2\u00f1"+
		"B\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7v\2\2\u00f5"+
		"\u00f6\7g\2\2\u00f6\u0104\7t\2\2\u00f7\u00f8\7K\2\2\u00f8\u00f9\7P\2\2"+
		"\u00f9\u00fa\7V\2\2\u00fa\u00fb\7G\2\2\u00fb\u00fc\7T\2\2\u00fc\u00fd"+
		"\7U\2\2\u00fd\u00fe\7G\2\2\u00fe\u00ff\7E\2\2\u00ff\u0100\7V\2\2\u0100"+
		"\u0101\7K\2\2\u0101\u0102\7Q\2\2\u0102\u0104\7P\2\2\u0103\u00f2\3\2\2"+
		"\2\u0103\u00f7\3\2\2\2\u0104D\3\2\2\2\u0105\u0106\7r\2\2\u0106\u0107\7"+
		"t\2\2\u0107\u0108\7q\2\2\u0108\u0109\7r\2\2\u0109\u010a\7g\2\2\u010a\u010b"+
		"\7t\2\2\u010b\u010c\7u\2\2\u010c\u010d\7w\2\2\u010d\u010e\7d\2\2\u010e"+
		"\u010f\7u\2\2\u010f\u0110\7g\2\2\u0110\u0111\7v\2\2\u0111F\3\2\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u0114\7w\2\2\u0114\u0115\7d\2\2\u0115\u0116\7u\2\2"+
		"\u0116\u0117\7g\2\2\u0117\u0118\7v\2\2\u0118H\3\2\2\2\u0119\u011a\7k\2"+
		"\2\u011a\u011b\7p\2\2\u011bJ\3\2\2\2\u011c\u011e\7/\2\2\u011d\u011c\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u0121\t\3\2\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123L\3\2\2\2\u0124\u0126\7/\2\2\u0125\u0124\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u012a\3\2\2\2\u0127\u0129\t\3\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012d\u012f\7\60\2\2\u012e\u0130\t\3\2\2\u012f"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132N\3\2\2\2\u0133\u0135\t\4\2\2\u0134\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u013b\3\2\2\2\u0138"+
		"\u013a\t\5\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013cP\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0140"+
		"\t\6\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b)\2\2\u0144R\3\2\2\2\u0145"+
		"\u0146\7\61\2\2\u0146\u0147\7\61\2\2\u0147\u0149\3\2\2\2\u0148\u014a\n"+
		"\7\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\b*\2\2\u014eT\3\2\2\2\u014f"+
		"\u0150\7\61\2\2\u0150\u0151\7\61\2\2\u0151\u0152\7\uffff\2\2\u0152\u0153"+
		"\7\uffff\2\2\u0153\u0154\7C\2\2\u0154\u0155\7P\2\2\u0155\u0156\7C\2\2"+
		"\u0156\u0157\7N\2\2\u0157\u0158\7[\2\2\u0158\u0159\7\\\2\2\u0159\u015a"+
		"\7G\2\2\u015a\u015c\3\2\2\2\u015b\u015d\n\b\2\2\u015c\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0161\b+\3\2\u0161V\3\2\2\2\27\2\u0090\u009a\u00a8\u00c2\u00cf"+
		"\u00d6\u00dc\u00e2\u0103\u011d\u0122\u0125\u012a\u0131\u0134\u0136\u013b"+
		"\u0141\u014b\u015e\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}