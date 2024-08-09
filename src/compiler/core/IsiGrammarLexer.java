// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

	import compiler.datastructures.*;
	import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;

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
		T__9=10, T__10=11, T__11=12, RELOPERATOR=13, TEXT=14, NUMBER=15, IDENTIFIER=16, 
		PLUS=17, MINUS=18, MUL=19, DIV=20, COMMA=21, LEFTPARENTHESIS=22, RIGHTPARENTHESIS=23, 
		OPENBRACKETS=24, CLOSEBRACKETS=25, DP=26, DOT=27, DOUBLEQUOTE=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "RELOPERATOR", "TEXT", "NUMBER", "IDENTIFIER", 
			"PLUS", "MINUS", "MUL", "DIV", "COMMA", "LEFTPARENTHESIS", "RIGHTPARENTHESIS", 
			"OPENBRACKETS", "CLOSEBRACKETS", "DP", "DOT", "DOUBLEQUOTE", "WS"
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
		"\u0004\u0000\u001d\u00cf\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0094\b\f\u0001\r\u0001\r\u0004\r\u0098\b\r\u000b\r\f\r\u0099"+
		"\u0001\r\u0001\r\u0001\u000e\u0004\u000e\u009f\b\u000e\u000b\u000e\f\u000e"+
		"\u00a0\u0001\u000e\u0001\u000e\u0004\u000e\u00a5\b\u000e\u000b\u000e\f"+
		"\u000e\u00a6\u0003\u000e\u00a9\b\u000e\u0001\u000f\u0003\u000f\u00ac\b"+
		"\u000f\u0001\u000f\u0005\u000f\u00af\b\u000f\n\u000f\f\u000f\u00b2\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0006\u0002\u0000"+
		"<<>>\u0004\u0000  09AZaz\u0001\u000009\u0002\u0000AZaz\u0003\u000009A"+
		"Zaz\u0003\u0000\t\n\r\r  \u00d7\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
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
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;"+
		"\u0001\u0000\u0000\u0000\u0003D\u0001\u0000\u0000\u0000\u0005L\u0001\u0000"+
		"\u0000\u0000\u0007T\u0001\u0000\u0000\u0000\t[\u0001\u0000\u0000\u0000"+
		"\u000bb\u0001\u0000\u0000\u0000\rg\u0001\u0000\u0000\u0000\u000fo\u0001"+
		"\u0000\u0000\u0000\u0011r\u0001\u0000\u0000\u0000\u0013x\u0001\u0000\u0000"+
		"\u0000\u0015~\u0001\u0000\u0000\u0000\u0017\u0081\u0001\u0000\u0000\u0000"+
		"\u0019\u0093\u0001\u0000\u0000\u0000\u001b\u0095\u0001\u0000\u0000\u0000"+
		"\u001d\u009e\u0001\u0000\u0000\u0000\u001f\u00ab\u0001\u0000\u0000\u0000"+
		"!\u00b3\u0001\u0000\u0000\u0000#\u00b5\u0001\u0000\u0000\u0000%\u00b7"+
		"\u0001\u0000\u0000\u0000\'\u00b9\u0001\u0000\u0000\u0000)\u00bb\u0001"+
		"\u0000\u0000\u0000+\u00bd\u0001\u0000\u0000\u0000-\u00bf\u0001\u0000\u0000"+
		"\u0000/\u00c1\u0001\u0000\u0000\u00001\u00c3\u0001\u0000\u0000\u00003"+
		"\u00c5\u0001\u0000\u0000\u00005\u00c7\u0001\u0000\u0000\u00007\u00c9\u0001"+
		"\u0000\u0000\u00009\u00cb\u0001\u0000\u0000\u0000;<\u0005p\u0000\u0000"+
		"<=\u0005r\u0000\u0000=>\u0005o\u0000\u0000>?\u0005g\u0000\u0000?@\u0005"+
		"r\u0000\u0000@A\u0005a\u0000\u0000AB\u0005m\u0000\u0000BC\u0005a\u0000"+
		"\u0000C\u0002\u0001\u0000\u0000\u0000DE\u0005f\u0000\u0000EF\u0005i\u0000"+
		"\u0000FG\u0005m\u0000\u0000GH\u0005p\u0000\u0000HI\u0005r\u0000\u0000"+
		"IJ\u0005o\u0000\u0000JK\u0005g\u0000\u0000K\u0004\u0001\u0000\u0000\u0000"+
		"LM\u0005d\u0000\u0000MN\u0005e\u0000\u0000NO\u0005c\u0000\u0000OP\u0005"+
		"l\u0000\u0000PQ\u0005a\u0000\u0000QR\u0005r\u0000\u0000RS\u0005e\u0000"+
		"\u0000S\u0006\u0001\u0000\u0000\u0000TU\u0005n\u0000\u0000UV\u0005u\u0000"+
		"\u0000VW\u0005m\u0000\u0000WX\u0005b\u0000\u0000XY\u0005e\u0000\u0000"+
		"YZ\u0005r\u0000\u0000Z\b\u0001\u0000\u0000\u0000[\\\u0005s\u0000\u0000"+
		"\\]\u0005t\u0000\u0000]^\u0005r\u0000\u0000^_\u0005i\u0000\u0000_`\u0005"+
		"n\u0000\u0000`a\u0005g\u0000\u0000a\n\u0001\u0000\u0000\u0000bc\u0005"+
		"l\u0000\u0000cd\u0005e\u0000\u0000de\u0005i\u0000\u0000ef\u0005a\u0000"+
		"\u0000f\f\u0001\u0000\u0000\u0000gh\u0005e\u0000\u0000hi\u0005s\u0000"+
		"\u0000ij\u0005c\u0000\u0000jk\u0005r\u0000\u0000kl\u0005e\u0000\u0000"+
		"lm\u0005v\u0000\u0000mn\u0005a\u0000\u0000n\u000e\u0001\u0000\u0000\u0000"+
		"op\u0005s\u0000\u0000pq\u0005e\u0000\u0000q\u0010\u0001\u0000\u0000\u0000"+
		"rs\u0005e\u0000\u0000st\u0005n\u0000\u0000tu\u0005t\u0000\u0000uv\u0005"+
		"a\u0000\u0000vw\u0005o\u0000\u0000w\u0012\u0001\u0000\u0000\u0000xy\u0005"+
		"s\u0000\u0000yz\u0005e\u0000\u0000z{\u0005n\u0000\u0000{|\u0005a\u0000"+
		"\u0000|}\u0005o\u0000\u0000}\u0014\u0001\u0000\u0000\u0000~\u007f\u0005"+
		":\u0000\u0000\u007f\u0080\u0005=\u0000\u0000\u0080\u0016\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005n\u0000\u0000\u0083"+
		"\u0084\u0005q\u0000\u0000\u0084\u0085\u0005u\u0000\u0000\u0085\u0086\u0005"+
		"a\u0000\u0000\u0086\u0087\u0005n\u0000\u0000\u0087\u0088\u0005t\u0000"+
		"\u0000\u0088\u0089\u0005o\u0000\u0000\u0089\u0018\u0001\u0000\u0000\u0000"+
		"\u008a\u0094\u0007\u0000\u0000\u0000\u008b\u008c\u0005<\u0000\u0000\u008c"+
		"\u0094\u0005=\u0000\u0000\u008d\u008e\u0005>\u0000\u0000\u008e\u0094\u0005"+
		"=\u0000\u0000\u008f\u0090\u0005!\u0000\u0000\u0090\u0094\u0005=\u0000"+
		"\u0000\u0091\u0092\u0005=\u0000\u0000\u0092\u0094\u0005=\u0000\u0000\u0093"+
		"\u008a\u0001\u0000\u0000\u0000\u0093\u008b\u0001\u0000\u0000\u0000\u0093"+
		"\u008d\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u001a\u0001\u0000\u0000\u0000\u0095"+
		"\u0097\u00037\u001b\u0000\u0096\u0098\u0007\u0001\u0000\u0000\u0097\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u00037\u001b\u0000\u009c\u001c\u0001"+
		"\u0000\u0000\u0000\u009d\u009f\u0007\u0002\u0000\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u009e\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0005.\u0000\u0000\u00a3\u00a5\u0007\u0002"+
		"\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u001e\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ac\u0007\u0003\u0000\u0000\u00ab\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00b0\u0001\u0000\u0000\u0000\u00ad\u00af\u0007\u0004"+
		"\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1 \u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0005+\u0000\u0000\u00b4\"\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0005-\u0000\u0000\u00b6$\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0005*\u0000\u0000\u00b8&\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005/"+
		"\u0000\u0000\u00ba(\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005,\u0000\u0000"+
		"\u00bc*\u0001\u0000\u0000\u0000\u00bd\u00be\u0005(\u0000\u0000\u00be,"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005)\u0000\u0000\u00c0.\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005{\u0000\u0000\u00c20\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0005}\u0000\u0000\u00c42\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0005:\u0000\u0000\u00c64\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005."+
		"\u0000\u0000\u00c86\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\"\u0000"+
		"\u0000\u00ca8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u0005\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0006\u001c\u0000\u0000"+
		"\u00ce:\u0001\u0000\u0000\u0000\n\u0000\u0093\u0097\u0099\u00a0\u00a6"+
		"\u00a8\u00ab\u00ae\u00b0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}