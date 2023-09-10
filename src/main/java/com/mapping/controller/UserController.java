package com.mapping.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapping.dto.UserDto;
import com.mapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mapping")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(
            @RequestParam(value = "userData", required = true) String userData,
            @RequestParam(value = "image", required = true)MultipartFile image
            ){
        UserDto userDto = null;
        try {
            userDto = this.objectMapper.readValue(userData, UserDto.class);
            UserDto user = this.userService.createUser(userDto, image);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") int userId){
        UserDto userById = this.userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/user/aadhar/{aadharId}/get")
    public ResponseEntity<UserDto> getuserByAadhar(@PathVariable("aadharId") int aadharId){
        UserDto userById = this.userService.getUserByAadhar(aadharId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @GetMapping("/user/aadhar/{aadharId}/find")
    public ResponseEntity<UserDto> findUserByAadhar(@PathVariable("aadharId") int aadharId){
        UserDto userById = this.userService.findByAadharId(aadharId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
}
