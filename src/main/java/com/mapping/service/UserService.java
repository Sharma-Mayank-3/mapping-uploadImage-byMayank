package com.mapping.service;

import com.mapping.dto.UserDto;
import com.mapping.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDto, MultipartFile image);

    UserDto getUserById(int userId);

    String deleteUser(int userId);

    UserDto getUserByAadhar(int aadharId);

    UserDto findByAadharId(int aadharId);
}
