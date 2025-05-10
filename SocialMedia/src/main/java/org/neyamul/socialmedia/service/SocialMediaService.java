package org.neyamul.socialmedia.service;

import org.neyamul.socialmedia.model.SocialUser;
import org.neyamul.socialmedia.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createUser(SocialUser user) {
        return socialUserRepository.save(user);
    }


    public void deleteUser(Long id) {
        socialUserRepository.deleteById(id);
    }
}
