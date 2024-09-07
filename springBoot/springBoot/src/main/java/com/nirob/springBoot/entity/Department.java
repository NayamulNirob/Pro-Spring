package com.nirob.springBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;

    @JoinColumn(name = "facId")
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Faculty faculty;
}
