package org.neyamul.socialmedia.repository;


import org.neyamul.socialmedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
