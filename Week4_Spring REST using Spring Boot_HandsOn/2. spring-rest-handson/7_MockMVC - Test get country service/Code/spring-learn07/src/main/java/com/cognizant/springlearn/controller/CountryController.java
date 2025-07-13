package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    public CountryController() {
        System.out.println("CountryController initialized");
    }

    @GetMapping("/country")
    public Country getCountry() {
        return new Country("IN", "India");
    }
}