package parser.helpers;

import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;

public class ParsingHelper
{
    public static <T> List<T> scalaList(T ... ts)
    {
        List<T> result = List$.MODULE$.empty();
        for(int i = ts.length; i > 0; i--)
        {
            result = new $colon$colon(ts[i - 1], result);
        }
        return result;
    }

    public static ast.Type typeObject(String t)
    {
        return ParsingHelperScala.typeObjectScala(t);
    }

    public static ast.Operator operatorObject(String op, int arity) { return ParsingHelperScala.operatorObjectScala(op, arity); }
}
