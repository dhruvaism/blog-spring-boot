package io.dhruv.blog.controller;

import io.dhruv.blog.dto.CategoryDto;
import io.dhruv.blog.entity.Category;
import io.dhruv.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.addCategory(Category.from(categoryDto));
        return  new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
    }

    @GetMapping("/category/{catId}")
    public ResponseEntity<CategoryDto> getCategoryByCatId(@PathVariable Long catId){
        Category category = categoryService.getCategoryByCatId(catId);
        return new ResponseEntity<>(CategoryDto.from(category),HttpStatus.OK);
    }

    @GetMapping("/category/blog/{blogId}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByBlogId(@PathVariable Long blogId){
          List<Category> categories = categoryService.getCategoriesByBlogId(blogId);
          List<CategoryDto> categoryDtos = categories.stream().map(CategoryDto::from).collect(Collectors.toList());
          return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }


}
