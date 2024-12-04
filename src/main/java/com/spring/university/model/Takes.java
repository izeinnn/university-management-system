package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Takes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semester;
    private Integer year;     //"Spring 2024" or "Fall 2023".
    private String grade; //will get value at end of the course. use public enum Grade {A, B, C, D, F, PASS, FAIL; }


    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
//    @JsonBackReference
    @JsonIgnoreProperties({"department"})
    private Course course;  // Assuming you have a Course entity

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonManagedReference
    @JsonIgnoreProperties({"course", "department"})
    private Section section;
}
