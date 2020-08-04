package optimizer;

public class Messages {
    private int line;

    public Messages(Priority priority, String message, int line) {
    this.message =message;
    this.priority = priority;
    this.line =line;
    }

    @Override
    public String toString() {
        return  priority.name()+"(L:"+ line +") : " + message ;
        //+ message
    }

    public String message;
    public Priority priority;

    public enum Priority  {
        Error,
        Warning,
        Info
    }
}