package compiler.ast;

import compiler.datastructures.Variable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadCommand implements Command
{
    private Variable variable;

    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(variable.getName()).append(" = ");

        switch (variable.getType()) {
            case Variable.INTEGER -> sb.append("_sc.nextInt(); _sc.nextLine();");
            case Variable.FLOAT   -> sb.append("_sc.nextFloat(); _sc.nextLine();");
            case Variable.STRING  -> sb.append("_sc.nextLine();");
        }


        return sb.toString();
    }

    @Override
    public String generateClangCode()
    {
        return "";
    }
}