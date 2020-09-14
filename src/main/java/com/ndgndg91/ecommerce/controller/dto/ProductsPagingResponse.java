package com.ndgndg91.ecommerce.controller.dto;

import java.util.List;

public final class ProductsPagingResponse {
    private final List<ProductResponse> products;
    private final int totalPage;
    private final long totalElements;

    public ProductsPagingResponse(List<ProductResponse> products, int totalPage, long totalElements) {
        this.products = products;
        this.totalPage = totalPage;
        this.totalElements = totalElements;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
