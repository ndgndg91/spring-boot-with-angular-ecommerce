package com.ndgndg91.ecommerce.controller.dto;

import java.util.List;

public final class ProductsPagingResponse {
    private final List<ProductResponse> products;
    private final Page page;


    public ProductsPagingResponse(List<ProductResponse> products, int totalPage, long totalElements, int size, int current) {
        this.products = products;
        this.page = new Page(size, totalElements, totalPage, current);
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public Page getPage() {
        return page;
    }
}
