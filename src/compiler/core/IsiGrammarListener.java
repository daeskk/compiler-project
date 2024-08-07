// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiGrammarParser}.
 */
public interface IsiGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiGrammarParser.ProgContext ctx);
}