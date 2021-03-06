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
		T__9=10, T__10=11, T__11=12, INV=13, TYPE=14, QUANTIFIER=15, EXTRACTOR=16, 
		IF=17, ELSE=18, RETURN=19, COMPARISON=20, PLUS=21, MINUS=22, MULTIPLICATION=23, 
		DIVISION=24, POWER=25, AND=26, OR=27, NOT=28, ASSIGNMENT=29, UNION=30, 
		DIFFERENCE=31, INTERSECTION=32, PROPERSUBSET=33, SUBSET=34, IN=35, IS=36, 
		NOVALUE=37, BOOL=38, INTEGER=39, FLOAT=40, IDENTIFIER=41, WS=42, COMMENTS=43, 
		COMMENTANALYZE=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "INV", "TYPE", "QUANTIFIER", "EXTRACTOR", "IF", 
			"ELSE", "RETURN", "COMPARISON", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", 
			"POWER", "AND", "OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", 
			"PROPERSUBSET", "SUBSET", "IN", "IS", "NOVALUE", "BOOL", "INTEGER", "FLOAT", 
			"IDENTIFIER", "WS", "COMMENTS", "COMMENTANALYZE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'switch'", "'case'", "'=>'", "'default'", 
			"'|'", "'.'", "'{'", "'}'", "'inv'", "'type'", null, null, "'if'", "'else'", 
			"'return'", null, "'+'", "'-'", "'*'", "'/'", null, null, null, null, 
			"':='", "'union'", "'diff'", null, "'propersubset'", "'subset'", "'in'", 
			"'is'", "'(/)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INV", "TYPE", "QUANTIFIER", "EXTRACTOR", "IF", "ELSE", "RETURN", 
			"COMPARISON", "PLUS", "MINUS", "MULTIPLICATION", "DIVISION", "POWER", 
			"AND", "OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", 
			"PROPERSUBSET", "SUBSET", "IN", "IS", "NOVALUE", "BOOL", "INTEGER", "FLOAT", 
			"IDENTIFIER", "WS", "COMMENTS", "COMMENTANALYZE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0166\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0094\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a2\n\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bc\n\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u00c9\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u00d0\n\33\3\34\3\34\3\34\3\34\5\34\u00d6\n\34\3"+
		"\35\3\35\3\35\3\35\5\35\u00dc\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\5!\u00fd\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u0126\n\'\3(\6(\u0129\n(\r(\16(\u012a\3)\7)\u012e"+
		"\n)\f)\16)\u0131\13)\3)\3)\6)\u0135\n)\r)\16)\u0136\3*\6*\u013a\n*\r*"+
		"\16*\u013b\3*\7*\u013f\n*\f*\16*\u0142\13*\3+\6+\u0145\n+\r+\16+\u0146"+
		"\3+\3+\3,\3,\3,\3,\6,\u014f\n,\r,\16,\u0150\3,\3,\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\6-\u0161\n-\r-\16-\u0162\3-\3-\2\2.\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.\3\2\t\4\2>>@@\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f"+
		"\17\17\"\"\3\2\f\f\4\2pptt\2\u0179\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3"+
		"\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\rj\3\2\2\2\17o\3\2"+
		"\2\2\21r\3\2\2\2\23z\3\2\2\2\25|\3\2\2\2\27~\3\2\2\2\31\u0080\3\2\2\2"+
		"\33\u0082\3\2\2\2\35\u0086\3\2\2\2\37\u0093\3\2\2\2!\u00a1\3\2\2\2#\u00a3"+
		"\3\2\2\2%\u00a6\3\2\2\2\'\u00ab\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2"+
		"-\u00bf\3\2\2\2/\u00c1\3\2\2\2\61\u00c3\3\2\2\2\63\u00c8\3\2\2\2\65\u00cf"+
		"\3\2\2\2\67\u00d5\3\2\2\29\u00db\3\2\2\2;\u00dd\3\2\2\2=\u00e0\3\2\2\2"+
		"?\u00e6\3\2\2\2A\u00fc\3\2\2\2C\u00fe\3\2\2\2E\u010b\3\2\2\2G\u0112\3"+
		"\2\2\2I\u0115\3\2\2\2K\u0118\3\2\2\2M\u0125\3\2\2\2O\u0128\3\2\2\2Q\u012f"+
		"\3\2\2\2S\u0139\3\2\2\2U\u0144\3\2\2\2W\u014a\3\2\2\2Y\u0154\3\2\2\2["+
		"\\\7*\2\2\\\4\3\2\2\2]^\7.\2\2^\6\3\2\2\2_`\7+\2\2`\b\3\2\2\2ab\7<\2\2"+
		"b\n\3\2\2\2cd\7u\2\2de\7y\2\2ef\7k\2\2fg\7v\2\2gh\7e\2\2hi\7j\2\2i\f\3"+
		"\2\2\2jk\7e\2\2kl\7c\2\2lm\7u\2\2mn\7g\2\2n\16\3\2\2\2op\7?\2\2pq\7@\2"+
		"\2q\20\3\2\2\2rs\7f\2\2st\7g\2\2tu\7h\2\2uv\7c\2\2vw\7w\2\2wx\7n\2\2x"+
		"y\7v\2\2y\22\3\2\2\2z{\7~\2\2{\24\3\2\2\2|}\7\60\2\2}\26\3\2\2\2~\177"+
		"\7}\2\2\177\30\3\2\2\2\u0080\u0081\7\177\2\2\u0081\32\3\2\2\2\u0082\u0083"+
		"\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085\7x\2\2\u0085\34\3\2\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7{\2\2\u0088\u0089\7r\2\2\u0089\u008a\7g\2\2\u008a"+
		"\36\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d\7z\2\2\u008d\u008e\7k\2\2\u008e"+
		"\u008f\7u\2\2\u008f\u0094\7v\2\2\u0090\u0091\7c\2\2\u0091\u0092\7n\2\2"+
		"\u0092\u0094\7n\2\2\u0093\u008b\3\2\2\2\u0093\u0090\3\2\2\2\u0094 \3\2"+
		"\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097\u0098\7n\2\2\u0098\u0099"+
		"\7g\2\2\u0099\u009a\7e\2\2\u009a\u00a2\7v\2\2\u009b\u009c\7e\2\2\u009c"+
		"\u009d\7j\2\2\u009d\u009e\7q\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7u\2\2"+
		"\u00a0\u00a2\7g\2\2\u00a1\u0095\3\2\2\2\u00a1\u009b\3\2\2\2\u00a2\"\3"+
		"\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5$\3\2\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"&\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7w\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7p\2\2\u00b1(\3\2\2\2\u00b2"+
		"\u00b3\7?\2\2\u00b3\u00bc\7?\2\2\u00b4\u00b5\7#\2\2\u00b5\u00bc\7?\2\2"+
		"\u00b6\u00b7\7@\2\2\u00b7\u00bc\7?\2\2\u00b8\u00b9\7>\2\2\u00b9\u00bc"+
		"\7?\2\2\u00ba\u00bc\t\2\2\2\u00bb\u00b2\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bb"+
		"\u00b6\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc*\3\2\2\2"+
		"\u00bd\u00be\7-\2\2\u00be,\3\2\2\2\u00bf\u00c0\7/\2\2\u00c0.\3\2\2\2\u00c1"+
		"\u00c2\7,\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7\61\2\2\u00c4\62\3\2\2\2\u00c5"+
		"\u00c9\7`\2\2\u00c6\u00c7\7,\2\2\u00c7\u00c9\7,\2\2\u00c8\u00c5\3\2\2"+
		"\2\u00c8\u00c6\3\2\2\2\u00c9\64\3\2\2\2\u00ca\u00cb\7(\2\2\u00cb\u00d0"+
		"\7(\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7p\2\2\u00ce\u00d0\7f\2\2\u00cf"+
		"\u00ca\3\2\2\2\u00cf\u00cc\3\2\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\7~\2\2"+
		"\u00d2\u00d6\7~\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d6\7t\2\2\u00d5\u00d1"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d68\3\2\2\2\u00d7\u00dc\7#\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7q\2\2\u00da\u00dc\7v\2\2\u00db\u00d7\3\2\2\2\u00db"+
		"\u00d8\3\2\2\2\u00dc:\3\2\2\2\u00dd\u00de\7<\2\2\u00de\u00df\7?\2\2\u00df"+
		"<\3\2\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7q\2\2\u00e4\u00e5\7p\2\2\u00e5>\3\2\2\2\u00e6\u00e7\7f\2\2\u00e7"+
		"\u00e8\7k\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7h\2\2\u00ea@\3\2\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7g\2\2"+
		"\u00ef\u00fd\7t\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7P\2\2\u00f2\u00f3"+
		"\7V\2\2\u00f3\u00f4\7G\2\2\u00f4\u00f5\7T\2\2\u00f5\u00f6\7U\2\2\u00f6"+
		"\u00f7\7G\2\2\u00f7\u00f8\7E\2\2\u00f8\u00f9\7V\2\2\u00f9\u00fa\7K\2\2"+
		"\u00fa\u00fb\7Q\2\2\u00fb\u00fd\7P\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00f0"+
		"\3\2\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7r\2\2\u00ff\u0100\7t\2\2\u0100\u0101"+
		"\7q\2\2\u0101\u0102\7r\2\2\u0102\u0103\7g\2\2\u0103\u0104\7t\2\2\u0104"+
		"\u0105\7u\2\2\u0105\u0106\7w\2\2\u0106\u0107\7d\2\2\u0107\u0108\7u\2\2"+
		"\u0108\u0109\7g\2\2\u0109\u010a\7v\2\2\u010aD\3\2\2\2\u010b\u010c\7u\2"+
		"\2\u010c\u010d\7w\2\2\u010d\u010e\7d\2\2\u010e\u010f\7u\2\2\u010f\u0110"+
		"\7g\2\2\u0110\u0111\7v\2\2\u0111F\3\2\2\2\u0112\u0113\7k\2\2\u0113\u0114"+
		"\7p\2\2\u0114H\3\2\2\2\u0115\u0116\7k\2\2\u0116\u0117\7u\2\2\u0117J\3"+
		"\2\2\2\u0118\u0119\7*\2\2\u0119\u011a\7\61\2\2\u011a\u011b\7+\2\2\u011b"+
		"L\3\2\2\2\u011c\u011d\7v\2\2\u011d\u011e\7t\2\2\u011e\u011f\7w\2\2\u011f"+
		"\u0126\7g\2\2\u0120\u0121\7h\2\2\u0121\u0122\7c\2\2\u0122\u0123\7n\2\2"+
		"\u0123\u0124\7u\2\2\u0124\u0126\7g\2\2\u0125\u011c\3\2\2\2\u0125\u0120"+
		"\3\2\2\2\u0126N\3\2\2\2\u0127\u0129\t\3\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012bP\3\2\2\2"+
		"\u012c\u012e\t\3\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0134\7\60\2\2\u0133\u0135\t\3\2\2\u0134\u0133\3\2\2\2\u0135\u0136\3"+
		"\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137R\3\2\2\2\u0138\u013a"+
		"\t\4\2\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u0140\3\2\2\2\u013d\u013f\t\5\2\2\u013e\u013d\3\2"+
		"\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"T\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\t\6\2\2\u0144\u0143\3\2\2\2"+
		"\u0145\u0146\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u0149\b+\2\2\u0149V\3\2\2\2\u014a\u014b\7\61\2\2\u014b"+
		"\u014c\7\61\2\2\u014c\u014e\3\2\2\2\u014d\u014f\n\7\2\2\u014e\u014d\3"+
		"\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\b,\2\2\u0153X\3\2\2\2\u0154\u0155\7\61\2\2"+
		"\u0155\u0156\7\61\2\2\u0156\u0157\7\u00a6\2\2\u0157\u0158\7C\2\2\u0158"+
		"\u0159\7P\2\2\u0159\u015a\7C\2\2\u015a\u015b\7N\2\2\u015b\u015c\7[\2\2"+
		"\u015c\u015d\7\\\2\2\u015d\u015e\7G\2\2\u015e\u0160\3\2\2\2\u015f\u0161"+
		"\n\b\2\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\b-\3\2\u0165Z\3\2\2\2\25"+
		"\2\u0093\u00a1\u00bb\u00c8\u00cf\u00d5\u00db\u00fc\u0125\u012a\u012f\u0136"+
		"\u0139\u013b\u0140\u0146\u0150\u0162\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}