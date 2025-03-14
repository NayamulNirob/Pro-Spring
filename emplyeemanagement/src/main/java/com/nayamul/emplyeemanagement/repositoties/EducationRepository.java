package com.nayamul.emplyeemanagement.repositoties;

import com.nayamul.emplyeemanagement.entites.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {
}
