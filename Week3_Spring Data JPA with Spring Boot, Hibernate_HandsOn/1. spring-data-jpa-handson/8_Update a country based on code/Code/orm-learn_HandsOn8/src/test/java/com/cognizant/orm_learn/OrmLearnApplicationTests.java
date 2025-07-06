package com.cognizant.orm_learn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
@SpringBootApplication
public class OrmLearnApplicationTests implements CommandLineRunner {
    @Autowired
    private CountryService countryService;
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplicationTests.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        testUpdateCountry();
    }
    void testUpdateCountry() {
    	countryService.updateCountry("IN", "Bharat");
        Country updated = countryService.findCountryByCode("IN");
        if (updated != null) {
            System.out.println("Updated Country: " + updated.getCode() + " - " + updated.getName());
        } else {
            System.out.println("Country not found.");
        }
    }
}