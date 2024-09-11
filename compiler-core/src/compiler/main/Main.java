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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

			// Print para verificar o conteúdo da lista de resultados antes de acessar os índices
			System.out.println("Results List Size: " + context.results.size());

			FileWriter writer = new FileWriter(grammarParser.getCodeGenerator().getProgramName() + ".java");
			writer.write(context.results.get(ProgrammingLanguage.JAVA.ordinal()));
			writer.close();

			writer = new FileWriter(grammarParser.getCodeGenerator().getProgramName() + ".cpp");
			writer.write(context.results.get(ProgrammingLanguage.CPP.ordinal()));
			writer.close();

			// Verificação para Python
			if (context.results.size() > ProgrammingLanguage.PYTHON.ordinal()) {
				writer = new FileWriter(grammarParser.getCodeGenerator().getProgramName() + ".py");
				writer.write(context.results.get(ProgrammingLanguage.PYTHON.ordinal()));
				writer.close();
			} else {
				System.out.println("Python code generation failed or was not added to results.");
			}

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
        String errorMessage = "";
		String sourceCode = "";

		IsiGrammarLexer grammarLexer;
		IsiGrammarParser grammarParser = null;
		CommonTokenStream commonTokenStream;

		try
		{
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

        return new CompileFileResponse(
				sourceCode,
				grammarParser != null ? grammarParser.getWarningList() : new ArrayList<>(),
				errorMessage);
    }
}
