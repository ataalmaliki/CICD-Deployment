package com.hawaya.socialapp.service;

import com.hawaya.socialapp.dto.PostDTO;
import com.hawaya.socialapp.exception.BusinessException;
import com.hawaya.socialapp.mappers.SocialMapper;
import com.hawaya.socialapp.model.Post;
import com.hawaya.socialapp.model.User;
import com.hawaya.socialapp.repositories.PostRepository;
import com.hawaya.socialapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {

    private final SocialMapper socialMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public Long addPost(Long userId, PostDTO postDTO) {
        Post post = socialMapper.postDTOToPost(postDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("User Not found", "1001"));
        post.setUser(user);
        post = postRepository.save(post);
        return post.getId();
    }

    public List<PostDTO> getPosts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("User Not found", "1001"));
        return socialMapper.postListToPostDTOList(postRepository.findAllByUser(user));
    }

}
