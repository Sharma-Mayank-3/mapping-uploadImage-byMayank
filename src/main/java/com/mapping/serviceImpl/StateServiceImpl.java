package com.mapping.serviceImpl;

import com.mapping.dto.StateDto;
import com.mapping.entity.Country;
import com.mapping.entity.State;
import com.mapping.repository.CountryRepo;
import com.mapping.repository.StateRepo;
import com.mapping.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StateRepo stateRepo;

    @Override
    public StateDto createState(StateDto stateDto, int countryId) {
        Country country = this.countryRepo.findById(countryId).orElseThrow(() -> new RuntimeException("country not found"));
        State map = this.modelMapper.map(stateDto, State.class);
        map.setCountry(country);
        State save = this.stateRepo.save(map);
        return this.modelMapper.map(save, StateDto.class);
    }

    @Override
    public String deleteState(int stateId) {
        State state = this.stateRepo.findById(stateId).orElseThrow(() -> new RuntimeException("state not found"));
        this.stateRepo.delete(state);
        return "deleted";
    }

    @Override
    public List<StateDto> getAllStateFromCountry(int countryId) {
        Country country = this.countryRepo.findById(countryId).orElseThrow(() -> new RuntimeException("country not found"));
        List<State> stateByCountry = this.stateRepo.getStateByCountry(country);
        return stateByCountry.stream().map(state-> this.modelMapper.map(state, StateDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StateDto> findAllStateByCountry(int countryId) {
        Country country = this.countryRepo.findById(countryId).orElseThrow(() -> new RuntimeException("country not found"));
        List<State> stateByCountry = this.stateRepo.findByCountry(country);
        return stateByCountry.stream().map(state-> this.modelMapper.map(state, StateDto.class)).collect(Collectors.toList());
    }
}
