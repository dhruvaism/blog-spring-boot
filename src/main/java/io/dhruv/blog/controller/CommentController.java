package io.dhruv.blog.controller;

import io.dhruv.blog.dto.CommentDto;
import io.dhruv.blog.entity.Comment;
import io.dhruv.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/blog/{blogId}/user/{userId}/comment/add")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto, @PathVariable Long blogId,@PathVariable Long userId){
        Comment comment = commentService.addComment(blogId,userId, Comment.from(commentDto));
        return new ResponseEntity<>(CommentDto.from(comment), HttpStatus.OK);
    }

    @GetMapping("blog/{blogId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByBlogId(@PathVariable Long blogId){
          List<Comment> comments = commentService.getCommentsByBlogId(blogId);
          List<CommentDto> commentDtos = comments.stream().map(CommentDto::from).collect(Collectors.toList());
          return new ResponseEntity<>(commentDtos,HttpStatus.OK);

    }

}
