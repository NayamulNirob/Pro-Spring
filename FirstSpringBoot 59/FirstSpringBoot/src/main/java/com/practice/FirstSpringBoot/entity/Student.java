package com.practice.FirstSpringBoot.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

@Column(nullable = false,name = "studentName",length = 40)
    private String name;
@Column( nullable = false,unique = true)
    private String email;
@Column(nullable = false)
    private Date dob;
@Column(nullable = false,unique = true)
    private String cell;
@Column(nullable = false)
    private String gender;

}
