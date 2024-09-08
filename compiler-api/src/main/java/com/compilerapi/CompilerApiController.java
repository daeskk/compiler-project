package main.java.com.compilerapi;

import compiler.main.CompilerCompileFileRequest;
import compiler.main.Main;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/compiler")
public class CompilerApiController
{
    @PostMapping
    public void compileFile(@RequestBody CompilerCompileFileRequest compilerCompileFileRequest)
    {
        Object o = Main.run();


    }
}
