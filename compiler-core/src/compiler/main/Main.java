package compiler.main;

import compiler.ast.CodeGenerator;
import compiler.core.IsiGrammarLexer;
import compiler.core.IsiGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import compiler.exceptions.SemanticException;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			IsiGrammarLexer grammarLexer;
			IsiGrammarParser grammarParser;
			CommonTokenStream commonTokenStream;

			grammarLexer = new IsiGrammarLexer(CharStreams.fromFileName("input.isi"));
			commonTokenStream = new CommonTokenStream(grammarLexer);
			grammarParser = new IsiGrammarParser(commonTokenStream);

			System.out.println("Compilation started..");

			grammarParser.prog();

			System.out.println("Compilation successful.");
		} catch (SemanticException e)
		{
			System.err.println("Semantic error occurred: " + e.getMessage());
		} catch (Exception e)
		{
			System.err.println("Generic error occurred: " + e.getMessage());
		}
	}

	public static Object run()
	{
		return null;
	}
}
