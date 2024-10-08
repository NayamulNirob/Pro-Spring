package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Student;
import com.nirob.springBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

//    @GetMapping("view")
//    public List<Student> getAllStudents() {
//        return studentService.getAllstu();
//    }
//    @GetMapping("view")
//    public ResponseEntity<List<Student>> getAllStudents() {
//        studentService.getAllstu();
//        return ResponseEntity.ok().body(studentService.getAllstu());
//    }

    @GetMapping("view")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student>students=studentService.getAllstu();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
//
//    @PostMapping("save")
//    public void saveStudent(@RequestBody Student s) {
//        studentService.saveStu(s);
//    }

    @PostMapping("save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student s) {
        studentService.saveStu(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

//    @DeleteMapping("delete/{id}")
//    public void deleteStudent(@PathVariable int id) {
//        studentService.deleteById(id);
//    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
      studentService.deleteById(id);
      return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

//    @PutMapping("update/{id}")
//    public void updateStudent(@PathVariable int id, @RequestBody Student s) {
//        studentService.updateStu(s, id);
//    }
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student s) {
        studentService.updateStu(s, id);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }


}
