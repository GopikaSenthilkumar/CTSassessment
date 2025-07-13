package com.cognizant.countryservice.controller;

import com.cognizant.countryservice.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        LOGGER.info("Start");
        LOGGER.info("Received country: Code = {}, Name = {}", country.getCode(), country.getName());
        return country;
    }
}