package com.cognizant.country.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.country.model.Country;
import com.cognizant.country.service.CountryService;
@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws Exception {
        return countryService.getCountry(code);
    }
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }
    @PutMapping
    public void updateCountry(@RequestBody Country country) throws Exception {
        countryService.updateCountry(country);
    }
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) throws Exception {
        countryService.deleteCountry(code);
    }
    @GetMapping("/search")
    public List<Country> searchCountry(@RequestParam String name) {
        return countryService.findCountriesByName(name);
    }
}