package com.ndgndg91.ecommerce.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ProductResponse {

    private Long id;

    private Long categoryId;
    private String categoryName;

    private String sku;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private  String imageUrl;

    private boolean active;

    private int unitsInStock;

    private LocalDate dataCreated;

    private LocalDate lastUpdated;

    public ProductResponse(Long id, String sku, String name, String description, BigDecimal unitPrice, String imageUrl, boolean active, int unitsInStock, LocalDate dataCreated, LocalDate lastUpdated) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.dataCreated = dataCreated;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public LocalDate getDataCreated() {
        return dataCreated;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }
}
