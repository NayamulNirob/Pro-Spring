package com.nayamul.employee_management.service;

import com.nayamul.employee_management.entity.Department;
import com.nayamul.employee_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentClass {

    final DepartmentRepository departmentRepository;

    public DepartmentClass(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department findById(int id) {
        return departmentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Department not found With This"+id)
        );
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }

    public Department update(Department department,int id) {
        return departmentRepository.save(department);
    }
}
