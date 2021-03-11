package io.dhruv.blog.dto;

import io.dhruv.blog.entity.User;
import lombok.Data;

@Data
public class CommentedByDto {

    private Long id;
    private String username;


    public static CommentedByDto from(User user){
        CommentedByDto commentedByDto = new CommentedByDto();
        commentedByDto.setId(user.getId());
        commentedByDto.setUsername(user.getUsername());
        return commentedByDto;
    }

}
