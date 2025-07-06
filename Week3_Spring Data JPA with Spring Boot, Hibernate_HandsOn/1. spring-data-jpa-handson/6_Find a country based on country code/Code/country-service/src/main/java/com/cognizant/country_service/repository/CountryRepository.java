package com.cognizant.country_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.country_service.model.Country;
public interface CountryRepository extends JpaRepository<Country, String> {
}