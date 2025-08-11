package com.springboot.blogproject.Repository;


import com.springboot.blogproject.Entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Categories, Integer> {
   List<Categories>findByCTitleContaining(String CTitle);


}