package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class ErrorLogger {

    private static Logger logger;
    private static FileHandler fileHandler;

    static {
        try {
            // Create logs directory if it doesn't exist
            new java.io.File("logs").mkdirs();

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String logFile = "logs/error_log_" + timestamp + ".log";

            logger = Logger.getLogger("ErrorLogger");
            fileHandler = new FileHandler(logFile, true); // Append mode

            // Custom formatter with date and time per log entry
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis()));
                    return String.format("[%s] %s: %s%n", date, record.getLevel(), record.getMessage());
                }
            });

            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Prevent console logging

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logError(String message, Throwable t) {
        logger.severe(message);
        if (t != null) {
            logger.severe(t.toString());
        }
    }
}
