package compiler.ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoWhileCommand implements Command
{
    private String expression;
    private List<Command> commandList;

    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("do {").append("\n");

        commandList.forEach(x -> sb.append(x.generateJavaCode()).append("\n"));

        sb.append("}").append("while (").append(expression).append(");").append("\n");

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

        sb.append("while True:").append("\n");

        commandList.forEach(x -> sb.append("\t").append(x.generatePythonCode()).append("\n"));

        sb.append("\tif not (").append(expression).append("):").append("\n");
        sb.append("\t\tbreak").append("\n");

        return sb.toString();
    }
}
