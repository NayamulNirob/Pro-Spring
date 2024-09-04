package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.Student;
import com.nirob.springBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStu(Student s) {
        studentRepository.save(s);
    }

    public List<Student> getAllstu() {
        return studentRepository.findAll();
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found By Id: " + id)
        );
    }

    public void updateStu(Student s, int id) {
        studentRepository.save(s);
    }
}
