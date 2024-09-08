package compiler.ast;

import compiler.datastructures.SymbolTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CodeGenerator
{
    private String programName;

    private SymbolTable symbolTable;

    private List<Command> commands;

    public void generateTarget()
    {
        try
        {
            String javaCode = generateJavaFile();

            System.out.println(javaCode);

            FileWriter writer = new FileWriter(programName + ".java");
            writer.write(javaCode);
            writer.close();

            String clangCode = generateClangFile();

            System.out.println(clangCode);

            writer = new FileWriter(programName + ".c");
            writer.write(clangCode);
            writer.close();
        }
        catch (IOException ignored)
        {

        }
    }

    private String generateJavaFile()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("import java.util.*; \n");
        stringBuilder.append("public class ").append(programName).append(" { \n");
        stringBuilder.append("\tpublic static void main(String args[]) {\n");
        stringBuilder.append("\t\tScanner _sc = new Scanner(System.in);\n");

        symbolTable.generateList().forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateJavaDeclarationCode())
                .append("\n"));

        commands.forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateJavaCode())
                .append("\n"));

        stringBuilder.append("\n");
        stringBuilder.append("\t}\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }

    private String generateClangFile()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("#include <stdio.h>; \n");
        stringBuilder.append("int main() { \n");

        symbolTable.generateList().forEach(x -> stringBuilder
                .append("\t")
                .append(x.generateClangDeclarationCode())
                .append("\n"));

        commands.forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateClangCode())
                .append("\n"));

        stringBuilder.append("\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
