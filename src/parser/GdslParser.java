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
		T__9=10, T__10=11, TYPE=12, BOOL=13, QUANTIFIER=14, IF=15, ELSE=16, COMPARISON=17, 
		ADD=18, SUB=19, DIVISION=20, MULTIPLICATION=21, POWER=22, AND=23, OR=24, 
		ASSIGNMENT=25, UNION=26, DIFFERENCE=27, INTERSECTION=28, FILLER=29, CHOOSE=30, 
		IN=31, NUMBER=32, IDENTIFIER=33, WS=34, COMMENTS=35, COMMENTANALYZE=36;
	public static final int
		RULE_gdsl = 0, RULE_typeDefinition = 1, RULE_functionDefinition = 2, RULE_declaration = 3, 
		RULE_scope = 4, RULE_statement = 5, RULE_variableDefinition = 6, RULE_returnStatement = 7, 
		RULE_switchCase = 8, RULE_conditionalIf = 9, RULE_setElementDefinition = 10, 
		RULE_expression = 11, RULE_variables = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"gdsl", "typeDefinition", "functionDefinition", "declaration", "scope", 
			"statement", "variableDefinition", "returnStatement", "switchCase", "conditionalIf", 
			"setElementDefinition", "expression", "variables"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'return'", "'switch'", "'case'", "'|'", 
			"'{'", "'}'", "'.'", "'type'", null, null, "'if'", "'else'", null, "'+'", 
			"'-'", "'/'", "'*'", null, null, null, "':='", "'UNION'", "'DIFF'", "'INTER'", 
			"'FILLER'", "'CHOOSE'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TYPE", "BOOL", "QUANTIFIER", "IF", "ELSE", "COMPARISON", "ADD", "SUB", 
			"DIVISION", "MULTIPLICATION", "POWER", "AND", "OR", "ASSIGNMENT", "UNION", 
			"DIFFERENCE", "INTERSECTION", "FILLER", "CHOOSE", "IN", "NUMBER", "IDENTIFIER", 
			"WS", "COMMENTS", "COMMENTANALYZE"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==IDENTIFIER) {
				{
				setState(29);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(26);
					typeDefinition();
					}
					break;
				case 2:
					{
					setState(27);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(28);
					variableDefinition();
					}
					break;
				}
				}
				setState(33);
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
			setState(34);
			match(TYPE);
			setState(35);
			((TypeDefinitionContext)_localctx).id = match(IDENTIFIER);
			setState(36);
			match(T__0);
			setState(37);
			declaration();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(38);
				match(T__1);
				setState(39);
				declaration();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
			setState(47);
			((FunctionDefinitionContext)_localctx).retType = match(IDENTIFIER);
			setState(48);
			((FunctionDefinitionContext)_localctx).functionId = match(IDENTIFIER);
			setState(49);
			match(T__0);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(50);
				declaration();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(51);
					match(T__1);
					setState(52);
					declaration();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(60);
			match(T__2);
			setState(61);
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
			setState(63);
			((DeclarationContext)_localctx).id = match(IDENTIFIER);
			setState(64);
			match(T__3);
			setState(65);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case IF:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__0);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << IF) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(69);
					statement();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
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
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				conditionalIf();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				switchCase();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				variableDefinition();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
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
			setState(84);
			declaration();
			setState(85);
			match(ASSIGNMENT);
			setState(86);
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
			setState(88);
			match(T__4);
			setState(89);
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
			setState(91);
			match(T__5);
			{
			setState(92);
			variables();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(93);
				match(T__1);
				setState(94);
				variables();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					match(T__6);
					setState(101);
					expression(0);
					setState(102);
					match(T__3);
					setState(103);
					scope();
					}
					} 
				}
				setState(109);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(IF);
				setState(111);
				match(T__0);
				setState(112);
				((IfStatementContext)_localctx).condition = expression(0);
				setState(113);
				match(T__2);
				setState(114);
				((IfStatementContext)_localctx).trueBranch = scope();
				}
				break;
			case 2:
				_localctx = new IfElseStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(IF);
				setState(117);
				match(T__0);
				setState(118);
				((IfElseStatementContext)_localctx).condition = expression(0);
				setState(119);
				match(T__2);
				setState(120);
				((IfElseStatementContext)_localctx).trueBranch = scope();
				setState(121);
				match(ELSE);
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(122);
					((IfElseStatementContext)_localctx).elseIfStatement = conditionalIf();
					}
					break;
				}
				setState(125);
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
			setState(129);
			((SetElementDefinitionContext)_localctx).localName = match(IDENTIFIER);
			setState(130);
			match(IN);
			setState(131);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(T__0);
				setState(135);
				expression(0);
				setState(136);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new AbsoluteExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(T__7);
				setState(139);
				expression(0);
				setState(140);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new SetQuantificationCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				((SetQuantificationCallExpContext)_localctx).quantifier = match(QUANTIFIER);
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
			case 4:
				{
				_localctx = new SetChooseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(CHOOSE);
				setState(150);
				expression(14);
				}
				break;
			case 5:
				{
				_localctx = new SetComprehensionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(T__8);
				setState(152);
				setElementDefinition();
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(153);
					match(T__7);
					setState(154);
					expression(0);
					}
					break;
				}
				setState(157);
				match(T__7);
				setState(158);
				expression(0);
				setState(159);
				match(T__9);
				}
				break;
			case 6:
				{
				_localctx = new SetLiteralExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(T__8);
				setState(162);
				expression(0);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(163);
					match(T__1);
					setState(164);
					expression(0);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(170);
				match(T__9);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(IDENTIFIER);
				setState(173);
				match(T__0);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << QUANTIFIER) | (1L << CHOOSE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(174);
					expression(0);
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(175);
						match(T__1);
						setState(176);
						expression(0);
						}
						}
						setState(181);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(184);
				match(T__2);
				}
				break;
			case 8:
				{
				_localctx = new VariableExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				((BoolExpContext)_localctx).bool = match(BOOL);
				}
				break;
			case 10:
				{
				_localctx = new NumberExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new SetOperatorExpContext(new ExpressionContext(_parentctx, _parentState));
						((SetOperatorExpContext)_localctx).setL = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(190);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(191);
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
						setState(192);
						((SetOperatorExpContext)_localctx).setR = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(193);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(194);
						match(POWER);
						setState(195);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new DivMulExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(197);
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
						setState(198);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(200);
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
						setState(201);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(203);
						((ComparisonExpContext)_localctx).operator = match(COMPARISON);
						setState(204);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new AndExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(206);
						match(AND);
						setState(207);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new OrExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(209);
						match(OR);
						setState(210);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new DotExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(212);
						match(T__10);
						setState(213);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(218);
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
		enterRule(_localctx, 24, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(IDENTIFIER);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(220);
				match(T__10);
				setState(221);
				match(IDENTIFIER);
				}
				}
				setState(226);
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\48\n\4\f\4\16\4;\13\4\5\4=\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\5\6O\n\6\3\7\3\7\3\7\3\7\5\7U\n"+
		"\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nb\n\n\f\n\16\ne\13\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\nl\n\n\f\n\16\no\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13~\n\13\3\13\3\13\5\13\u0082"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009e\n\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u00a8\n\r\f\r\16\r\u00ab\13\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u00b4\n\r\f\r\16\r\u00b7\13\r\5\r\u00b9\n\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00bf\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d9\n\r\f\r\16\r\u00dc"+
		"\13\r\3\16\3\16\3\16\7\16\u00e1\n\16\f\16\16\16\u00e4\13\16\3\16\2\3\30"+
		"\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\5\3\2\34\36\3\2\26\27\3\2\24\25"+
		"\2\u00fd\2!\3\2\2\2\4$\3\2\2\2\6\61\3\2\2\2\bA\3\2\2\2\nN\3\2\2\2\fT\3"+
		"\2\2\2\16V\3\2\2\2\20Z\3\2\2\2\22]\3\2\2\2\24\u0081\3\2\2\2\26\u0083\3"+
		"\2\2\2\30\u00be\3\2\2\2\32\u00dd\3\2\2\2\34 \5\4\3\2\35 \5\6\4\2\36 \5"+
		"\16\b\2\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2"+
		"\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2\2\2$%\7\16\2\2%&\7#\2\2&\'\7\3\2\2\',"+
		"\5\b\5\2()\7\4\2\2)+\5\b\5\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-"+
		"/\3\2\2\2.,\3\2\2\2/\60\7\5\2\2\60\5\3\2\2\2\61\62\7#\2\2\62\63\7#\2\2"+
		"\63<\7\3\2\2\649\5\b\5\2\65\66\7\4\2\2\668\5\b\5\2\67\65\3\2\2\28;\3\2"+
		"\2\29\67\3\2\2\29:\3\2\2\2:=\3\2\2\2;9\3\2\2\2<\64\3\2\2\2<=\3\2\2\2="+
		">\3\2\2\2>?\7\5\2\2?@\5\n\6\2@\7\3\2\2\2AB\7#\2\2BC\7\6\2\2CD\7#\2\2D"+
		"\t\3\2\2\2EO\5\f\7\2FJ\7\3\2\2GI\5\f\7\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2"+
		"JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MO\7\5\2\2NE\3\2\2\2NF\3\2\2\2O\13\3\2\2"+
		"\2PU\5\24\13\2QU\5\22\n\2RU\5\16\b\2SU\5\20\t\2TP\3\2\2\2TQ\3\2\2\2TR"+
		"\3\2\2\2TS\3\2\2\2U\r\3\2\2\2VW\5\b\5\2WX\7\33\2\2XY\5\30\r\2Y\17\3\2"+
		"\2\2Z[\7\7\2\2[\\\5\30\r\2\\\21\3\2\2\2]^\7\b\2\2^c\5\32\16\2_`\7\4\2"+
		"\2`b\5\32\16\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dm\3\2\2\2ec\3\2"+
		"\2\2fg\7\t\2\2gh\5\30\r\2hi\7\6\2\2ij\5\n\6\2jl\3\2\2\2kf\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2n\23\3\2\2\2om\3\2\2\2pq\7\21\2\2qr\7\3\2\2"+
		"rs\5\30\r\2st\7\5\2\2tu\5\n\6\2u\u0082\3\2\2\2vw\7\21\2\2wx\7\3\2\2xy"+
		"\5\30\r\2yz\7\5\2\2z{\5\n\6\2{}\7\22\2\2|~\5\24\13\2}|\3\2\2\2}~\3\2\2"+
		"\2~\177\3\2\2\2\177\u0080\5\n\6\2\u0080\u0082\3\2\2\2\u0081p\3\2\2\2\u0081"+
		"v\3\2\2\2\u0082\25\3\2\2\2\u0083\u0084\7#\2\2\u0084\u0085\7!\2\2\u0085"+
		"\u0086\5\30\r\2\u0086\27\3\2\2\2\u0087\u0088\b\r\1\2\u0088\u0089\7\3\2"+
		"\2\u0089\u008a\5\30\r\2\u008a\u008b\7\5\2\2\u008b\u00bf\3\2\2\2\u008c"+
		"\u008d\7\n\2\2\u008d\u008e\5\30\r\2\u008e\u008f\7\n\2\2\u008f\u00bf\3"+
		"\2\2\2\u0090\u0091\7\20\2\2\u0091\u0092\7\3\2\2\u0092\u0093\5\26\f\2\u0093"+
		"\u0094\7\4\2\2\u0094\u0095\5\30\r\2\u0095\u0096\7\5\2\2\u0096\u00bf\3"+
		"\2\2\2\u0097\u0098\7 \2\2\u0098\u00bf\5\30\r\20\u0099\u009a\7\13\2\2\u009a"+
		"\u009d\5\26\f\2\u009b\u009c\7\n\2\2\u009c\u009e\5\30\r\2\u009d\u009b\3"+
		"\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\n\2\2\u00a0"+
		"\u00a1\5\30\r\2\u00a1\u00a2\7\f\2\2\u00a2\u00bf\3\2\2\2\u00a3\u00a4\7"+
		"\13\2\2\u00a4\u00a9\5\30\r\2\u00a5\u00a6\7\4\2\2\u00a6\u00a8\5\30\r\2"+
		"\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\f\2\2\u00ad"+
		"\u00bf\3\2\2\2\u00ae\u00af\7#\2\2\u00af\u00b8\7\3\2\2\u00b0\u00b5\5\30"+
		"\r\2\u00b1\u00b2\7\4\2\2\u00b2\u00b4\5\30\r\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bf\7\5\2\2\u00bb\u00bf\7#\2\2\u00bc\u00bf\7\17"+
		"\2\2\u00bd\u00bf\7\"\2\2\u00be\u0087\3\2\2\2\u00be\u008c\3\2\2\2\u00be"+
		"\u0090\3\2\2\2\u00be\u0097\3\2\2\2\u00be\u0099\3\2\2\2\u00be\u00a3\3\2"+
		"\2\2\u00be\u00ae\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00da\3\2\2\2\u00c0\u00c1\f\22\2\2\u00c1\u00c2\t"+
		"\2\2\2\u00c2\u00d9\5\30\r\23\u00c3\u00c4\f\17\2\2\u00c4\u00c5\7\30\2\2"+
		"\u00c5\u00d9\5\30\r\20\u00c6\u00c7\f\16\2\2\u00c7\u00c8\t\3\2\2\u00c8"+
		"\u00d9\5\30\r\17\u00c9\u00ca\f\r\2\2\u00ca\u00cb\t\4\2\2\u00cb\u00d9\5"+
		"\30\r\16\u00cc\u00cd\f\f\2\2\u00cd\u00ce\7\23\2\2\u00ce\u00d9\5\30\r\r"+
		"\u00cf\u00d0\f\13\2\2\u00d0\u00d1\7\31\2\2\u00d1\u00d9\5\30\r\f\u00d2"+
		"\u00d3\f\n\2\2\u00d3\u00d4\7\32\2\2\u00d4\u00d9\5\30\r\13\u00d5\u00d6"+
		"\f\6\2\2\u00d6\u00d7\7\r\2\2\u00d7\u00d9\7#\2\2\u00d8\u00c0\3\2\2\2\u00d8"+
		"\u00c3\3\2\2\2\u00d8\u00c6\3\2\2\2\u00d8\u00c9\3\2\2\2\u00d8\u00cc\3\2"+
		"\2\2\u00d8\u00cf\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\31\3\2\2"+
		"\2\u00dc\u00da\3\2\2\2\u00dd\u00e2\7#\2\2\u00de\u00df\7\r\2\2\u00df\u00e1"+
		"\7#\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\33\3\2\2\2\u00e4\u00e2\3\2\2\2\26\37!,9<JNTcm}\u0081"+
		"\u009d\u00a9\u00b5\u00b8\u00be\u00d8\u00da\u00e2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}