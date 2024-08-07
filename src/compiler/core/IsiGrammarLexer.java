// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;
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
		RELOPERATOR=10, TEXT=11, NUMBER=12, IDENTIFIER=13, PLUS=14, MINUS=15, 
		MUL=16, DIV=17, COMMA=18, LEFTPARENTHESIS=19, RIGHTPARENTHESIS=20, OPENBRACKETS=21, 
		CLOSEBRACKETS=22, DP=23, DOT=24, DOUBLEQUOTE=25, WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"RELOPERATOR", "TEXT", "NUMBER", "IDENTIFIER", "PLUS", "MINUS", "MUL", 
			"DIV", "COMMA", "LEFTPARENTHESIS", "RIGHTPARENTHESIS", "OPENBRACKETS", 
			"CLOSEBRACKETS", "DP", "DOT", "DOUBLEQUOTE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", "':='", null, null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "','", "'('", "')'", "'{'", "'}'", "':'", "'.'", 
			"'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "RELOPERATOR", 
			"TEXT", "NUMBER", "IDENTIFIER", "PLUS", "MINUS", "MUL", "DIV", "COMMA", 
			"LEFTPARENTHESIS", "RIGHTPARENTHESIS", "OPENBRACKETS", "CLOSEBRACKETS", 
			"DP", "DOT", "DOUBLEQUOTE", "WS"
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
		"\u0004\u0000\u001a\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tw\b"+
		"\t\u0001\n\u0001\n\u0004\n{\b\n\u000b\n\f\n|\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000b\u0082\b\u000b\u000b\u000b\f\u000b\u0083\u0001\f\u0003\f\u0087"+
		"\b\f\u0001\f\u0005\f\u008a\b\f\n\f\f\f\u008d\t\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0000\u0000\u001a\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a\u0001\u0000"+
		"\u0006\u0002\u0000<<>>\u0004\u0000  09AZaz\u0001\u000009\u0002\u0000A"+
		"Zaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  \u00b0\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001"+
		"\u0000\u0000\u0000\u0003>\u0001\u0000\u0000\u0000\u0005F\u0001\u0000\u0000"+
		"\u0000\u0007N\u0001\u0000\u0000\u0000\tS\u0001\u0000\u0000\u0000\u000b"+
		"[\u0001\u0000\u0000\u0000\r^\u0001\u0000\u0000\u0000\u000fd\u0001\u0000"+
		"\u0000\u0000\u0011j\u0001\u0000\u0000\u0000\u0013v\u0001\u0000\u0000\u0000"+
		"\u0015x\u0001\u0000\u0000\u0000\u0017\u0081\u0001\u0000\u0000\u0000\u0019"+
		"\u0086\u0001\u0000\u0000\u0000\u001b\u008e\u0001\u0000\u0000\u0000\u001d"+
		"\u0090\u0001\u0000\u0000\u0000\u001f\u0092\u0001\u0000\u0000\u0000!\u0094"+
		"\u0001\u0000\u0000\u0000#\u0096\u0001\u0000\u0000\u0000%\u0098\u0001\u0000"+
		"\u0000\u0000\'\u009a\u0001\u0000\u0000\u0000)\u009c\u0001\u0000\u0000"+
		"\u0000+\u009e\u0001\u0000\u0000\u0000-\u00a0\u0001\u0000\u0000\u0000/"+
		"\u00a2\u0001\u0000\u0000\u00001\u00a4\u0001\u0000\u0000\u00003\u00a6\u0001"+
		"\u0000\u0000\u000056\u0005p\u0000\u000067\u0005r\u0000\u000078\u0005o"+
		"\u0000\u000089\u0005g\u0000\u00009:\u0005r\u0000\u0000:;\u0005a\u0000"+
		"\u0000;<\u0005m\u0000\u0000<=\u0005a\u0000\u0000=\u0002\u0001\u0000\u0000"+
		"\u0000>?\u0005f\u0000\u0000?@\u0005i\u0000\u0000@A\u0005m\u0000\u0000"+
		"AB\u0005p\u0000\u0000BC\u0005r\u0000\u0000CD\u0005o\u0000\u0000DE\u0005"+
		"g\u0000\u0000E\u0004\u0001\u0000\u0000\u0000FG\u0005d\u0000\u0000GH\u0005"+
		"e\u0000\u0000HI\u0005c\u0000\u0000IJ\u0005l\u0000\u0000JK\u0005a\u0000"+
		"\u0000KL\u0005r\u0000\u0000LM\u0005e\u0000\u0000M\u0006\u0001\u0000\u0000"+
		"\u0000NO\u0005l\u0000\u0000OP\u0005e\u0000\u0000PQ\u0005i\u0000\u0000"+
		"QR\u0005a\u0000\u0000R\b\u0001\u0000\u0000\u0000ST\u0005e\u0000\u0000"+
		"TU\u0005s\u0000\u0000UV\u0005c\u0000\u0000VW\u0005r\u0000\u0000WX\u0005"+
		"e\u0000\u0000XY\u0005v\u0000\u0000YZ\u0005a\u0000\u0000Z\n\u0001\u0000"+
		"\u0000\u0000[\\\u0005s\u0000\u0000\\]\u0005e\u0000\u0000]\f\u0001\u0000"+
		"\u0000\u0000^_\u0005e\u0000\u0000_`\u0005n\u0000\u0000`a\u0005t\u0000"+
		"\u0000ab\u0005a\u0000\u0000bc\u0005o\u0000\u0000c\u000e\u0001\u0000\u0000"+
		"\u0000de\u0005s\u0000\u0000ef\u0005e\u0000\u0000fg\u0005n\u0000\u0000"+
		"gh\u0005a\u0000\u0000hi\u0005o\u0000\u0000i\u0010\u0001\u0000\u0000\u0000"+
		"jk\u0005:\u0000\u0000kl\u0005=\u0000\u0000l\u0012\u0001\u0000\u0000\u0000"+
		"mw\u0007\u0000\u0000\u0000no\u0005<\u0000\u0000ow\u0005=\u0000\u0000p"+
		"q\u0005>\u0000\u0000qw\u0005=\u0000\u0000rs\u0005!\u0000\u0000sw\u0005"+
		"=\u0000\u0000tu\u0005=\u0000\u0000uw\u0005=\u0000\u0000vm\u0001\u0000"+
		"\u0000\u0000vn\u0001\u0000\u0000\u0000vp\u0001\u0000\u0000\u0000vr\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000w\u0014\u0001\u0000\u0000"+
		"\u0000xz\u00031\u0018\u0000y{\u0007\u0001\u0000\u0000zy\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u00031\u0018\u0000\u007f"+
		"\u0016\u0001\u0000\u0000\u0000\u0080\u0082\u0007\u0002\u0000\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u0018\u0001\u0000\u0000\u0000\u0085\u0087\u0007\u0003\u0000\u0000\u0086"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u008b\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0007\u0004\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u001a\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005+\u0000\u0000\u008f\u001c"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005-\u0000\u0000\u0091\u001e\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0005*\u0000\u0000\u0093 \u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005/\u0000\u0000\u0095\"\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005,\u0000\u0000\u0097$\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005(\u0000\u0000\u0099&\u0001\u0000\u0000\u0000\u009a\u009b\u0005)"+
		"\u0000\u0000\u009b(\u0001\u0000\u0000\u0000\u009c\u009d\u0005{\u0000\u0000"+
		"\u009d*\u0001\u0000\u0000\u0000\u009e\u009f\u0005}\u0000\u0000\u009f,"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005:\u0000\u0000\u00a1.\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005.\u0000\u0000\u00a30\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0005\"\u0000\u0000\u00a52\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0007\u0005\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0006\u0019\u0000\u0000\u00a94\u0001\u0000\u0000\u0000\b\u0000"+
		"vz|\u0083\u0086\u0089\u008b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}