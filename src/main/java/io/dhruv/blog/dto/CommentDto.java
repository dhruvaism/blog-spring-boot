package io.dhruv.blog.dto;

import io.dhruv.blog.entity.Comment;
import io.dhruv.blog.entity.User;
import lombok.Data;

@Data
public class CommentDto {

    private Long id;
    private String comment;
    private CommentedByDto commentedBy;

    public static CommentDto from(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setComment(comment.getComment());
        commentDto.setCommentedBy(CommentedByDto.from(comment.getUser()));
        return commentDto;
    }

}
