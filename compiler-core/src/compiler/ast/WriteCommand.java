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
    public String generateClangCode()
    {
        return "";
    }
}