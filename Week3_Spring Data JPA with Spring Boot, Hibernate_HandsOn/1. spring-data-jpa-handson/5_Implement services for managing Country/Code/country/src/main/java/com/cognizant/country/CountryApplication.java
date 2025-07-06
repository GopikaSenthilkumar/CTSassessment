package com.cognizant.country;
import com.cognizant.country.model.Country;
import org.springframework.context.annotation.Bean;
import com.cognizant.country.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CountryApplication {
	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}
@Bean
	CommandLineRunner test(CountryRepository countryRepository) {
	    return args -> {
	        Country c = new Country("IN", "India");
	        countryRepository.save(c);
	        System.out.println("Saved: " + c);
	        Country fetched = countryRepository.findById("IN").orElse(null);
	        System.out.println("Fetched: " + fetched);
	    };
	}
}