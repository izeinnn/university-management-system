package com.spring.university.repository;

import com.spring.university.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {
}
