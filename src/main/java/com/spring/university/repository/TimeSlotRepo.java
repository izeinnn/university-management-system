package com.spring.university.repository;

import com.spring.university.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {

    boolean existsByDayAndStartTime(String day, String startTime);

}
