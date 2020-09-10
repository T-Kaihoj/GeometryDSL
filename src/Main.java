import analyzer.RelationChecker;
import ast.Program;
import executor.Executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import executor.Executor;
import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.Messages;
import optimizer.OptimizerData;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import transpilation.Transpilation;

public class Main {
    public static void main(String[] args) throws Exception
    {
        CustomGdslParser parser = new CustomGdslParser();
        InputStream inputStream = null;
        String fileName = "examples/boundingBox.gdsl";

        try{
            inputStream = new FileInputStream(fileName);
        }catch(IOException e){
            System.out.println("Could not find file: " + fileName);
            return;
        }

        Program program = parser.parse(inputStream);

        Executor executor = new Executor();
        Transpilation transpilation = new Transpilation();
        System.out.println(transpilation.convert(program));
        executor.executeProgram(program, "main");

        RelationChecker.checkRelations(program);
    }
}
