package com.nayamul.employee_management.service;

import com.nayamul.employee_management.entity.User;
import com.nayamul.employee_management.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found With This"+id)
        );
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
