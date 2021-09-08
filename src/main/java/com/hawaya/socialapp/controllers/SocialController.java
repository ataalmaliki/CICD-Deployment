package com.hawaya.socialapp.controllers;

import com.hawaya.socialapp.dto.PostDTO;
import com.hawaya.socialapp.dto.UserDTO;
import com.hawaya.socialapp.service.PostServiceImpl;
import com.hawaya.socialapp.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class SocialController {

    private final UserServiceImpl userService;
    private final PostServiceImpl postService;

    @PostMapping("/users/register")
    public Long register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @GetMapping("/users/login")
    public boolean login(String email, String password) {
        return userService.login(email, password);
    }

    @PostMapping("/users/{userId}/post")
    public Long addPost(@PathVariable Long userId, @RequestBody PostDTO postDTO) {
        return postService.addPost(userId, postDTO);
    }

    @PostMapping("/users/{userId}/posts")
    public List<PostDTO> getPosts(@PathVariable Long userId) {
        return postService.getPosts(userId);
    }


}
