package logger;

public class Message extends Exception {
    public String message;
    public Severity severity;
    public int lineNumber;

    public Message(Severity severity, String message, int line) {
        this.message = message;
        this.severity = severity;
        this.lineNumber = line;
    }

    @Override
    public String toString() {
        return "[" + lineNumber + " " + severity.name().toUpperCase() + "]: " + message;
    }
}
