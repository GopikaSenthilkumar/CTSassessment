package com.example.ormlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ormlearn.model.Country;
import com.example.ormlearn.repository.CountryRepository;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testFindByNameContaining();
        testFindByNameContainingSorted();
        testFindByNameStartingWith();
    }

    private void testFindByNameContaining() {
        System.out.println("Countries containing 'ou':");
        List<Country> countries = countryRepository.findByNameContaining("ou");
        countries.forEach(System.out::println);
    }

    private void testFindByNameContainingSorted() {
        System.out.println("Countries containing 'ou' (sorted):");
        List<Country> countries = countryRepository.findByNameContainingOrderByNameAsc("ou");
        countries.forEach(System.out::println);
    }

    private void testFindByNameStartingWith() {
        System.out.println("Countries starting with 'Z':");
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        countries.forEach(System.out::println);
    }
}
