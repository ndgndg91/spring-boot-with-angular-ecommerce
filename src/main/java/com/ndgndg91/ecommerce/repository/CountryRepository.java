package com.ndgndg91.ecommerce.repository;

import com.ndgndg91.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
