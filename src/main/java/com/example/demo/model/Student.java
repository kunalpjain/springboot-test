package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    public Student(String name, Course addedCourse, University university) {
        this.name = name;
        this.course = addedCourse;
        this.university = university;
    }
}
