package com.spring.university.repository;

import com.spring.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
