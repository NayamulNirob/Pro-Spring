package com.nirob.springBoot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Entity
@Data
@Table(name = "students")


public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private int id;
    @Column (nullable = false,length = 50,name = "stuName")
    private String name;
    @Column (nullable = false)
    private int age;
    @Column (nullable = false)
    private String gender;
    @Column (nullable = false)
    private Date birthday;

}
