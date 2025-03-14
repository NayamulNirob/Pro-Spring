package com.nayamul.emplyeemanagement.restcontroller;
import com.nayamul.emplyeemanagement.entites.Education;
import com.nayamul.emplyeemanagement.entites.Education;
import com.nayamul.emplyeemanagement.services.EducationService;
import com.nayamul.emplyeemanagement.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/education/")
@CrossOrigin("*")
public class EducationRestController {
    @Autowired
    EducationService educationService;


    @GetMapping("get")
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education>Educations =educationService.getAllEducation();
        return new ResponseEntity<>(Educations, HttpStatus.OK);
    }
    @PostMapping("save")
    public ResponseEntity<Education> saveEducation(@RequestBody Education Education) {
        educationService.saveEducation(Education);
        return new ResponseEntity<>(Education, HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable long id, @RequestBody Education Education) {
        Education employees=educationService.updateEducation(Education,id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable long id) {
        Education country= educationService.findEducationById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEducationById(@PathVariable long id) {
        educationService.deleteEducationById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
