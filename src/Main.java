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

        if(options.isSelfTest)
        {
            SelfTest.run();
            return;
        }

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

        if(options.optimize)
        {
            try {
                program = MasterOptimizer.transform(MasterAnalyzer.transform(program));
            } catch (Exception err) {
                Logger.log(Severity.Warning,"Optimization of '" + options.programFileName + "' resulted in exception:\n\t " + err,-1);
            }
        }

        Executor executor = new Executor();
        String executionOutput = "";
        if (options.execute){
            try {
                executionOutput = ValuePrettifier.toString(executor.executeProgram(program, options.programMainFunctionName), 0);
            } catch (logger.Message mes) {
                logger.Logger.getInstance().add(mes);
            } catch(Exception err) {
                throw err;
                //Logger.log(Severity.Error, err.getMessage(), -1);
            }
        }

        if (options.transpile) {
            Transpilation transpilation = new Transpilation();
            System.out.println(transpilation.convert(program));
        }

        Logger logger = Logger.getInstance();
        System.out.print(logger.toString(options.infoLevel));
        System.out.println(executionOutput);
    }
}
