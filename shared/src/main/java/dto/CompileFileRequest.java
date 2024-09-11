package main.java.dto;

import main.java.enums.ProgrammingLanguage;

public record CompileFileRequest(
        String sourceCode,
        ProgrammingLanguage programmingLanguage
)
{
}
