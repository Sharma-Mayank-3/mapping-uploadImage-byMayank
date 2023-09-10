package com.mapping.repository;

import com.mapping.entity.Aadhar;
import com.mapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AadharRepo extends JpaRepository<Aadhar, Integer> {

    Optional<Aadhar> findByUser(User user);

    @Query(value = "select a from Aadhar a where a.user= :user")
    Optional<Aadhar> getAadharByUser(@Param("user") User user);

}
