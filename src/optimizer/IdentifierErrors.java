package optimizer;

import logger.Message;
import syntaxTree.*;

import java.util.ArrayList;
import java.util.List;

public class IdentifierErrors extends BaseOptimizer {
    @Override
    public OptimizerData run(OptimizerData data) {
        List<ValueDefinition> valueDefinitions =new ArrayList<>();
        List<String>strings = new ArrayList<>();
        data.tree.program().foreach(v ->
        {if(v.getClass() == ValueDefinition.class)
            valueDefinitions.add((ValueDefinition)v);
            return null;
        } );
        valueDefinitions.forEach(valueDefinition ->
        {
            if (strings.contains(valueDefinition.decl().name()))
                data.messageList.add(new Message(Message.Severity.Error,"IdentifierErrors",valueDefinition.info().lineNumber()));
            strings.add(valueDefinition.decl().name());
        });


        return data;
    }
}
