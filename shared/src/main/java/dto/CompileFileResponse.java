package main.java.dto;

import java.util.List;

public record CompileFileResponse(
        String sourceCode,
        List<String> errors,
        String errorMessage
)
{
}
