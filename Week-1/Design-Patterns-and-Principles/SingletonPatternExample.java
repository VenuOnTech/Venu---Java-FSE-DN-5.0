public class SingletonPatternExample {

    static class Logger {
        private static Logger loggerInstance;

        private Logger() {
        }

        public static synchronized Logger getInstance() {
            if (loggerInstance == null) {
                loggerInstance = new Logger();
            }
            return loggerInstance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger 1: " + logger1);
        System.out.println("Logger 2: " + logger2);

        logger1.log("Application started");
        logger2.log("User logged in");

        if (logger1 == logger2) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Instances are different. Singleton pattern is not working.");
        }
    }
}