package com.springboot.blogproject.ServiceImpl;

import com.springboot.blogproject.Entities.Categories;
import com.springboot.blogproject.Exception.CategoryNotFoundException;
import com.springboot.blogproject.Payload.CategoryDto;
import com.springboot.blogproject.Repository.CategoryRepo;
import com.springboot.blogproject.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    private Categories categories;

    @Override


    public List<CategoryDto> getAllCategory(CategoryDto categoryDto) {
        List<Categories> category = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = category.stream().map((CategoryData) -> modelMapper.
                map(CategoryData, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategorybyId(int id) {
        Categories categories=categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("cId","Cid",id));
        CategoryDto categoryDto=modelMapper.map(categories,CategoryDto.class);
        return  categoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        Categories categories=categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("cId","Cid",id));
        categories.setCDescription(categoryDto.getCDescription());
        categories.setCTitle(categoryDto.getCTitle());
        categoryRepo.save(categories);

        return categoryDto;
    }

    @Override
    public String createCategory(CategoryDto categoryDto) {
       Categories categories1=modelMapper.map(categoryDto,Categories.class);
       categoryRepo.save(categories1);
        return "Data Saved succesfully";
    }

    @Override
    public List<CategoryDto> searchCategoryByKeyword(String keyword) {
        List<Categories>categories1=categoryRepo.findByCTitleContaining(keyword);
        List<CategoryDto>categoryDtos=categories1.stream().map(categories2 ->
                modelMapper.map(categories2,CategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }

    @Override
    public void deleteCategory(int id) {
        Categories categories=categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFoundException("cId","Cid",id));
        categoryRepo.delete(categories);
        return ;
    }
}
