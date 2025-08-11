package com.springboot.blogproject.Service;

import com.springboot.blogproject.Payload.CategoryDto;
import com.springboot.blogproject.Payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<CategoryDto> getAllCategory(CategoryDto categoryDto);

    CategoryDto getCategorybyId(int id);

    CategoryDto updateCategory(CategoryDto categoryDto,int id);

    String createCategory(CategoryDto categoryDto);
    List<CategoryDto> searchCategoryByKeyword(String keyword);
    void deleteCategory(int id);

}
