package com.springboot.blogproject.Controller;

import com.springboot.blogproject.Payload.Apiresponse;
import com.springboot.blogproject.Payload.CategoryDto;
import com.springboot.blogproject.Payload.UserDto;
import com.springboot.blogproject.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Apiresponse> PostData( @Valid  @RequestBody CategoryDto categoryDto){
        categoryService.createCategory(categoryDto);
        return  new ResponseEntity<>( new Apiresponse("Category Created Succesfully",true), HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<CategoryDto>> getAllCategory(CategoryDto categoryDto){
        List<CategoryDto>categoryDtos=categoryService.getAllCategory(categoryDto);
        return ResponseEntity.ok(categoryDtos);
    }

    @PutMapping(path = "/{id}")
    public  ResponseEntity<CategoryDto>UpdateData(@Valid @RequestBody CategoryDto categoryDto,@PathVariable int id){
       categoryDto= categoryService.updateCategory(categoryDto,id);
        return ResponseEntity.ok(categoryDto);
    }

   @GetMapping(path = "/{id}")
    public  ResponseEntity<CategoryDto>findCategory( @PathVariable int id){
       CategoryDto categoryDto=categoryService.getCategorybyId(id);
       return  ResponseEntity.ok(categoryDto);
   }

   @GetMapping(path = "/search/{keyword}")
   public ResponseEntity<List<CategoryDto>> searchCategory(@PathVariable String keyword ){
        List<CategoryDto>categoryDtos=categoryService.searchCategoryByKeyword(keyword);
        return ResponseEntity.ok(categoryDtos);
   }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Apiresponse>DeleteCategoryItem(@PathVariable int id){
       this.categoryService.deleteCategory(id);
        return  new ResponseEntity<Apiresponse>(new Apiresponse("Date Deleted Successfully",true),HttpStatus.OK);
    }
}
