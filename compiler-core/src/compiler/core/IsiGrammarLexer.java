// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

    import main.java.enums.*;
    import compiler.datastructures.*;
    import compiler.exceptions.*;
    import compiler.ast.*;

    import java.util.stream.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsiGrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "RELOPERATOR", "TEXT", 
			"NUMBER", "IDENTIFIER", "PLUS", "MINUS", "MUL", "DIV", "COMMA", "LEFTPARENTHESIS", 
			"RIGHTPARENTHESIS", "OPENBRACKETS", "CLOSEBRACKETS", "DP", "DOT", "DOUBLEQUOTE", 
			"WS"
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

		
		private int _varType;
		private Integer _exprLeftType = -1, _exprRightType = null;
		private boolean _breakUsable = false;
		private boolean _hasScanner = false;

		private String _varName, _exprLeftVarname, top, _lastContent, temp;

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

	    private List<String> warnings = new ArrayList<>();

	    public CodeGenerator getCodeGenerator() {
	        return codeGenerator;
	    }

	    public List<String> getWarningList() {
	        return warnings;
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

		public String convertTypeToString(int type) {
		    switch (type) {
		        case Variable.INTEGER:
		            return "Integer";
		        case Variable.DOUBLE:
		            return "Double";
	            case Variable.STRING:
	                return "String";
	            default: return "unknown";
		    }
		}

		public void checkTypes(int type) {
	        if (_exprLeftType == -1) {
	            return;
	        }
		    if (_exprLeftType != type) {
	            throw new SemanticException("Symbol '" + _exprLeftVarname + "' can't receive a '" + convertTypeToString(type) + "' value");
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
	            warnings.add("Warning: Uninitialized variables: " + uninitializedList.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(", ", "[", "]")));
	        }
		}

		public void checkOperatorType(String operator) {
		    if (_exprLeftType == Variable.STRING && !operator.equals("+")) {
		        throw new SemanticException("Operator '" + operator + "' is not allowed for the variable '" + _exprLeftVarname + "' of type 'string'");
		    }
		}

		public void verifyUnusedVariables() {
	        if(_symbolTable.generateUnusedList().size() > 0) {
	            List<String> unusedListVariables = _symbolTable.generateUnusedList()
	                                                               .stream()
	                                                               .map(x -> x.getName())
	                                                               .toList();
	            System.out.println("Warning: Unused variables: " + unusedListVariables);
	            warnings.add("Warning: Unused variables: " + unusedListVariables.stream().collect(Collectors.joining(", ", "[", "]")));

	        }
		}

		public void checkBreak() {
	        if (!_breakUsable)
	            throw new SemanticException("Command 'parar' must be used inside a loop.");
	    }


	public IsiGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiGrammar.g4"; }

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
		"\u0004\u0000 \u00eb\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00b0\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0004\u0010\u00b4\b\u0010\u000b\u0010\f\u0010\u00b5\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0004\u0011\u00bb\b\u0011\u000b\u0011\f\u0011\u00bc"+
		"\u0001\u0011\u0001\u0011\u0004\u0011\u00c1\b\u0011\u000b\u0011\f\u0011"+
		"\u00c2\u0003\u0011\u00c5\b\u0011\u0001\u0012\u0003\u0012\u00c8\b\u0012"+
		"\u0001\u0012\u0005\u0012\u00cb\b\u0012\n\u0012\f\u0012\u00ce\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0000\u0000 \u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? \u0001\u0000\u0006\u0002\u0000<<"+
		">>\u0004\u0000  09AZaz\u0001\u000009\u0002\u0000AZaz\u0003\u000009AZa"+
		"z\u0003\u0000\t\n\r\r  \u00f3\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0001A\u0001\u0000\u0000\u0000\u0003J\u0001\u0000\u0000\u0000"+
		"\u0005R\u0001\u0000\u0000\u0000\u0007Z\u0001\u0000\u0000\u0000\tb\u0001"+
		"\u0000\u0000\u0000\u000bi\u0001\u0000\u0000\u0000\rp\u0001\u0000\u0000"+
		"\u0000\u000fv\u0001\u0000\u0000\u0000\u0011{\u0001\u0000\u0000\u0000\u0013"+
		"\u0083\u0001\u0000\u0000\u0000\u0015\u0086\u0001\u0000\u0000\u0000\u0017"+
		"\u008c\u0001\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000\u001b"+
		"\u0095\u0001\u0000\u0000\u0000\u001d\u009e\u0001\u0000\u0000\u0000\u001f"+
		"\u00af\u0001\u0000\u0000\u0000!\u00b1\u0001\u0000\u0000\u0000#\u00ba\u0001"+
		"\u0000\u0000\u0000%\u00c7\u0001\u0000\u0000\u0000\'\u00cf\u0001\u0000"+
		"\u0000\u0000)\u00d1\u0001\u0000\u0000\u0000+\u00d3\u0001\u0000\u0000\u0000"+
		"-\u00d5\u0001\u0000\u0000\u0000/\u00d7\u0001\u0000\u0000\u00001\u00d9"+
		"\u0001\u0000\u0000\u00003\u00db\u0001\u0000\u0000\u00005\u00dd\u0001\u0000"+
		"\u0000\u00007\u00df\u0001\u0000\u0000\u00009\u00e1\u0001\u0000\u0000\u0000"+
		";\u00e3\u0001\u0000\u0000\u0000=\u00e5\u0001\u0000\u0000\u0000?\u00e7"+
		"\u0001\u0000\u0000\u0000AB\u0005p\u0000\u0000BC\u0005r\u0000\u0000CD\u0005"+
		"o\u0000\u0000DE\u0005g\u0000\u0000EF\u0005r\u0000\u0000FG\u0005a\u0000"+
		"\u0000GH\u0005m\u0000\u0000HI\u0005a\u0000\u0000I\u0002\u0001\u0000\u0000"+
		"\u0000JK\u0005f\u0000\u0000KL\u0005i\u0000\u0000LM\u0005m\u0000\u0000"+
		"MN\u0005p\u0000\u0000NO\u0005r\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005"+
		"g\u0000\u0000Q\u0004\u0001\u0000\u0000\u0000RS\u0005d\u0000\u0000ST\u0005"+
		"e\u0000\u0000TU\u0005c\u0000\u0000UV\u0005l\u0000\u0000VW\u0005a\u0000"+
		"\u0000WX\u0005r\u0000\u0000XY\u0005e\u0000\u0000Y\u0006\u0001\u0000\u0000"+
		"\u0000Z[\u0005i\u0000\u0000[\\\u0005n\u0000\u0000\\]\u0005t\u0000\u0000"+
		"]^\u0005e\u0000\u0000^_\u0005g\u0000\u0000_`\u0005e\u0000\u0000`a\u0005"+
		"r\u0000\u0000a\b\u0001\u0000\u0000\u0000bc\u0005d\u0000\u0000cd\u0005"+
		"o\u0000\u0000de\u0005u\u0000\u0000ef\u0005b\u0000\u0000fg\u0005l\u0000"+
		"\u0000gh\u0005e\u0000\u0000h\n\u0001\u0000\u0000\u0000ij\u0005s\u0000"+
		"\u0000jk\u0005t\u0000\u0000kl\u0005r\u0000\u0000lm\u0005i\u0000\u0000"+
		"mn\u0005n\u0000\u0000no\u0005g\u0000\u0000o\f\u0001\u0000\u0000\u0000"+
		"pq\u0005p\u0000\u0000qr\u0005a\u0000\u0000rs\u0005r\u0000\u0000st\u0005"+
		"a\u0000\u0000tu\u0005r\u0000\u0000u\u000e\u0001\u0000\u0000\u0000vw\u0005"+
		"l\u0000\u0000wx\u0005e\u0000\u0000xy\u0005i\u0000\u0000yz\u0005a\u0000"+
		"\u0000z\u0010\u0001\u0000\u0000\u0000{|\u0005e\u0000\u0000|}\u0005s\u0000"+
		"\u0000}~\u0005c\u0000\u0000~\u007f\u0005r\u0000\u0000\u007f\u0080\u0005"+
		"e\u0000\u0000\u0080\u0081\u0005v\u0000\u0000\u0081\u0082\u0005a\u0000"+
		"\u0000\u0082\u0012\u0001\u0000\u0000\u0000\u0083\u0084\u0005s\u0000\u0000"+
		"\u0084\u0085\u0005e\u0000\u0000\u0085\u0014\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005e\u0000\u0000\u0087\u0088\u0005n\u0000\u0000\u0088\u0089\u0005"+
		"t\u0000\u0000\u0089\u008a\u0005a\u0000\u0000\u008a\u008b\u0005o\u0000"+
		"\u0000\u008b\u0016\u0001\u0000\u0000\u0000\u008c\u008d\u0005s\u0000\u0000"+
		"\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005n\u0000\u0000\u008f\u0090"+
		"\u0005a\u0000\u0000\u0090\u0091\u0005o\u0000\u0000\u0091\u0018\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005:\u0000\u0000\u0093\u0094\u0005=\u0000\u0000"+
		"\u0094\u001a\u0001\u0000\u0000\u0000\u0095\u0096\u0005e\u0000\u0000\u0096"+
		"\u0097\u0005n\u0000\u0000\u0097\u0098\u0005q\u0000\u0000\u0098\u0099\u0005"+
		"u\u0000\u0000\u0099\u009a\u0005a\u0000\u0000\u009a\u009b\u0005n\u0000"+
		"\u0000\u009b\u009c\u0005t\u0000\u0000\u009c\u009d\u0005o\u0000\u0000\u009d"+
		"\u001c\u0001\u0000\u0000\u0000\u009e\u009f\u0005e\u0000\u0000\u009f\u00a0"+
		"\u0005x\u0000\u0000\u00a0\u00a1\u0005e\u0000\u0000\u00a1\u00a2\u0005c"+
		"\u0000\u0000\u00a2\u00a3\u0005u\u0000\u0000\u00a3\u00a4\u0005t\u0000\u0000"+
		"\u00a4\u00a5\u0005e\u0000\u0000\u00a5\u001e\u0001\u0000\u0000\u0000\u00a6"+
		"\u00b0\u0007\u0000\u0000\u0000\u00a7\u00a8\u0005<\u0000\u0000\u00a8\u00b0"+
		"\u0005=\u0000\u0000\u00a9\u00aa\u0005>\u0000\u0000\u00aa\u00b0\u0005="+
		"\u0000\u0000\u00ab\u00ac\u0005!\u0000\u0000\u00ac\u00b0\u0005=\u0000\u0000"+
		"\u00ad\u00ae\u0005=\u0000\u0000\u00ae\u00b0\u0005=\u0000\u0000\u00af\u00a6"+
		"\u0001\u0000\u0000\u0000\u00af\u00a7\u0001\u0000\u0000\u0000\u00af\u00a9"+
		"\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b0 \u0001\u0000\u0000\u0000\u00b1\u00b3\u0003"+
		"=\u001e\u0000\u00b2\u00b4\u0007\u0001\u0000\u0000\u00b3\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0003=\u001e\u0000\u00b8\"\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0007\u0002\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c4\u0001\u0000\u0000"+
		"\u0000\u00be\u00c0\u0005.\u0000\u0000\u00bf\u00c1\u0007\u0002\u0000\u0000"+
		"\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00be\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5$\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c8\u0007\u0003\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cc\u0001\u0000\u0000\u0000\u00c9\u00cb\u0007\u0004\u0000\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"&\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0005+\u0000\u0000\u00d0(\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005-"+
		"\u0000\u0000\u00d2*\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005*\u0000\u0000"+
		"\u00d4,\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005/\u0000\u0000\u00d6."+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005,\u0000\u0000\u00d80\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005(\u0000\u0000\u00da2\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005)\u0000\u0000\u00dc4\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0005{\u0000\u0000\u00de6\u0001\u0000\u0000\u0000\u00df\u00e0\u0005}"+
		"\u0000\u0000\u00e08\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005:\u0000\u0000"+
		"\u00e2:\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005.\u0000\u0000\u00e4<"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\"\u0000\u0000\u00e6>\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0007\u0005\u0000\u0000\u00e8\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0006\u001f\u0000\u0000\u00ea@\u0001\u0000"+
		"\u0000\u0000\n\u0000\u00af\u00b3\u00b5\u00bc\u00c2\u00c4\u00c7\u00ca\u00cc"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}