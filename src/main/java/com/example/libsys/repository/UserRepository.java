package com.example.libsys.repository;

import com.example.libsys.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserEntity findById(int id);
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String emailAddress);
    Boolean existsByEmail(String emailAddress);
    Boolean existsByUsername(String username);
}
