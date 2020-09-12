package com.ndgndg91.ecommerce.controller.dto;

import com.ndgndg91.ecommerce.entity.ProductCategory;

import java.util.List;

public final class GetCategoryResponse {
    private List<ProductCategory> categories;

    public GetCategoryResponse(List<ProductCategory> categories){
        this.categories = categories;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }
}
