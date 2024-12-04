package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@ToString
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String building;
    private Double budget;

    @JsonIgnore
//    @ToString.Exclude
    @OneToMany(mappedBy = "department")
    private List<Instructor> instructors;

    @JsonIgnore
//    @ToString.Exclude
    @ManyToMany()
    @JoinTable( name = "department_course",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses ;

    // this for MockData class
    // Include instructor and course counts to avoid full list recursion
//    @ToString.Include(name = "instructorCount")
//    public int getInstructorCount() {
//        return instructors != null ? instructors.size() : 0;
//    }
//
//    @ToString.Include(name = "courseCount")
//    public int getCourseCount() {
//        return courses != null ? courses.size() : 0;
//    }
//


}
