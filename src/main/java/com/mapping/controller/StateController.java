package com.mapping.controller;

import com.mapping.dto.StateDto;
import com.mapping.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapping")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping("/country/{countryId}/state")
    public ResponseEntity<StateDto> createState(
            @RequestBody StateDto stateDto,
            @PathVariable("countryId") int countryId
    ){
        StateDto state = this.stateService.createState(stateDto, countryId);
        return new ResponseEntity<>(state, HttpStatus.CREATED);
    }

    @DeleteMapping("/state/{stateId}")
    public ResponseEntity<String> deleteState(
            @PathVariable("stateId") int stateId
    ){
        this.stateService.deleteState(stateId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}/state/get")
    public ResponseEntity<List<StateDto>> getAllStateFromCountry(
            @PathVariable("countryId") int countryId
    ){
        List<StateDto> allStateFromCountry = this.stateService.getAllStateFromCountry(countryId);
        return new ResponseEntity<>(allStateFromCountry, HttpStatus.CREATED);
    }

    @GetMapping("/country/{countryId}/state/find")
    public ResponseEntity<List<StateDto>> findAllStateByCountry(
            @PathVariable("countryId") int countryId
    ){
        List<StateDto> allStateFromCountry = this.stateService.findAllStateByCountry(countryId);
        return new ResponseEntity<>(allStateFromCountry, HttpStatus.CREATED);
    }
}
