// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

    import compiler.datastructures.*;
    import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, RELOPERATOR=15, TEXT=16, 
		NUMBER=17, IDENTIFIER=18, PLUS=19, MINUS=20, MUL=21, DIV=22, COMMA=23, 
		LEFTPARENTHESIS=24, RIGHTPARENTHESIS=25, OPENBRACKETS=26, CLOSEBRACKETS=27, 
		DP=28, DOT=29, DOUBLEQUOTE=30, WS=31;
	public static final int
		RULE_prog = 0, RULE_declare = 1, RULE_vartype = 2, RULE_block = 3, RULE_cmd = 4, 
		RULE_cmdread = 5, RULE_cmdwrite = 6, RULE_cmdif = 7, RULE_cmdexpr = 8, 
		RULE_cmdwhile = 9, RULE_cmddowhile = 10, RULE_term = 11, RULE_expr = 12, 
		RULE_factor = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declare", "vartype", "block", "cmd", "cmdread", "cmdwrite", 
			"cmdif", "cmdexpr", "cmdwhile", "cmddowhile", "term", "expr", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'integer'", "'float'", 
			"'string'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "':='", 
			"'enquanto'", "'execute'", null, null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "','", "'('", "')'", "'{'", "'}'", "':'", "'.'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "RELOPERATOR", "TEXT", "NUMBER", "IDENTIFIER", "PLUS", 
			"MINUS", "MUL", "DIV", "COMMA", "LEFTPARENTHESIS", "RIGHTPARENTHESIS", 
			"OPENBRACKETS", "CLOSEBRACKETS", "DP", "DOT", "DOUBLEQUOTE", "WS"
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
		private Integer _exprLeftType, _exprRightType = null;

		private String _varName;
		private Set<String> _unusedVariables = new HashSet<>();

		private Symbol currentSymbol;
	    private SymbolTable _symbolTable = new SymbolTable();

		public void addSymbol() {
			if (_symbolTable.exists(_varName)) {
				throw new SemanticException("variable '" + _varName + "' redeclared");	
			}
			
			_symbolTable.add(new Variable(_varType, _varName, false));
			_unusedVariables.add(_varName);
		}
		
		public void verifyIdentifier() {
			if (!_symbolTable.exists(_varName)) {
				throw new SemanticException("Variable '" + _varName + "' not declared");
			}
		}

		public void verifyUninitializedList() {
	        List<String> uninitializedList = _symbolTable
	                                            .generateUninitializedList()
	                                            .stream()
	                                            .filter(x -> !_unusedVariables.contains(x.getName()))
	                                            .map(x -> x.getName())
	                                            .toList();

	        System.out.println("Warning: Uninitialized variables in use: " + uninitializedList);
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
			setState(28);
			match(T__0);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(29);
				declare();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			block();
			setState(36);
			match(T__1);
			setState(37);
			match(DOT);

								    if(_unusedVariables.size() > 0) {
								        System.out.println("Warning: Unused variables: " + _unusedVariables);
								    }

								    _symbolTable.iterate();

								    verifyUninitializedList();
								
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
			setState(40);
			match(T__2);
			setState(41);
			vartype();
			setState(42);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();

									addSymbol();
								
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(44);
				match(COMMA);
				setState(45);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();

										addSymbol();
									
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__3);
				 _varType = Variable.INTEGER; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(T__4);
				 _varType = Variable.FLOAT;   
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(T__5);
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
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				cmd();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 287616L) != 0) );
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
		public CmddowhileContext cmddowhile() {
			return getRuleContext(CmddowhileContext.class,0);
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
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				cmdread();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				cmdwrite();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				cmdexpr();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				cmdif();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				cmdwhile();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				cmddowhile();
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
			setState(75);
			match(T__6);
			setState(76);
			match(LEFTPARENTHESIS);
			setState(77);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									verifyIdentifier();
									_unusedVariables.remove(_varName);
								
			setState(79);
			match(RIGHTPARENTHESIS);
			setState(80);
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
			setState(82);
			match(T__7);
			setState(83);
			match(LEFTPARENTHESIS);
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(84);
				match(TEXT);
				}
				break;
			case IDENTIFIER:
				{
				setState(85);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
										_unusedVariables.remove(_varName);
									
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(89);
			match(RIGHTPARENTHESIS);
			setState(90);
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
			setState(92);
			match(T__8);
			setState(93);
			match(LEFTPARENTHESIS);
			setState(94);
			expr();
			setState(95);
			match(RELOPERATOR);
			setState(96);
			expr();
			setState(97);
			match(RIGHTPARENTHESIS);
			setState(98);
			match(T__9);
			setState(99);
			match(OPENBRACKETS);
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				cmd();
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 287616L) != 0) );
			setState(105);
			match(CLOSEBRACKETS);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(106);
				match(T__10);
				setState(107);
				match(OPENBRACKETS);
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(108);
					cmd();
					}
					}
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 287616L) != 0) );
				setState(113);
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
			setState(117);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									verifyIdentifier();
			                        Variable _var = (Variable) _symbolTable.get(_input.LT(-1).getText());
			                        _var.setInitialized(true);
			                        _exprLeftType = _var.getType();
								
			setState(119);
			match(T__11);
			setState(120);
			expr();
			setState(121);
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
			setState(124);
			match(T__12);
			setState(125);
			match(LEFTPARENTHESIS);
			setState(126);
			expr();
			setState(127);
			match(RELOPERATOR);
			setState(128);
			expr();
			setState(129);
			match(RIGHTPARENTHESIS);
			setState(130);
			match(OPENBRACKETS);
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				cmd();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 287616L) != 0) );
			setState(136);
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
	public static class CmddowhileContext extends ParserRuleContext {
		public TerminalNode OPENBRACKETS() { return getToken(IsiGrammarParser.OPENBRACKETS, 0); }
		public TerminalNode CLOSEBRACKETS() { return getToken(IsiGrammarParser.CLOSEBRACKETS, 0); }
		public TerminalNode LEFTPARENTHESIS() { return getToken(IsiGrammarParser.LEFTPARENTHESIS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELOPERATOR() { return getToken(IsiGrammarParser.RELOPERATOR, 0); }
		public TerminalNode RIGHTPARENTHESIS() { return getToken(IsiGrammarParser.RIGHTPARENTHESIS, 0); }
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmddowhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmddowhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmddowhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmddowhile(this);
		}
	}

	public final CmddowhileContext cmddowhile() throws RecognitionException {
		CmddowhileContext _localctx = new CmddowhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmddowhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__13);
			setState(139);
			match(OPENBRACKETS);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				cmd();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 287616L) != 0) );
			setState(145);
			match(CLOSEBRACKETS);
			setState(146);
			match(T__12);
			setState(147);
			match(LEFTPARENTHESIS);
			setState(148);
			expr();
			setState(149);
			match(RELOPERATOR);
			setState(150);
			expr();
			setState(151);
			match(RIGHTPARENTHESIS);
			setState(152);
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
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			factor();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(155);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				factor();
				}
				}
				setState(161);
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			term();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(163);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(164);
				term();
				}
				}
				setState(169);
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
		public TerminalNode TEXT() { return getToken(IsiGrammarParser.TEXT, 0); }
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
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(NUMBER);

				                        if (_exprRightType == null) {
				                            _exprRightType = Variable.INTEGER;
				                        }
				                    
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(TEXT);

				                        if (_exprRightType == null) {
				                            _exprRightType = Variable.STRING;
				                        }

				                    
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
										_unusedVariables.remove(_varName);
									
				}
				break;
			case LEFTPARENTHESIS:
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(LEFTPARENTHESIS);
				setState(177);
				expr();
				setState(178);
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
		"\u0004\u0001\u001f\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005\u0000\u001f"+
		"\b\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00010\b\u0001\n\u0001\f\u0001"+
		"3\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001\u0003"+
		"\u0004\u0003@\b\u0003\u000b\u0003\f\u0003A\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004J\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006X\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0004\u0007f\b\u0007\u000b\u0007\f\u0007g\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007n\b\u0007\u000b\u0007"+
		"\f\u0007o\u0001\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0085\b\t\u000b\t\f\t\u0086"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0004\n\u008e\b\n\u000b\n\f\n"+
		"\u008f\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u009e\b\u000b"+
		"\n\u000b\f\u000b\u00a1\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00a6\b"+
		"\f\n\f\f\f\u00a9\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b5\b\r\u0001\r\u0000\u0000\u000e"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u0000\u0002\u0001\u0000\u0015\u0016\u0001\u0000\u0013\u0014\u00bd\u0000"+
		"\u001c\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u0004<\u0001"+
		"\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000"+
		"\u0000\nK\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e\\\u0001"+
		"\u0000\u0000\u0000\u0010u\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000"+
		"\u0000\u0014\u008a\u0001\u0000\u0000\u0000\u0016\u009a\u0001\u0000\u0000"+
		"\u0000\u0018\u00a2\u0001\u0000\u0000\u0000\u001a\u00b4\u0001\u0000\u0000"+
		"\u0000\u001c \u0005\u0001\u0000\u0000\u001d\u001f\u0003\u0002\u0001\u0000"+
		"\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 "+
		"\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0003\u0006\u0003\u0000$%\u0005"+
		"\u0002\u0000\u0000%&\u0005\u001d\u0000\u0000&\'\u0006\u0000\uffff\uffff"+
		"\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0003"+
		"\u0004\u0002\u0000*+\u0005\u0012\u0000\u0000+1\u0006\u0001\uffff\uffff"+
		"\u0000,-\u0005\u0017\u0000\u0000-.\u0005\u0012\u0000\u0000.0\u0006\u0001"+
		"\uffff\uffff\u0000/,\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000045\u0005\u001d\u0000\u00005\u0003\u0001"+
		"\u0000\u0000\u000067\u0005\u0004\u0000\u00007=\u0006\u0002\uffff\uffff"+
		"\u000089\u0005\u0005\u0000\u00009=\u0006\u0002\uffff\uffff\u0000:;\u0005"+
		"\u0006\u0000\u0000;=\u0006\u0002\uffff\uffff\u0000<6\u0001\u0000\u0000"+
		"\u0000<8\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=\u0005\u0001"+
		"\u0000\u0000\u0000>@\u0003\b\u0004\u0000?>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"B\u0007\u0001\u0000\u0000\u0000CJ\u0003\n\u0005\u0000DJ\u0003\f\u0006"+
		"\u0000EJ\u0003\u0010\b\u0000FJ\u0003\u000e\u0007\u0000GJ\u0003\u0012\t"+
		"\u0000HJ\u0003\u0014\n\u0000IC\u0001\u0000\u0000\u0000ID\u0001\u0000\u0000"+
		"\u0000IE\u0001\u0000\u0000\u0000IF\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000J\t\u0001\u0000\u0000\u0000KL\u0005"+
		"\u0007\u0000\u0000LM\u0005\u0018\u0000\u0000MN\u0005\u0012\u0000\u0000"+
		"NO\u0006\u0005\uffff\uffff\u0000OP\u0005\u0019\u0000\u0000PQ\u0005\u001d"+
		"\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000RS\u0005\b\u0000\u0000SW\u0005"+
		"\u0018\u0000\u0000TX\u0005\u0010\u0000\u0000UV\u0005\u0012\u0000\u0000"+
		"VX\u0006\u0006\uffff\uffff\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u0019\u0000\u0000Z[\u0005"+
		"\u001d\u0000\u0000[\r\u0001\u0000\u0000\u0000\\]\u0005\t\u0000\u0000]"+
		"^\u0005\u0018\u0000\u0000^_\u0003\u0018\f\u0000_`\u0005\u000f\u0000\u0000"+
		"`a\u0003\u0018\f\u0000ab\u0005\u0019\u0000\u0000bc\u0005\n\u0000\u0000"+
		"ce\u0005\u001a\u0000\u0000df\u0003\b\u0004\u0000ed\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000is\u0005\u001b\u0000\u0000jk\u0005\u000b"+
		"\u0000\u0000km\u0005\u001a\u0000\u0000ln\u0003\b\u0004\u0000ml\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0005\u001b\u0000\u0000"+
		"rt\u0001\u0000\u0000\u0000sj\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\u000f\u0001\u0000\u0000\u0000uv\u0005\u0012\u0000\u0000vw\u0006"+
		"\b\uffff\uffff\u0000wx\u0005\f\u0000\u0000xy\u0003\u0018\f\u0000yz\u0005"+
		"\u001d\u0000\u0000z{\u0006\b\uffff\uffff\u0000{\u0011\u0001\u0000\u0000"+
		"\u0000|}\u0005\r\u0000\u0000}~\u0005\u0018\u0000\u0000~\u007f\u0003\u0018"+
		"\f\u0000\u007f\u0080\u0005\u000f\u0000\u0000\u0080\u0081\u0003\u0018\f"+
		"\u0000\u0081\u0082\u0005\u0019\u0000\u0000\u0082\u0084\u0005\u001a\u0000"+
		"\u0000\u0083\u0085\u0003\b\u0004\u0000\u0084\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u001b\u0000\u0000\u0089\u0013\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u000e\u0000\u0000\u008b\u008d\u0005\u001a\u0000\u0000"+
		"\u008c\u008e\u0003\b\u0004\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\u001b\u0000\u0000\u0092\u0093\u0005\r\u0000\u0000\u0093\u0094"+
		"\u0005\u0018\u0000\u0000\u0094\u0095\u0003\u0018\f\u0000\u0095\u0096\u0005"+
		"\u000f\u0000\u0000\u0096\u0097\u0003\u0018\f\u0000\u0097\u0098\u0005\u0019"+
		"\u0000\u0000\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u0015\u0001\u0000"+
		"\u0000\u0000\u009a\u009f\u0003\u001a\r\u0000\u009b\u009c\u0007\u0000\u0000"+
		"\u0000\u009c\u009e\u0003\u001a\r\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u0017\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a7\u0003\u0016\u000b\u0000"+
		"\u00a3\u00a4\u0007\u0001\u0000\u0000\u00a4\u00a6\u0003\u0016\u000b\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u0019\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0005\u0011\u0000\u0000\u00ab\u00b5\u0006\r\uffff\uffff\u0000"+
		"\u00ac\u00ad\u0005\u0010\u0000\u0000\u00ad\u00b5\u0006\r\uffff\uffff\u0000"+
		"\u00ae\u00af\u0005\u0012\u0000\u0000\u00af\u00b5\u0006\r\uffff\uffff\u0000"+
		"\u00b0\u00b1\u0005\u0018\u0000\u0000\u00b1\u00b2\u0003\u0018\f\u0000\u00b2"+
		"\u00b3\u0005\u0019\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4"+
		"\u00aa\u0001\u0000\u0000\u0000\u00b4\u00ac\u0001\u0000\u0000\u0000\u00b4"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000\u0000\u00b5"+
		"\u001b\u0001\u0000\u0000\u0000\u000e 1<AIWgos\u0086\u008f\u009f\u00a7"+
		"\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}