
public class TestLog {
    public static void main(String[] args) {
        Logger logOne = Logger.getInstance();
        logOne.writeLog("Application started");
        Logger logTwo = Logger.getInstance();
        logTwo.writeLog("User logged in");
        if (logOne == logTwo) {
            System.out.println("Same logger used across the app");
        } else {
            System.out.println("Different logger instances found");
        }
    }
}
