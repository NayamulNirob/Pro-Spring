package org.neyamul.ecomarceproject.repository;

import org.neyamul.ecomarceproject.model.AppRole;
import org.neyamul.ecomarceproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
