package compiler.ast;

public interface Command
{
    String generateJavaCode();

    String generateCppCode();
}
