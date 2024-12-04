package com.spring.university.service;


import com.spring.university.Response;
import com.spring.university.model.TimeSlot;
import com.spring.university.repository.TimeSlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TimeSlotService {

    private final TimeSlotRepo timeSlotRepo;


    public Response addTimeSlot(TimeSlot timeSlot) {

        if (timeSlotRepo.existsByDayAndStartTime(timeSlot.getDay(), timeSlot.getStartTime())) {
            throw new RuntimeException("TimeSlot already exists");
        }
        timeSlotRepo.save(timeSlot);
        return Response.builder()
                .success(true)
                .message("time slot added successfully")
                .data(timeSlot)
                .build();
    }

    // Get all TimeSlots
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepo.findAll();
    }

    // Get TimeSlot by ID
    public TimeSlot getTimeSlotById(Long id) {
        return timeSlotRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeSlot not found with id: " + id));
    }

    // Update an existing TimeSlot
    public Response updateTimeSlot(Long id, TimeSlot updatedTimeSlot) {
        TimeSlot existingTimeSlot = timeSlotRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeSlot not found with id: " + id));

        existingTimeSlot.setDay(updatedTimeSlot.getDay());
        existingTimeSlot.setStartTime(updatedTimeSlot.getStartTime());
        existingTimeSlot.setEndTime(updatedTimeSlot.getEndTime());

        timeSlotRepo.save(existingTimeSlot);
        return Response.builder()
                .success(true)
                .message("time slot updated successfully")
                .data(existingTimeSlot)
                .build();
    }

    // Delete a TimeSlot
    public Response deleteTimeSlot(Long id) {
        TimeSlot existingTimeSlot = timeSlotRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeSlot not found with id: " + id));
        timeSlotRepo.delete(existingTimeSlot);
        return Response.builder()
                .success(true)
                .message("time slot deleted successfully")
                .build();
    }

}



