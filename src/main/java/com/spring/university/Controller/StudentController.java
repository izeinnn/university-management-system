package com.spring.university.Controller;

import com.spring.university.Response;
import com.spring.university.dto.StudentDto;
import com.spring.university.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class StudentController {

    private final StudentService studentService;

    // Add a new Student
    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> addStudent(@RequestBody StudentDto studentDto) {
        Response response = studentService.addStudent(studentDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Update an existing Student
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Response response = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete a Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable Long id) {
        Response response = studentService.deleteStudent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
