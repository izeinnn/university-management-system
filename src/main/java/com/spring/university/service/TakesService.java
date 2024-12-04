package com.spring.university.service;


import com.spring.university.dto.TakesDto;
import com.spring.university.model.Course;
import com.spring.university.model.Section;
import com.spring.university.model.Student;
import com.spring.university.model.Takes;
import com.spring.university.repository.CourseRepo;
import com.spring.university.repository.SectionRepo;
import com.spring.university.repository.StudentRepo;
import com.spring.university.repository.TakesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



/*
* complete methods.
* may need to customize the query ourselves in repository.
*/


@Service
@AllArgsConstructor
public class TakesService {

    private final TakesRepo takesRepo;
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final SectionRepo sectionRepo;

    // Method to enroll a student in a course
    public Takes enrollStudentInCourse(TakesDto takesDto) {
        Student student = studentRepo.findById(takesDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(takesDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Section section = sectionRepo.findById(takesDto.getSectionId())
                .orElseThrow(() -> new RuntimeException("Section not found"));

        boolean exists = takesRepo.existsByStudentAndCourseAndSection(
                student, course, section);

        if (exists) {
            throw new RuntimeException("Student is already enrolled in this course and section");
        }

        Takes takes = new Takes();
        takes.setStudent(student);
        takes.setCourse(course);
        takes.setSection(section);
        takes.setSemester(takesDto.getSemester());
        takes.setYear(takesDto.getYear());
        takes.setGrade("N/A"); // Grade to be updated later after course completion

        return takesRepo.save(takes);
    }



}
