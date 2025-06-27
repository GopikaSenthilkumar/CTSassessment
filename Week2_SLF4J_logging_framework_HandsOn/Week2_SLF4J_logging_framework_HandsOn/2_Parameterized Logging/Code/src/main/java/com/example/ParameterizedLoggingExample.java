package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    public static void main(String[] args) {
        String username = "Gopika";
        int loginAttempts = 3;
        logger.info("User {} has logged in successfully.", username);
        logger.warn("User {} has attempted to log in {} times unsuccessfully.", username, loginAttempts);
        logger.error("An error occurred for user {} after {} failed attempts.", username, loginAttempts);
    }
}
