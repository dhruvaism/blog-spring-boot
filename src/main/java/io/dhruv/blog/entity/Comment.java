package io.dhruv.blog.entity;


import io.dhruv.blog.dto.CommentDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @ManyToOne
    private Blog blog;

    @ManyToOne //bi directional
    private User user;

    public static Comment from(CommentDto commentDto){
         Comment comment = new Comment();
         comment.setComment(commentDto.getComment());
         return comment;
    }


}
