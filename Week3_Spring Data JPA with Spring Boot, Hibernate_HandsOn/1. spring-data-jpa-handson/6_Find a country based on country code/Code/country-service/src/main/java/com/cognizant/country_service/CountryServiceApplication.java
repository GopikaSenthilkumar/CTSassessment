package com.cognizant.country_service;
import com.cognizant.country_service.model.Country;
import com.cognizant.country_service.service.CountryService;
import com.cognizant.country_service.repository.CountryRepository;
import com.cognizant.country_service.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class CountryServiceApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceApplication.class);
    @Autowired
    private CountryService countryService;
    public static void main(String[] args) {
        SpringApplication.run(CountryServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(CountryRepository countryRepository) {
        return args -> {
            Country india = new Country();
            india.setCode("IN");
            india.setName("India");
            countryRepository.save(india);
        };
    }
    @Override
    public void run(String... args) {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}