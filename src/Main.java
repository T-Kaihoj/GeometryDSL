import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        GdslParse gdslParse  = new GdslParse();
        gdslParse.parse("a:int := 15+15+12");

    }
}
