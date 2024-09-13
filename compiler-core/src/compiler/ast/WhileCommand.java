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
        StringBuilder sb = new StringBuilder();

        sb.append("while (").append(expression).append(") {").append("\n");

        commandList.forEach(x -> sb.append(x.generateCppCode()).append("\n"));

        sb.append("}").append("\n");

        return sb.toString();
    }

    @Override
    public String generateKotlinCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while (").append(expression).append(") {\n");
        commandList.forEach(x -> sb.append("\t").append(x.generateKotlinCode()).append("\n"));
        sb.append("}");

        return sb.toString();
    }
}
