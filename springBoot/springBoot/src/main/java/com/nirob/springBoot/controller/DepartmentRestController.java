package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dep/")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("view")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("save")
    public void saveDepartment( @RequestBody Department d) {
        departmentService.saveDepartment(d);
    }
    @DeleteMapping("delete/{id}")
    public void deleteDepartment(@PathVariable("id") int id) {
     departmentService.deleteDepartmentById(id);
    }
    @PutMapping("update/{id}")
    public void updateDepartment(@PathVariable("id") int id,@RequestBody Department d) {
        departmentService.updateDepartment(d,id);
    }
}
