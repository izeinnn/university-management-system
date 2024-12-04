package com.spring.university.Controller;

import com.spring.university.dto.TeachesRequestDTO;
import com.spring.university.model.Teaches;
import com.spring.university.service.TeachesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teaches")
@AllArgsConstructor
public class TeachesController {

    private final TeachesService teachesService;

    @GetMapping("/section/{sectionId}")
    public List<Teaches> getTeachesBySection(@PathVariable Long sectionId) {
        return teachesService.findBySectionId(sectionId);
    }

    @PostMapping
    public Teaches addTeaches(@RequestBody TeachesRequestDTO teachesRequestDTO) {
        return teachesService.addTeaches(teachesRequestDTO);
    }
}