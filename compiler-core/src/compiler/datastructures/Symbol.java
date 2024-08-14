package compiler.datastructures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public abstract class Symbol
{
	protected String name;

	public abstract String generateJavaDeclarationCode();
	public abstract String generateClangDeclarationCode();
}
