package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.entity.Faculty;
import com.nirob.springBoot.repository.DepartmentRepository;
import com.nirob.springBoot.repository.FacultyRepository;
import com.nirob.springBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final FacultyRepository facultyRepository;

    public DepartmentService(DepartmentRepository departmentRepository, FacultyRepository facultyRepository) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
    }


    public Department saveDepartment(Department d) {
        Faculty faculty=facultyRepository.findById(d.getFaculty().getId()).orElseThrow(
                () -> new RuntimeException("Faculty not found")
        );
        d.setFaculty(faculty);
        departmentRepository.save(d);
        return d;
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
   public void updateDepartment( Department d, int id) {
        departmentRepository.save(d);
   }
}
