package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Double totalCred;
    private Long departmentId;  // Reference to Department by ID
    private Long advisorId;
//private LocalDate enrollmentDate;  // Date the student officially started studies

}
