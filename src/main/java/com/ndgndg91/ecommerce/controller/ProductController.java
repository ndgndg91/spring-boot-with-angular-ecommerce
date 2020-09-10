package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.entity.Product;
import com.ndgndg91.ecommerce.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public ResponseEntity<Products> products(){
        return ResponseEntity.ok(new Products(productRepository.findAll()));
    }

    private class Products{
        private final List<Product> products;

        Products(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }
}
