package com.spring.university.mapper;

import com.spring.university.dto.InstructorDto;
import com.spring.university.model.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    // Map Instructor entity to InstructorDto
    public InstructorDto toDto(Instructor instructor) {
        InstructorDto dto = new InstructorDto();
        dto.setId(instructor.getId());
        dto.setFirstName(instructor.getFirstName());
        dto.setLastName(instructor.getLastName());
//        dto.setEmail(instructor.getEmail());
        dto.setPhone(instructor.getPhone());
        if (instructor.getDepartment() != null) {
            dto.setDepartmentId(instructor.getDepartment().getId());
        }
        return dto;
    }

    // Optional: Map InstructorDto to Instructor entity
    public Instructor toEntity(InstructorDto dto) {
        Instructor instructor = new Instructor();
        instructor.setId(dto.getId());
        instructor.setFirstName(dto.getFirstName());
        instructor.setLastName(dto.getLastName());
//        instructor.setEmail(dto.getEmail());
        instructor.setPhone(dto.getPhone());
        return instructor;
    }
}
