package org.neyamul.socialmedia;

import org.neyamul.socialmedia.model.Post;
import org.neyamul.socialmedia.model.SocialGroup;
import org.neyamul.socialmedia.model.SocialProfile;
import org.neyamul.socialmedia.model.SocialUser;
import org.neyamul.socialmedia.repository.PostRepository;
import org.neyamul.socialmedia.repository.SocialGroupRepository;
import org.neyamul.socialmedia.repository.SocialProfileRepository;
import org.neyamul.socialmedia.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SocialUserRepository socialUserRepository;

    @Autowired
    private SocialProfileRepository socialProfileRepository;

    @Autowired
    private SocialGroupRepository socialGroupRepository;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some sample data for SocialUser
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            //Save the users to the database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Create some Groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            //Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save the groups to the database
            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            // Add users to the groups
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);

            //Save the users to the database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Create Some Posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Add users to the posts
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            // Save the posts to the database
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            //Create some profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Set the users for the profiles
            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            // Save the profiles to the database
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            //FetchTypes
            System.out.println("Fetch Types");
            socialUserRepository.findById(1L);

        };
    }

    }