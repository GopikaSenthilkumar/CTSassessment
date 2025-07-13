package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private List<Country> countryList = new ArrayList<>();

    @Override
    public Country addCountry(Country country) {
        countryList.add(country);
        return country;
    }
}