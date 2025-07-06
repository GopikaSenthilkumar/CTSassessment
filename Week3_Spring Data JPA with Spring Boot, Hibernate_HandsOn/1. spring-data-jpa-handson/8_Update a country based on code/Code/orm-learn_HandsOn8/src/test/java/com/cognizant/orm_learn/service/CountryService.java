package com.cognizant.orm_learn.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
    @Transactional
    public void updateCountry(String code, String name) {
        Optional<Country> countryOptional = countryRepository.findById(code);
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            country.setName(name);
            countryRepository.save(country); 
        } else {
            throw new RuntimeException("Country with code " + code + " not found");
        }
    }
}