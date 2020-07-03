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
		RULE_gdsl = 0, RULE_typeDefinition = 1, RULE_functionDefinition = 2, RULE_functionDeclaration = 3, 
		RULE_declaration = 4, RULE_scope = 5, RULE_statement = 6, RULE_variableDefinition = 7, 
		RULE_returnStatement = 8, RULE_switchCase = 9, RULE_iif = 10, RULE_iifElset = 11, 
		RULE_elset = 12, RULE_setElementDefinition = 13, RULE_expression = 14, 
		RULE_variables = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"gdsl", "typeDefinition", "functionDefinition", "functionDeclaration", 
			"declaration", "scope", "statement", "variableDefinition", "returnStatement", 
			"switchCase", "iif", "iifElset", "elset", "setElementDefinition", "expression", 
			"variables"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==IDENTIFIER) {
				{
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					typeDefinition();
					}
					break;
				case 2:
					{
					setState(33);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(34);
					variableDefinition();
					}
					break;
				}
				}
				setState(39);
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
			setState(40);
			match(TYPE);
			setState(41);
			((TypeDefinitionContext)_localctx).id = match(IDENTIFIER);
			setState(42);
			match(T__0);
			setState(43);
			declaration();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(44);
				match(T__1);
				setState(45);
				declaration();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			functionDeclaration();
			setState(54);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public Token retType;
		public Token functionId;
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
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((FunctionDeclarationContext)_localctx).retType = match(IDENTIFIER);
			setState(57);
			((FunctionDeclarationContext)_localctx).functionId = match(IDENTIFIER);
			setState(58);
			match(T__0);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(59);
				declaration();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(60);
					match(T__1);
					setState(61);
					declaration();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(69);
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
		enterRule(_localctx, 8, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((DeclarationContext)_localctx).id = match(IDENTIFIER);
			setState(72);
			match(T__3);
			setState(73);
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
		enterRule(_localctx, 10, RULE_scope);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case IFT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__0);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << IFT) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(77);
					statement();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
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
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IFT:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				iif();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				switchCase();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				variableDefinition();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
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
		enterRule(_localctx, 14, RULE_variableDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			declaration();
			setState(93);
			match(ASSIGNMENT);
			setState(94);
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
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
			setState(97);
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
		enterRule(_localctx, 18, RULE_switchCase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__5);
			{
			setState(100);
			variables();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(101);
				match(T__1);
				setState(102);
				variables();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(108);
					match(T__6);
					setState(109);
					expression(0);
					setState(110);
					match(T__3);
					setState(111);
					scope();
					}
					} 
				}
				setState(117);
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
		enterRule(_localctx, 20, RULE_iif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IFT);
			setState(119);
			match(T__0);
			setState(120);
			expression(0);
			setState(121);
			match(T__2);
			setState(122);
			scope();
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					iifElset();
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(129);
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
		enterRule(_localctx, 22, RULE_iifElset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(132);
			match(IFELSET);
			setState(133);
			match(T__0);
			setState(134);
			expression(0);
			setState(135);
			match(T__2);
			setState(136);
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
		enterRule(_localctx, 24, RULE_elset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ELSET);
			setState(139);
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
		enterRule(_localctx, 26, RULE_setElementDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((SetElementDefinitionContext)_localctx).localName = match(IDENTIFIER);
			setState(142);
			match(IN);
			setState(143);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(GdslParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GdslParser.IDENTIFIER, i);
		}
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(146);
				match(T__0);
				setState(147);
				expression(0);
				setState(148);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new AbsoluteExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(T__7);
				setState(151);
				expression(0);
				setState(152);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new SetQuantificationCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				((SetQuantificationCallExpContext)_localctx).quantifier = match(QUANTIFIER);
				setState(155);
				match(T__0);
				setState(156);
				setElementDefinition();
				setState(157);
				match(T__1);
				setState(158);
				expression(0);
				setState(159);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new SetChooseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(CHOOSE);
				setState(162);
				expression(14);
				}
				break;
			case 5:
				{
				_localctx = new SetComprehensionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(T__8);
				setState(164);
				setElementDefinition();
				setState(166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(165);
					match(T__7);
					}
					break;
				}
				setState(168);
				match(T__7);
				setState(169);
				expression(0);
				setState(170);
				match(T__9);
				}
				break;
			case 6:
				{
				_localctx = new SetLiteralExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(T__8);
				setState(173);
				expression(0);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(174);
					match(T__1);
					setState(175);
					expression(0);
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
				match(T__9);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(IDENTIFIER);
				setState(184);
				match(T__0);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << QUANTIFIER) | (1L << CHOOSE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(185);
					expression(0);
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(186);
						match(T__1);
						setState(187);
						expression(0);
						}
						}
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(195);
				match(T__2);
				}
				break;
			case 8:
				{
				_localctx = new VariableExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(BOOL);
				}
				break;
			case 10:
				{
				_localctx = new NumberExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new SetOperatorExpContext(new ExpressionContext(_parentctx, _parentState));
						((SetOperatorExpContext)_localctx).setL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(202);
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
						setState(203);
						((SetOperatorExpContext)_localctx).setR = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(205);
						match(POWER);
						setState(206);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new DivMulExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(208);
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
						setState(209);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(211);
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
						setState(212);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(214);
						((ComparisonExpContext)_localctx).operator = match(COMPARISON);
						setState(215);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new AndExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(217);
						match(AND);
						setState(218);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new OrExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(220);
						match(OR);
						setState(221);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new DotExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(225); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(223);
								match(T__10);
								setState(224);
								match(IDENTIFIER);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(227); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 30, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(IDENTIFIER);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(235);
				match(T__10);
				setState(236);
				match(IDENTIFIER);
				}
				}
				setState(241);
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
		case 14:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\61\n\3\f\3\16\3"+
		"\64\13\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5A\n\5\f\5\16\5"+
		"D\13\5\5\5F\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7Q\n\7\f\7\16\7"+
		"T\13\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13j\n\13\f\13\16\13m\13\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13t\n\13\f\13\16\13w\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\177\n\f"+
		"\f\f\16\f\u0082\13\f\3\f\5\f\u0085\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a9"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00b3\n\20\f\20\16"+
		"\20\u00b6\13\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00bf\n\20\f\20"+
		"\16\20\u00c2\13\20\5\20\u00c4\n\20\3\20\3\20\3\20\3\20\5\20\u00ca\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00e4\n\20\r\20"+
		"\16\20\u00e5\7\20\u00e8\n\20\f\20\16\20\u00eb\13\20\3\21\3\21\3\21\7\21"+
		"\u00f0\n\21\f\21\16\21\u00f3\13\21\3\21\2\3\36\22\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \2\5\3\2\35\37\3\2\30\31\3\2\22\23\2\u010a\2\'\3\2"+
		"\2\2\4*\3\2\2\2\6\67\3\2\2\2\b:\3\2\2\2\nI\3\2\2\2\fV\3\2\2\2\16\\\3\2"+
		"\2\2\20^\3\2\2\2\22b\3\2\2\2\24e\3\2\2\2\26x\3\2\2\2\30\u0086\3\2\2\2"+
		"\32\u008c\3\2\2\2\34\u008f\3\2\2\2\36\u00c9\3\2\2\2 \u00ec\3\2\2\2\"&"+
		"\5\4\3\2#&\5\6\4\2$&\5\20\t\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&)\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\7\21\2\2+,\7$\2\2,-\7\3"+
		"\2\2-\62\5\n\6\2./\7\4\2\2/\61\5\n\6\2\60.\3\2\2\2\61\64\3\2\2\2\62\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\5\2\2\66\5"+
		"\3\2\2\2\678\5\b\5\289\5\f\7\29\7\3\2\2\2:;\7$\2\2;<\7$\2\2<E\7\3\2\2"+
		"=B\5\n\6\2>?\7\4\2\2?A\5\n\6\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"CF\3\2\2\2DB\3\2\2\2E=\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\5\2\2H\t\3\2\2"+
		"\2IJ\7$\2\2JK\7\6\2\2KL\7$\2\2L\13\3\2\2\2MW\5\16\b\2NR\7\3\2\2OQ\5\16"+
		"\b\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UW\7\5"+
		"\2\2VM\3\2\2\2VN\3\2\2\2W\r\3\2\2\2X]\5\26\f\2Y]\5\24\13\2Z]\5\20\t\2"+
		"[]\5\22\n\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2\2^_"+
		"\5\n\6\2_`\7\34\2\2`a\5\36\20\2a\21\3\2\2\2bc\7\7\2\2cd\5\36\20\2d\23"+
		"\3\2\2\2ef\7\b\2\2fk\5 \21\2gh\7\4\2\2hj\5 \21\2ig\3\2\2\2jm\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2lu\3\2\2\2mk\3\2\2\2no\7\t\2\2op\5\36\20\2pq\7\6\2"+
		"\2qr\5\f\7\2rt\3\2\2\2sn\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\25\3\2"+
		"\2\2wu\3\2\2\2xy\7\16\2\2yz\7\3\2\2z{\5\36\20\2{|\7\5\2\2|\u0080\5\f\7"+
		"\2}\177\5\30\r\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\5\32\16\2"+
		"\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\27\3\2\2\2\u0086\u0087"+
		"\7\17\2\2\u0087\u0088\7\3\2\2\u0088\u0089\5\36\20\2\u0089\u008a\7\5\2"+
		"\2\u008a\u008b\5\f\7\2\u008b\31\3\2\2\2\u008c\u008d\7\20\2\2\u008d\u008e"+
		"\5\f\7\2\u008e\33\3\2\2\2\u008f\u0090\7$\2\2\u0090\u0091\7\"\2\2\u0091"+
		"\u0092\5\36\20\2\u0092\35\3\2\2\2\u0093\u0094\b\20\1\2\u0094\u0095\7\3"+
		"\2\2\u0095\u0096\5\36\20\2\u0096\u0097\7\5\2\2\u0097\u00ca\3\2\2\2\u0098"+
		"\u0099\7\n\2\2\u0099\u009a\5\36\20\2\u009a\u009b\7\n\2\2\u009b\u00ca\3"+
		"\2\2\2\u009c\u009d\7\25\2\2\u009d\u009e\7\3\2\2\u009e\u009f\5\34\17\2"+
		"\u009f\u00a0\7\4\2\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\7\5\2\2\u00a2\u00ca"+
		"\3\2\2\2\u00a3\u00a4\7!\2\2\u00a4\u00ca\5\36\20\20\u00a5\u00a6\7\13\2"+
		"\2\u00a6\u00a8\5\34\17\2\u00a7\u00a9\7\n\2\2\u00a8\u00a7\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7\n\2\2\u00ab\u00ac\5\36"+
		"\20\2\u00ac\u00ad\7\f\2\2\u00ad\u00ca\3\2\2\2\u00ae\u00af\7\13\2\2\u00af"+
		"\u00b4\5\36\20\2\u00b0\u00b1\7\4\2\2\u00b1\u00b3\5\36\20\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\f\2\2\u00b8\u00ca\3\2"+
		"\2\2\u00b9\u00ba\7$\2\2\u00ba\u00c3\7\3\2\2\u00bb\u00c0\5\36\20\2\u00bc"+
		"\u00bd\7\4\2\2\u00bd\u00bf\5\36\20\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00ca\7\5\2\2\u00c6\u00ca\7$\2\2\u00c7\u00ca\7\24\2\2\u00c8"+
		"\u00ca\7#\2\2\u00c9\u0093\3\2\2\2\u00c9\u0098\3\2\2\2\u00c9\u009c\3\2"+
		"\2\2\u00c9\u00a3\3\2\2\2\u00c9\u00a5\3\2\2\2\u00c9\u00ae\3\2\2\2\u00c9"+
		"\u00b9\3\2\2\2\u00c9\u00c6\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2"+
		"\2\2\u00ca\u00e9\3\2\2\2\u00cb\u00cc\f\22\2\2\u00cc\u00cd\t\2\2\2\u00cd"+
		"\u00e8\5\36\20\23\u00ce\u00cf\f\17\2\2\u00cf\u00d0\7\27\2\2\u00d0\u00e8"+
		"\5\36\20\20\u00d1\u00d2\f\16\2\2\u00d2\u00d3\t\3\2\2\u00d3\u00e8\5\36"+
		"\20\17\u00d4\u00d5\f\r\2\2\u00d5\u00d6\t\4\2\2\u00d6\u00e8\5\36\20\16"+
		"\u00d7\u00d8\f\f\2\2\u00d8\u00d9\7\26\2\2\u00d9\u00e8\5\36\20\r\u00da"+
		"\u00db\f\13\2\2\u00db\u00dc\7\32\2\2\u00dc\u00e8\5\36\20\f\u00dd\u00de"+
		"\f\n\2\2\u00de\u00df\7\33\2\2\u00df\u00e8\5\36\20\13\u00e0\u00e3\f\6\2"+
		"\2\u00e1\u00e2\7\r\2\2\u00e2\u00e4\7$\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00cb\3\2\2\2\u00e7\u00ce\3\2\2\2\u00e7\u00d1\3\2\2\2\u00e7\u00d4\3\2"+
		"\2\2\u00e7\u00d7\3\2\2\2\u00e7\u00da\3\2\2\2\u00e7\u00dd\3\2\2\2\u00e7"+
		"\u00e0\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f1\7$\2\2\u00ed\u00ee"+
		"\7\r\2\2\u00ee\u00f0\7$\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2!\3\2\2\2\u00f3\u00f1\3\2\2\2"+
		"\27%\'\62BERV\\ku\u0080\u0084\u00a8\u00b4\u00c0\u00c3\u00c9\u00e5\u00e7"+
		"\u00e9\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}