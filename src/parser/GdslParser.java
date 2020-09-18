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
		T__9=10, T__10=11, T__11=12, TYPE=13, BOOL=14, QUANTIFIER=15, EXTRACTOR=16, 
		IF=17, ELSE=18, RETURN=19, COMPARISON=20, ADD=21, SUB=22, DIVISION=23, 
		MULTIPLICATION=24, POWER=25, AND=26, OR=27, NOT=28, ASSIGNMENT=29, UNION=30, 
		DIFFERENCE=31, INTERSECTION=32, IN=33, NUMBER=34, IDENTIFIER=35, WS=36, 
		COMMENTS=37, COMMENTANALYZE=38;
	public static final int
		RULE_gdsl = 0, RULE_typeDefinition = 1, RULE_functionDefinition = 2, RULE_declaration = 3, 
		RULE_scope = 4, RULE_statement = 5, RULE_variableDefinition = 6, RULE_returnStatement = 7, 
		RULE_switchCase = 8, RULE_conditionalIf = 9, RULE_setElementDefinition = 10, 
		RULE_expression = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"gdsl", "typeDefinition", "functionDefinition", "declaration", "scope", 
			"statement", "variableDefinition", "returnStatement", "switchCase", "conditionalIf", 
			"setElementDefinition", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'switch'", "'case'", "'=>'", "'default'", 
			"'|'", "'.'", "'{'", "'}'", "'type'", null, null, null, "'if'", "'else'", 
			"'return'", null, "'+'", "'-'", "'/'", "'*'", null, null, null, null, 
			"':='", "'union'", "'diff'", "'inter'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "TYPE", "BOOL", "QUANTIFIER", "EXTRACTOR", "IF", "ELSE", "RETURN", 
			"COMPARISON", "ADD", "SUB", "DIVISION", "MULTIPLICATION", "POWER", "AND", 
			"OR", "NOT", "ASSIGNMENT", "UNION", "DIFFERENCE", "INTERSECTION", "IN", 
			"NUMBER", "IDENTIFIER", "WS", "COMMENTS", "COMMENTANALYZE"
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==IDENTIFIER) {
				{
				setState(27);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(24);
					typeDefinition();
					}
					break;
				case 2:
					{
					setState(25);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(26);
					variableDefinition();
					}
					break;
				}
				}
				setState(31);
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
			setState(32);
			match(TYPE);
			setState(33);
			((TypeDefinitionContext)_localctx).id = match(IDENTIFIER);
			setState(34);
			match(T__0);
			setState(35);
			declaration();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(36);
				match(T__1);
				setState(37);
				declaration();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
			setState(45);
			((FunctionDefinitionContext)_localctx).retType = match(IDENTIFIER);
			setState(46);
			((FunctionDefinitionContext)_localctx).functionId = match(IDENTIFIER);
			setState(47);
			match(T__0);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(48);
				declaration();
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(49);
					match(T__1);
					setState(50);
					declaration();
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(58);
			match(T__2);
			setState(59);
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
			setState(61);
			((DeclarationContext)_localctx).id = match(IDENTIFIER);
			setState(62);
			match(T__3);
			setState(63);
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case IF:
			case RETURN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << IF) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(67);
					statement();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
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
		public ConditionalIfContext conditionalIf() {
			return getRuleContext(ConditionalIfContext.class,0);
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
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				conditionalIf();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				switchCase();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				variableDefinition();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
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
			setState(82);
			declaration();
			setState(83);
			match(ASSIGNMENT);
			setState(84);
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
		public TerminalNode RETURN() { return getToken(GdslParser.RETURN, 0); }
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
			setState(86);
			match(RETURN);
			setState(87);
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
		public ScopeContext defaultscope;
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
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__4);
			setState(90);
			match(T__0);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(91);
				match(T__5);
				setState(92);
				expression(0);
				setState(93);
				match(T__6);
				setState(94);
				scope();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(101);
				match(T__7);
				setState(102);
				match(T__6);
				setState(103);
				((SwitchCaseContext)_localctx).defaultscope = scope();
				}
			}

			setState(106);
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

	public static class ConditionalIfContext extends ParserRuleContext {
		public ConditionalIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalIf; }
	 
		public ConditionalIfContext() { }
		public void copyFrom(ConditionalIfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElseStatementContext extends ConditionalIfContext {
		public ExpressionContext condition;
		public ScopeContext trueBranch;
		public ConditionalIfContext elseIfStatement;
		public ScopeContext falseBranch;
		public TerminalNode IF() { return getToken(GdslParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(GdslParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ScopeContext> scope() {
			return getRuleContexts(ScopeContext.class);
		}
		public ScopeContext scope(int i) {
			return getRuleContext(ScopeContext.class,i);
		}
		public ConditionalIfContext conditionalIf() {
			return getRuleContext(ConditionalIfContext.class,0);
		}
		public IfElseStatementContext(ConditionalIfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends ConditionalIfContext {
		public ExpressionContext condition;
		public ScopeContext trueBranch;
		public TerminalNode IF() { return getToken(GdslParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IfStatementContext(ConditionalIfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalIfContext conditionalIf() throws RecognitionException {
		ConditionalIfContext _localctx = new ConditionalIfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conditionalIf);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(IF);
				setState(109);
				match(T__0);
				setState(110);
				((IfStatementContext)_localctx).condition = expression(0);
				setState(111);
				match(T__2);
				setState(112);
				((IfStatementContext)_localctx).trueBranch = scope();
				}
				break;
			case 2:
				_localctx = new IfElseStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(IF);
				setState(115);
				match(T__0);
				setState(116);
				((IfElseStatementContext)_localctx).condition = expression(0);
				setState(117);
				match(T__2);
				setState(118);
				((IfElseStatementContext)_localctx).trueBranch = scope();
				setState(119);
				match(ELSE);
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(120);
					((IfElseStatementContext)_localctx).elseIfStatement = conditionalIf();
					}
					break;
				}
				setState(123);
				((IfElseStatementContext)_localctx).falseBranch = scope();
				}
				break;
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
		enterRule(_localctx, 20, RULE_setElementDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((SetElementDefinitionContext)_localctx).localName = match(IDENTIFIER);
			setState(128);
			match(IN);
			setState(129);
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
	public static class SetExtractionExpContext extends ExpressionContext {
		public Token extractor;
		public SetElementDefinitionContext setElementDefinition() {
			return getRuleContext(SetElementDefinitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EXTRACTOR() { return getToken(GdslParser.EXTRACTOR, 0); }
		public SetExtractionExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetExtractionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetExtractionExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetExtractionExp(this);
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
	public static class NotExpContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(GdslParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterNotExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitNotExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitNotExp(this);
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
	public static class SetQuantificationExpContext extends ExpressionContext {
		public Token quantifier;
		public SetElementDefinitionContext setElementDefinition() {
			return getRuleContext(SetElementDefinitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode QUANTIFIER() { return getToken(GdslParser.QUANTIFIER, 0); }
		public SetQuantificationExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).enterSetQuantificationExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GdslListener ) ((GdslListener)listener).exitSetQuantificationExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GdslVisitor ) return ((GdslVisitor<? extends T>)visitor).visitSetQuantificationExp(this);
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(132);
				match(T__0);
				setState(133);
				expression(0);
				setState(134);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new AbsoluteExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__8);
				setState(137);
				expression(0);
				setState(138);
				match(T__8);
				}
				break;
			case 3:
				{
				_localctx = new NotExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(NOT);
				setState(141);
				expression(16);
				}
				break;
			case 4:
				{
				_localctx = new SetQuantificationExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				((SetQuantificationExpContext)_localctx).quantifier = match(QUANTIFIER);
				setState(143);
				match(T__0);
				setState(144);
				setElementDefinition();
				setState(145);
				match(T__1);
				setState(146);
				expression(0);
				setState(147);
				match(T__2);
				}
				break;
			case 5:
				{
				_localctx = new SetExtractionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				((SetExtractionExpContext)_localctx).extractor = match(EXTRACTOR);
				setState(150);
				match(T__0);
				setState(151);
				setElementDefinition();
				setState(152);
				match(T__1);
				setState(153);
				expression(0);
				setState(154);
				match(T__2);
				}
				break;
			case 6:
				{
				_localctx = new SetComprehensionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(T__10);
				setState(157);
				setElementDefinition();
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(158);
					match(T__8);
					setState(159);
					expression(0);
					}
					break;
				}
				setState(162);
				match(T__8);
				setState(163);
				expression(0);
				setState(164);
				match(T__11);
				}
				break;
			case 7:
				{
				_localctx = new SetLiteralExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(T__10);
				setState(167);
				expression(0);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(168);
					match(T__1);
					setState(169);
					expression(0);
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__11);
				}
				break;
			case 8:
				{
				_localctx = new FunctionCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(IDENTIFIER);
				setState(178);
				match(T__0);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__10) | (1L << BOOL) | (1L << QUANTIFIER) | (1L << EXTRACTOR) | (1L << NOT) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(179);
					expression(0);
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(180);
						match(T__1);
						setState(181);
						expression(0);
						}
						}
						setState(186);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(189);
				match(T__2);
				}
				break;
			case 9:
				{
				_localctx = new VariableExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(IDENTIFIER);
				}
				break;
			case 10:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				((BoolExpContext)_localctx).bool = match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new NumberExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new SetOperatorExpContext(new ExpressionContext(_parentctx, _parentState));
						((SetOperatorExpContext)_localctx).setL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(196);
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
						setState(197);
						((SetOperatorExpContext)_localctx).setR = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(199);
						match(POWER);
						setState(200);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new DivMulExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(202);
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
						setState(203);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(205);
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
						setState(206);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(208);
						((ComparisonExpContext)_localctx).operator = match(COMPARISON);
						setState(209);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new AndExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(211);
						match(AND);
						setState(212);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new OrExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(214);
						match(OR);
						setState(215);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new DotExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(217);
						match(T__9);
						setState(218);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(223);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00e3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\66\n\4\f\4\16\49\13\4\5\4;\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\7\6G\n\6\f\6\16\6J\13\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\5\7S\n\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nc\n\n\f\n\16\n"+
		"f\13\n\3\n\3\n\3\n\5\nk\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13|\n\13\3\13\3\13\5\13\u0080\n\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a3"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ad\n\r\f\r\16\r\u00b0\13\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b9\n\r\f\r\16\r\u00bc\13\r\5\r\u00be"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00de"+
		"\n\r\f\r\16\r\u00e1\13\r\3\r\2\3\30\16\2\4\6\b\n\f\16\20\22\24\26\30\2"+
		"\5\3\2 \"\3\2\31\32\3\2\27\30\2\u00fb\2\37\3\2\2\2\4\"\3\2\2\2\6/\3\2"+
		"\2\2\b?\3\2\2\2\nL\3\2\2\2\fR\3\2\2\2\16T\3\2\2\2\20X\3\2\2\2\22[\3\2"+
		"\2\2\24\177\3\2\2\2\26\u0081\3\2\2\2\30\u00c3\3\2\2\2\32\36\5\4\3\2\33"+
		"\36\5\6\4\2\34\36\5\16\b\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36"+
		"!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"#\7\17\2\2"+
		"#$\7%\2\2$%\7\3\2\2%*\5\b\5\2&\'\7\4\2\2\')\5\b\5\2(&\3\2\2\2),\3\2\2"+
		"\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\5\2\2.\5\3\2\2\2/\60\7"+
		"%\2\2\60\61\7%\2\2\61:\7\3\2\2\62\67\5\b\5\2\63\64\7\4\2\2\64\66\5\b\5"+
		"\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3"+
		"\2\2\2:\62\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\5\2\2=>\5\n\6\2>\7\3\2\2\2"+
		"?@\7%\2\2@A\7\6\2\2AB\7%\2\2B\t\3\2\2\2CM\5\f\7\2DH\7\3\2\2EG\5\f\7\2"+
		"FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KM\7\5\2\2"+
		"LC\3\2\2\2LD\3\2\2\2M\13\3\2\2\2NS\5\24\13\2OS\5\22\n\2PS\5\16\b\2QS\5"+
		"\20\t\2RN\3\2\2\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\r\3\2\2\2TU\5\b\5\2U"+
		"V\7\37\2\2VW\5\30\r\2W\17\3\2\2\2XY\7\25\2\2YZ\5\30\r\2Z\21\3\2\2\2[\\"+
		"\7\7\2\2\\d\7\3\2\2]^\7\b\2\2^_\5\30\r\2_`\7\t\2\2`a\5\n\6\2ac\3\2\2\2"+
		"b]\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2ej\3\2\2\2fd\3\2\2\2gh\7\n\2\2"+
		"hi\7\t\2\2ik\5\n\6\2jg\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\5\2\2m\23\3\2\2"+
		"\2no\7\23\2\2op\7\3\2\2pq\5\30\r\2qr\7\5\2\2rs\5\n\6\2s\u0080\3\2\2\2"+
		"tu\7\23\2\2uv\7\3\2\2vw\5\30\r\2wx\7\5\2\2xy\5\n\6\2y{\7\24\2\2z|\5\24"+
		"\13\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5\n\6\2~\u0080\3\2\2\2\177n\3\2"+
		"\2\2\177t\3\2\2\2\u0080\25\3\2\2\2\u0081\u0082\7%\2\2\u0082\u0083\7#\2"+
		"\2\u0083\u0084\5\30\r\2\u0084\27\3\2\2\2\u0085\u0086\b\r\1\2\u0086\u0087"+
		"\7\3\2\2\u0087\u0088\5\30\r\2\u0088\u0089\7\5\2\2\u0089\u00c4\3\2\2\2"+
		"\u008a\u008b\7\13\2\2\u008b\u008c\5\30\r\2\u008c\u008d\7\13\2\2\u008d"+
		"\u00c4\3\2\2\2\u008e\u008f\7\36\2\2\u008f\u00c4\5\30\r\22\u0090\u0091"+
		"\7\21\2\2\u0091\u0092\7\3\2\2\u0092\u0093\5\26\f\2\u0093\u0094\7\4\2\2"+
		"\u0094\u0095\5\30\r\2\u0095\u0096\7\5\2\2\u0096\u00c4\3\2\2\2\u0097\u0098"+
		"\7\22\2\2\u0098\u0099\7\3\2\2\u0099\u009a\5\26\f\2\u009a\u009b\7\4\2\2"+
		"\u009b\u009c\5\30\r\2\u009c\u009d\7\5\2\2\u009d\u00c4\3\2\2\2\u009e\u009f"+
		"\7\r\2\2\u009f\u00a2\5\26\f\2\u00a0\u00a1\7\13\2\2\u00a1\u00a3\5\30\r"+
		"\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\7\13\2\2\u00a5\u00a6\5\30\r\2\u00a6\u00a7\7\16\2\2\u00a7\u00c4\3\2\2"+
		"\2\u00a8\u00a9\7\r\2\2\u00a9\u00ae\5\30\r\2\u00aa\u00ab\7\4\2\2\u00ab"+
		"\u00ad\5\30\r\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7\16\2\2\u00b2\u00c4\3\2\2\2\u00b3\u00b4\7%\2\2\u00b4\u00bd\7\3"+
		"\2\2\u00b5\u00ba\5\30\r\2\u00b6\u00b7\7\4\2\2\u00b7\u00b9\5\30\r\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c4\7\5\2\2\u00c0\u00c4\7%"+
		"\2\2\u00c1\u00c4\7\20\2\2\u00c2\u00c4\7$\2\2\u00c3\u0085\3\2\2\2\u00c3"+
		"\u008a\3\2\2\2\u00c3\u008e\3\2\2\2\u00c3\u0090\3\2\2\2\u00c3\u0097\3\2"+
		"\2\2\u00c3\u009e\3\2\2\2\u00c3\u00a8\3\2\2\2\u00c3\u00b3\3\2\2\2\u00c3"+
		"\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00df\3\2"+
		"\2\2\u00c5\u00c6\f\21\2\2\u00c6\u00c7\t\2\2\2\u00c7\u00de\5\30\r\22\u00c8"+
		"\u00c9\f\16\2\2\u00c9\u00ca\7\33\2\2\u00ca\u00de\5\30\r\17\u00cb\u00cc"+
		"\f\r\2\2\u00cc\u00cd\t\3\2\2\u00cd\u00de\5\30\r\16\u00ce\u00cf\f\f\2\2"+
		"\u00cf\u00d0\t\4\2\2\u00d0\u00de\5\30\r\r\u00d1\u00d2\f\13\2\2\u00d2\u00d3"+
		"\7\26\2\2\u00d3\u00de\5\30\r\f\u00d4\u00d5\f\n\2\2\u00d5\u00d6\7\34\2"+
		"\2\u00d6\u00de\5\30\r\13\u00d7\u00d8\f\t\2\2\u00d8\u00d9\7\35\2\2\u00d9"+
		"\u00de\5\30\r\n\u00da\u00db\f\23\2\2\u00db\u00dc\7\f\2\2\u00dc\u00de\7"+
		"%\2\2\u00dd\u00c5\3\2\2\2\u00dd\u00c8\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd"+
		"\u00ce\3\2\2\2\u00dd\u00d1\3\2\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00d7\3\2"+
		"\2\2\u00dd\u00da\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\31\3\2\2\2\u00e1\u00df\3\2\2\2\25\35\37*\67:HLRd"+
		"j{\177\u00a2\u00ae\u00ba\u00bd\u00c3\u00dd\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}