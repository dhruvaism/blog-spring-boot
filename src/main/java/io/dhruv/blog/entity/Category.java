package io.dhruv.blog.entity;

import io.dhruv.blog.dto.CategoryDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "Category_Blog", joinColumns = @JoinColumn(name = "cat_id"), inverseJoinColumns = @JoinColumn(name = "blog_id"))
    List<Blog> blogs = new ArrayList<>();

    public void addBlog(Blog blog){
        blogs.add(blog);
    }

    public void removeBlog(Blog blog){
        blogs.remove(blog);
    }

    public static Category from(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }






}
