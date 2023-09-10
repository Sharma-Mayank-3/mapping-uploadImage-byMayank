package com.mapping.serviceImpl;

import com.cloudinary.Cloudinary;
import com.mapping.config.CloudinaryConfigration;
import com.mapping.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map uploadImage(MultipartFile file) {
        try {
            Map upload = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
            return upload;
        } catch (IOException e) {
            throw new RuntimeException("image not found...");
        }
    }
}
