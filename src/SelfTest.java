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

public class SelfTest {
    //private static String optimizerStr;
    private static String executorStr ="type Circle(x: int, y: int, r: int)\n" +"\n" +"bool intersects(a: Circle, b: Circle)\n(\n return (a.x - b.x)^2 + (a.y - b.y)^2 <= (a.r + b.r)^2\n" +")\n" +"\n" +"bool rel(a: Int, b: Int)\n" +"(\n" +"    return a + b > 4\n" +")\n" +            "\n" +            "bool main()\n" +            "(\n" +            "    C: Circle := Circle(4, 2, 1)\n" +            "    return intersects(C, C)\n" +            ")\n";

    public static void run() {
        System.out.println("Running Self test:");
        int i = 0;
        i =+ testparser();
        i =+ testOptimization();
        i =+ testExecutor();
        i =+ testTranspile();
        System.out.println();
        System.out.println(i==0? "Everything is working correctly":"Something went wrong in your installation");
    }

    private static int testparser() {
        System.out.println("Testing parser");

        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
        }catch (Exception err) {
            System.out.println("Error: parser is not ok");
            return -1;
        }
        System.out.println("parser is ok");
        return 0;
    }
    private static int testTranspile() {
        System.out.println("Testing transpile");

        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            Transpilation transpilation = new Transpilation();
            transpilation.convert(program);
        }catch (Exception err) {
            System.out.println("Error: Optimization is not ok");
            return -1;
        }
        System.out.println("transpile is ok");
        return 0;
    }

    private static int testExecutor() {
        System.out.println("Testing Executor");

        try {
            Executor executor = new Executor();
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            executor.executeProgram(program, "Executor");
        }catch (Exception err) {
            System.out.println("Error: Executor is not ok");
            return -1;
        }
        System.out.println("Executor is ok ");
        return 0;
    }


    private static int testOptimization() {
        System.out.println("Testing Optimization");
        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            program = MasterOptimizer.transform(MasterAnalyzer.transform(program));
        } catch (Exception err) {
            System.out.println("Error: Optimization is not functioning");
            return -1;
        }
        System.out.println("Optimization is ok");
        return 0;
    }

}

