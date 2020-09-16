package com.ndgndg91.ecommerce.controller.dto.country;

public final class StateResponse {
    private final long id;
    private final String name;

    public StateResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
