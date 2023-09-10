package com.mapping.repository;

import com.mapping.entity.Country;
import com.mapping.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

    /**
     *
     * Note : Very Important :
     *
     * No Need of all this below since when u get from state from stateId, country is already present.
     *
     *
    @Query(value = "select c from Country c where c.states= : state")
    Optional<Country> getCountyByState(@Param("state")State state);

    Optional<Country> findByStates(State state);
    */

}
