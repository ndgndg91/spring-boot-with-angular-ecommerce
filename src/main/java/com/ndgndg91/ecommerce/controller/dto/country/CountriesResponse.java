package com.ndgndg91.ecommerce.controller.dto.country;

import com.ndgndg91.ecommerce.entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountriesResponse {
    private final List<CountryResponse> countries;

    private CountriesResponse(){
        this.countries = new ArrayList<>();
    }

    public static CountriesResponse ok(List<Country> all) {
        CountriesResponse res = new CountriesResponse();
        List<CountryResponse> countries = all.stream()
                .map(c -> new CountryResponse(c.getId(), c.getCode(), c.getName()))
                .collect(Collectors.toList());

        res.countries.addAll(countries);
        return res;
    }

    public List<CountryResponse> getCountries() {
        return countries;
    }
}
