package parser.helpers;

import ast.StatementInfo;
import org.antlr.v4.runtime.ParserRuleContext;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;

public class ParsingHelper
{
    public static StatementInfo info(ParserRuleContext context, String ... tags){
        return new StatementInfo(context.start.getLine(),scalaList(tags));
    }

    public static <T> List<T> scalaList(T ... ts)
    {
        List<T> result = List$.MODULE$.empty();
        for(int i = ts.length; i > 0; i--)
        {
            result = new $colon$colon(ts[i - 1], result);
        }
        return result;
    }

    public static <T> List<T> scalaList(java.util.List<T> l)
    {
        List<T> result = List$.MODULE$.empty();
        for(int i = l.size(); i > 0; i--)
        {
            result = new $colon$colon(l.get(i - 1), result);
        }
        return result;
    }

    public static ast.Type typeObject(String t)
    {
        return ParsingHelperScala.typeObjectScala(t);
    }

    public static ast.Operator operatorObject(String op, int arity) { return ParsingHelperScala.operatorObjectScala(op, arity); }
}
