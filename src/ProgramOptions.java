import logger.Severity;

import java.util.Arrays;
import java.util.List;

public class ProgramOptions {
    public String programFileName;
    public String programMainFunctionName = "main";
    public static ProgramOptions  instance = null;
    public boolean optimize;
    public boolean execute;
    public boolean transpile;
    public boolean isSelfTest;
    public logger.Severity infoLevel = Severity.Warning;

    public static ProgramOptions getInstance()
    {
        return instance;
    }
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

            if(arg.equals("--test"))
            {
                isSelfTest = true;
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