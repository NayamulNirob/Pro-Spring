package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Student;
import com.nirob.springBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/api/")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("view")
    public List<Student> getAllStudents() {
        return studentService.getAllstu();
    }

    @PostMapping("save")
    public void saveStudent(@RequestBody Student s) {
        studentService.saveStu(s);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("update/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student s) {
        studentService.updateStu(s, id);
    }
}
