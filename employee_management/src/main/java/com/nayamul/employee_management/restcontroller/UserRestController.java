package com.nayamul.employee_management.restcontroller;

import com.nayamul.employee_management.entity.User;
import com.nayamul.employee_management.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/user/")
public class UserRestController {

    final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<User> login( @RequestBody User request) {
       userRepository.save(request);
       return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
