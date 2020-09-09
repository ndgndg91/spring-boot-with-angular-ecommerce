package com.ndgndg91.ecommerce.repository;

import com.ndgndg91.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
