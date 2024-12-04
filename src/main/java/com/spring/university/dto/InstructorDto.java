package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long departmentId; // Reference to Department
}
