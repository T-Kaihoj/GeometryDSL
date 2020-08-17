package optimizer;

import ast.Program;
import ast.*;

import java.util.ArrayList;
import java.util.List;

public class IdentifierErrors extends BaseOptimizer {
    @Override
    public OptimizerData run(OptimizerData data) {
        List<ValueDefinition> valueDefinitions =new ArrayList<>();
        List<String>strings = new ArrayList<>();
        data.tree.prog().foreach(v ->
        {if(v.getClass() == ValueDefinition.class)
            valueDefinitions.add((ValueDefinition)v);
            return null;
        } );
        valueDefinitions.forEach(valueDefinition ->
        {
            if (strings.contains(valueDefinition.decl().name()))
                data.messagesList.add(new Messages(Messages.Priority.Error,"IdentifierErrors",valueDefinition.info().lineNumber()));
            strings.add(valueDefinition.decl().name());
        });


        return data;
    }
}
