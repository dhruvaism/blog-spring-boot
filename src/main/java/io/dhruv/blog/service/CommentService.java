package io.dhruv.blog.service;

import io.dhruv.blog.entity.Blog;
import io.dhruv.blog.entity.Comment;
import io.dhruv.blog.entity.User;
import io.dhruv.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private BlogService blogService;
    private UserService userService;

    @Autowired
    public CommentService(CommentRepository commentRepository, BlogService blogService, UserService userService) {
        this.commentRepository = commentRepository;
        this.blogService = blogService;
        this.userService = userService;
    }

    @Transactional
    public Comment addComment(Long blogId,Long userId,Comment comment){
        Blog blog = blogService.getBlog(blogId);
        User user  = userService.getUser(userId);
        comment.setUser(user);
        blog.addComment(comment);
        return comment;
    }

    public List<Comment> getCommentsByBlogId(Long blogId){
         Blog blog = blogService.getBlog(blogId);
         return blog.getComments();
    }







}
