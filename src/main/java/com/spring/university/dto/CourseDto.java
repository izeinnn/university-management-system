package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {
    private String name;
    private Integer credits;
    private Long departmentId; // Add the departmentId field
    private Long instructorId;
}
