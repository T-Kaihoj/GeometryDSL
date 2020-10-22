import analyzer.MasterAnalyzer;
import executor.Executor;
import executor.ValuePrettifier;
import logger.Logger;
import logger.Severity;
import optimizer.MasterOptimizer;
import syntaxTree.Program;
import syntaxTree.StaticTypeChecker;
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
        StaticTypeChecker.check(program);
        Logger logger = Logger.getInstance();
        System.out.print(logger.toString(options.infoLevel));

        if(options.optimize)
        {
            try {
                program = MasterOptimizer.transform(MasterAnalyzer.transform(program));
            } catch (Exception err) {
                Logger.log(Severity.Warning,"Optimization of '" + options.programFileName + "' resulted in exception:\n\t " + err,-1);
            }
        }

        Executor executor = new Executor();
        if (options.execute){
            System.out.println(ValuePrettifier.toString(executor.executeProgram(program, options.programMainFunctionName), 0));
        }

        if (options.transpile) {
            Transpilation transpilation = new Transpilation();
            System.out.println(transpilation.convert(program));
        }
    }

    private static class ProgramOptions {
        public String programFileName;
        public String programMainFunctionName = "main";

        public boolean optimize;
        public boolean execute;
        public boolean transpile;
        public logger.Severity infoLevel = Severity.Warning;

        public ProgramOptions(String[] args) {
            List<String> argList = Arrays.asList(args);
            argList.forEach(arg -> {
                if(!arg.startsWith("-"))
                {
                    programFileName = arg;
                }

                if(arg.startsWith("--function="))
                {
                    programMainFunctionName = arg.substring(arg.indexOf("=") + 1);
                }

                if(arg.startsWith("-") && !arg.substring(1).startsWith("-") && arg.substring(1).contains("o") ||
                    arg.equals("--optimize"))
                {
                    optimize = true;
                }

                if(arg.startsWith("-") && !arg.substring(1).startsWith("-") && arg.substring(1).contains("e") ||
                    arg.equals("--execute"))
                {
                    execute = true;
                }

                if(arg.startsWith("-") && !arg.substring(1).startsWith("-") && arg.substring(1).contains("t") ||
                    arg.equals("--transpile"))
                {
                    transpile = true;
                }

                if(arg.startsWith("--infolevel="))
                {
                    String level = arg.substring(arg.indexOf("=") + 1);
                    if(level.equals("error")) {
                        infoLevel = Severity.Error;
                    } else if(level.equals("warning")) {
                        infoLevel = Severity.Warning;
                    } else if(level.equals("info")) {
                        infoLevel = Severity.Info;
                    }
                }
            });
        }
    }
}
