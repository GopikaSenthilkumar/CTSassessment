
public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger initialized");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeLog(String content) {
        System.out.println("[LOG] " + content);
    }
}
