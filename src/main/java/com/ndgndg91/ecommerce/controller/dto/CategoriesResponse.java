package com.ndgndg91.ecommerce.controller.dto;

import java.util.List;

public final class CategoriesResponse {
    private final List<CategoryResponse> productCategories;

    public CategoriesResponse(List<CategoryResponse> categories) {
        this.productCategories = categories;
    }

    public List<CategoryResponse> getProductCategories() {
        return productCategories;
    }
}
