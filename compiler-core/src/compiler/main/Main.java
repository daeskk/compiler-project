package compiler.main;

import compiler.core.IsiGrammarLexer;
import compiler.core.IsiGrammarParser;
import compiler.exceptions.CodeGenerationException;
import main.java.dto.CompileFileRequest;
import main.java.dto.CompileFileResponse;
import main.java.enums.ProgrammingLanguage;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import compiler.exceptions.SemanticException;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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

			IsiGrammarParser.ProgContext context = grammarParser.prog();

			FileWriter writer = new FileWriter(grammarParser.getCodeGenerator().getProgramName() + ".java");
			writer.write(context.results.get(ProgrammingLanguage.JAVA.ordinal()));
			writer.close();

			writer = new FileWriter(grammarParser.getCodeGenerator().getProgramName() + ".cpp");
			writer.write(context.results.get(ProgrammingLanguage.CPP.ordinal()));
			writer.close();

			System.out.println("Compilation successful.");
		} catch (SemanticException e)
		{
			System.err.println("Semantic error occurred: " + e.getMessage());
		} catch (Exception e)
		{
			System.err.println("Generic error occurred: " + e.getMessage());
		}
	}

	public static CompileFileResponse run(CompileFileRequest compileFileRequest)
	{
		List<String> warnings = new ArrayList<>();
		String errorMessage = "";
		String sourceCode = "";

		try
		{
			IsiGrammarLexer grammarLexer;
			IsiGrammarParser grammarParser;
			CommonTokenStream commonTokenStream;

			grammarLexer = new IsiGrammarLexer(CharStreams.fromString(compileFileRequest.sourceCode()));
			commonTokenStream = new CommonTokenStream(grammarLexer);
			grammarParser = new IsiGrammarParser(commonTokenStream);

			IsiGrammarParser.ProgContext context = grammarParser.prog();

			sourceCode = context.results.get(compileFileRequest.programmingLanguage().ordinal());
		} catch (SemanticException e)
		{
			errorMessage = "Semantic error occurred: " + e.getMessage();
		} catch (CodeGenerationException e)
		{
			errorMessage = "Code generation error occurred: " + e.getMessage();
		} catch (Exception e)
		{
			errorMessage = "An unexpected error occurred.";
		}
		
        return new CompileFileResponse(sourceCode, warnings, errorMessage);
    }
}
