package compiler.ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IfCommand implements Command
{
    private String expression;
    private List<Command> trueList = new ArrayList<>();
    private List<Command> falseList = new ArrayList<>();



    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("if (").append(expression).append(") {").append("\n");

        trueList.forEach(x -> sb.append(x.generateJavaCode()).append("\n"));

        sb.append("}").append("\n");

        if (!falseList.isEmpty()) {
            sb.append("else {").append("\n");

            falseList.forEach(x -> sb.append(x.generateJavaCode()).append("\n"));

            sb.append("}").append("\n");
        }

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

        sb.append("if ").append(expression).append(":\n");

        trueList.forEach(x -> sb.append("\t").append(x.generatePythonCode()).append("\n"));

        if (!falseList.isEmpty()) {
            sb.append("else:\n");

            falseList.forEach(x -> sb.append("\t").append(x.generatePythonCode()).append("\n"));
        }

        return sb.toString();
    }
}
