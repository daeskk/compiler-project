package compiler.datastructures;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Variable extends Symbol
{
	public static final int INTEGER = 0;
	public static final int FLOAT   = 1;
	public static final int STRING  = 2;
	
	private int type;
	private boolean initialized;

	public Variable(int varType, String varName, boolean initialized)
	{
		super(varName);

		this.type = varType;
		this.initialized = initialized;
	}

	@Override
	public String toString()
	{
		return "Variable{" +
				"name='" + name + '\'' +
				", initialized=" + initialized +
				", type=" + type +
				'}';
	}
}
