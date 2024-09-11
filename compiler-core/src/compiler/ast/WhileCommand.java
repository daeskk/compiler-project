package compiler.ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WhileCommand implements Command
{
    private String expression;
    private List<Command> commandList;

    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while (").append(expression).append(") {").append("\n");

        commandList.forEach(x -> sb.append(x.generateJavaCode()).append("\n"));

        sb.append("}").append("\n");

        return sb.toString();
    }

    @Override
    public String generateCppCode()
    {
        return "";
    }

    @Override
    public String generatePythonCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while ").append(expression).append(":\n");

        commandList.forEach(x -> sb.append("\t").append(x.generatePythonCode()).append("\n"));

        return sb.toString();
    }
}
