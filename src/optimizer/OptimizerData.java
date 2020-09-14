package optimizer;

import logger.Message;
import syntaxTree.Program;

import java.util.List;

public class OptimizerData {
    public Program tree;
    public List<Message> messageList;
    public List<CodeChanges> changesList;

    public OptimizerData(Program tree, List<Message> messageList, List<CodeChanges> changesList) {
        this.tree = tree;
        this.messageList = messageList;
        this.changesList = changesList;

    }


    class CodeChanges {
    }
}
