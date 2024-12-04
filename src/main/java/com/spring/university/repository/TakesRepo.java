package com.spring.university.repository;

import com.spring.university.model.Course;
import com.spring.university.model.Section;
import com.spring.university.model.Student;
import com.spring.university.model.Takes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakesRepo extends JpaRepository<Takes, Long>{


    boolean existsByStudentAndCourseAndSection(Student student, Course course, Section section);
}



