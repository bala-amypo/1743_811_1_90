package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // already existing
    boolean existsByEmail(String email);

    // fixes compilation error
    Optional<User> findByEmail(String email);
}