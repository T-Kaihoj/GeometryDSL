package logger;

public class Message {
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

    public enum Severity {
        Error(0),
        Warning(1),
        Info(2);

        private final int severityLevel;

        Severity(int severity){ severityLevel = severity; }
        public int getLevel() { return severityLevel; }
    }
}
