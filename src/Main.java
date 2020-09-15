import analyzer.RelationChecker;
import executor.Executor;
import logger.Message;
import logger.Logger;
import syntaxTree.Program;
import transpilation.Transpilation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception
    {
        CustomGdslParser parser = new CustomGdslParser();
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
        Transpilation transpilation = new Transpilation();
        System.out.println(transpilation.convert(program));
        System.out.println(executor.executeProgram(program, "main"));

        Logger logger = Logger.getInstance();
        System.out.print(logger.toString());
        RelationChecker.transform(program);
    }
}
