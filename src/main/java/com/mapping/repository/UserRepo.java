package com.mapping.repository;

import com.mapping.entity.Aadhar;
import com.mapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u where u.aadhar= :aadhar")
    Optional<User> getUserByAadharId(@Param("aadhar") Aadhar aadhar);

    Optional<User> findByAadhar(Aadhar aadhar);

}
