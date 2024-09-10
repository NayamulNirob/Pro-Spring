package com.nirob.springBoot.service;

import com.nirob.springBoot.entity.User;
import com.nirob.springBoot.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
    public void update(User user,int id) {
        userRepository.save(user);
    }
}
