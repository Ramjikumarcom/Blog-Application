package com.springboot.blogproject.Repository;

import com.springboot.blogproject.Entities.Categories;
import com.springboot.blogproject.Entities.SocialPost;
import com.springboot.blogproject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<SocialPost, Integer> {
    // Corrected return type and method name
    List<SocialPost> findByCategories(Categories categories);

    // Corrected return type
    List<SocialPost> findByUser(User user);
    List<SocialPost>findByTitleContaining (String title);
}
