package io.dhruv.blog.dto;

import io.dhruv.blog.entity.User;
import lombok.Data;

@Data
public class CreatedByDto {

    private Long id;
    private String userName;

    public static CreatedByDto from(User user){
        CreatedByDto createdByDto = new CreatedByDto();
        createdByDto.setId(user.getId());
        createdByDto.setUserName(user.getUsername());
        return createdByDto;
    }


}
