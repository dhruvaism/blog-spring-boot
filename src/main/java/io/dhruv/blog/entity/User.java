package io.dhruv.blog.entity;

import io.dhruv.blog.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Blog> blogs = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Comment> comments = new ArrayList<>();

    public void addBlog(Blog blog){
        this.blogs.add(blog);
    }

    public void removeBlog(Blog blog){
        this.blogs.remove(blog);
    }

    public static User from(UserDto userDto){
        User user = new User();
        user.setDob(userDto.getDob());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }


}
