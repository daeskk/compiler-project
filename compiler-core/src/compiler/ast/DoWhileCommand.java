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
}
