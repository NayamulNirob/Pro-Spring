package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public void saveDepartment(Department d) {
        departmentRepository.save(d);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

   public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
   }
   public Department findById(int id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No department found with id: " + id)
        );
   }
   public void updateDepartment(@RequestBody Department d, @PathVariable int id) {
        departmentRepository.save(d);
   }
}
