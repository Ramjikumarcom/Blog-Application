package com.springboot.blogproject.Repository;

import com.springboot.blogproject.Entities.User;
import com.springboot.blogproject.Payload.UserDto;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Use 'interface' instead of 'class'
public interface UserRepo extends JpaRepository<User, Integer> {

 public List<User>findByNameContaining (String name);
public Optional<User>findByEmail(String email);
}
