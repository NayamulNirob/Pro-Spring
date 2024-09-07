package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.Faculty;
import com.nirob.springBoot.repository.DepartmentRepository;
import com.nirob.springBoot.repository.FacultyRepository;
import com.nirob.springBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;




    public void saveFaculty(Faculty f) {

        facultyRepository.save(f);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public void deleteFacultyById(Integer id) {
        facultyRepository.deleteById(id);
    }
    public Faculty findById(Integer id) {
        return facultyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Faculty found with id: " + id)
        );
    }
    public void updateFaculty( Faculty f, int id) {
        facultyRepository.save(f);
    }
}
