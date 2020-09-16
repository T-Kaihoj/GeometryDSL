package logger;

public enum Severity {
    Error(0),
    Warning(1),
    Info(2);

    private final int severityLevel;

    Severity(int severity){ severityLevel = severity; }
    public int getLevel() { return severityLevel; }
}
