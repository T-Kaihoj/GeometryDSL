import analyzer.MasterAnalyzer;
import executor.Executor;
import optimizer.MasterOptimizer;
import syntaxTree.Program;
import transpilation.Transpilation;

public class SelfTest {
    //private static String optimizerStr;
    private static String executorStr ="type Circle(x: int, y: int, r: int)\n" +"\n" +"bool intersects(a: Circle, b: Circle)\n(\n return (a.x - b.x)^2 + (a.y - b.y)^2 <= (a.r + b.r)^2\n" +")\n" +"\n" +"bool rel(a: Int, b: Int)\n" +"(\n" +"    return a + b > 4\n" +")\n" +            "\n" +            "bool main()\n" +            "(\n" +            "    C: Circle := Circle(4, 2, 1)\n" +            "    return intersects(C, C)\n" +            ")\n";

    public static void run() {
        System.out.println("Running self test:");
        int i = 0;
        i =+ testParser();
        i =+ testOptimizer();
        i =+ testExecutor();
        i =+ testTranspiler();
        System.out.println(i == 0 ? "Everything is working correctly" : "Something went wrong in your installation");
    }

    private static int testParser() {
        System.out.print("Testing Parser... ");

        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
        } catch (Exception err) {
            System.out.println("Not ok");
            return -1;
        }
        System.out.println("Ok");
        return 0;
    }

    private static int testTranspiler() {
        System.out.print("Testing Transpiler... ");

        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            Transpilation transpilation = new Transpilation();
            transpilation.convert(program);
        }catch (Exception err) {
            System.out.println("Not ok");
            return -1;
        }
        System.out.println("Ok");
        return 0;
    }

    private static int testExecutor() {
        System.out.print("Testing Executor... ");

        try {
            Executor executor = new Executor();
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            executor.executeProgram(program, "main");
        } catch (Exception err) {
            System.out.println("Not Ok");
            return -1;
        }
        System.out.println("Ok");
        return 0;
    }


    private static int testOptimizer() {
        System.out.print("Testing Optimizer... ");
        try {
            CustomGdslParser parser = new CustomGdslParser();
            Program program = parser.parse(executorStr);
            MasterOptimizer.transform(MasterAnalyzer.transform(program));
        } catch (Exception err) {
            System.out.println("Not ok");
            return -1;
        }
        System.out.println("Ok");
        return 0;
    }

}

