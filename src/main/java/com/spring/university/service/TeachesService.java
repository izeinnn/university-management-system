package com.spring.university.service;

import com.spring.university.dto.TeachesRequestDTO;
import com.spring.university.model.Course;
import com.spring.university.model.Instructor;
import com.spring.university.model.Section;
import com.spring.university.model.Teaches;
import com.spring.university.repository.CourseRepo;
import com.spring.university.repository.InstructorRepo;
import com.spring.university.repository.SectionRepo;
import com.spring.university.repository.TeachesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeachesService {

    private TeachesRepository teachesRepository;
    private CourseRepo courseRepo;
    private InstructorRepo instructorRepo;
    private SectionRepo sectionRepo;

    public List<Teaches> findBySectionId(Long sectionId) {
        return teachesRepository.findBySectionId(sectionId);
    }

    public Teaches addTeaches(TeachesRequestDTO teachesRequestDTO) {
        Course course = courseRepo.findById(teachesRequestDTO.getCourseId()).orElseThrow();
        Instructor instructor = instructorRepo.findById(teachesRequestDTO.getInstructorId()).orElseThrow();
        Section section = sectionRepo.findById(teachesRequestDTO.getSectionId()).orElseThrow();

        Teaches teaches = new Teaches();
        teaches.setCourse(course);
        teaches.setInstructor(instructor);
        teaches.setSection(section);
        teaches.setYear(teachesRequestDTO.getYear());

        return teachesRepository.save(teaches);
    }
}