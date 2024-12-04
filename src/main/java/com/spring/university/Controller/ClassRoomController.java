package com.spring.university.Controller;

import com.spring.university.model.ClassRoom;
import com.spring.university.service.ClassRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
@AllArgsConstructor
public class ClassRoomController {


    private final ClassRoomService classRoomService;

    // Endpoint to add a new classroom
    @PostMapping
    public ClassRoom addClassRoom(@RequestBody ClassRoom classRoom) {
        return classRoomService.addClassRoom(classRoom);
    }

    // Endpoint to get a classroom by ID
    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Long id) {
        return classRoomService.getClassRoomById(id);
    }

    // Endpoint to update a classroom
    @PutMapping("/{id}")
    public ClassRoom updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoomDetails) {
        return classRoomService.updateClassRoom(id, classRoomDetails);
    }

    // Endpoint to delete a classroom
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable Long id) {
        classRoomService.deleteClassRoom(id);
        return ResponseEntity.ok("Classroom deleted successfully");
    }
}
