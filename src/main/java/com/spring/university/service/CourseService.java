package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.dto.CourseDto;
import com.spring.university.model.Course;
import com.spring.university.model.Department;
import com.spring.university.model.Instructor;
import com.spring.university.repository.CourseRepo;
import com.spring.university.repository.DepartmentRepo;
import com.spring.university.repository.InstructorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;
    private final DepartmentRepo departmentRepo;
    private final InstructorRepo instructorRepo;


    public Course addCourse(String name, int credits, Long departmentId) {
        // Create a new course
        Course course = new Course();
        course.setName(name);
        course.setCredits(credits);

        // Fetch the department by its ID
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Assign the department to the course
        course.setDepartment(Collections.singletonList(department));
        department.getCourses().add(course);

        // Save the new course
        return courseRepo.save(course);
    }


    // Create Course
//    public Response createCourse(Course course) {
//        if (courseRepo.existsById(course.getId().intValue())) {
//            throw new RuntimeException("Course already exists");
//        }
//        courseRepo.save(course);
//
//        return Response.builder()
//                .success(true)
//                .message("Course created successfully")
//                .data(course)
//                .build();
//    }

    // Get Course by ID
    public Response getCourseById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return Response.builder()
                .success(true)
                .message("Course retrieved successfully")
                .data(course)
                .build();
    }


    // Update Course
    public Response updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (courseDto.getDepartmentId() != null) {
            // Fetch the department by its ID
            Department department = departmentRepo.findById(courseDto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            course.getDepartment().add(department);
//            course.setDepartment((List<Department>) department); //from Fukker AI
        }
        if (courseDto.getInstructorId() != null) {
            // Fetch the instructor by its ID
            Instructor instructor = instructorRepo.findById(courseDto.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
//            course.getInstructors().clear(); // Clear existing instructors
//            course.getInstructors().add(instructor);
//            instructor.getCourses().add(course);
        }

        if (courseDto.getName() != null) {
            course.setName(courseDto.getName());
        }

        if (courseDto.getCredits() != null) {
            course.setCredits(courseDto.getCredits());
        }

        courseRepo.save(course);
        return Response.builder()
                .success(true)
                .message("Course updated successfully")
                .data(course)
                .build();
    }



    // Delete Course
    public Response deleteCourse(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseRepo.delete(course);

        return Response.builder()
                .success(true)
                .message("Course deleted successfully")
                .build();
    }

    // Get All Courses
    public Response getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return Response.builder()
                .success(true)
                .message("Courses retrieved successfully")
                .data(courses)
                .build();
    }





}
