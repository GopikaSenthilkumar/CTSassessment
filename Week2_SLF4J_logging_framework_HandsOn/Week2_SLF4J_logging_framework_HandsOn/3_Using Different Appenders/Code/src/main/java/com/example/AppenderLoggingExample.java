package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);
    public static void main(String[] args) {
        logger.debug("Debug level log message");
        logger.info("Info level log message");
        logger.warn("Warning level log message");
        logger.error("Error level log message");
        System.out.println("Log messages have been sent to console and app.log file.");
    }
}
