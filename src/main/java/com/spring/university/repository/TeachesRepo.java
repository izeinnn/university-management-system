package com.spring.university.repository;

import com.spring.university.model.Teaches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachesRepo extends JpaRepository<Teaches, Long> {

}
