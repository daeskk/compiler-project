package compiler.ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttrCommand implements Command
{
    private String id;
    private String expression;

    @Override
    public String generateJavaCode()
    {
        return id + " = " + expression + ";";
    }

    @Override
    public String generateCppCode()
    {
        return "";
    }

    @Override
    public String generatePythonCode() {
        return id + " = " + expression;
    }
}
