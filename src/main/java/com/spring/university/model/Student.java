package com.spring.university.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
//    private String email;
    private String phone;
    private Double total_cred;
//    private LocalDate enrollmentDate;  // Date the student officially started studies

    @OneToOne(mappedBy = "student")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "advisor_id")
    private Instructor advisor;

    @OneToMany(mappedBy = "student")
    private List<Takes> takes;


}
