package com.spring.university.Controller;

import com.spring.university.dto.TakesDto;
import com.spring.university.model.Takes;
import com.spring.university.service.TakesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/takes")
@AllArgsConstructor
public class TakesController {

    private final TakesService takesService;

    // Endpoint to enroll a student in a course
    @PostMapping("/enroll")
    public ResponseEntity<Takes> enrollStudentInCourse(@RequestBody TakesDto takesDto) {
        Takes takes = takesService.enrollStudentInCourse(takesDto);
        return new ResponseEntity<>(takes, HttpStatus.CREATED);
    }

}
