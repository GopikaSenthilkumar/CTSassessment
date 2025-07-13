package com.cognizant.countryservice.service;

import com.cognizant.countryservice.model.Country;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private List<Country> countryList = new ArrayList<>();

    @Override
    public List<Country> getAllCountries() {
        return countryList;
    }

    @Override
    public Country getCountryByCode(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Country addCountry(Country country) {
        countryList.add(country);
        return country;
    }

    @Override
    public Country updateCountry(Country country) {
        Country existing = getCountryByCode(country.getCode());
        if (existing != null) {
            existing.setName(country.getName());
        }
        return existing;
    }

    @Override
    public void deleteCountry(String code) {
        countryList.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }
    @PostConstruct
    public void initCountryList() {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("FR", "France"));
    }
}