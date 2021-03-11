package io.dhruv.blog.service;

import io.dhruv.blog.entity.Blog;
import io.dhruv.blog.entity.Category;
import io.dhruv.blog.entity.User;
import io.dhruv.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BlogService {

    private BlogRepository blogRepository;
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    public BlogService(BlogRepository blogRepository, UserService userService) {
        this.blogRepository = blogRepository;
        this.userService = userService;
    }

    @Transactional
    public Blog addBlog(Blog blog, Long user_id){
         User user = userService.getUser(user_id);
         blogRepository.save(blog);
         user.addBlog(blog);
         blog.setUser(user);
         return blog;
    }

    @Transactional
    public List<Blog> getBlogs(Long user_id){
        User user = userService.getUser(user_id);
        return user.getBlogs();
    }

    @Transactional
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @Transactional
    public Blog getBlog(Long blog_id){
        return blogRepository.findById(blog_id).get();
    }


    @Transactional
    public String addCategory(Long blogId,Long catId){
        Blog blog = getBlog(blogId);
        Category category = categoryService.getCategoryByCatId(catId);
        blog.addCategory(category);
        category.addBlog(blog);
        return category.getName()+" is Added Successfully";
    }

}
