package com.spring.university.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
//    private String email;
    private String phone;


    @OneToOne(mappedBy = "instructor")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "advisor")
    private List<Student> students;

    @OneToMany(mappedBy = "instructor")
    private List<Teaches> teaches;


}
