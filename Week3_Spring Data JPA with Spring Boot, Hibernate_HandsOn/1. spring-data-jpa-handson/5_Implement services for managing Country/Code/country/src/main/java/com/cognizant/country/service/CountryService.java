package com.cognizant.country.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.country.model.Country;
import com.cognizant.country.repository.CountryRepository;
import jakarta.transaction.Transactional;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public Country getCountry(String code) throws Exception {
        Optional<Country> country = countryRepository.findById(code);
        if (country.isPresent()) {
            return country.get();
        }
        throw new Exception("Country not found");
    }
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
    public void updateCountry(Country country) throws Exception {
        if (!countryRepository.existsById(country.getCode())) {
            throw new Exception("Country not found for update");
        }
        countryRepository.save(country);
    }
    @Transactional
    public void deleteCountry(String code) throws Exception {
        if (!countryRepository.existsById(code)) {
            throw new Exception("Country not found for deletion");
        }
        countryRepository.deleteById(code);
    }

    public List<Country> findCountriesByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}