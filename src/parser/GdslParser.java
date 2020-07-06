// Generated from Gdsl.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GdslParser extends Parser {
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
	public static final int
		RULE_gdsl = 0, RULE_typeDefinition = 1, RULE_functionDefinition = 2, RULE_declaration = 3, 
		RULE_scope = 4, RULE_statement = 5, RULE_variableDefinition = 6, RULE_returnStatement = 7, 
		RULE_switchCase = 8, RULE_iif = 9, RULE_iifElset = 10, RULE_elset = 11, 
		RULE_setElementDefinition = 12, RULE_expression = 13, RULE_variables = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"gdsl", "typeDefinition", "functionDefinition", "declaration", "scope", 
			"statement", "variableDefinition", "returnStatement", "switchCase", "iif", 
			"iifElset", "elset", "setElementDefinition", "expression", "variables"
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

	@Override
	public String getGrammarFileName() { return "Gdsl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GdslParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GdslContext extends ParserRuleContext {
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public GdslContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdsl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterGdsl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitGdsl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitGdsl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GdslContext gdsl() throws RecognitionException {
		GdslContext _localctx = new GdslContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gdsl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==IDENTIFIER) {
				{
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					typeDefinition();
					}
					break;
				case 2:
					{
					setState(31);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(32);
					variableDefinition();
					}
					break;
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDefinitionContext extends ParserRuleContext {
		public Token id;
		public TerminalNode TYPE() { return getToken(GdslParser.TYPE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(GdslParser.IDENTIFIER, 0); }
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitTypeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(TYPE);
			setState(39);
			((TypeDefinitionContext)_localctx).id = match(IDENTIFIER);
			setState(40);
			match(T__0);
			setState(41);
			declaration();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(42);
				match(T__1);
				setState(43);
				declaration();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Token retType;
		public Token functionId;
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(GdslParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GdslParser.IDENTIFIER, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			((FunctionDefinitionContext)_localctx).retType = match(IDENTIFIER);
			setState(52);
			((FunctionDefinitionContext)_localctx).functionId = match(IDENTIFIER);
			setState(53);
			match(T__0);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(54);
				declaration();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(55);
					match(T__1);
					setState(56);
					declaration();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(64);
			match(T__2);
			setState(65);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public List<TerminalNode> IDENTIFIER() { return getTokens(GdslParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GdslParser.IDENTIFIER, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			((DeclarationContext)_localctx).id = match(IDENTIFIER);
			setState(68);
			match(T__3);
			setState(69);
			((DeclarationContext)_localctx).type = match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scope);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case IFT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__0);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << IFT) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(73);
					statement();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public IifContext iif() {
			return getRuleContext(IifContext.class,0);
		}
		public SwitchCaseContext switchCase() {
			return getRuleContext(SwitchCaseContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				iif();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				switchCase();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				variableDefinition();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				returnStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(GdslParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			declaration();
			setState(89);
			match(ASSIGNMENT);
			setState(90);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__4);
			setState(93);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchCaseContext extends ParserRuleContext {
		public List<VariablesContext> variables() {
			return getRuleContexts(VariablesContext.class);
		}
		public VariablesContext variables(int i) {
			return getRuleContext(VariablesContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ScopeContext> scope() {
			return getRuleContexts(ScopeContext.class);
		}
		public ScopeContext scope(int i) {
			return getRuleContext(ScopeContext.class,i);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSwitchCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSwitchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_switchCase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			{
			setState(96);
			variables();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(97);
				match(T__1);
				setState(98);
				variables();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(T__6);
					setState(105);
					expression(0);
					setState(106);
					match(T__3);
					setState(107);
					scope();
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IifContext extends ParserRuleContext {
		public TerminalNode IFT() { return getToken(GdslParser.IFT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<IifElsetContext> iifElset() {
			return getRuleContexts(IifElsetContext.class);
		}
		public IifElsetContext iifElset(int i) {
			return getRuleContext(IifElsetContext.class,i);
		}
		public ElsetContext elset() {
			return getRuleContext(ElsetContext.class,0);
		}
		public IifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterIif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitIif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitIif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IifContext iif() throws RecognitionException {
		IifContext _localctx = new IifContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_iif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IFT);
			setState(115);
			match(T__0);
			setState(116);
			expression(0);
			setState(117);
			match(T__2);
			setState(118);
			scope();
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					iifElset();
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(125);
				elset();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IifElsetContext extends ParserRuleContext {
		public TerminalNode IFELSET() { return getToken(GdslParser.IFELSET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IifElsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iifElset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterIifElset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitIifElset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitIifElset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IifElsetContext iifElset() throws RecognitionException {
		IifElsetContext _localctx = new IifElsetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_iifElset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(128);
			match(IFELSET);
			setState(129);
			match(T__0);
			setState(130);
			expression(0);
			setState(131);
			match(T__2);
			setState(132);
			scope();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsetContext extends ParserRuleContext {
		public TerminalNode ELSET() { return getToken(GdslParser.ELSET, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ElsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterElset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitElset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitElset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsetContext elset() throws RecognitionException {
		ElsetContext _localctx = new ElsetContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ELSET);
			setState(135);
			scope();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetElementDefinitionContext extends ParserRuleContext {
		public Token localName;
		public ExpressionContext globalName;
		public TerminalNode IN() { return getToken(GdslParser.IN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GdslParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetElementDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setElementDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetElementDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetElementDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetElementDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetElementDefinitionContext setElementDefinition() throws RecognitionException {
		SetElementDefinitionContext _localctx = new SetElementDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_setElementDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((SetElementDefinitionContext)_localctx).localName = match(IDENTIFIER);
			setState(138);
			match(IN);
			setState(139);
			((SetElementDefinitionContext)_localctx).globalName = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DotExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GdslParser.IDENTIFIER, 0); }
		public DotExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterDotExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitDotExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitDotExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetComprehensionExpContext extends ExpressionContext {
		public SetElementDefinitionContext setElementDefinition() {
			return getRuleContext(SetElementDefinitionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetComprehensionExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetComprehensionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetComprehensionExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetComprehensionExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(GdslParser.NUMBER, 0); }
		public NumberExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterNumberExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitNumberExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitNumberExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(GdslParser.AND, 0); }
		public AndExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterAndExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitAndExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitAndExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(GdslParser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterFunctionCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitFunctionCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitFunctionCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpContext extends ExpressionContext {
		public Token bool;
		public TerminalNode BOOL() { return getToken(GdslParser.BOOL, 0); }
		public BoolExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitBoolExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(GdslParser.IDENTIFIER, 0); }
		public VariableExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterVariableExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitVariableExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitVariableExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(GdslParser.OR, 0); }
		public OrExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterOrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitOrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitOrExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExpContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(GdslParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(GdslParser.SUB, 0); }
		public AddSubExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterAddSubExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitAddSubExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitAddSubExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetLiteralExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetLiteralExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetLiteralExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetLiteralExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetLiteralExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode POWER() { return getToken(GdslParser.POWER, 0); }
		public PowerExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterPowerExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitPowerExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitPowerExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivMulExpContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(GdslParser.DIVISION, 0); }
		public TerminalNode MULTIPLICATION() { return getToken(GdslParser.MULTIPLICATION, 0); }
		public DivMulExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterDivMulExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitDivMulExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitDivMulExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpContext extends ExpressionContext {
		public Token operator;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMPARISON() { return getToken(GdslParser.COMPARISON, 0); }
		public ComparisonExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterComparisonExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitComparisonExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitComparisonExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetChooseExpContext extends ExpressionContext {
		public TerminalNode CHOOSE() { return getToken(GdslParser.CHOOSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetChooseExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetChooseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetChooseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetChooseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AbsoluteExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbsoluteExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterAbsoluteExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitAbsoluteExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitAbsoluteExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterParenthesisExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitParenthesisExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitParenthesisExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOperatorExpContext extends ExpressionContext {
		public ExpressionContext setL;
		public Token operator;
		public ExpressionContext setR;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode UNION() { return getToken(GdslParser.UNION, 0); }
		public TerminalNode DIFFERENCE() { return getToken(GdslParser.DIFFERENCE, 0); }
		public TerminalNode INTERSECTION() { return getToken(GdslParser.INTERSECTION, 0); }
		public SetOperatorExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetOperatorExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetOperatorExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetOperatorExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetQuantificationCallExpContext extends ExpressionContext {
		public Token quantifier;
		public SetElementDefinitionContext setElementDefinition() {
			return getRuleContext(SetElementDefinitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode QUANTIFIER() { return getToken(GdslParser.QUANTIFIER, 0); }
		public SetQuantificationCallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetQuantificationCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetQuantificationCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetQuantificationCallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(142);
				match(T__0);
				setState(143);
				expression(0);
				setState(144);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new AbsoluteExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(T__7);
				setState(147);
				expression(0);
				setState(148);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new SetQuantificationCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				((SetQuantificationCallExpContext)_localctx).quantifier = match(QUANTIFIER);
				setState(151);
				match(T__0);
				setState(152);
				setElementDefinition();
				setState(153);
				match(T__1);
				setState(154);
				expression(0);
				setState(155);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new SetChooseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				match(CHOOSE);
				setState(158);
				expression(14);
				}
				break;
			case 5:
				{
				_localctx = new SetComprehensionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__8);
				setState(160);
				setElementDefinition();
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(161);
					match(T__7);
					setState(162);
					expression(0);
					}
					break;
				}
				setState(165);
				match(T__7);
				setState(166);
				expression(0);
				setState(167);
				match(T__9);
				}
				break;
			case 6:
				{
				_localctx = new SetLiteralExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__8);
				setState(170);
				expression(0);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(171);
					match(T__1);
					setState(172);
					expression(0);
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				match(T__9);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(IDENTIFIER);
				setState(181);
				match(T__0);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << QUANTIFIER) | (1L << CHOOSE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(182);
					expression(0);
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(183);
						match(T__1);
						setState(184);
						expression(0);
						}
						}
						setState(189);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(192);
				match(T__2);
				}
				break;
			case 8:
				{
				_localctx = new VariableExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				((BoolExpContext)_localctx).bool = match(BOOL);
				}
				break;
			case 10:
				{
				_localctx = new NumberExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(222);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new SetOperatorExpContext(new ExpressionContext(_parentctx, _parentState));
						((SetOperatorExpContext)_localctx).setL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(199);
						((SetOperatorExpContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << DIFFERENCE) | (1L << INTERSECTION))) != 0)) ) {
							((SetOperatorExpContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(200);
						((SetOperatorExpContext)_localctx).setR = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(202);
						match(POWER);
						setState(203);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new DivMulExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(205);
						((DivMulExpContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIVISION || _la==MULTIPLICATION) ) {
							((DivMulExpContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(206);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(208);
						((AddSubExpContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubExpContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(209);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(211);
						((ComparisonExpContext)_localctx).operator = match(COMPARISON);
						setState(212);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new AndExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(214);
						match(AND);
						setState(215);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new OrExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(217);
						match(OR);
						setState(218);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new DotExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(220);
						match(T__10);
						setState(221);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VariablesContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GdslParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GdslParser.IDENTIFIER, i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(IDENTIFIER);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(228);
				match(T__10);
				setState(229);
				match(IDENTIFIER);
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n\2"+
		"\f\2\16\2\'\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\5\4A\n\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\6\5\6S\n\6"+
		"\3\7\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\7\nf\n\n\f\n\16\ni\13\n\3\n\3\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\7\13{\n\13\f\13\16\13~\13\13\3\13\5\13\u0081"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a6\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u00b0\n\17\f\17\16\17\u00b3\13\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00bc\n\17\f\17\16\17\u00bf\13\17\5\17\u00c1"+
		"\n\17\3\17\3\17\3\17\3\17\5\17\u00c7\n\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00e1\n\17\f\17\16\17\u00e4\13\17\3\20\3\20"+
		"\3\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20\3\20\2\3\34\21\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36\2\5\3\2\35\37\3\2\30\31\3\2\22\23\2\u0103"+
		"\2%\3\2\2\2\4(\3\2\2\2\6\65\3\2\2\2\bE\3\2\2\2\nR\3\2\2\2\fX\3\2\2\2\16"+
		"Z\3\2\2\2\20^\3\2\2\2\22a\3\2\2\2\24t\3\2\2\2\26\u0082\3\2\2\2\30\u0088"+
		"\3\2\2\2\32\u008b\3\2\2\2\34\u00c6\3\2\2\2\36\u00e5\3\2\2\2 $\5\4\3\2"+
		"!$\5\6\4\2\"$\5\16\b\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2"+
		"\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2()\7\21\2\2)*\7$\2\2*+\7\3\2\2+\60"+
		"\5\b\5\2,-\7\4\2\2-/\5\b\5\2.,\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3"+
		"\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7\5\2\2\64\5\3\2\2\2\65\66\7"+
		"$\2\2\66\67\7$\2\2\67@\7\3\2\28=\5\b\5\29:\7\4\2\2:<\5\b\5\2;9\3\2\2\2"+
		"<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3\2\2\2@8\3\2\2\2@A\3\2\2\2"+
		"AB\3\2\2\2BC\7\5\2\2CD\5\n\6\2D\7\3\2\2\2EF\7$\2\2FG\7\6\2\2GH\7$\2\2"+
		"H\t\3\2\2\2IS\5\f\7\2JN\7\3\2\2KM\5\f\7\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2"+
		"\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QS\7\5\2\2RI\3\2\2\2RJ\3\2\2\2S\13\3\2"+
		"\2\2TY\5\24\13\2UY\5\22\n\2VY\5\16\b\2WY\5\20\t\2XT\3\2\2\2XU\3\2\2\2"+
		"XV\3\2\2\2XW\3\2\2\2Y\r\3\2\2\2Z[\5\b\5\2[\\\7\34\2\2\\]\5\34\17\2]\17"+
		"\3\2\2\2^_\7\7\2\2_`\5\34\17\2`\21\3\2\2\2ab\7\b\2\2bg\5\36\20\2cd\7\4"+
		"\2\2df\5\36\20\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hq\3\2\2\2ig\3"+
		"\2\2\2jk\7\t\2\2kl\5\34\17\2lm\7\6\2\2mn\5\n\6\2np\3\2\2\2oj\3\2\2\2p"+
		"s\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\23\3\2\2\2sq\3\2\2\2tu\7\16\2\2uv\7\3\2"+
		"\2vw\5\34\17\2wx\7\5\2\2x|\5\n\6\2y{\5\26\f\2zy\3\2\2\2{~\3\2\2\2|z\3"+
		"\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177\u0081\5\30\r\2\u0080\177"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\25\3\2\2\2\u0082\u0083\7\17\2\2\u0083"+
		"\u0084\7\3\2\2\u0084\u0085\5\34\17\2\u0085\u0086\7\5\2\2\u0086\u0087\5"+
		"\n\6\2\u0087\27\3\2\2\2\u0088\u0089\7\20\2\2\u0089\u008a\5\n\6\2\u008a"+
		"\31\3\2\2\2\u008b\u008c\7$\2\2\u008c\u008d\7\"\2\2\u008d\u008e\5\34\17"+
		"\2\u008e\33\3\2\2\2\u008f\u0090\b\17\1\2\u0090\u0091\7\3\2\2\u0091\u0092"+
		"\5\34\17\2\u0092\u0093\7\5\2\2\u0093\u00c7\3\2\2\2\u0094\u0095\7\n\2\2"+
		"\u0095\u0096\5\34\17\2\u0096\u0097\7\n\2\2\u0097\u00c7\3\2\2\2\u0098\u0099"+
		"\7\25\2\2\u0099\u009a\7\3\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7\4\2"+
		"\2\u009c\u009d\5\34\17\2\u009d\u009e\7\5\2\2\u009e\u00c7\3\2\2\2\u009f"+
		"\u00a0\7!\2\2\u00a0\u00c7\5\34\17\20\u00a1\u00a2\7\13\2\2\u00a2\u00a5"+
		"\5\32\16\2\u00a3\u00a4\7\n\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2"+
		"\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9"+
		"\5\34\17\2\u00a9\u00aa\7\f\2\2\u00aa\u00c7\3\2\2\2\u00ab\u00ac\7\13\2"+
		"\2\u00ac\u00b1\5\34\17\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0\5\34\17\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5"+
		"\u00c7\3\2\2\2\u00b6\u00b7\7$\2\2\u00b7\u00c0\7\3\2\2\u00b8\u00bd\5\34"+
		"\17\2\u00b9\u00ba\7\4\2\2\u00ba\u00bc\5\34\17\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c7\7\5\2\2\u00c3\u00c7\7$\2\2\u00c4\u00c7\7\24"+
		"\2\2\u00c5\u00c7\7#\2\2\u00c6\u008f\3\2\2\2\u00c6\u0094\3\2\2\2\u00c6"+
		"\u0098\3\2\2\2\u00c6\u009f\3\2\2\2\u00c6\u00a1\3\2\2\2\u00c6\u00ab\3\2"+
		"\2\2\u00c6\u00b6\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00e2\3\2\2\2\u00c8\u00c9\f\22\2\2\u00c9\u00ca\t"+
		"\2\2\2\u00ca\u00e1\5\34\17\23\u00cb\u00cc\f\17\2\2\u00cc\u00cd\7\27\2"+
		"\2\u00cd\u00e1\5\34\17\20\u00ce\u00cf\f\16\2\2\u00cf\u00d0\t\3\2\2\u00d0"+
		"\u00e1\5\34\17\17\u00d1\u00d2\f\r\2\2\u00d2\u00d3\t\4\2\2\u00d3\u00e1"+
		"\5\34\17\16\u00d4\u00d5\f\f\2\2\u00d5\u00d6\7\26\2\2\u00d6\u00e1\5\34"+
		"\17\r\u00d7\u00d8\f\13\2\2\u00d8\u00d9\7\32\2\2\u00d9\u00e1\5\34\17\f"+
		"\u00da\u00db\f\n\2\2\u00db\u00dc\7\33\2\2\u00dc\u00e1\5\34\17\13\u00dd"+
		"\u00de\f\6\2\2\u00de\u00df\7\r\2\2\u00df\u00e1\7$\2\2\u00e0\u00c8\3\2"+
		"\2\2\u00e0\u00cb\3\2\2\2\u00e0\u00ce\3\2\2\2\u00e0\u00d1\3\2\2\2\u00e0"+
		"\u00d4\3\2\2\2\u00e0\u00d7\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00dd\3\2"+
		"\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\35\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00ea\7$\2\2\u00e6\u00e7\7\r\2\2"+
		"\u00e7\u00e9\7$\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\37\3\2\2\2\u00ec\u00ea\3\2\2\2\26#"+
		"%\60=@NRXgq|\u0080\u00a5\u00b1\u00bd\u00c0\u00c6\u00e0\u00e2\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}