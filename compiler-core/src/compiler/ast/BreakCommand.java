package compiler.ast;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BreakCommand implements Command
{
    @Override
    public String generateJavaCode()
    {
        return "break;\n";
    }

    @Override
    public String generateCppCode()
    {
        return "break;\n";
    }


    @Override
    public String generateKotlinCode() {
        return "break";
    }
}
