package com.example.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ormlearn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String text);

    List<Country> findByNameContainingOrderByNameAsc(String text);

    List<Country> findByNameStartingWith(String letter);
}
