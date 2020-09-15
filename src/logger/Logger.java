package logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {
    private static final Logger SINGLETON_MESSAGE_QUEUE = new Logger();

    private final List<Message> messageList = new ArrayList<>();

    private Logger() {}

    public static Logger getInstance() {
        return SINGLETON_MESSAGE_QUEUE;
    }

    public static void log(Message.Severity severity, String message, int lineNumber) {
        getInstance().add(new Message(severity, message, lineNumber));
    }

    public void add(Message message) {
        messageList.add(message);
    }

    public String toString() {
        return toString(Message.Severity.Warning);
    }

    public String toString(Message.Severity severityLevel) {
        List<Message> sortedMessageList = messageList.stream()
            .filter(m -> m.severity.getLevel() <= severityLevel.getLevel())
            .sorted(Comparator.comparingInt(o -> o.severity.getLevel()))
            .sorted(Comparator.comparingInt(o -> o.lineNumber)).collect(Collectors.toList());

        String finalMessage = "";
        for (Message message : sortedMessageList) {
            finalMessage = finalMessage.concat(message.toString()).concat("\n");
        }
        return finalMessage;
    }
}
