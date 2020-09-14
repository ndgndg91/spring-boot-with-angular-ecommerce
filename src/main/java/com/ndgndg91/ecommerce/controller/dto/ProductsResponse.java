package com.ndgndg91.ecommerce.controller.dto;

import java.util.List;

public final class ProductsResponse {
    private final List<ProductResponse> products;

    public ProductsResponse(List<ProductResponse> products) {
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
