package com.mapping.serviceImpl;

import com.mapping.dto.CountryDto;
import com.mapping.entity.Country;
import com.mapping.entity.State;
import com.mapping.repository.CountryRepo;
import com.mapping.repository.StateRepo;
import com.mapping.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StateRepo stateRepo;

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        Country map = this.modelMapper.map(countryDto, Country.class);
        Country save = this.countryRepo.save(map);
        return this.modelMapper.map(save, CountryDto.class);
    }


    @Override
    public String deleteCountry(int countryId) {
        Country country = this.countryRepo.findById(countryId).orElseThrow(() -> new RuntimeException("country not found"));
        this.countryRepo.delete(country);
        return "deleted";
    }

    @Override
    public CountryDto getCountryByState(int stateId) {
        State state = this.stateRepo.findById(stateId).orElseThrow(() -> new RuntimeException("state not found"));
        return this.modelMapper.map(state.getCountry(), CountryDto.class);
    }

}
