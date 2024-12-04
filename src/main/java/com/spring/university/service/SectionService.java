package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.dto.SectionDto;
import com.spring.university.model.ClassRoom;
import com.spring.university.model.Course;
import com.spring.university.model.Section;
import com.spring.university.model.TimeSlot;
import com.spring.university.repository.ClassRoomRepo;
import com.spring.university.repository.CourseRepo;
import com.spring.university.repository.SectionRepo;
import com.spring.university.repository.TimeSlotRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService {

    private final SectionRepo sectionRepo;
    private final ClassRoomRepo classRoomRepo;
    private final CourseRepo courseRepo;
    private final TimeSlotRepo timeSlotRepo;

    // Add a new Section
    public Response addSection(SectionDto sectionDto) {

        // Fetch the related entities based on IDs from the DTO
        ClassRoom classRoom = classRoomRepo.findById(sectionDto.getClassRoomId())
                .orElseThrow(() -> new RuntimeException("ClassRoom not found with id: " + sectionDto.getClassRoomId()));

        Course course = courseRepo.findById(sectionDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + sectionDto.getCourseId()));

        TimeSlot timeSlot = timeSlotRepo.findById(sectionDto.getTimSlotId())
                .orElseThrow(() -> new RuntimeException("TimeSlot not found with id: " + sectionDto.getTimSlotId()));

        // Create the Section entity and set its values
        Section section = new Section();
        section.setSemester(sectionDto.getSemester());
        section.setYear(sectionDto.getYear());
        section.setClassRoom(classRoom);
        section.setCourse(course);
        section.setTimeSlot(timeSlot);

        // Save the Section entity
        sectionRepo.save(section);

        return Response.builder()
                .success(true)
                .message("Section added successfully")
                .data(section)
                .build();
    }


    // Update an existing Section
    public Response updateSection(Long id, SectionDto sectionDto) {

        Section existingSection = sectionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found with id: " + id));

        // Fetch the related entities
        ClassRoom classRoom = classRoomRepo.findById(sectionDto.getClassRoomId())
                .orElseThrow(() -> new RuntimeException("ClassRoom not found with id: " + sectionDto.getClassRoomId()));

        Course course = courseRepo.findById(sectionDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + sectionDto.getCourseId()));

        TimeSlot timeSlot = timeSlotRepo.findById(sectionDto.getTimSlotId())
                .orElseThrow(() -> new RuntimeException("TimeSlot not found with id: " + sectionDto.getTimSlotId()));

        // Update existing Section
        existingSection.setSemester(sectionDto.getSemester());
        existingSection.setYear(sectionDto.getYear());
        existingSection.setClassRoom(classRoom);
        existingSection.setCourse(course);
        existingSection.setTimeSlot(timeSlot);

        // Save the updated Section
        sectionRepo.save(existingSection);

        return Response.builder()
                .success(true)
                .message("Section updated successfully")
                .data(existingSection)
                .build();
    }

    // Delete a Section
    public Response deleteSection(Long id) {

        Section existingSection = sectionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found with id: " + id));

        sectionRepo.delete(existingSection);

        return Response.builder()
                .success(true)
                .message("Section deleted successfully")
                .data(existingSection)
                .build();
    }

    // Get a Section by ID
    public Response getSectionById(Long id) {

        Section section = sectionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found with id: " + id));

        return Response.builder()
                .success(true)
                .message("Section found successfully")
                .data(section)
                .build();
    }

    public List<Section> getAllSections() {
        List<Section> sections = sectionRepo.findAll();
        return sections;
    }
}
