package compiler.datastructures;

import compiler.exceptions.CodeGenerationException;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class Variable extends Symbol
{
	public static final int INTEGER = 0;
	public static final int DOUBLE  = 1;
	public static final int STRING  = 2;
	
	private int 	type;
	private boolean initialized;
	private boolean used;

	public Variable(int varType, String varName, boolean initialized, boolean used)
	{
		super(varName);

		this.type = varType;
		this.initialized = initialized;
		this.used = used;
	}

	@Override
	public String generateJavaDeclarationCode()
	{
		StringBuilder sb = new StringBuilder();

		switch (type)
		{
            case Variable.INTEGER -> sb.append("int ");
			case Variable.DOUBLE  -> sb.append("double ");
            case Variable.STRING  -> sb.append("String ");

			default -> throw new CodeGenerationException("Unrecognized type");
        }

		sb.append(name).append(";");

		return sb.toString();
	}

	@Override
	public String generateCppDeclarationCode()
	{
		StringBuilder sb = new StringBuilder();

		switch (type)
		{
			case Variable.INTEGER -> sb.append("int ");
			case Variable.DOUBLE  -> sb.append("float ");
			case Variable.STRING  -> sb.append("string ");

			default -> throw new CodeGenerationException("Unrecognized type");
		}

		sb.append(name).append(";");

		return sb.toString();
	}

	@Override
	public String toString()
	{
		return "Variable{" +
				"type=" + type +
				", initialized=" + initialized +
				", used=" + used +
				", name='" + name + '\'' +
				'}';
	}
}
