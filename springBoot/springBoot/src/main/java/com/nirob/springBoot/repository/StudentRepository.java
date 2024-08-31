package com.nirob.springBoot.repository;

import com.nirob.springBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
