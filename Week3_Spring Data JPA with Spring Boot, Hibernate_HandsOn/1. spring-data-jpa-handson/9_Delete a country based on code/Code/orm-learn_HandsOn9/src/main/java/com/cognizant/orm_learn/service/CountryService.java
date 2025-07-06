package com.cognizant.orm_learn.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
}