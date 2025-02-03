package com.nayamul.Journal.restcontroller;

import com.nayamul.Journal.dio.JournalEntry;
import com.nayamul.Journal.dio.User;
import com.nayamul.Journal.service.JournalService;
import com.nayamul.Journal.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/user")
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<User> updateEntry(@RequestBody User user,@PathVariable ObjectId id) {
        return ResponseEntity.ok(userService.updateUser(user,user.getId()));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUserById(id);
        return  new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
//    @GetMapping("/get/{email}")
//    public ResponseEntity<List<User>> getUserByEmail(@PathVariable String email) {
//        return ResponseEntity.ok(userService.getAllUsers().stream().filter(e-> Objects.equals(e.getEmail(),email)).toList());
//    }
//    @GetMapping("/get/{userName}")
//    public ResponseEntity<List<User>> getEntryByAuthor(@PathVariable String userName) {
//        return ResponseEntity.ok(userService.getAllUsers().stream().filter(e-> Objects.equals(e.getUserName(),userName)).toList());
//    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
