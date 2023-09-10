package com.mapping.controller;

import com.mapping.dto.AadharDto;
import com.mapping.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping")
public class AadharController {

    @Autowired
    private AadharService aadharService;

    @PostMapping("/user/{userId}/aadhar")
    public ResponseEntity<AadharDto> createAadhar(
            @RequestBody AadharDto aadharDto,
            @PathVariable("userId") int userId
            ){
        AadharDto aadhar = this.aadharService.createAadhar(aadharDto, userId);
        return new ResponseEntity<>(aadhar, HttpStatus.CREATED);
    }

    @DeleteMapping("/aadhar/{aadharId}")
    public ResponseEntity<String> deleteAadhar(
            @PathVariable("aadharId") int aadharId
    ){
        this.aadharService.deleteAadhar(aadharId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/aadhar/get")
    public ResponseEntity<AadharDto> getAadharByUser(
            @PathVariable("userId") int userId
    ){
        AadharDto aadhar = this.aadharService.getAadharByUser(userId);
        return new ResponseEntity<>(aadhar, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/aadhar/find")
    public ResponseEntity<AadharDto> findAadharByUser(
            @PathVariable("userId") int userId
    ){
        AadharDto aadhar = this.aadharService.findAadharByUser(userId);
        return new ResponseEntity<>(aadhar, HttpStatus.OK);
    }
}
