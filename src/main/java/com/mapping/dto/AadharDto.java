package com.mapping.dto;

import com.mapping.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AadharDto {
    private int aadharId;

    private String aadharAddress;
//    private UserDto user;
}
