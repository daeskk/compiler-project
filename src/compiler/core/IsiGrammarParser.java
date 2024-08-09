// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

	import compiler.datastructures.*;
	import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, RELOPERATOR=13, TEXT=14, NUMBER=15, IDENTIFIER=16, 
		PLUS=17, MINUS=18, MUL=19, DIV=20, COMMA=21, LEFTPARENTHESIS=22, RIGHTPARENTHESIS=23, 
		OPENBRACKETS=24, CLOSEBRACKETS=25, DP=26, DOT=27, DOUBLEQUOTE=28, WS=29;
	public static final int
		RULE_prog = 0, RULE_declare = 1, RULE_vartype = 2, RULE_block = 3, RULE_cmd = 4, 
		RULE_cmdread = 5, RULE_cmdwrite = 6, RULE_cmdif = 7, RULE_cmdexpr = 8, 
		RULE_cmdwhile = 9, RULE_term = 10, RULE_expr = 11, RULE_factor = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declare", "vartype", "block", "cmd", "cmdread", "cmdwrite", 
			"cmdif", "cmdexpr", "cmdwhile", "term", "expr", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'number'", "'string'", 
			"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "':='", "'enquanto'", 
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "','", "'('", "')'", 
			"'{'", "'}'", "':'", "'.'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "RELOPERATOR", "TEXT", "NUMBER", "IDENTIFIER", "PLUS", "MINUS", 
			"MUL", "DIV", "COMMA", "LEFTPARENTHESIS", "RIGHTPARENTHESIS", "OPENBRACKETS", 
			"CLOSEBRACKETS", "DP", "DOT", "DOUBLEQUOTE", "WS"
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
	public String getGrammarFileName() { return "IsiGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

		
		private int _varType;
		private String _varName;
		private String _varValue;
		
		private Symbol currentSymbol;
			
		private SymbolTable _symbolTable = new SymbolTable();
		
		private Set<String> _unusedVariables = new HashSet<>();
			
		public void addSymbol() {
			if (_symbolTable.exists(_varName)) {
				throw new SemanticException("variable '" + _varName + "' redeclared");	
			}
			
			_symbolTable.add(new Variable(_varType, _varName, _varValue));
			_unusedVariables.add(_varName);
		}
		
		public void verifyIdentifier() {
			if (!_symbolTable.exists(_varName)) {
				throw new SemanticException("Variable '" + _varName + "' not declared");
			}
		}

	public IsiGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(27);
				declare();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			block();
			setState(34);
			match(T__1);
			setState(35);
			match(DOT);

								    if(_unusedVariables.size() > 0) {
								        System.out.println("Unused variables: " + _unusedVariables);
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
	public static class DeclareContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(IsiGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(IsiGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(IsiGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(IsiGrammarParser.COMMA, i);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitDeclare(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__2);
			setState(39);
			vartype();
			setState(40);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									_varValue = null;

									addSymbol();
								
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(42);
				match(COMMA);
				setState(43);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										_varValue = null;

										addSymbol();
									
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(DOT);
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
	public static class VartypeContext extends ParserRuleContext {
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterVartype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitVartype(this);
		}
	}

	public final VartypeContext vartype() throws RecognitionException {
		VartypeContext _localctx = new VartypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vartype);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__3);
				 _varType = Variable.NUMBER; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__4);
				 _varType = Variable.STRING; 
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
	public static class BlockContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				cmd();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70080L) != 0) );
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
	public static class CmdContext extends ParserRuleContext {
		public CmdreadContext cmdread() {
			return getRuleContext(CmdreadContext.class,0);
		}
		public CmdwriteContext cmdwrite() {
			return getRuleContext(CmdwriteContext.class,0);
		}
		public CmdexprContext cmdexpr() {
			return getRuleContext(CmdexprContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdwhileContext cmdwhile() {
			return getRuleContext(CmdwhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmd);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				cmdread();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				cmdwrite();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				cmdexpr();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				cmdif();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				cmdwhile();
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
	public static class CmdreadContext extends ParserRuleContext {
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(IsiGrammarParser.IDENTIFIER, 0); }
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public CmdreadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdread; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdread(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdread(this);
		}
	}

	public final CmdreadContext cmdread() throws RecognitionException {
		CmdreadContext _localctx = new CmdreadContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdread);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__5);
			setState(71);
			match(LEFTPARENTHESIS);
			setState(72);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									verifyIdentifier();
								
			setState(74);
			match(RIGHTPARENTHESIS);
			setState(75);
			match(DOT);
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
	public static class CmdwriteContext extends ParserRuleContext {
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public TerminalNode TEXT() { return getToken(IsiGrammarParser.TEXT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(IsiGrammarParser.IDENTIFIER, 0); }
		public CmdwriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdwrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdwrite(this);
		}
	}

	public final CmdwriteContext cmdwrite() throws RecognitionException {
		CmdwriteContext _localctx = new CmdwriteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdwrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__6);
			setState(78);
			match(LEFTPARENTHESIS);
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(79);
				match(TEXT);
				}
				break;
			case IDENTIFIER:
				{
				setState(80);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
									
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84);
			match(RIGHTPARENTHESIS);
			setState(85);
			match(DOT);
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
	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOPERATOR() { return getToken(IsiGrammarParser.RELOPERATOR, 0); }
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public List<TerminalNode> OPENBRACKETS() { return getTokens(IsiGrammarParser.OPENBRACKETS); }
		public TerminalNode OPENBRACKETS(int i) {
			return getToken(IsiGrammarParser.OPENBRACKETS, i);
		}
		public List<TerminalNode> CLOSEBRACKETS() { return getTokens(IsiGrammarParser.CLOSEBRACKETS); }
		public TerminalNode CLOSEBRACKETS(int i) {
			return getToken(IsiGrammarParser.CLOSEBRACKETS, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__7);
			setState(88);
			match(LEFTPARENTHESIS);
			setState(89);
			expr();
			setState(90);
			match(RELOPERATOR);
			setState(91);
			expr();
			setState(92);
			match(RIGHTPARENTHESIS);
			setState(93);
			match(T__8);
			setState(94);
			match(OPENBRACKETS);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				cmd();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70080L) != 0) );
			setState(100);
			match(CLOSEBRACKETS);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(101);
				match(T__9);
				setState(102);
				match(OPENBRACKETS);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
					cmd();
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70080L) != 0) );
				setState(108);
				match(CLOSEBRACKETS);
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
	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(IsiGrammarParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdexpr(this);
		}
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									verifyIdentifier();
									_unusedVariables.remove(_varName);
								
			setState(114);
			match(T__10);
			setState(115);
			expr();
			setState(116);
			match(DOT);
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
	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOPERATOR() { return getToken(IsiGrammarParser.RELOPERATOR, 0); }
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public TerminalNode OPENBRACKETS() { return getToken(IsiGrammarParser.OPENBRACKETS, 0); }
		public TerminalNode CLOSEBRACKETS() { return getToken(IsiGrammarParser.CLOSEBRACKETS, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdwhile(this);
		}
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__11);
			setState(119);
			match(LEFTPARENTHESIS);
			setState(120);
			expr();
			setState(121);
			match(RELOPERATOR);
			setState(122);
			expr();
			setState(123);
			match(RIGHTPARENTHESIS);
			setState(124);
			match(OPENBRACKETS);
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				cmd();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70080L) != 0) );
			setState(130);
			match(CLOSEBRACKETS);
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
		public List<TerminalNode> MUL() { return getTokens(IsiGrammarParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(IsiGrammarParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(IsiGrammarParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(IsiGrammarParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			factor();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				factor();
				}
				}
				setState(139);
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
	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(IsiGrammarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(IsiGrammarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(IsiGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(IsiGrammarParser.MINUS, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			term();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(141);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				term();
				}
				}
				setState(147);
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
		public TerminalNode NUMBER() { return getToken(IsiGrammarParser.NUMBER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(IsiGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
									
				}
				break;
			case LEFTPARENTHESIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(LEFTPARENTHESIS);
				setState(152);
				expr();
				setState(153);
				match(RIGHTPARENTHESIS);
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
		"\u0004\u0001\u001d\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0005\u0000\u001d\b\u0000\n\u0000"+
		"\f\u0000 \t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001.\b\u0001\n\u0001\f\u00011\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00029\b\u0002\u0001\u0003\u0004\u0003<\b\u0003\u000b\u0003\f\u0003="+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"E\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007a\b\u0007\u000b\u0007"+
		"\f\u0007b\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"i\b\u0007\u000b\u0007\f\u0007j\u0001\u0007\u0001\u0007\u0003\u0007o\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u007f\b\t\u000b"+
		"\t\f\t\u0080\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u0088\b\n"+
		"\n\n\f\n\u008b\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0090"+
		"\b\u000b\n\u000b\f\u000b\u0093\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u009c\b\f\u0001\f\u0000\u0000\r\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002"+
		"\u0001\u0000\u0013\u0014\u0001\u0000\u0011\u0012\u00a1\u0000\u001a\u0001"+
		"\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000"+
		"\u0000\u0006;\u0001\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nF\u0001"+
		"\u0000\u0000\u0000\fM\u0001\u0000\u0000\u0000\u000eW\u0001\u0000\u0000"+
		"\u0000\u0010p\u0001\u0000\u0000\u0000\u0012v\u0001\u0000\u0000\u0000\u0014"+
		"\u0084\u0001\u0000\u0000\u0000\u0016\u008c\u0001\u0000\u0000\u0000\u0018"+
		"\u009b\u0001\u0000\u0000\u0000\u001a\u001e\u0005\u0001\u0000\u0000\u001b"+
		"\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		" \u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000!\"\u0003\u0006\u0003\u0000\"#\u0005\u0002\u0000\u0000#$\u0005"+
		"\u001b\u0000\u0000$%\u0006\u0000\uffff\uffff\u0000%\u0001\u0001\u0000"+
		"\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0003\u0004\u0002\u0000()\u0005"+
		"\u0010\u0000\u0000)/\u0006\u0001\uffff\uffff\u0000*+\u0005\u0015\u0000"+
		"\u0000+,\u0005\u0010\u0000\u0000,.\u0006\u0001\uffff\uffff\u0000-*\u0001"+
		"\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000002\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000023\u0005\u001b\u0000\u00003\u0003\u0001\u0000\u0000\u000045\u0005"+
		"\u0004\u0000\u000059\u0006\u0002\uffff\uffff\u000067\u0005\u0005\u0000"+
		"\u000079\u0006\u0002\uffff\uffff\u000084\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u00009\u0005\u0001\u0000\u0000\u0000:<\u0003\b\u0004\u0000"+
		";:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000=>\u0001\u0000\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?E\u0003"+
		"\n\u0005\u0000@E\u0003\f\u0006\u0000AE\u0003\u0010\b\u0000BE\u0003\u000e"+
		"\u0007\u0000CE\u0003\u0012\t\u0000D?\u0001\u0000\u0000\u0000D@\u0001\u0000"+
		"\u0000\u0000DA\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001"+
		"\u0000\u0000\u0000E\t\u0001\u0000\u0000\u0000FG\u0005\u0006\u0000\u0000"+
		"GH\u0005\u0016\u0000\u0000HI\u0005\u0010\u0000\u0000IJ\u0006\u0005\uffff"+
		"\uffff\u0000JK\u0005\u0017\u0000\u0000KL\u0005\u001b\u0000\u0000L\u000b"+
		"\u0001\u0000\u0000\u0000MN\u0005\u0007\u0000\u0000NR\u0005\u0016\u0000"+
		"\u0000OS\u0005\u000e\u0000\u0000PQ\u0005\u0010\u0000\u0000QS\u0006\u0006"+
		"\uffff\uffff\u0000RO\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TU\u0005\u0017\u0000\u0000UV\u0005\u001b\u0000"+
		"\u0000V\r\u0001\u0000\u0000\u0000WX\u0005\b\u0000\u0000XY\u0005\u0016"+
		"\u0000\u0000YZ\u0003\u0016\u000b\u0000Z[\u0005\r\u0000\u0000[\\\u0003"+
		"\u0016\u000b\u0000\\]\u0005\u0017\u0000\u0000]^\u0005\t\u0000\u0000^`"+
		"\u0005\u0018\u0000\u0000_a\u0003\b\u0004\u0000`_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000dn\u0005\u0019\u0000\u0000ef\u0005\n\u0000"+
		"\u0000fh\u0005\u0018\u0000\u0000gi\u0003\b\u0004\u0000hg\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u0019\u0000\u0000mo\u0001"+
		"\u0000\u0000\u0000ne\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"o\u000f\u0001\u0000\u0000\u0000pq\u0005\u0010\u0000\u0000qr\u0006\b\uffff"+
		"\uffff\u0000rs\u0005\u000b\u0000\u0000st\u0003\u0016\u000b\u0000tu\u0005"+
		"\u001b\u0000\u0000u\u0011\u0001\u0000\u0000\u0000vw\u0005\f\u0000\u0000"+
		"wx\u0005\u0016\u0000\u0000xy\u0003\u0016\u000b\u0000yz\u0005\r\u0000\u0000"+
		"z{\u0003\u0016\u000b\u0000{|\u0005\u0017\u0000\u0000|~\u0005\u0018\u0000"+
		"\u0000}\u007f\u0003\b\u0004\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0005"+
		"\u0019\u0000\u0000\u0083\u0013\u0001\u0000\u0000\u0000\u0084\u0089\u0003"+
		"\u0018\f\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u0088\u0003\u0018"+
		"\f\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u0015\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u0091\u0003\u0014\n\u0000\u008d\u008e\u0007\u0001\u0000\u0000"+
		"\u008e\u0090\u0003\u0014\n\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0017\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u009c\u0005\u000f\u0000\u0000\u0095"+
		"\u0096\u0005\u0010\u0000\u0000\u0096\u009c\u0006\f\uffff\uffff\u0000\u0097"+
		"\u0098\u0005\u0016\u0000\u0000\u0098\u0099\u0003\u0016\u000b\u0000\u0099"+
		"\u009a\u0005\u0017\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b"+
		"\u0094\u0001\u0000\u0000\u0000\u009b\u0095\u0001\u0000\u0000\u0000\u009b"+
		"\u0097\u0001\u0000\u0000\u0000\u009c\u0019\u0001\u0000\u0000\u0000\r\u001e"+
		"/8=DRbjn\u0080\u0089\u0091\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}