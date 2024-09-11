package compiler.ast;

import compiler.datastructures.SymbolTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enums.ProgrammingLanguage;

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

    private boolean hasScanner = false;

    public String generateTarget(ProgrammingLanguage programmingLanguage)
    {
        switch (programmingLanguage)
        {
            case ProgrammingLanguage.JAVA ->
            {
                return generateJavaFile();
            }
            case ProgrammingLanguage.CPP ->
            {
                return generateCppFile();
            }
        }

        return "";
    }

    private String generateJavaFile()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("import java.util.*; \n");
        stringBuilder.append("public class ").append(programName).append(" { \n");
        stringBuilder.append("\tpublic static void main(String args[]) {\n");

        if (hasScanner) {
            stringBuilder.append("\t\tScanner _sc = new Scanner(System.in);\n");
        }


        symbolTable.generateList().forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateJavaDeclarationCode())
                .append("\n"));

        commands.forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateJavaCode())
                .append("\n"));

        if (hasScanner) {
            stringBuilder.append("\t\t_sc.close();\n");
        }

        stringBuilder.append("\n");
        stringBuilder.append("\t}\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }

    private String generateCppFile()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("#include <iostream>; \n");
        stringBuilder.append("int main() { \n");

        symbolTable.generateList().forEach(x -> stringBuilder
                .append("\t")
                .append(x.generateCppDeclarationCode())
                .append("\n"));

        commands.forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateCppCode())
                .append("\n"));

        stringBuilder.append("\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
