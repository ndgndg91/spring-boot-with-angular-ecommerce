package com.ndgndg91.ecommerce.controller.dto.product;

public final class CategoryResponse {
    private Long id;
    private String categoryName;

    public CategoryResponse(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
