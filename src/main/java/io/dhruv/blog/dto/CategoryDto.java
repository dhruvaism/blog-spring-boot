package io.dhruv.blog.dto;

import io.dhruv.blog.entity.Category;
import lombok.Data;

@Data
public class CategoryDto {

    private Long id;
    private String name;

    public static CategoryDto from(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

}
