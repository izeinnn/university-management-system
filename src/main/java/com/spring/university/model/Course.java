package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer credits;

    //    private int year;

    @ManyToMany(mappedBy = "courses")
    private List<Department> department;


    @OneToMany(mappedBy = "course")
    @JsonBackReference
    private List<Teaches> teaches;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "course_instructor",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "instructor_id")
//    )
//    private List<Instructor> instructors;

}
