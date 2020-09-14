package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.controller.dto.*;
import com.ndgndg91.ecommerce.entity.Product;
import com.ndgndg91.ecommerce.repository.ProductCategoryRepository;
import com.ndgndg91.ecommerce.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    public ProductController(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> product(
            @PathVariable long id
    )
    {
        log.info("call id API");
        // TODO null handling
        ProductResponse productResponse = productRepository.findById(id).map(p ->
                new ProductResponse(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        p.isActive(),
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated()
                )).orElse(null);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/api/products")
    public ResponseEntity<ProductsPagingResponse> products(
            Pageable pageable
    ) {
        log.info("call API");
        Page<Product> page = productRepository.findAll(pageable);
        List<ProductResponse> all = page.stream().map(p ->
                new ProductResponse(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        p.isActive(),
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated()
                )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(new ProductsPagingResponse(all, page.getTotalPages(), page.getTotalElements()));
    }

    @GetMapping("/api/products/search/findByCategoryId")
    public ResponseEntity<ProductsResponse> productsByCategoryId(
            @RequestParam long id,
            Pageable pageable
    ) {
        log.info("call Find By Category API");
        Page<Product> byCategoryId = productRepository.findByCategoryId(id, pageable);
        return getProductsResponseResponseEntity(byCategoryId);
    }

    @GetMapping("/api/products/search/findByNameContaining")
    public ResponseEntity<ProductsResponse> productsByNameContaining(
            @RequestParam String name,
            Pageable pageable
    )
    {
        Page<Product> byNameContaining = productRepository.findByNameContaining(name, pageable);
        return getProductsResponseResponseEntity(byNameContaining);
    }

    private ResponseEntity<ProductsResponse> getProductsResponseResponseEntity(Page<Product> byNameContaining) {
        List<ProductResponse> products = byNameContaining.stream().map(p ->
                new ProductResponse(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        p.isActive(),
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated()
                )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(new ProductsResponse(products));
    }

    @GetMapping("/api/product-category")
    public ResponseEntity<CategoriesResponse> categories() {
        log.info("call Product Category call");
        List<CategoryResponse> all = productCategoryRepository.findAll().stream()
                .map(c -> new CategoryResponse(c.getId(), c.getCategoryName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new CategoriesResponse(all));
    }
}
