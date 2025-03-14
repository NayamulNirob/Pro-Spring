package com.nayamul.emplyeemanagement.services;

import com.nayamul.emplyeemanagement.entites.Education;
import com.nayamul.emplyeemanagement.entites.Education;
import com.nayamul.emplyeemanagement.repositoties.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    EducationRepository educationRepository;


    public List<Education> getAllEducation(){
        return educationRepository.findAll();
    }

    public Education saveEducation(Education Education) {

        return educationRepository.save(Education);
    }


    public Education findEducationById(Long id) {
        return educationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Education found with id: " + id)
        );
    }



    public Education updateEducation(Education Education, Long id) {
        return educationRepository.save(Education);
    }

    public void deleteEducationById(Long id) {

        Education country = educationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No Education found with id: " + id));
    }
}
