package com.ndgndg91.ecommerce.controller.dto.country;

import com.ndgndg91.ecommerce.entity.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class StatesResponse {

    private final List<StateResponse> states;

    private StatesResponse(){
        this.states = new ArrayList<>();
    }

    public static StatesResponse ok(List<State> all) {
        StatesResponse res = new StatesResponse();
        List<StateResponse> states = all.stream()
                .map(s -> new StateResponse(s.getId(), s.getName()))
                .collect(Collectors.toList());

        res.states.addAll(states);
        return res;
    }

    public List<StateResponse> getStates() {
        return states;
    }
}
