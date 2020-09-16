package com.ndgndg91.ecommerce.controller.dto.country;

public final class CountryResponse {
    private final long id;
    private final String code;
    private final String name;

    public CountryResponse(long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
