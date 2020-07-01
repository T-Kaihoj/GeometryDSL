// Generated from gdsl.g4 by ANTLR 4.8
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gdslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, IFT=12, IFELSET=13, ELSET=14, TYPE=15, ADD=16, SUB=17, 
		BOOL=18, QUANTIFIER=19, COMPARISON=20, POWER=21, DIVISION=22, MULTIPLICATION=23, 
		AND=24, OR=25, ASSIGNMENT=26, UNION=27, DIFFERENCE=28, INTERSECTION=29, 
		FILLER=30, CHOOSE=31, IN=32, NUMBER=33, IDENTIFIER=34, WS=35, COMMENTANALYZE=36, 
		COMMENTS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "A", "D", "E", "F", "I", "L", "N", "O", "P", "R", "S", 
			"T", "Y", "IFT", "IFELSET", "ELSET", "TYPE", "ADD", "SUB", "BOOL", "QUANTIFIER", 
			"COMPARISON", "POWER", "DIVISION", "MULTIPLICATION", "AND", "OR", "ASSIGNMENT", 
			"UNION", "DIFFERENCE", "INTERSECTION", "FILLER", "CHOOSE", "IN", "NUMBER", 
			"IDENTIFIER", "WS", "COMMENTANALYZE", "COMMENTS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'return'", "'switch'", "'case'", "'|'", 
			"'{'", "'}'", "'.'", null, null, null, "'type'", "'+'", "'-'", null, 
			null, null, null, "'/'", "'*'", null, null, "':='", "'UNION'", "'DIFF'", 
			"'INTER'", "'FILLER'", "'CHOOSE'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"IFT", "IFELSET", "ELSET", "TYPE", "ADD", "SUB", "BOOL", "QUANTIFIER", 
			"COMPARISON", "POWER", "DIVISION", "MULTIPLICATION", "AND", "OR", "ASSIGNMENT", 
			"UNION", "DIFFERENCE", "INTERSECTION", "FILLER", "CHOOSE", "IN", "NUMBER", 
			"IDENTIFIER", "WS", "COMMENTANALYZE", "COMMENTS"
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


	public gdslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gdsl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u015f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00c7"+
		"\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u00d7\n!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00e2\n\"\3#\3#\3#\5#\u00e7\n#\3$\3$\3%\3"+
		"%\3&\3&\3&\3&\3&\5&\u00f2\n&\3\'\3\'\3\'\3\'\5\'\u00f8\n\'\3(\3(\3(\3"+
		")\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		",\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\7/\u0120\n/\f/\16/\u0123\13/\3/\3/"+
		"\6/\u0127\n/\r/\16/\u0128\3/\6/\u012c\n/\r/\16/\u012d\5/\u0130\n/\3\60"+
		"\6\60\u0133\n\60\r\60\16\60\u0134\3\60\7\60\u0138\n\60\f\60\16\60\u013b"+
		"\13\60\3\61\6\61\u013e\n\61\r\61\16\61\u013f\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\6\62\u0150\n\62\r\62\16"+
		"\62\u0151\3\62\3\62\3\63\3\63\3\63\3\63\6\63\u015a\n\63\r\63\16\63\u015b"+
		"\3\63\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\16\65\17\67\209\21"+
		";\22=\23?\24A\25C\26E\27G\30I\31K\32M\33O\34Q\35S\36U\37W Y![\"]#_$a%"+
		"c&e\'\3\2\26\4\2CCcc\4\2FFff\4\2GGgg\4\2HHhh\4\2KKkk\4\2NNnn\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2TTtt\4\2UUuu\4\2VVvv\4\2[[{{\4\2>>@@\3\2\62;\4\2C\\"+
		"c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2pptt\3\2\f\f\2\u0164\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\3g\3\2\2\2\5i\3\2\2\2\7k\3\2\2\2\tm\3\2\2\2\13o\3\2\2\2\rv\3\2\2\2"+
		"\17}\3\2\2\2\21\u0082\3\2\2\2\23\u0084\3\2\2\2\25\u0086\3\2\2\2\27\u0088"+
		"\3\2\2\2\31\u008a\3\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2\2\2\37\u0090\3"+
		"\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2\2%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009a"+
		"\3\2\2\2+\u009c\3\2\2\2-\u009e\3\2\2\2/\u00a0\3\2\2\2\61\u00a2\3\2\2\2"+
		"\63\u00a4\3\2\2\2\65\u00a7\3\2\2\2\67\u00af\3\2\2\29\u00b4\3\2\2\2;\u00b9"+
		"\3\2\2\2=\u00bb\3\2\2\2?\u00c6\3\2\2\2A\u00d6\3\2\2\2C\u00e1\3\2\2\2E"+
		"\u00e6\3\2\2\2G\u00e8\3\2\2\2I\u00ea\3\2\2\2K\u00f1\3\2\2\2M\u00f7\3\2"+
		"\2\2O\u00f9\3\2\2\2Q\u00fc\3\2\2\2S\u0102\3\2\2\2U\u0107\3\2\2\2W\u010d"+
		"\3\2\2\2Y\u0114\3\2\2\2[\u011b\3\2\2\2]\u012f\3\2\2\2_\u0132\3\2\2\2a"+
		"\u013d\3\2\2\2c\u0143\3\2\2\2e\u0155\3\2\2\2gh\7*\2\2h\4\3\2\2\2ij\7."+
		"\2\2j\6\3\2\2\2kl\7+\2\2l\b\3\2\2\2mn\7<\2\2n\n\3\2\2\2op\7t\2\2pq\7g"+
		"\2\2qr\7v\2\2rs\7w\2\2st\7t\2\2tu\7p\2\2u\f\3\2\2\2vw\7u\2\2wx\7y\2\2"+
		"xy\7k\2\2yz\7v\2\2z{\7e\2\2{|\7j\2\2|\16\3\2\2\2}~\7e\2\2~\177\7c\2\2"+
		"\177\u0080\7u\2\2\u0080\u0081\7g\2\2\u0081\20\3\2\2\2\u0082\u0083\7~\2"+
		"\2\u0083\22\3\2\2\2\u0084\u0085\7}\2\2\u0085\24\3\2\2\2\u0086\u0087\7"+
		"\177\2\2\u0087\26\3\2\2\2\u0088\u0089\7\60\2\2\u0089\30\3\2\2\2\u008a"+
		"\u008b\t\2\2\2\u008b\32\3\2\2\2\u008c\u008d\t\3\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\t\4\2\2\u008f\36\3\2\2\2\u0090\u0091\t\5\2\2\u0091 \3\2\2\2\u0092"+
		"\u0093\t\6\2\2\u0093\"\3\2\2\2\u0094\u0095\t\7\2\2\u0095$\3\2\2\2\u0096"+
		"\u0097\t\b\2\2\u0097&\3\2\2\2\u0098\u0099\t\t\2\2\u0099(\3\2\2\2\u009a"+
		"\u009b\t\n\2\2\u009b*\3\2\2\2\u009c\u009d\t\13\2\2\u009d,\3\2\2\2\u009e"+
		"\u009f\t\f\2\2\u009f.\3\2\2\2\u00a0\u00a1\t\r\2\2\u00a1\60\3\2\2\2\u00a2"+
		"\u00a3\t\16\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\5!\21\2\u00a5\u00a6\5\37"+
		"\20\2\u00a6\64\3\2\2\2\u00a7\u00a8\5\35\17\2\u00a8\u00a9\5#\22\2\u00a9"+
		"\u00aa\5-\27\2\u00aa\u00ab\5\35\17\2\u00ab\u00ac\7\"\2\2\u00ac\u00ad\5"+
		"!\21\2\u00ad\u00ae\5\37\20\2\u00ae\66\3\2\2\2\u00af\u00b0\5\35\17\2\u00b0"+
		"\u00b1\5#\22\2\u00b1\u00b2\5-\27\2\u00b2\u00b3\5\35\17\2\u00b38\3\2\2"+
		"\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7{\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8:\3\2\2\2\u00b9\u00ba\7-\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7"+
		"/\2\2\u00bc>\3\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0"+
		"\7w\2\2\u00c0\u00c7\7g\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7c\2\2\u00c3"+
		"\u00c4\7n\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c7\7g\2\2\u00c6\u00bd\3\2\2"+
		"\2\u00c6\u00c1\3\2\2\2\u00c7@\3\2\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7"+
		"z\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7u\2\2\u00cc\u00d7\7v\2\2\u00cd\u00ce"+
		"\7c\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d7\7n\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7e\2\2"+
		"\u00d5\u00d7\7v\2\2\u00d6\u00c8\3\2\2\2\u00d6\u00cd\3\2\2\2\u00d6\u00d0"+
		"\3\2\2\2\u00d7B\3\2\2\2\u00d8\u00d9\7?\2\2\u00d9\u00e2\7?\2\2\u00da\u00db"+
		"\7#\2\2\u00db\u00e2\7?\2\2\u00dc\u00dd\7@\2\2\u00dd\u00e2\7?\2\2\u00de"+
		"\u00df\7>\2\2\u00df\u00e2\7?\2\2\u00e0\u00e2\t\17\2\2\u00e1\u00d8\3\2"+
		"\2\2\u00e1\u00da\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00de\3\2\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2D\3\2\2\2\u00e3\u00e7\7`\2\2\u00e4\u00e5\7,\2\2\u00e5"+
		"\u00e7\7,\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7F\3\2\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9H\3\2\2\2\u00ea\u00eb\7,\2\2\u00ebJ\3\2\2\2\u00ec"+
		"\u00ed\7(\2\2\u00ed\u00f2\7(\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7p\2\2"+
		"\u00f0\u00f2\7f\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2L\3\2"+
		"\2\2\u00f3\u00f4\7~\2\2\u00f4\u00f8\7~\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f8"+
		"\7t\2\2\u00f7\u00f3\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8N\3\2\2\2\u00f9\u00fa"+
		"\7<\2\2\u00fa\u00fb\7?\2\2\u00fbP\3\2\2\2\u00fc\u00fd\7W\2\2\u00fd\u00fe"+
		"\7P\2\2\u00fe\u00ff\7K\2\2\u00ff\u0100\7Q\2\2\u0100\u0101\7P\2\2\u0101"+
		"R\3\2\2\2\u0102\u0103\7F\2\2\u0103\u0104\7K\2\2\u0104\u0105\7H\2\2\u0105"+
		"\u0106\7H\2\2\u0106T\3\2\2\2\u0107\u0108\7K\2\2\u0108\u0109\7P\2\2\u0109"+
		"\u010a\7V\2\2\u010a\u010b\7G\2\2\u010b\u010c\7T\2\2\u010cV\3\2\2\2\u010d"+
		"\u010e\7H\2\2\u010e\u010f\7K\2\2\u010f\u0110\7N\2\2\u0110\u0111\7N\2\2"+
		"\u0111\u0112\7G\2\2\u0112\u0113\7T\2\2\u0113X\3\2\2\2\u0114\u0115\7E\2"+
		"\2\u0115\u0116\7J\2\2\u0116\u0117\7Q\2\2\u0117\u0118\7Q\2\2\u0118\u0119"+
		"\7U\2\2\u0119\u011a\7G\2\2\u011aZ\3\2\2\2\u011b\u011c\7k\2\2\u011c\u011d"+
		"\7p\2\2\u011d\\\3\2\2\2\u011e\u0120\t\20\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2"+
		"\2\2\u0123\u0121\3\2\2\2\u0124\u0126\7\60\2\2\u0125\u0127\t\20\2\2\u0126"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u0130\3\2\2\2\u012a\u012c\t\20\2\2\u012b\u012a\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2"+
		"\2\2\u012f\u0121\3\2\2\2\u012f\u012b\3\2\2\2\u0130^\3\2\2\2\u0131\u0133"+
		"\t\21\2\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0139\3\2\2\2\u0136\u0138\t\22\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"`\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013e\t\23\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141\u0142\b\61\2\2\u0142b\3\2\2\2\u0143\u0144\7\61\2\2\u0144"+
		"\u0145\7\61\2\2\u0145\u0146\7\u00a6\2\2\u0146\u0147\7C\2\2\u0147\u0148"+
		"\7P\2\2\u0148\u0149\7C\2\2\u0149\u014a\7N\2\2\u014a\u014b\7[\2\2\u014b"+
		"\u014c\7\\\2\2\u014c\u014d\7G\2\2\u014d\u014f\3\2\2\2\u014e\u0150\n\24"+
		"\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b\62\3\2\u0154d\3\2\2\2"+
		"\u0155\u0156\7\61\2\2\u0156\u0157\7\61\2\2\u0157\u0159\3\2\2\2\u0158\u015a"+
		"\n\25\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0159\3\2\2\2"+
		"\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b\63\2\2\u015ef\3"+
		"\2\2\2\23\2\u00c6\u00d6\u00e1\u00e6\u00f1\u00f7\u0121\u0128\u012d\u012f"+
		"\u0132\u0134\u0139\u013f\u0151\u015b\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}