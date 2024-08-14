package compiler.ast;

import compiler.datastructures.SymbolTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CodeGenerator
{
    private SymbolTable symbolTable;

    public void generateTarget()
    {
        String s = generateJavaFile();

        System.out.println(s);


//        String s2 = generateClangFile();
//
//        System.out.println(s2);
    }

    private String generateJavaFile()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("import java.util.*; \n");
        stringBuilder.append("public class MainClass { \n");
        stringBuilder.append("\tpublic static void main(String args[]) {\n");

        symbolTable.generateList().forEach(x -> stringBuilder
                .append("\t\t")
                .append(x.generateJavaDeclarationCode())
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

        stringBuilder.append("\n");
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
