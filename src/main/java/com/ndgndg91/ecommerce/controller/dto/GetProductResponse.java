package com.ndgndg91.ecommerce.controller.dto;

import com.ndgndg91.ecommerce.entity.Product;

import java.util.List;

public final class GetProductResponse {
    private final List<Product> products;

    public GetProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
