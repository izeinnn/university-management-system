package com.spring.university.Controller;


import com.spring.university.Response;
import com.spring.university.dto.InstructorDto;
import com.spring.university.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController {

    private InstructorService instructorService;

    // Add a new Instructor
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response> addInstructor(@RequestBody InstructorDto instructorDto) {
        return ResponseEntity.ok(instructorService.addInstructor(instructorDto));
    }

    // Update an existing Instructor
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateInstructor(@PathVariable Long id, @RequestBody InstructorDto instructorDto) {
        Response response = instructorService.updateInstructor(id, instructorDto);
        return ResponseEntity.ok(response);
    }

    // Delete an Instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteInstructor(@PathVariable Long id) {
        Response response = instructorService.deleteInstructor(id);
        return ResponseEntity.ok(response);
    }

    // Fetch a single Instructor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Response> getInstructorById(@PathVariable Long id) {
        Response response = instructorService.getInstructorById(id);
        return ResponseEntity.ok(response);
    }

    // Fetch all Instructors
    @GetMapping
    public ResponseEntity<Response> getAllInstructors() {
        Response response = instructorService.getAllInstructors();
        return ResponseEntity.ok(response);
    }




}
