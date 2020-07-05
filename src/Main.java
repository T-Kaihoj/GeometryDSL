import ast.ProgramEntity;

import java.io.FileInputStream;
import java.io.IOException;

import ast.ValueDefinition;
import executor.*;
import parser.helpers.ParsingHelper;
import parser.helpers.ParsingHelperScala;
import scala.collection.immutable.Nil;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        GdslParse gdslParse  = new GdslParse();
        ProgramEntity x = gdslParse.parse("a:int := Test(15+15+12, 15, 1, s.a.r,select(x in A, all(y in A, gt(x,y))) , false) \n"+
                "type bbox(minX:number, minY:number, maxX:number, maxY:number)\n" +
                "Set max (A:Set) (return select(x in A, all(y in A, gt(x,y))))"
        );

        Variable y = Executor.executeStatement((ValueDefinition)x, ParsingHelper.scalaList()).head();

        System.out.println(y);
    }
}
