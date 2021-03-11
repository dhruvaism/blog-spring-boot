package io.dhruv.blog.controller;

import io.dhruv.blog.dto.UserDto;
import io.dhruv.blog.entity.User;
import io.dhruv.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestBody final UserDto userDto){
           User user = userService.addUser(User.from(userDto));
           return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<User> users = userService.getUsers();
        List<UserDto> userDtos = users.stream().map(UserDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable final Long userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }





}
