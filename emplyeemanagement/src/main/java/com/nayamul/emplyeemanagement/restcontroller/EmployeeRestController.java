package com.nayamul.emplyeemanagement.restcontroller;

import com.nayamul.emplyeemanagement.entites.Employee;
import com.nayamul.emplyeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee/")
@CrossOrigin("*")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("get")
    public ResponseEntity<List<Employee>>getAllEmployees() {
        List<Employee>Employees =employeeService.getAllEmployee();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }
    @PostMapping("save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee Employee) {
        employeeService.saveEmployee(Employee);
        return new ResponseEntity<>(Employee, HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee Employee) {
        Employee employees=employeeService.updateEmployee(Employee,id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee country= employeeService.findEmployeeById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}

