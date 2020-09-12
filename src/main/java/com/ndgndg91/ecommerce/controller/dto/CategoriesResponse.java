package com.ndgndg91.ecommerce.controller.dto;

import java.util.List;

public final class CategoriesResponse {
    private List<CategoryResponse> categories;

    public CategoriesResponse(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }
}
