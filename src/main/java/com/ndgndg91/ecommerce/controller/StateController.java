package com.ndgndg91.ecommerce.controller;

import com.ndgndg91.ecommerce.controller.dto.country.StatesResponse;
import com.ndgndg91.ecommerce.entity.State;
import com.ndgndg91.ecommerce.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    private final StateRepository stateRepository;

    public StateController(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @GetMapping("/api/states")
    public ResponseEntity<StatesResponse> states(){
        List<State> all = stateRepository.findAll();
        StatesResponse response = StatesResponse.ok(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/states/findByCountryCode")
    public ResponseEntity<StatesResponse> findByContryCode(
            @RequestParam String code
    ){
        List<State> byCountryCode = stateRepository.findByCountryCode(code);
        StatesResponse response = StatesResponse.ok(byCountryCode);
        return ResponseEntity.ok(response);
    }
}
