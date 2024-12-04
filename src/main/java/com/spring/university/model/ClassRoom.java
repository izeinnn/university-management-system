package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String building;
    private Integer roomNumber;
    private Integer capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "classRoom")
    @JsonBackReference
    private List<Section> sections;

}
