import ast.Program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.z3.Context;
import executor.Executor;
import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.OptimizerData;

public class Main {
    public static void main(String[] args) throws Exception {
        Z3Test.run();
    }
}
