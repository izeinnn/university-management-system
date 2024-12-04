package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TakesDto {

        private Long studentId;    // Student ID
        private Long courseId;     // Course ID
        private Long sectionId;    // Section ID
        private String semester;   // e.g., "Fall 2023"
        private int year;          // e.g., 2023
        private String grade;      // Grade (will be set later)

}
