package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Department;
import com.nirob.springBoot.entity.Faculty;
import com.nirob.springBoot.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/faculty/")
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("view")
    public List<Faculty> saveFaculty() {
        return facultyService.getAllFaculty();
    }
    @PostMapping("save")
    public void saveFaculty(@RequestBody Faculty faculty) {
      facultyService.saveFaculty(faculty);
    }
    @PutMapping("update/{id}")
    public void updateFaculty(@RequestBody Faculty f, @PathVariable("id") int id) {
        facultyService.updateFaculty(f,id);
    }
    @DeleteMapping("delete/{id}")
    public void deleteFaculty(@PathVariable("id") int id) {
        facultyService.deleteFacultyById(id);
    }

}

