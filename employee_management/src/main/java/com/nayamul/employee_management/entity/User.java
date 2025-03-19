package com.nayamul.employee_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String password;

    private String cell;

    private String address;

    private Date dob;

    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;
}
