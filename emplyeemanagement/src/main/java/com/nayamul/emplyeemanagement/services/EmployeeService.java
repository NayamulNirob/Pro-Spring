package com.nayamul.emplyeemanagement.services;

import com.nayamul.emplyeemanagement.entites.Education;
import com.nayamul.emplyeemanagement.entites.Employee;
import com.nayamul.emplyeemanagement.repositoties.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;



    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }


    public Employee saveEmployee(Employee Employee) {

        return employeeRepository.save(Employee);
    }


    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Employee found with id: " + id)
        );
    }



    public Employee updateEmployee(Employee Employee, Long id) {
        return employeeRepository.save(Employee);
    }

    public void deleteEmployeeById(Long id) {

        Employee country = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Employee found with id: " + id));
    }

}
