package io.dhruv.blog.service;

import io.dhruv.blog.entity.Blog;
import io.dhruv.blog.entity.Category;
import io.dhruv.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogService blogService;

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByBlogId(Long blogId){
        Blog blog = blogService.getBlog(blogId);
        return blog.getCategories();
    }

    public Category getCategoryByCatId(Long catId){
        return categoryRepository.findById(catId).get();
    }



}
