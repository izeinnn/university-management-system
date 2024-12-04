package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.dto.InstructorDto;
import com.spring.university.mapper.InstructorMapper;
import com.spring.university.model.Department;
import com.spring.university.model.Instructor;
import com.spring.university.repository.DepartmentRepo;
import com.spring.university.repository.InstructorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorService {

    private final InstructorRepo instructorRepo;
    private final DepartmentRepo departmentRepo;
    private final InstructorMapper instructorMapper;


    // Add a new Instructor
    public Response addInstructor(InstructorDto instructorDto) {
        // Fetch department based on ID from DTO
        Department department = departmentRepo.findById(instructorDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + instructorDto.getDepartmentId()));

        // Create and save the new Instructor entity
        Instructor instructor = Instructor.builder()
//                .id(instructorDto.getId())
                .firstName(instructorDto.getFirstName())
                .lastName(instructorDto.getLastName())
//                .email(instructorDto.getEmail())
                .phone(instructorDto.getPhone())
                .department(department)
                .build();

        instructorRepo.save(instructor);

        return Response.builder()
                .success(true)
                .message("Instructor added successfully")
                .data(instructor)
                .build();
    }


    public Response updateInstructor(Long id, InstructorDto instructorDto) {
        // Find the existing Instructor entity
        Instructor existingInstructor = instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));

        // Fetch updated department based on DTO
        Department department = departmentRepo.findById(instructorDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + instructorDto.getDepartmentId()));

        // Update the Instructor entity
        existingInstructor.setFirstName(instructorDto.getFirstName());
        existingInstructor.setLastName(instructorDto.getLastName());
//        existingInstructor.setEmail(instructorDto.getEmail());
        existingInstructor.setPhone(instructorDto.getPhone());
        existingInstructor.setDepartment(department);

        instructorRepo.save(existingInstructor);

        return Response.builder()
                .success(true)
                .message("Instructor updated successfully")
                .data(existingInstructor)
                .build();
    }

    // Delete an Instructor
    public Response deleteInstructor(Long id) {
        // Find and delete the Instructor entity
        Instructor existingInstructor = instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));

        instructorRepo.delete(existingInstructor);

        return Response.builder()
                .success(true)
                .message("Instructor deleted successfully")
                .data(existingInstructor)
                .build();
    }


    //learn how to use mapDto

    // Fetch a single Instructor by ID
    public Response getInstructorById(Long id) {
        Instructor instructor = instructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));

        // Map to DTO
        InstructorDto instructorDto = instructorMapper.toDto(instructor);

        return Response.builder()
                .success(true)
                .message("Instructor fetched successfully")
                .data(instructorDto)
                .build();
    }

    // Fetch all Instructors
    public Response getAllInstructors() {
        // Fetch all instructors and map to DTOs
        List<InstructorDto> instructorDtos = instructorRepo.findAll().stream()
                .map(instructorMapper::toDto)
                .toList();

        return Response.builder()
                .success(true)
                .message("All instructors fetched successfully")
                .data(instructorDtos)
                .build();
    }



}
