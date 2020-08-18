import ast.Program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import executor.Executor;
import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.OptimizerData;

public class Main {
    public static void main(String[] args) throws Exception {
        GdslParse gdslParse  = new GdslParse();
        InputStream inputStream;
        Program x;
        String file = "examples/boundingBox.gdsl";
        try {
            inputStream = new FileInputStream(file);
            x = gdslParse.parse(inputStream);

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
