import ast.Program;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.Messages;
import optimizer.OptimizerData;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

public class Main {
    public static void main(String[] args) throws Exception {
        GdslParse gdslParse  = new GdslParse();
        System.out.println("Hello world");
        InputStream inputStream;
        Program x;
        String file = "Example/testin.gdsl";
        try {
            inputStream = new FileInputStream(file);
            x = gdslParse.parse(inputStream);

            IdentifierErrors identifierErrors = new IdentifierErrors();

            List<BaseOptimizer> optimizerList= new LinkedList<>();
            optimizerList.add(identifierErrors);

            OptimizerData data = new OptimizerData(x,new LinkedList<>(),new LinkedList<>());
            for (BaseOptimizer baseOptimizer : optimizerList) {
                data = baseOptimizer.run(data);
            }

            data.messagesList.forEach(messages ->  System.out.println(messages));

            System.out.println(x);
        } catch (IOException e) {
            System.out.println(file);
            e.printStackTrace();
        }
    }
}
