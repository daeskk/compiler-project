// Generated from IsiGrammar.g4 by ANTLR 4.13.2
package compiler.core;

    import compiler.datastructures.*;
    import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;

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
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(IsiGrammarParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(IsiGrammarParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterVartype(IsiGrammarParser.VartypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitVartype(IsiGrammarParser.VartypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(IsiGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(IsiGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiGrammarParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiGrammarParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmdread}.
	 * @param ctx the parse tree
	 */
	void enterCmdread(IsiGrammarParser.CmdreadContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmdread}.
	 * @param ctx the parse tree
	 */
	void exitCmdread(IsiGrammarParser.CmdreadContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmdwrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdwrite(IsiGrammarParser.CmdwriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmdwrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdwrite(IsiGrammarParser.CmdwriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(IsiGrammarParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(IsiGrammarParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdexpr(IsiGrammarParser.CmdexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdexpr(IsiGrammarParser.CmdexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdwhile(IsiGrammarParser.CmdwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdwhile(IsiGrammarParser.CmdwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#cmddowhile}.
	 * @param ctx the parse tree
	 */
	void enterCmddowhile(IsiGrammarParser.CmddowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#cmddowhile}.
	 * @param ctx the parse tree
	 */
	void exitCmddowhile(IsiGrammarParser.CmddowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(IsiGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(IsiGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(IsiGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(IsiGrammarParser.FactorContext ctx);
}