package com.practice.FirstSpringBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "studentName", length = 40)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date dob;
     @Column(nullable = false)
    private String cell;
    @Column(nullable = false)
    private String gender;

}
