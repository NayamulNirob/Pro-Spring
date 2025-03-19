package com.nayamul.employee_management.restcontroller;

import com.nayamul.employee_management.entity.Department;
import com.nayamul.employee_management.repository.DepartmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/department/")
public class DepartmentRestController {

    final DepartmentRepository departmentRepository;

    public DepartmentRestController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("get")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity <Optional<Department>> getDepartmentById( @PathVariable int id) {
        Optional<Department> department = departmentRepository.findById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        departmentRepository.save(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department,@PathVariable int id) {
        departmentRepository.save(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Department> deleteDepartment(@RequestBody Department department, @PathVariable int id) {
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
