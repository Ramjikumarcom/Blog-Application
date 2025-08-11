package com.springboot.blogproject.Repository;

import com.springboot.blogproject.Entities.CommentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentEntity,Integer> {
}
