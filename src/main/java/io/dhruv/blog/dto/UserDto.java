package io.dhruv.blog.dto;

import io.dhruv.blog.entity.Blog;
import io.dhruv.blog.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {

    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    //private List<BlogDto> blogDtoList;

    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setDob(user.getDob());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        //userDto.setBlogDtoList(user.getBlogs().stream().map(BlogDto::from).collect(Collectors.toList()));
        return userDto;
    }

}
