package compiler.ast;

public interface Command
{
    String generateJavaCode();

    String generateCppCode();

    String generateKotlinCode();
}
