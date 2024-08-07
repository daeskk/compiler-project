package compiler.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import compiler.core.IsiGrammarLexer;
import compiler.core.IsiGrammarParser;

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
			
			System.out.println("Running the compiler...");
			
			grammarParser.prog();
			
			System.out.println("Compilation successful.");	
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}
