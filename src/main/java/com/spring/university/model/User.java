package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.university.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email; //(email OR username)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "student_id",nullable = true)
    private Student student;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "instructor_id",nullable = true)
    private Instructor instructor;
}
