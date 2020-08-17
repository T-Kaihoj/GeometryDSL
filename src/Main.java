import ast.Program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import executor.Executor;
import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.Messages;
import optimizer.OptimizerData;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

public class Main {
    public static void main(String[] args) throws Exception {
        GdslParse gdslParse  = new GdslParse();
        InputStream inputStream;
        Program x;
        String file = "examples/testing.gdsl";
        try {
            inputStream = new FileInputStream(file);
            x = gdslParse.parse(inputStream);
            System.out.println(x);

            Executor executor = new Executor();
            System.out.println(executor.executeProgram(x, "main"));

            IdentifierErrors identifierErrors = new IdentifierErrors();

            List<BaseOptimizer> optimizerList= new LinkedList<>();
            optimizerList.add(identifierErrors);

            OptimizerData data = new OptimizerData(x,new LinkedList<>(),new LinkedList<>());
            for (BaseOptimizer baseOptimizer : optimizerList) {
                data = baseOptimizer.run(data);
            }

            data.messagesList.forEach(messages ->  System.out.println(messages));

        } catch (IOException e) {
            System.out.println(file);
            e.printStackTrace();
        }
    }
}
