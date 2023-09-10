package com.mapping.serviceImpl;

import com.mapping.dto.AadharDto;
import com.mapping.entity.Aadhar;
import com.mapping.entity.User;
import com.mapping.repository.AadharRepo;
import com.mapping.repository.UserRepo;
import com.mapping.service.AadharService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AadharServiceImpl implements AadharService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AadharRepo aadharRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public AadharDto createAadhar(AadharDto aadharDto, int userId) {
        Aadhar map = this.modelMapper.map(aadharDto, Aadhar.class);
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        map.setUser(user);
        Aadhar save = this.aadharRepo.save(map);
        return this.modelMapper.map(save, AadharDto.class);
    }

    @Override
    public String deleteAadhar(int aadharId) {
        Aadhar aadhar = this.aadharRepo.findById(aadharId).orElseThrow(() -> new RuntimeException("aadhar not found"));
        this.aadharRepo.delete(aadhar);
        return "deleted";
    }

    @Override
    public AadharDto getAadharByUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Aadhar aadhar = this.aadharRepo.getAadharByUser(user).orElseThrow(() -> new RuntimeException("user not found in aadhar"));
        return this.modelMapper.map(aadhar, AadharDto.class);
    }

    @Override
    public AadharDto findAadharByUser(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Aadhar aadhar = this.aadharRepo.findByUser(user).orElseThrow(() -> new RuntimeException("user not found in aadhar"));
        return this.modelMapper.map(aadhar, AadharDto.class);
    }
}
