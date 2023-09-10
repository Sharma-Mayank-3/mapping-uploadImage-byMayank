package com.mapping.service;

import com.mapping.dto.StateDto;

import java.util.List;

public interface StateService {

    StateDto createState(StateDto stateDto, int countryId);

    String deleteState(int stateId);

    List<StateDto> getAllStateFromCountry(int countryId);

    List<StateDto> findAllStateByCountry(int countryId);
}
