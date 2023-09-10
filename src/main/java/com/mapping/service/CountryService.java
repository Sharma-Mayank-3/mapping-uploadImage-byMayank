package com.mapping.service;

import com.mapping.dto.CountryDto;

public interface CountryService {

    CountryDto createCountry(CountryDto countryDto);

    String deleteCountry(int countryId);

    CountryDto getCountryByState(int stateId);

}
