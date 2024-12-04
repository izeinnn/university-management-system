package com.spring.university.repository;

import com.spring.university.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
   Optional<User> findByEmail(String Email);

    boolean existsByEmail(String email);
}
