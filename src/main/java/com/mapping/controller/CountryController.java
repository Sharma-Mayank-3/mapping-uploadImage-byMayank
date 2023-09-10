package com.mapping.controller;

import com.mapping.dto.CountryDto;
import com.mapping.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/country")
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto){
        CountryDto country = this.countryService.createCountry(countryDto);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @GetMapping("/country/state/{stateId}/get")
    public ResponseEntity<CountryDto> g(@PathVariable("stateId") int stateId){
        CountryDto country = this.countryService.getCountryByState(stateId);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("/country/{countryId}")
    public ResponseEntity<String> deleteCountry(@PathVariable("countryId") int countryId){
        this.countryService.deleteCountry(countryId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
