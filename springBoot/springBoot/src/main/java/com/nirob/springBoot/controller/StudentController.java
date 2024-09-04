package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Student;
import com.nirob.springBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/savestudentform")
    public String saveStudent(Model m) {
        m.addAttribute("student", new Student());
        m.addAttribute("title","Add New Student");
        return "savestudentform";
    }

    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute("student")  Student student) {
        studentService.saveStu(student);
        return "redirect:/showAllStudent";
    }
    @RequestMapping("/showAllStudent")
    public String showAllStudent(Model m) {
        List<Student>stuList=studentService.getAllstu();
        m.addAttribute("stuList", stuList);
        m.addAttribute("title","Show All Student");
        return "showAllStudent";
    }
    @RequestMapping("deletestudent/{id}")
    public String deleteStudent(@PathVariable("id")int id) {
        studentService.deleteById(id);
        return "redirect:/showAllStudent";
    }
    @RequestMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") int id, Model m) {
        Student s= studentService.findById(id);
        m.addAttribute("student", s);
        return "savestudentform";
    }




}
