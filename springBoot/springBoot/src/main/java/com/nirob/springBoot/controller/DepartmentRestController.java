package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.entity.Faculty;
import com.nirob.springBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dep/")
@CrossOrigin("*")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("view")
    public ResponseEntity< List<Department>> getAllDepartments() {
        List<Department>departments= departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);

    }

    @PostMapping("save")
    public ResponseEntity<Department> saveDepartment( @RequestBody Department d) {
        departmentService.saveDepartment(d);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") int id) {
     departmentService.deleteDepartmentById(id);
     return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable("id") int id,@RequestBody Department d) {
        departmentService.updateDepartment(d,id);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
