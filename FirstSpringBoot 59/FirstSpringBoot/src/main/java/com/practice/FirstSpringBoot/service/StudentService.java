package com.practice.FirstSpringBoot.service;
import java.util.List;
import com.practice.FirstSpringBoot.entity.Student;
import com.practice.FirstSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;

public void saveStu(Student s){
    studentRepository.save(s);
}
public List<Student> getAllstu(){
  return studentRepository.findAll();
}

public void deleteById(int id){
    studentRepository.deleteById(id);
}
public Student findById(int id){
    return studentRepository.findById(id).get();
}


}
