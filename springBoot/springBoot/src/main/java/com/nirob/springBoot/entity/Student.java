package com.nirob.springBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private int id;
    @Column (nullable = false,length = 50)
    private String name;
    @Column (nullable = false)
    private int age;
    @Column (nullable = false)
    private String gender;
    @Column (nullable = false)
    private Date birthday;

}
