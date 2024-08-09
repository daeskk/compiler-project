package compiler.datastructures;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Variable extends Symbol
{
	public static final int NUMBER = 0;
	public static final int STRING = 1;
	
	private int type;
	private String value;

	public Variable(int varType, String varName, String varValue)
	{
		super(varName);

		this.type = varType;
		this.value = varValue;
	}

	@Override
	public String toString()
	{
		return "Variable{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				", type=" + type +
				'}';
	}
}
