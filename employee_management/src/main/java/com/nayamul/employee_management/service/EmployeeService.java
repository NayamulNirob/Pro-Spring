package com.nayamul.employee_management.service;

import com.nayamul.employee_management.entity.Employee;
import com.nayamul.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee with id " + id + " not found")
        );
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Employee employee, long id) {
        return employeeRepository.save(employee);
    }




}
