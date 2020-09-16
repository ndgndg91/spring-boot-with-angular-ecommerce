package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.controller.dto.country.CountriesResponse;
import com.ndgndg91.ecommerce.entity.Country;
import com.ndgndg91.ecommerce.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/api/countries")
    public ResponseEntity<CountriesResponse> countries(){
        List<Country> all = countryRepository.findAll();
        CountriesResponse response = CountriesResponse.ok(all);
        return ResponseEntity.ok(response);
    }
}
