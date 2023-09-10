package com.mapping.service;

import com.mapping.dto.AadharDto;

public interface AadharService {

    AadharDto createAadhar(AadharDto aadharDto, int userId);

    String deleteAadhar(int aadharId);

    AadharDto getAadharByUser(int userId);

    AadharDto findAadharByUser(int userId);

}
