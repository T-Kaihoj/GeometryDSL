import analyzer.MasterAnalyzer;
import executor.Executor;
import executor.ValuePrettifier;
import logger.Logger;
import optimizer.MasterOptimizer;
import syntaxTree.Program;
import transpilation.Transpilation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        ProgramOptions options = new ProgramOptions(args);

        if(options.programFileName == null)
        {
            System.out.println("No program file specified");
            return;
        }

        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(options.programFileName);
        }catch(IOException e){
            System.out.println("Could not find file: " + options.programFileName);
            return;
        }

        CustomGdslParser parser = new CustomGdslParser();
        Program program = parser.parse(inputStream);

        if(options.optimize)
        {
            program = MasterOptimizer.transform(MasterAnalyzer.transform(program));
        }

        Executor executor = new Executor();
        if (options.execute){
            System.out.println(ValuePrettifier.toString(executor.executeProgram(program, options.programMainFunctionName), 0));
        }

        if (options.transpile) {
            Transpilation transpilation = new Transpilation();
            System.out.println(transpilation.convert(program));
        }

        Logger logger = Logger.getInstance();
        System.out.print(logger.toString());
    }

    private static class ProgramOptions {
        public String programFileName;
        public String programMainFunctionName = "main";

        public boolean optimize;
        public boolean execute;
        public boolean transpile;

        public ProgramOptions(String[] args) {
            List<String> argList = Arrays.asList(args);

            argList.forEach(arg -> {
                if(!arg.startsWith("-"))
                {
                    programFileName = arg;
                }

                if(arg.startsWith("-f=") || arg.startsWith("--function="))
                {
                    programMainFunctionName = arg.substring(arg.indexOf("=") + 1);
                }

                if(arg.equals("-o") || arg.equals("--optimize"))
                {
                    optimize = true;
                }
                if(arg.equals("-e") || arg.equals("--execute"))
                {
                    execute = true;
                }

                if(arg.equals("-t") || arg.equals("--transpile"))
                {
                    transpile = true;
                }
            });
        }
    }
}
