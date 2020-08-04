package optimizer;

import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;

public class OptimizerHelper {
    public static <T> List<T> scalaList(T ... ts)
    {
        List<T> result = List$.MODULE$.empty();
        for(int i = ts.length; i > 0; i--)
        {
            result = new $colon$colon(ts[i - 1], result);
        }
        return result;
    }
}
