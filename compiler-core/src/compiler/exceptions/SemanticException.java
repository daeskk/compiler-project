package compiler.exceptions;

import java.io.Serial;

public class SemanticException extends RuntimeException
{
	@Serial
	private static final long serialVersionUID = 1L;
	
	public SemanticException(String message)
	{
		super(message);
	}
}
