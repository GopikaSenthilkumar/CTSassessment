package com.cognizant.orm_learn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
    @Autowired
    private CountryService countryService;
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        testAddCountry();
    }
    void testAddCountry() {
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");
        countryService.addCountry(country);
        System.out.println("Added country!");
        Country added = countryService.findCountryByCode("ZZ");
        System.out.println("Retrieved Country: " + added.getCode() + " - " + added.getName());
    }
}