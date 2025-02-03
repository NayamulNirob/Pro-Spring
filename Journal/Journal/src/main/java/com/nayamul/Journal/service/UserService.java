package com.nayamul.Journal.service;

import com.nayamul.Journal.dio.User;
import com.nayamul.Journal.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user,ObjectId id) {
        return userRepository.save(user);
    }

    public User getUserById(ObjectId id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("NO User Found with this id")
        );
    }

    public void deleteUserById(ObjectId id) {
       userRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("NO User Found with this id"+id)
       );
       userRepository.deleteById(id);
    }


}
