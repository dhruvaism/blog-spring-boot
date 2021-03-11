package io.dhruv.blog.controller;

import io.dhruv.blog.dto.BlogDto;
import io.dhruv.blog.entity.Blog;
import io.dhruv.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog/user/{userId}/add")
    public ResponseEntity<BlogDto> addBlog(@RequestBody final BlogDto blogDto, @PathVariable final Long userId){
        Blog blog = blogService.addBlog(Blog.from(blogDto),userId);
        return new ResponseEntity<>(BlogDto.from(blog), HttpStatus.OK);
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable final Long blogId){
        Blog blog = blogService.getBlog(blogId);
        return new ResponseEntity<>(BlogDto.from(blog),HttpStatus.OK);
    }

    @GetMapping("/blogs/user/{userId}")
    public ResponseEntity<List<BlogDto>> getBlogsByUserId(@PathVariable final Long userId){
        List<Blog> blogs = blogService.getBlogs(userId);
        List<BlogDto> blogDtos = blogs.stream().map(BlogDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(blogDtos,HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllBlogs(){
        List<Blog> blogs = blogService.getAllBlogs();
        List<BlogDto> blogDtos = blogs.stream().map(BlogDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(blogDtos,HttpStatus.OK);
    }

    @PostMapping("/blog/{blogId}/category/{catId}/add")
    public ResponseEntity<String> assignCategory(@PathVariable Long blogId,@PathVariable Long catId){
        String s = blogService.addCategory(blogId,catId);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }





}
