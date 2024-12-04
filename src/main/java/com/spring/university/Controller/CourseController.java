package com.spring.university.Controller;

import com.spring.university.Response;
import com.spring.university.dto.CourseDto;
import com.spring.university.model.Course;
import com.spring.university.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    // Create Course
    @PostMapping
        public ResponseEntity<Course> createCourse(@RequestParam String name, @RequestParam int credits, @RequestParam Long departmentId) {
            Course course = courseService.addCourse(name, credits, departmentId);
        return ResponseEntity.ok(course);
    }
    /*or
    //    public ResponseEntity<Course> createCourse(@RequestBody CourseDto course) {
          Course newCourse = courseService.addCourse
          (course.getName(), course.getCredits(),
           course.getDepartmentId());
     */


    @GetMapping("/{id}")
    public Response getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Update a course
    @PutMapping("/{id}")
    public Response updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    // Delete a course
    @DeleteMapping("/{id}")
    public Response deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    // Get all courses
    @GetMapping
    public Response getAllCourses() {
        return courseService.getAllCourses();
    }
}
