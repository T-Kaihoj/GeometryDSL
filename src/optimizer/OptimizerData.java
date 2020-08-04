package optimizer;

import ast.AST;
import ast.Program;

import java.util.List;

public class OptimizerData {
    public Program tree;
    public List<Messages> messagesList;
    public List<CodeChanges> changesList;

    public OptimizerData(Program tree, List<Messages> messagesList, List<CodeChanges> changesList) {
        this.tree = tree;
        this.messagesList = messagesList;
        this.changesList = changesList;

    }


    class CodeChanges {
    }
}
