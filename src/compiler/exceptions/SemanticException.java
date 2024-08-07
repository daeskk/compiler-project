package compiler.exceptions;

public class SemanticException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public SemanticException(String message)
	{
		super(message);
	}
}
