package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.entity.Student;
import com.nirob.springBoot.repository.DepartmentRepository;
import com.nirob.springBoot.repository.FacultyRepository;
import com.nirob.springBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }


    public void saveStu(Student s) {

       Department department= departmentRepository.findById(s.getDepartment().getId()).orElseThrow(
               () -> new RuntimeException("Department not found")
       );
       s.setDepartment(department);

//       s.setDepartment(departmentRepository.findById(s.getDepartment().getId()).orElseThrow(
//               () -> new IllegalArgumentException("Department not found")
//       ));

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

    public void updateStu( Student s,int id) {
        studentRepository.save(s);
    }
}
