package com.hawaya.socialapp.service;

import com.hawaya.socialapp.dto.UserDTO;
import com.hawaya.socialapp.mappers.SocialMapper;
import com.hawaya.socialapp.model.User;
import com.hawaya.socialapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final SocialMapper socialMapper;
    private final UserRepository userRepository;


    public Long register(UserDTO userDTO) {
        User user = socialMapper.userDTOToUser(userDTO);
        user = userRepository.save(user);
        return user.getId();
    }

    public Boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.isPresent() ? true : false;
    }


}
