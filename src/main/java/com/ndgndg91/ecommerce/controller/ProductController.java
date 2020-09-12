package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.controller.dto.CategoriesResponse;
import com.ndgndg91.ecommerce.controller.dto.CategoryResponse;
import com.ndgndg91.ecommerce.controller.dto.ProductResponse;
import com.ndgndg91.ecommerce.controller.dto.ProductsResponse;
import com.ndgndg91.ecommerce.entity.Product;
import com.ndgndg91.ecommerce.repository.ProductCategoryRepository;
import com.ndgndg91.ecommerce.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    public ProductController(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping("/api/products")
    public ResponseEntity<ProductsResponse> products() {
        log.info("call API");
        List<ProductResponse> all = productRepository.findAll().stream().map(p ->
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
        return ResponseEntity.ok(new ProductsResponse(all));
    }

    @GetMapping("/api/products/search/findByCategoryId")
    public ResponseEntity<ProductsResponse> productByCategoryId(
            @RequestParam long id,
            Pageable pageable
    ) {
        log.info("call Find By Category API");
        Page<Product> byCategoryId = productRepository.findByCategoryId(id, pageable);
        List<ProductResponse> products = byCategoryId.stream().map(p ->
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
