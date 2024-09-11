// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

    import main.java.enums.*;
    import compiler.datastructures.*;
    import compiler.exceptions.*;
    import compiler.ast.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;
    import java.util.ArrayList;
    import java.util.Stack;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, RELOPERATOR=16, 
		TEXT=17, NUMBER=18, IDENTIFIER=19, PLUS=20, MINUS=21, MUL=22, DIV=23, 
		COMMA=24, LEFTPARENTHESIS=25, RIGHTPARENTHESIS=26, OPENBRACKETS=27, CLOSEBRACKETS=28, 
		DP=29, DOT=30, DOUBLEQUOTE=31, WS=32;
	public static final int
		RULE_prog = 0, RULE_declare = 1, RULE_vartype = 2, RULE_block = 3, RULE_cmd = 4, 
		RULE_cmdbreak = 5, RULE_cmdread = 6, RULE_cmdwrite = 7, RULE_cmdif = 8, 
		RULE_cmdexpr = 9, RULE_cmdwhile = 10, RULE_cmddowhile = 11, RULE_term = 12, 
		RULE_expr = 13, RULE_factor = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declare", "vartype", "block", "cmd", "cmdbreak", "cmdread", 
			"cmdwrite", "cmdif", "cmdexpr", "cmdwhile", "cmddowhile", "term", "expr", 
			"factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'integer'", "'double'", 
			"'string'", "'parar'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", 
			"':='", "'enquanto'", "'execute'", null, null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "','", "'('", "')'", "'{'", "'}'", "':'", "'.'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "RELOPERATOR", "TEXT", "NUMBER", "IDENTIFIER", 
			"PLUS", "MINUS", "MUL", "DIV", "COMMA", "LEFTPARENTHESIS", "RIGHTPARENTHESIS", 
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
		private boolean _breakUsable = false;
		private boolean _hasScanner = false;

		private String _varName, _exprLeftVarname, top;

		private Stack<String> expressionStack = new Stack<>();
		private Stack<IfCommand> ifCommandStack= new Stack<>();

		private Symbol currentSymbol;
	    private SymbolTable _symbolTable = new SymbolTable();

	    private Variable _currentVar;

	    private IfCommand currentIfCommand;
	    private DoWhileCommand currentDoWhileCommand;
	    private WhileCommand currentWhileCommand;

	    private Stack<List<Command>> commandStack = new Stack<>();

	    private CodeGenerator codeGenerator = new CodeGenerator();

	    public CodeGenerator getCodeGenerator() {
	        return codeGenerator;
	    }

		public void addSymbol() {
			if (_symbolTable.exists(_varName)) {
				throw new SemanticException("variable '" + _varName + "' redeclared");
			}
			
			_symbolTable.add(new Variable(_varType, _varName, false, false));
		}
		
		public void verifyIdentifier() {
			if (!_symbolTable.exists(_varName)) {
				throw new SemanticException("Variable '" + _varName + "' not declared");
			}
		}

		public void verifyIfInitialized() {
			Variable currentVar = (Variable) _symbolTable.get(_varName);

	        if (!currentVar.isInitialized()) {
				throw new SemanticException("Variable '" + _varName + "' might not have been initialized");
	        }
		}

		public void setAsUsed() {
		    Variable currentVar = (Variable) _symbolTable.get(_varName);
			currentVar.setUsed(true);
		}

		public void verifyUninitializedList() {
	        List<String> uninitializedList = _symbolTable
	                                            .generateUninitializedList()
	                                            .stream()
	                                            .map(x -> x.getName())
	                                            .toList();

	        if (uninitializedList.size() > 0) {
	            System.out.println("Warning: Uninitialized variables: " + uninitializedList);
	        }
		}

		public void verifyUnusedVariables() {
	        if(_symbolTable.generateUnusedList().size() > 0) {
	            System.out.println("Warning: Unused variables: " + _symbolTable.generateUnusedList()
	                                                                                .stream()
	                                                                                .map(x -> x.getName())
	                                                                                .toList());
	        }
		}

		public void checkBreak() {
	        if (!_breakUsable)
	            throw new SemanticException("Command 'parar' must be used inside a loop.");
	    }

	public IsiGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<String> results;
		public TerminalNode IDENTIFIER() { return getToken(IsiGrammarParser.IDENTIFIER, 0); }
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
			setState(30);
			match(T__0);
			setState(31);
			match(IDENTIFIER);

			                        codeGenerator.setProgramName(_input.LT(-1).getText());
			                        commandStack.push(new ArrayList<>());
			                    
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(33);
				declare();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			block();
			setState(40);
			match(T__1);
			setState(41);
			match(DOT);

			                        verifyUnusedVariables();
								    verifyUninitializedList();

			                        codeGenerator.setSymbolTable(_symbolTable);
			                        codeGenerator.setCommands(commandStack.pop());
			                        codeGenerator.setHasScanner(_hasScanner);

			                        ((ProgContext)_localctx).results =  new ArrayList<>();

			                        _localctx.results.add(codeGenerator.generateTarget(ProgrammingLanguage.JAVA));
								    _localctx.results.add(codeGenerator.generateTarget(ProgrammingLanguage.CPP));
								
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
			setState(44);
			match(T__2);
			setState(45);
			vartype();
			setState(46);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();

									addSymbol();
								
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(48);
				match(COMMA);
				setState(49);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();

										addSymbol();
									
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__3);
				 _varType = Variable.INTEGER; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(T__4);
				 _varType = Variable.DOUBLE;  
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
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
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				cmd();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 575360L) != 0) );
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
		public CmdbreakContext cmdbreak() {
			return getRuleContext(CmdbreakContext.class,0);
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				cmdread();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				cmdwrite();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				cmdexpr();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				cmdif();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				cmdwhile();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				cmddowhile();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				cmdbreak();
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
	public static class CmdbreakContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(IsiGrammarParser.DOT, 0); }
		public CmdbreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdbreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).enterCmdbreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiGrammarListener ) ((IsiGrammarListener)listener).exitCmdbreak(this);
		}
	}

	public final CmdbreakContext cmdbreak() throws RecognitionException {
		CmdbreakContext _localctx = new CmdbreakContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdbreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__6);
			setState(81);
			match(DOT);

			                        checkBreak();
			                        BreakCommand cmdBreak = new BreakCommand();
			                        commandStack.peek().add(cmdBreak);
			                        
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
		enterRule(_localctx, 12, RULE_cmdread);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__7);
			setState(85);
			match(LEFTPARENTHESIS);
			setState(86);
			match(IDENTIFIER);

			                        _hasScanner = true;
									_varName = _input.LT(-1).getText();
									verifyIdentifier();
									setAsUsed();
			                        Variable _var = (Variable) _symbolTable.get(_varName);
			                        _var.setInitialized(true);

								    commandStack.peek().add(new ReadCommand((Variable) _symbolTable.get(_varName)));

								
			setState(88);
			match(RIGHTPARENTHESIS);
			setState(89);
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
		enterRule(_localctx, 14, RULE_cmdwrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__8);
			setState(92);
			match(LEFTPARENTHESIS);
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(93);
				match(TEXT);

									    commandStack.peek().add(new WriteCommand(_input.LT(-1).getText()));
									
				}
				break;
			case IDENTIFIER:
				{
				setState(95);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
										verifyIfInitialized();
										setAsUsed();

									    commandStack.peek().add(new WriteCommand(_varName));
									
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(99);
			match(RIGHTPARENTHESIS);
			setState(100);
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
		enterRule(_localctx, 16, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__9);

			                            commandStack.push(new ArrayList<>());
			                            ifCommandStack.push(new IfCommand());
			                            expressionStack.push("");
			                        
			setState(104);
			match(LEFTPARENTHESIS);
			setState(105);
			expr();
			setState(106);
			match(RELOPERATOR);

			                             top = expressionStack.pop();
			                             top += _input.LT(-1).getText();

			                             expressionStack.push(top);
			                        
			setState(108);
			expr();
			setState(109);
			match(RIGHTPARENTHESIS);

			                             ifCommandStack.peek().setExpression(expressionStack.pop());
			                        
			setState(111);
			match(T__10);
			setState(112);
			match(OPENBRACKETS);
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113);
				cmd();
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 575360L) != 0) );
			setState(118);
			match(CLOSEBRACKETS);

			                             ifCommandStack.peek().setTrueList(commandStack.pop());
							        
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(120);
				match(T__11);

				                             commandStack.push(new ArrayList<>());
				                        
				setState(122);
				match(OPENBRACKETS);
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(123);
					cmd();
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 575360L) != 0) );
				setState(128);
				match(CLOSEBRACKETS);

				                            ifCommandStack.peek().setFalseList(commandStack.pop());
				                        
				}
			}


			                            commandStack.peek().add(ifCommandStack.pop());
			                        
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
		enterRule(_localctx, 18, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IDENTIFIER);

									_varName = _input.LT(-1).getText();
									_exprLeftVarname = _varName;
									verifyIdentifier();
			                        _currentVar = (Variable) _symbolTable.get(_input.LT(-1).getText());
			                        _exprLeftType = _currentVar.getType();
								
			setState(137);
			match(T__12);

			                        expressionStack.push("");
								
			setState(139);
			expr();
			setState(140);
			match(DOT);

								    if (_exprLeftType != _exprRightType) {

			                            throw new SemanticException("Mismatched type assignment at variable '" + _exprLeftVarname + "'");
			                        }
			                        _currentVar.setInitialized(true);
			                        commandStack.peek().add(new AttrCommand(_exprLeftVarname, expressionStack.pop()));
								
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
		enterRule(_localctx, 20, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__13);

			                        commandStack.push(new ArrayList<>());
			                        currentWhileCommand = new WhileCommand();
			                        expressionStack.push("");
			                        _breakUsable = true;
			                    
			setState(145);
			match(LEFTPARENTHESIS);
			setState(146);
			expr();
			setState(147);
			match(RELOPERATOR);

			                         top = expressionStack.pop();
			                         top += _input.LT(-1).getText();

			                         expressionStack.push(top);
			                    
			setState(149);
			expr();
			setState(150);
			match(RIGHTPARENTHESIS);

			                        currentWhileCommand.setExpression(expressionStack.pop());
			                    
			setState(152);
			match(OPENBRACKETS);
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				cmd();
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 575360L) != 0) );
			setState(158);
			match(CLOSEBRACKETS);

			                        currentWhileCommand.setCommandList(commandStack.pop());
			                        commandStack.peek().add(currentWhileCommand);
			                        _breakUsable = false;
			                    
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
		enterRule(_localctx, 22, RULE_cmddowhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__14);

			                        commandStack.push(new ArrayList<>());
			                        currentDoWhileCommand = new DoWhileCommand();
			                        _breakUsable = true;
			                    
			setState(163);
			match(OPENBRACKETS);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				cmd();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 575360L) != 0) );
			setState(169);
			match(CLOSEBRACKETS);
			setState(170);
			match(T__13);

			                        expressionStack.push("");
			                    
			setState(172);
			match(LEFTPARENTHESIS);
			setState(173);
			expr();
			setState(174);
			match(RELOPERATOR);

			                         top = expressionStack.pop();
			                         top += _input.LT(-1).getText();

			                         expressionStack.push(top);
			                    
			setState(176);
			expr();
			setState(177);
			match(RIGHTPARENTHESIS);

			                        currentDoWhileCommand.setExpression(expressionStack.pop());
			                    
			setState(179);
			match(DOT);

			                        currentDoWhileCommand.setCommandList(commandStack.pop());
			                        commandStack.peek().add(currentDoWhileCommand);
			                        _breakUsable = false;
			                    
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
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			factor();

			                         top = expressionStack.pop();
			                         top += _input.LT(-1).getText();

			                         expressionStack.push(top);
			                    
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(184);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                         top = expressionStack.pop();
				                         top += _input.LT(-1).getText();

				                         expressionStack.push(top);
				                    
				setState(186);
				factor();

				                         top = expressionStack.pop();
				                         top += _input.LT(-1).getText();

				                         expressionStack.push(top);
				                    
				}
				}
				setState(193);
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
		enterRule(_localctx, 26, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			term();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                         top = expressionStack.pop();
				                         top += _input.LT(-1).getText();

				                         expressionStack.push(top);
				                    
				setState(197);
				term();
				}
				}
				setState(202);
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
		enterRule(_localctx, 28, RULE_factor);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(NUMBER);

				                        String numberString = _input.LT(-1).getText();
				                        if (numberString.contains(".")) {
				                            _exprRightType = Variable.DOUBLE;
				                        } else {
				                            _exprRightType = Variable.INTEGER;
				                        }
				                    
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(TEXT);

				                        _exprRightType = Variable.STRING;
				                    
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(IDENTIFIER);

										_varName = _input.LT(-1).getText();
										verifyIdentifier();
										verifyIfInitialized();
										setAsUsed();

				                        Variable _var = (Variable) _symbolTable.get(_input.LT(-1).getText());
				                        _exprRightType = _var.getType();
									
				}
				break;
			case LEFTPARENTHESIS:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				match(LEFTPARENTHESIS);
				setState(210);
				expr();
				setState(211);
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
		"\u0004\u0001 \u00d8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002A\b\u0002\u0001\u0003\u0004\u0003D\b\u0003\u000b\u0003\f\u0003"+
		"E\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004O\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\bs\b\b\u000b\b\f\bt\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b}\b\b\u000b\b\f\b~\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u0084\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u009b\b\n\u000b"+
		"\n\f\n\u009c\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0004\u000b\u00a6\b\u000b\u000b\u000b\f\u000b\u00a7\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f"+
		"\u00be\b\f\n\f\f\f\u00c1\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c7"+
		"\b\r\n\r\f\r\u00ca\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00d6\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0002"+
		"\u0001\u0000\u0016\u0017\u0001\u0000\u0014\u0015\u00de\u0000\u001e\u0001"+
		"\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000"+
		"\u0000\u0006C\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\nP\u0001"+
		"\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000"+
		"\u0000\u0010f\u0001\u0000\u0000\u0000\u0012\u0087\u0001\u0000\u0000\u0000"+
		"\u0014\u008f\u0001\u0000\u0000\u0000\u0016\u00a1\u0001\u0000\u0000\u0000"+
		"\u0018\u00b6\u0001\u0000\u0000\u0000\u001a\u00c2\u0001\u0000\u0000\u0000"+
		"\u001c\u00d5\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000"+
		"\u001f \u0005\u0013\u0000\u0000 $\u0006\u0000\uffff\uffff\u0000!#\u0003"+
		"\u0002\u0001\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000\'(\u0003\u0006\u0003\u0000()\u0005\u0002"+
		"\u0000\u0000)*\u0005\u001e\u0000\u0000*+\u0006\u0000\uffff\uffff\u0000"+
		"+\u0001\u0001\u0000\u0000\u0000,-\u0005\u0003\u0000\u0000-.\u0003\u0004"+
		"\u0002\u0000./\u0005\u0013\u0000\u0000/5\u0006\u0001\uffff\uffff\u0000"+
		"01\u0005\u0018\u0000\u000012\u0005\u0013\u0000\u000024\u0006\u0001\uffff"+
		"\uffff\u000030\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000089\u0005\u001e\u0000\u00009\u0003\u0001\u0000"+
		"\u0000\u0000:;\u0005\u0004\u0000\u0000;A\u0006\u0002\uffff\uffff\u0000"+
		"<=\u0005\u0005\u0000\u0000=A\u0006\u0002\uffff\uffff\u0000>?\u0005\u0006"+
		"\u0000\u0000?A\u0006\u0002\uffff\uffff\u0000@:\u0001\u0000\u0000\u0000"+
		"@<\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000A\u0005\u0001\u0000"+
		"\u0000\u0000BD\u0003\b\u0004\u0000CB\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0007"+
		"\u0001\u0000\u0000\u0000GO\u0003\f\u0006\u0000HO\u0003\u000e\u0007\u0000"+
		"IO\u0003\u0012\t\u0000JO\u0003\u0010\b\u0000KO\u0003\u0014\n\u0000LO\u0003"+
		"\u0016\u000b\u0000MO\u0003\n\u0005\u0000NG\u0001\u0000\u0000\u0000NH\u0001"+
		"\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000"+
		"NK\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000"+
		"\u0000O\t\u0001\u0000\u0000\u0000PQ\u0005\u0007\u0000\u0000QR\u0005\u001e"+
		"\u0000\u0000RS\u0006\u0005\uffff\uffff\u0000S\u000b\u0001\u0000\u0000"+
		"\u0000TU\u0005\b\u0000\u0000UV\u0005\u0019\u0000\u0000VW\u0005\u0013\u0000"+
		"\u0000WX\u0006\u0006\uffff\uffff\u0000XY\u0005\u001a\u0000\u0000YZ\u0005"+
		"\u001e\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\t\u0000\u0000\\"+
		"a\u0005\u0019\u0000\u0000]^\u0005\u0011\u0000\u0000^b\u0006\u0007\uffff"+
		"\uffff\u0000_`\u0005\u0013\u0000\u0000`b\u0006\u0007\uffff\uffff\u0000"+
		"a]\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0005\u001a\u0000\u0000de\u0005\u001e\u0000\u0000e\u000f\u0001"+
		"\u0000\u0000\u0000fg\u0005\n\u0000\u0000gh\u0006\b\uffff\uffff\u0000h"+
		"i\u0005\u0019\u0000\u0000ij\u0003\u001a\r\u0000jk\u0005\u0010\u0000\u0000"+
		"kl\u0006\b\uffff\uffff\u0000lm\u0003\u001a\r\u0000mn\u0005\u001a\u0000"+
		"\u0000no\u0006\b\uffff\uffff\u0000op\u0005\u000b\u0000\u0000pr\u0005\u001b"+
		"\u0000\u0000qs\u0003\b\u0004\u0000rq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vw\u0005\u001c\u0000\u0000w\u0083\u0006\b\uffff\uffff"+
		"\u0000xy\u0005\f\u0000\u0000yz\u0006\b\uffff\uffff\u0000z|\u0005\u001b"+
		"\u0000\u0000{}\u0003\b\u0004\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u001c\u0000\u0000"+
		"\u0081\u0082\u0006\b\uffff\uffff\u0000\u0082\u0084\u0001\u0000\u0000\u0000"+
		"\u0083x\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0006\b\uffff\uffff\u0000\u0086"+
		"\u0011\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0013\u0000\u0000\u0088"+
		"\u0089\u0006\t\uffff\uffff\u0000\u0089\u008a\u0005\r\u0000\u0000\u008a"+
		"\u008b\u0006\t\uffff\uffff\u0000\u008b\u008c\u0003\u001a\r\u0000\u008c"+
		"\u008d\u0005\u001e\u0000\u0000\u008d\u008e\u0006\t\uffff\uffff\u0000\u008e"+
		"\u0013\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u000e\u0000\u0000\u0090"+
		"\u0091\u0006\n\uffff\uffff\u0000\u0091\u0092\u0005\u0019\u0000\u0000\u0092"+
		"\u0093\u0003\u001a\r\u0000\u0093\u0094\u0005\u0010\u0000\u0000\u0094\u0095"+
		"\u0006\n\uffff\uffff\u0000\u0095\u0096\u0003\u001a\r\u0000\u0096\u0097"+
		"\u0005\u001a\u0000\u0000\u0097\u0098\u0006\n\uffff\uffff\u0000\u0098\u009a"+
		"\u0005\u001b\u0000\u0000\u0099\u009b\u0003\b\u0004\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005\u001c\u0000\u0000\u009f\u00a0\u0006"+
		"\n\uffff\uffff\u0000\u00a0\u0015\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u000f\u0000\u0000\u00a2\u00a3\u0006\u000b\uffff\uffff\u0000\u00a3\u00a5"+
		"\u0005\u001b\u0000\u0000\u00a4\u00a6\u0003\b\u0004\u0000\u00a5\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0005\u001c\u0000\u0000\u00aa\u00ab\u0005"+
		"\u000e\u0000\u0000\u00ab\u00ac\u0006\u000b\uffff\uffff\u0000\u00ac\u00ad"+
		"\u0005\u0019\u0000\u0000\u00ad\u00ae\u0003\u001a\r\u0000\u00ae\u00af\u0005"+
		"\u0010\u0000\u0000\u00af\u00b0\u0006\u000b\uffff\uffff\u0000\u00b0\u00b1"+
		"\u0003\u001a\r\u0000\u00b1\u00b2\u0005\u001a\u0000\u0000\u00b2\u00b3\u0006"+
		"\u000b\uffff\uffff\u0000\u00b3\u00b4\u0005\u001e\u0000\u0000\u00b4\u00b5"+
		"\u0006\u000b\uffff\uffff\u0000\u00b5\u0017\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0003\u001c\u000e\u0000\u00b7\u00bf\u0006\f\uffff\uffff\u0000\u00b8"+
		"\u00b9\u0007\u0000\u0000\u0000\u00b9\u00ba\u0006\f\uffff\uffff\u0000\u00ba"+
		"\u00bb\u0003\u001c\u000e\u0000\u00bb\u00bc\u0006\f\uffff\uffff\u0000\u00bc"+
		"\u00be\u0001\u0000\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00be"+
		"\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u0019\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c8\u0003\u0018\f\u0000\u00c3\u00c4"+
		"\u0007\u0001\u0000\u0000\u00c4\u00c5\u0006\r\uffff\uffff\u0000\u00c5\u00c7"+
		"\u0003\u0018\f\u0000\u00c6\u00c3\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u001b\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0005\u0012\u0000\u0000\u00cc\u00d6\u0006"+
		"\u000e\uffff\uffff\u0000\u00cd\u00ce\u0005\u0011\u0000\u0000\u00ce\u00d6"+
		"\u0006\u000e\uffff\uffff\u0000\u00cf\u00d0\u0005\u0013\u0000\u0000\u00d0"+
		"\u00d6\u0006\u000e\uffff\uffff\u0000\u00d1\u00d2\u0005\u0019\u0000\u0000"+
		"\u00d2\u00d3\u0003\u001a\r\u0000\u00d3\u00d4\u0005\u001a\u0000\u0000\u00d4"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d5\u00cb\u0001\u0000\u0000\u0000\u00d5"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d5\u00cf\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d6\u001d\u0001\u0000\u0000\u0000\u000e"+
		"$5@ENat~\u0083\u009c\u00a7\u00bf\u00c8\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}