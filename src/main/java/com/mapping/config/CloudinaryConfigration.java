package com.mapping.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfigration {

    @Bean
    public Cloudinary getCloudinary(){

        Map<String, String> map = new HashMap<>();
        map.put("cloud_name", "dewjv3wki");
        map.put("api_key", "944486932521654");
        map.put("api_secret", "13hGA1935RHfu4u_D3wff_oPub8");

        return new Cloudinary(map);
    }

}
