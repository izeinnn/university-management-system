package com.spring.university.Controller;

import com.spring.university.Response;
import com.spring.university.dto.SectionDto;
import com.spring.university.model.Section;
import com.spring.university.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@AllArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    // Add a new Section
    @PostMapping
    public ResponseEntity<Response> addSection(@RequestBody SectionDto sectionDto) {
        Response response = sectionService.addSection(sectionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Update an existing Section
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateSection(@PathVariable Long id, @RequestBody SectionDto sectionDto) {
        Response response = sectionService.updateSection(id, sectionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete a Section
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteSection(@PathVariable Long id) {
        Response response = sectionService.deleteSection(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get Section by ID
    @GetMapping("/{id}")
    public ResponseEntity<Response> getSectionById(@PathVariable Long id) {
        Response response = sectionService.getSectionById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sectionList= sectionService.getAllSections();
        return new ResponseEntity<>(sectionList, HttpStatus.OK);
    }

}
