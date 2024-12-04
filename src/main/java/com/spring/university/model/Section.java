package com.spring.university.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semester;
    private Long year;


    @ManyToOne
    @JoinColumn(name = "classroom_id")
    @JsonManagedReference
    @JsonIgnoreProperties({"building", "roomNumber", "capacity"}) // Ignore these fields in the response
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonManagedReference
    @JsonIgnoreProperties({"department","credits"})
    private Course course;

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    @JsonBackReference
    private List<Takes> takes;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    @JsonManagedReference
    private TimeSlot timeSlot;

    @OneToMany(mappedBy = "section")
    @JsonManagedReference
    private List<Teaches> teaches;
}
