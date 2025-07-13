package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        if (!countryMap.containsKey(code)) {
            throw new CountryNotFoundException("Country Not found");
        }
        return countryMap.get(code);
    }
}