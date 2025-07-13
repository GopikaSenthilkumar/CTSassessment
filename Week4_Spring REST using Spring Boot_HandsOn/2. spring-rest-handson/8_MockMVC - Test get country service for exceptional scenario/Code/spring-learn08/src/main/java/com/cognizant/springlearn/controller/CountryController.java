package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    public CountryController() {
        System.out.println("CountryController initialized");
    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Country Not found")
    public void handleCountryNotFoundException() {
     
    }
}