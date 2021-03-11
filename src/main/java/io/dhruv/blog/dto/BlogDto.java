package io.dhruv.blog.dto;

import io.dhruv.blog.entity.Blog;
import lombok.Data;

@Data
public class BlogDto {

    private Long id;

    private String title;
    private String description;
    private CreatedByDto createdByDto;

    public static BlogDto from(Blog blog){
        BlogDto blogDto = new BlogDto();
        blogDto.setDescription(blog.getDescription());
        blogDto.setId(blog.getId());
        blogDto.setTitle(blog.getTitle());
        blogDto.setCreatedByDto(CreatedByDto.from(blog.getUser()));
        return blogDto;
    }

}
