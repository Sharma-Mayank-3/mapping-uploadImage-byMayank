package com.mapping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapping.entity.Aadhar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;
    private String userName;
    private String address;

    private String imageUrl;

    private AadharDto aadhar;


}
