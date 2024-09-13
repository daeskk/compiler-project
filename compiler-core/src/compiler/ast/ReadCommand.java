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
            case Variable.DOUBLE  -> sb.append("_sc.nextDouble(); _sc.nextLine();");
            case Variable.STRING  -> sb.append("_sc.nextLine();");
        }


        return sb.toString();
    }

    @Override
    public String generateCppCode()
    {
        return "std::cin >> " + variable.getName() + ";";
    }

    @Override
    public String generateKotlinCode() {
        return switch (variable.getType()) {
            case Variable.INTEGER -> variable.getName() + " = readLine()!!.toInt()";
            case Variable.DOUBLE  -> variable.getName() + " = readLine()!!.toDouble()";
            case Variable.STRING  -> variable.getName() + " = readLine()!!";
            default -> throw new IllegalStateException("Unexpected value: " + variable.getType());
        };
    }
}
