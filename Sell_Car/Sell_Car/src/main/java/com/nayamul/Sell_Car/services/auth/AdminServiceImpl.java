package com.nayamul.Sell_Car.services.auth;

import com.nayamul.Sell_Car.entaties.User;
import com.nayamul.Sell_Car.enums.UserRole;
import com.nayamul.Sell_Car.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl {
    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        Optional<User> OptionalAdmin = userRepository.findByUserRole(UserRole.ADMIN);
        if(OptionalAdmin.isEmpty()){
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@test.com");
            admin.setUserRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
            System.out.println("Admin created successfully");

        }
        else{
            System.out.println("Admin already exists");
        }
    }
}
