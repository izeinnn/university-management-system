package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.dto.StudentDto;
import com.spring.university.model.Department;
import com.spring.university.model.Instructor;
import com.spring.university.model.Student;
import com.spring.university.repository.DepartmentRepo;
import com.spring.university.repository.InstructorRepo;
import com.spring.university.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final DepartmentRepo departmentRepo;
    private final InstructorRepo instructorRepo;

    // Add a new Student
    //need to add advisor & enrollment date
    public Response addStudent(StudentDto studentDto) {
        // Fetch department and advisor based on IDs from DTO
        Department department = departmentRepo.findById(studentDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + studentDto.getDepartmentId()));

        Instructor advisor = instructorRepo.findById(studentDto.getAdvisorId())
                .orElseThrow(() -> new RuntimeException("Advisor not found with id: " + studentDto.getAdvisorId()));

        // Create and save the new Student entity
        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
//                .email(studentDto.getEmail())
                .phone(studentDto.getPhone())
                .total_cred(studentDto.getTotalCred())
                .department(department)
                .advisor(advisor)
//                .entryDate(studentDto.getEnrollmentDate() != null ? studentDto.getEnrollmentDate() : LocalDate.now()) // Set enrollmentDate
                .build();

        studentRepo.save(student);
        instructorRepo.save(advisor);

        return Response.builder()
                .success(true)
                .message("Student added successfully")
                .data(student)
                .build();
    }

    // Update an existing Student
    public Response updateStudent(Long id, StudentDto studentDto) {
        // Find the existing Student entity
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Fetch updated department and advisor based on DTO
        Department department = departmentRepo.findById(studentDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + studentDto.getDepartmentId()));

//        Instructor advisor = instructorRepo.findById(studentDto.getAdvisorId())
//                .orElseThrow(() -> new RuntimeException("Advisor not found with id: " + studentDto.getAdvisorId()));

        // Update the Student entity
        existingStudent.setFirstName(studentDto.getFirstName());
        existingStudent.setLastName(studentDto.getLastName());
//        existingStudent.setEmail(studentDto.getEmail());
        existingStudent.setPhone(studentDto.getPhone());
        existingStudent.setTotal_cred(studentDto.getTotalCred());
        existingStudent.setDepartment(department);
//        existingStudent.setAdvisor(advisor);

        studentRepo.save(existingStudent);

        return Response.builder()
                .success(true)
                .message("Student updated successfully")
                .data(existingStudent)
                .build();
    }

    // Delete a Student
    public Response deleteStudent(Long id) {
        // Find and delete the Student entity
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepo.delete(existingStudent);

        return Response.builder()
                .success(true)
                .message("Student deleted successfully")
                .data(existingStudent)
                .build();
    }
}
