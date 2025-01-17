package compiler.ast;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class WriteCommand implements Command
{
    String id;

    @Override
    public String generateJavaCode()
    {
        return "System.out.println(" + id + ");";
    }

    @Override
    public String generateCppCode()
    {
        return "std::cout << " + id + " << std::endl" + ";";
    }

    @Override
    public String generateKotlinCode() {
        return "println(" + id + ")";
    }
}
