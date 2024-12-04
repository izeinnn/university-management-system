package com.spring.university.Controller;

import com.spring.university.Response;
import com.spring.university.model.TimeSlot;
import com.spring.university.service.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeslots")
@AllArgsConstructor
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    // Add a new TimeSlot
    @PostMapping
    public ResponseEntity<Response> addTimeSlot(@RequestBody TimeSlot timeSlot) {
        return ResponseEntity.ok(timeSlotService.addTimeSlot(timeSlot));
    }

    // Get all TimeSlots
    @GetMapping
    public ResponseEntity<List<TimeSlot>> getAllTimeSlots() {
        List<TimeSlot> timeSlots = timeSlotService.getAllTimeSlots();
        return new ResponseEntity<>(timeSlots, HttpStatus.OK);
    }

    // Get a TimeSlot by ID
    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> getTimeSlotById(@PathVariable Long id) {
        TimeSlot timeSlot = timeSlotService.getTimeSlotById(id);
        return new ResponseEntity<>(timeSlot, HttpStatus.OK);
    }



    // Update an existing TimeSlot
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateTimeSlot(@PathVariable Long id, @RequestBody TimeSlot timeSlot) {
        return ResponseEntity.ok(timeSlotService.updateTimeSlot(id,timeSlot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTimeSlot(@PathVariable Long id) {
//        timeSlotService.deleteTimeSlot(id);
        return ResponseEntity.ok(timeSlotService.deleteTimeSlot(id));
    }


}
