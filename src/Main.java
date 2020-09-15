import analyzer.RelationChecker;
import executor.Executor;
import logger.Message;
import logger.Logger;
import syntaxTree.Program;
import transpilation.Transpilation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        ProgramOptions options = new ProgramOptions(args);
        
        CustomGdslParser parser = new CustomGdslParser();
        InputStream inputStream = null;
        String fileName = "examples/circleIntersection.gdsl";

        try{
            inputStream = new FileInputStream(options.fileName);
        }catch(IOException e){
            System.out.println("Could not find file: " + fileName);
            return;
        }

        Program program = parser.parse(inputStream);
        Executor executor = new Executor();
        if (options.isTranspilation) {
            Transpilation transpilation = new Transpilation();
            System.out.println(transpilation.convert(program));
        }
        if (options.isExecutor){
            System.out.println(executor.executeProgram(program, options.executorFunctionName));
        }

        if (options.isRelationChecker) {
            Logger logger = Logger.getInstance();
            System.out.print(logger.toString());
            RelationChecker.transform(program);
        }
    }

    private static class ProgramOptions {
        public String fileName;
        public boolean isRelationChecker;
        public String executorFunctionName;
        public boolean isExecutor;
        public boolean isTranspilation;

        public ProgramOptions(String[] args) {
            List<String> input = Arrays.asList(args);
            isExecutor= true;
            isRelationChecker= input.contains("-r")|| input.contains("--relation");
            isTranspilation= input.contains("-t")|| input.contains("--transpilation");
            input.forEach(s -> {
                if(!s.startsWith("-"))
                    fileName =s;
            });
            executorFunctionName= "main";
        }
    }
}
