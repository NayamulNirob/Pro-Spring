package com.practice.FirstSpringBoot.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

@Column(unique = true,nullable = false,name = "studentName")
    private String name;
@Column(unique = true,nullable = true)
    private String email;

    private Date dob;

    private String cell;

    private String gender;

}
