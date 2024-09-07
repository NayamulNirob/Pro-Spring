package com.nirob.springBoot.controller;

import com.nirob.springBoot.entity.Faculty;
import com.nirob.springBoot.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/faculty/")
@CrossOrigin("*")
public class FacultyRestController {
    private final FacultyService facultyService;

    public FacultyRestController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("view")
    public ResponseEntity<List<Faculty> > saveFaculty() {

        List<Faculty>faculties= facultyService.getAllFaculty();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
    @PostMapping("save")
    public ResponseEntity<String> saveFaculty(@RequestBody Faculty faculty) {
      facultyService.saveFaculty(faculty);
      return new ResponseEntity<>("Faculty saved", HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateFaculty(@RequestBody Faculty f, @PathVariable("id") int id) {
        facultyService.updateFaculty(f,id);
        return new ResponseEntity<>("Faculty updated", HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable("id") int id) {

        facultyService.deleteFacultyById(id);
        return new ResponseEntity<>("Faculty deleted", HttpStatus.OK);
    }

}

