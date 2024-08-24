package com.practice.FirstSpringBoot.restcontroller;

import com.practice.FirstSpringBoot.entity.Student;
import com.practice.FirstSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllstu();
    }

    @PostMapping("/save")
    public void saveStudent(@RequestBody  Student s) {
    studentService.saveStu(s);
    } 
    @RequestMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public void updateStudent(@RequestBody Student s,@PathVariable int id) {
        studentService.updateStu(s,id);
    }

}
