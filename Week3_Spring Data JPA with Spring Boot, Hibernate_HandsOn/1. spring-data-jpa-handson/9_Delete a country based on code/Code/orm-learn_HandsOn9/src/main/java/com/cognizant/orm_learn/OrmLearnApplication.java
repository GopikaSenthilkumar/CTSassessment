package com.cognizant.orm_learn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.model.Country;
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
    @Autowired
    private CountryService countryService;
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");
        countryService.addCountry(country);
        System.out.println("Country ZZ added.");
        countryService.deleteCountry("ZZ");
        System.out.println("Country ZZ deleted.");
        Country result = countryService.findCountryByCode("ZZ");
        if (result == null) {
            System.out.println("Delete confirmed. Country not found.");
        } else {
            System.out.println("Country still exists: " + result.getCode());
        }
    }
}