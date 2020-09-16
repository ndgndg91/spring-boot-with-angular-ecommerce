package com.ndgndg91.ecommerce.controller.dto.product;

public final class Page {
    private final int size;
    private final long totalElements;
    private final int totalPages;
    private final int current;

    public Page(int size, long totalElements, int totalPages, int current) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrent() {
        return current;
    }
}
