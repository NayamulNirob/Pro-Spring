package com.nayamul.Sell_Car.repositories;

import com.nayamul.Sell_Car.entaties.User;
import com.nayamul.Sell_Car.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findFirstByEmail(String email);

    Optional<User> findByUserRole(UserRole userRole);
}
