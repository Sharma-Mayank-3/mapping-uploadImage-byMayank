package com.mapping.repository;

import com.mapping.entity.Country;
import com.mapping.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

    @Query(value = "select s from State s where s.country= :country")
    List<State> getStateByCountry(@Param("country") Country country);

    List<State> findByCountry(Country country);

}
