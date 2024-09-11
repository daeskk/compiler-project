package main.java.com.compilerapi;

import compiler.main.Main;
import main.java.dto.CompileFileRequest;
import main.java.dto.CompileFileResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/compiler")
public class CompilerApiController
{
    @PostMapping
    public CompileFileResponse compileFile(@RequestBody CompileFileRequest compileFileRequest)
    {
        return Main.run(compileFileRequest);
    }
}
