package io.dhruv.blog.entity;

import io.dhruv.blog.dto.BlogDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Blog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    private List<Comment> comments = new ArrayList<>();


    @ManyToMany(mappedBy = "blogs")
    List<Category> categories = new ArrayList<>();


    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public void removeCategory(Category category){
        categories.remove(category);
    }


    public static Blog from(BlogDto blogDto){
        Blog blog = new Blog();
        blog.setDescription(blogDto.getDescription());
        blog.setTitle(blogDto.getTitle());
        return blog;
    }


}
