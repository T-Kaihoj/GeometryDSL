import ast.Program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import optimizer.BaseOptimizer;
import optimizer.IdentifierErrors;
import optimizer.Messages;
import optimizer.OptimizerData;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        GdslParse gdslParse  = new GdslParse();
        Program x = gdslParse.parse(
                "a:int := Test(15+15+12, 15, 1, s.a.r,select(x in A, all(y in A, gt(x,y))) , false) \n"+
                "type bbox(minX:number, minY:number, maxX:number, maxY:number)\n" +
                "Set max (A:Set) (return select(x in A, all(y in A, gt(x,y))))" +
                "b:int := 54"
        );
        IdentifierErrors identifierErrors = new IdentifierErrors();

        List<BaseOptimizer> optimizerList= new LinkedList<>();
        optimizerList.add(identifierErrors);

        OptimizerData data = new OptimizerData(x,new LinkedList<>(),new LinkedList<>());
        for (BaseOptimizer baseOptimizer : optimizerList) {
            data = baseOptimizer.run(data);
        }

        data.messagesList.forEach(messages ->  System.out.println(messages));

        System.out.println(x);
    }
}
