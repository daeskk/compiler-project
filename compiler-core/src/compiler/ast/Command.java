package compiler.ast;

public interface Command
{
    String generateJavaCode();

    String generateClangCode();
}
