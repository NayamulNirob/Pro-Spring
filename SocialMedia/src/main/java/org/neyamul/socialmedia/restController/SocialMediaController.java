package org.neyamul.socialmedia.restController;

import org.neyamul.socialmedia.model.SocialUser;
import org.neyamul.socialmedia.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-media/")
public class SocialMediaController {

    @Autowired
    private  SocialMediaService socialMediaService;

    @RequestMapping("users")
    public ResponseEntity<List<SocialUser>> getAllUsers() {
       List<SocialUser> users =socialMediaService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("users/create")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser user) {
        SocialUser createdUser = socialMediaService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        socialMediaService.deleteUser(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }



}
