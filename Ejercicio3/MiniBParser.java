// Generated from ./MiniBParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniBParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR=1, TO=2, NEXT=3, IF=4, THEN=5, ELSE=6, WHILE=7, DO=8, END=9, PRINT=10, 
		INPUT=11, LET=12, MOD=13, CONTINUE=14, EXIT=15, REPEAT=16, UNTIL=17, VAL=18, 
		LEN=19, ISNAN=20, EQUAL=21, PLUS=22, MINUS=23, MULT=24, DIV=25, LT=26, 
		LTE=27, GT=28, GTE=29, EQ=30, NEQ=31, LPAREN=32, RPAREN=33, COMMA=34, 
		QUOTE=35, AND=36, OR=37, NOT=38, IDENTIFIER=39, NUMBER=40, STRING=41, 
		WS=42, COMMENT=43;
	public static final int
		RULE_programa = 0, RULE_statement = 1, RULE_forStatement = 2, RULE_ifStatement = 3, 
		RULE_whileStatement = 4, RULE_printStatement = 5, RULE_inputStatement = 6, 
		RULE_letStatement = 7, RULE_repeatStatement = 8, RULE_logicalOp = 9, RULE_bloqueControl = 10, 
		RULE_condition = 11, RULE_expression = 12, RULE_term = 13, RULE_factor = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "statement", "forStatement", "ifStatement", "whileStatement", 
			"printStatement", "inputStatement", "letStatement", "repeatStatement", 
			"logicalOp", "bloqueControl", "condition", "expression", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'='", "'+'", "'-'", 
			"'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'('", "')'", 
			"','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR", "TO", "NEXT", "IF", "THEN", "ELSE", "WHILE", "DO", "END", 
			"PRINT", "INPUT", "LET", "MOD", "CONTINUE", "EXIT", "REPEAT", "UNTIL", 
			"VAL", "LEN", "ISNAN", "EQUAL", "PLUS", "MINUS", "MULT", "DIV", "LT", 
			"LTE", "GT", "GTE", "EQ", "NEQ", "LPAREN", "RPAREN", "COMMA", "QUOTE", 
			"AND", "OR", "NOT", "IDENTIFIER", "NUMBER", "STRING", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "MiniBParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549755886738L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				forStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				whileStatement();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				printStatement();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				inputStatement();
				}
				break;
			case LET:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				letStatement();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				repeatStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniBParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(MiniBParser.EQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(MiniBParser.TO, 0); }
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(MiniBParser.NEXT, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(FOR);
			setState(45);
			match(IDENTIFIER);
			setState(46);
			match(EQUAL);
			setState(47);
			expression();
			setState(48);
			match(TO);
			setState(49);
			expression();
			setState(50);
			bloqueControl();
			setState(51);
			match(NEXT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniBParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(MiniBParser.THEN, 0); }
		public List<BloqueControlContext> bloqueControl() {
			return getRuleContexts(BloqueControlContext.class);
		}
		public BloqueControlContext bloqueControl(int i) {
			return getRuleContext(BloqueControlContext.class,i);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public TerminalNode ELSE() { return getToken(MiniBParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(IF);
			setState(54);
			condition();
			setState(55);
			match(THEN);
			setState(56);
			bloqueControl();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(57);
				match(ELSE);
				setState(58);
				bloqueControl();
				}
			}

			setState(61);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniBParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BloqueControlContext bloqueControl() {
			return getRuleContext(BloqueControlContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniBParser.END, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(WHILE);
			setState(64);
			condition();
			setState(65);
			bloqueControl();
			setState(66);
			match(END);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MiniBParser.PRINT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MiniBParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MiniBParser.PLUS, i);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(PRINT);
			setState(69);
			expression();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(70);
				match(PLUS);
				setState(71);
				expression();
				}
				}
				setState(76);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(MiniBParser.INPUT, 0); }
		public TerminalNode STRING() { return getToken(MiniBParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitInputStatement(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(INPUT);
			setState(78);
			match(STRING);
			setState(79);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LetStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(MiniBParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LET() { return getToken(MiniBParser.LET, 0); }
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLetStatement(this);
		}
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(81);
				match(LET);
				}
			}

			setState(84);
			match(IDENTIFIER);
			setState(85);
			match(EQUAL);
			setState(86);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStatementContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(MiniBParser.REPEAT, 0); }
		public TerminalNode UNTIL() { return getToken(MiniBParser.UNTIL, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitRepeatStatement(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeatStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(REPEAT);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				statement();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549755886738L) != 0) );
			setState(94);
			match(UNTIL);
			setState(95);
			condition();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MiniBParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniBParser.OR, 0); }
		public TerminalNode NOT() { return getToken(MiniBParser.NOT, 0); }
		public LogicalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterLogicalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitLogicalOp(this);
		}
	}

	public final LogicalOpContext logicalOp() throws RecognitionException {
		LogicalOpContext _localctx = new LogicalOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logicalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueControlContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiniBParser.CONTINUE, 0); }
		public TerminalNode EXIT() { return getToken(MiniBParser.EXIT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BloqueControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloqueControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterBloqueControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitBloqueControl(this);
		}
	}

	public final BloqueControlContext bloqueControl() throws RecognitionException {
		BloqueControlContext _localctx = new BloqueControlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bloqueControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
			case IF:
			case WHILE:
			case PRINT:
			case INPUT:
			case LET:
			case REPEAT:
			case IDENTIFIER:
				{
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					statement();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 549755886738L) != 0) );
				}
				break;
			case CONTINUE:
				{
				setState(104);
				match(CONTINUE);
				}
				break;
			case EXIT:
				{
				setState(105);
				match(EXIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOpContext logicalOp() {
			return getRuleContext(LogicalOpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode LT() { return getToken(MiniBParser.LT, 0); }
		public TerminalNode LTE() { return getToken(MiniBParser.LTE, 0); }
		public TerminalNode GT() { return getToken(MiniBParser.GT, 0); }
		public TerminalNode GTE() { return getToken(MiniBParser.GTE, 0); }
		public TerminalNode EQ() { return getToken(MiniBParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniBParser.NEQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			expression();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) {
				{
				setState(109);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4227858432L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(110);
				expression();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) {
				{
				setState(113);
				logicalOp();
				setState(114);
				condition();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MiniBParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MiniBParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(MiniBParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(MiniBParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			term();
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(120);
					term();
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(MiniBParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(MiniBParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(MiniBParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(MiniBParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(MiniBParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(MiniBParser.MOD, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			factor();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 50339840L) != 0)) {
				{
				{
				setState(127);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 50339840L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				factor();
				}
				}
				setState(133);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(MiniBParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniBParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MiniBParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniBParser.RPAREN, 0); }
		public TerminalNode STRING() { return getToken(MiniBParser.STRING, 0); }
		public TerminalNode VAL() { return getToken(MiniBParser.VAL, 0); }
		public TerminalNode LEN() { return getToken(MiniBParser.LEN, 0); }
		public TerminalNode ISNAN() { return getToken(MiniBParser.ISNAN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniBParserListener ) ((MiniBParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(LPAREN);
				setState(137);
				expression();
				setState(138);
				match(RPAREN);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				match(STRING);
				}
				break;
			case VAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				match(VAL);
				setState(142);
				match(LPAREN);
				setState(143);
				expression();
				setState(144);
				match(RPAREN);
				}
				break;
			case LEN:
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				match(LEN);
				setState(147);
				match(LPAREN);
				setState(148);
				expression();
				setState(149);
				match(RPAREN);
				}
				break;
			case ISNAN:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				match(ISNAN);
				setState(152);
				match(LPAREN);
				setState(153);
				expression();
				setState(154);
				match(RPAREN);
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

	public static final String _serializedATN =
		"\u0004\u0001+\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0004\u0000"+
		" \b\u0000\u000b\u0000\f\u0000!\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005I\b\u0005\n\u0005"+
		"\f\u0005L\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0003\u0007S\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0004\b[\b\b\u000b\b\f\b\\\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0004\ne\b\n\u000b\n\f\nf\u0001\n\u0001\n\u0003"+
		"\nk\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bp\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bu\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0005\fz\b\f\n\f\f\f}\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u0082\b\r"+
		"\n\r\f\r\u0085\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u009d\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0004\u0001"+
		"\u0000$&\u0001\u0000\u001a\u001f\u0001\u0000\u0016\u0017\u0002\u0000\r"+
		"\r\u0018\u0019\u00a7\u0000\u001f\u0001\u0000\u0000\u0000\u0002*\u0001"+
		"\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000"+
		"\u0000\b?\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000\fM\u0001"+
		"\u0000\u0000\u0000\u000eR\u0001\u0000\u0000\u0000\u0010X\u0001\u0000\u0000"+
		"\u0000\u0012a\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016"+
		"l\u0001\u0000\u0000\u0000\u0018v\u0001\u0000\u0000\u0000\u001a~\u0001"+
		"\u0000\u0000\u0000\u001c\u009c\u0001\u0000\u0000\u0000\u001e \u0003\u0002"+
		"\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0001\u0001"+
		"\u0000\u0000\u0000#+\u0003\u0004\u0002\u0000$+\u0003\u0006\u0003\u0000"+
		"%+\u0003\b\u0004\u0000&+\u0003\n\u0005\u0000\'+\u0003\f\u0006\u0000(+"+
		"\u0003\u000e\u0007\u0000)+\u0003\u0010\b\u0000*#\u0001\u0000\u0000\u0000"+
		"*$\u0001\u0000\u0000\u0000*%\u0001\u0000\u0000\u0000*&\u0001\u0000\u0000"+
		"\u0000*\'\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000"+
		"\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0001\u0000\u0000"+
		"-.\u0005\'\u0000\u0000./\u0005\u0015\u0000\u0000/0\u0003\u0018\f\u0000"+
		"01\u0005\u0002\u0000\u000012\u0003\u0018\f\u000023\u0003\u0014\n\u0000"+
		"34\u0005\u0003\u0000\u00004\u0005\u0001\u0000\u0000\u000056\u0005\u0004"+
		"\u0000\u000067\u0003\u0016\u000b\u000078\u0005\u0005\u0000\u00008;\u0003"+
		"\u0014\n\u00009:\u0005\u0006\u0000\u0000:<\u0003\u0014\n\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=>\u0005\t\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?@\u0005\u0007\u0000"+
		"\u0000@A\u0003\u0016\u000b\u0000AB\u0003\u0014\n\u0000BC\u0005\t\u0000"+
		"\u0000C\t\u0001\u0000\u0000\u0000DE\u0005\n\u0000\u0000EJ\u0003\u0018"+
		"\f\u0000FG\u0005\u0016\u0000\u0000GI\u0003\u0018\f\u0000HF\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000K\u000b\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000MN\u0005\u000b\u0000\u0000NO\u0005)\u0000\u0000OP\u0005\'\u0000"+
		"\u0000P\r\u0001\u0000\u0000\u0000QS\u0005\f\u0000\u0000RQ\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0005"+
		"\'\u0000\u0000UV\u0005\u0015\u0000\u0000VW\u0003\u0018\f\u0000W\u000f"+
		"\u0001\u0000\u0000\u0000XZ\u0005\u0010\u0000\u0000Y[\u0003\u0002\u0001"+
		"\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005"+
		"\u0011\u0000\u0000_`\u0003\u0016\u000b\u0000`\u0011\u0001\u0000\u0000"+
		"\u0000ab\u0007\u0000\u0000\u0000b\u0013\u0001\u0000\u0000\u0000ce\u0003"+
		"\u0002\u0001\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gk\u0001\u0000\u0000"+
		"\u0000hk\u0005\u000e\u0000\u0000ik\u0005\u000f\u0000\u0000jd\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0015"+
		"\u0001\u0000\u0000\u0000lo\u0003\u0018\f\u0000mn\u0007\u0001\u0000\u0000"+
		"np\u0003\u0018\f\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pt\u0001\u0000\u0000\u0000qr\u0003\u0012\t\u0000rs\u0003\u0016\u000b\u0000"+
		"su\u0001\u0000\u0000\u0000tq\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000u\u0017\u0001\u0000\u0000\u0000v{\u0003\u001a\r\u0000wx\u0007\u0002"+
		"\u0000\u0000xz\u0003\u001a\r\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0019"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0083\u0003\u001c"+
		"\u000e\u0000\u007f\u0080\u0007\u0003\u0000\u0000\u0080\u0082\u0003\u001c"+
		"\u000e\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u001b\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0086\u009d\u0005(\u0000\u0000\u0087\u009d\u0005\'\u0000"+
		"\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u008a\u0003\u0018\f\u0000"+
		"\u008a\u008b\u0005!\u0000\u0000\u008b\u009d\u0001\u0000\u0000\u0000\u008c"+
		"\u009d\u0005)\u0000\u0000\u008d\u008e\u0005\u0012\u0000\u0000\u008e\u008f"+
		"\u0005 \u0000\u0000\u008f\u0090\u0003\u0018\f\u0000\u0090\u0091\u0005"+
		"!\u0000\u0000\u0091\u009d\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0013"+
		"\u0000\u0000\u0093\u0094\u0005 \u0000\u0000\u0094\u0095\u0003\u0018\f"+
		"\u0000\u0095\u0096\u0005!\u0000\u0000\u0096\u009d\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0005\u0014\u0000\u0000\u0098\u0099\u0005 \u0000\u0000\u0099"+
		"\u009a\u0003\u0018\f\u0000\u009a\u009b\u0005!\u0000\u0000\u009b\u009d"+
		"\u0001\u0000\u0000\u0000\u009c\u0086\u0001\u0000\u0000\u0000\u009c\u0087"+
		"\u0001\u0000\u0000\u0000\u009c\u0088\u0001\u0000\u0000\u0000\u009c\u008c"+
		"\u0001\u0000\u0000\u0000\u009c\u008d\u0001\u0000\u0000\u0000\u009c\u0092"+
		"\u0001\u0000\u0000\u0000\u009c\u0097\u0001\u0000\u0000\u0000\u009d\u001d"+
		"\u0001\u0000\u0000\u0000\r!*;JR\\fjot{\u0083\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}