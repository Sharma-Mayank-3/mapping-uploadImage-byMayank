package com.mapping.dto;

import com.mapping.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDto {

    private int stateId;

    private String stateName;

//    private CountryDto country;
}
