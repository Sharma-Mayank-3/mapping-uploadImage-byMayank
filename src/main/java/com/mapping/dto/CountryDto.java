package com.mapping.dto;

import com.mapping.entity.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private int countryId;

    private String countryName;

    private List<StateDto> states = new ArrayList<>();
}
