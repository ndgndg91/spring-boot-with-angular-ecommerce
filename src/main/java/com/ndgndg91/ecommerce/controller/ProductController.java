package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.controller.dto.GetProductResponse;
import com.ndgndg91.ecommerce.controller.dto.GetCategoryResponse;
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
    public ResponseEntity<GetProductResponse> products(){
        log.info("call API");
        return ResponseEntity.ok(new GetProductResponse(productRepository.findAll()));
    }

    @GetMapping("/api/products/search/findByCategoryId")
    public ResponseEntity<GetProductResponse> productByCategoryId(
            @RequestParam long id,
            Pageable pageable
    ){
        log.info("call Find By Category API");
        Page<Product> byCategoryId = productRepository.findByCategoryId(id, pageable);
        List<Product> collect = byCategoryId.stream().collect(Collectors.toList());
        return ResponseEntity.ok(new GetProductResponse(collect));
    }

    @GetMapping("/api/product-category")
    public ResponseEntity<GetCategoryResponse> categories(){
        log.info("call Product Category call");
        return ResponseEntity.ok(new GetCategoryResponse(productCategoryRepository.findAll()));
    }
}
