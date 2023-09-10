package com.mapping.serviceImpl;

import com.cloudinary.Cloudinary;
import com.mapping.dto.UserDto;
import com.mapping.entity.Aadhar;
import com.mapping.entity.User;
import com.mapping.repository.AadharRepo;
import com.mapping.repository.UserRepo;
import com.mapping.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AadharRepo aadharRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public UserDto createUser(UserDto userDto, MultipartFile image) {

        try {
            Map upload = this.cloudinary.uploader().upload(image.getBytes(), Map.of());
            User map = this.modelMapper.map(userDto, User.class);
            map.setImageUrl((String) upload.get("url"));
            User save = this.userRepo.save(map);
            return this.modelMapper.map(save, UserDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserDto getUserById(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public String deleteUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        this.userRepo.delete(user);
        return "deleted";
    }

    @Override
    public UserDto getUserByAadhar(int aadharId) {
        Aadhar aadhar = this.aadharRepo.findById(aadharId).orElseThrow(() -> new RuntimeException("aadhar not found"));
        User user = this.userRepo.getUserByAadharId(aadhar).orElseThrow(() -> new RuntimeException("aadhar not attached to user"));

        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto findByAadharId(int aadharId) {
        Aadhar aadhar = this.aadharRepo.findById(aadharId).orElseThrow(() -> new RuntimeException("aadhar not found"));
        User user = this.userRepo.findByAadhar(aadhar).orElseThrow(() -> new RuntimeException("aadhar not attached to user"));

        return this.modelMapper.map(user, UserDto.class);
    }
}
