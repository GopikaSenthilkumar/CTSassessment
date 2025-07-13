package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication started successfully");

        displayDate();
        displayCountry(); 
    }

    public static void displayDate() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        var format = context.getBean("dateFormat", java.text.SimpleDateFormat.class);

        try {
            var parsedDate = format.parse("11/07/2025");
            LOGGER.debug("Parsed Date: {}", parsedDate);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }

        LOGGER.info("END");
    }

    public static void displayCountry() {
        LOGGER.info("START - displayCountry");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("END - displayCountry");
    }
}