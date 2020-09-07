import analyser.RelationChecker;
import ast.Program;
import executor.Executor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception
    {
        GdslParse parser = new GdslParse();
        InputStream inputStream = null;
        String fileName = "examples/circleIntersection.gdsl";

        try{
            inputStream = new FileInputStream(fileName);
        }catch(IOException e){
            System.out.println("Could not find file: " + fileName);
            return;
        }

        Program program = parser.parse(inputStream);
        Executor executor = new Executor();
        System.out.println(executor.executeProgram(program, "main"));

        RelationChecker.checkRelations(program);
    }
}
