package org.neyamul.socialmedia.repository;

import org.neyamul.socialmedia.model.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {
}
