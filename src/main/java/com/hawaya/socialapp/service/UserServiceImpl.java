package com.hawaya.socialapp.service;

import com.hawaya.socialapp.dto.UserDTO;
import com.hawaya.socialapp.exception.BusinessException;
import com.hawaya.socialapp.mappers.SocialMapper;
import com.hawaya.socialapp.model.User;
import com.hawaya.socialapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final SocialMapper socialMapper;
    private final UserRepository userRepository;

    public UserDTO register(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if (user.isPresent())
            throw new BusinessException("1002", "User Already Exist");
        else {
            User newUser = socialMapper.userDTOToUser(userDTO);
            return socialMapper.userToUserDTO(userRepository.save(newUser));
        }
    }

    public UserDTO login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent())
            return socialMapper.userToUserDTO(user.get());
        else
            throw new BusinessException("1001", "User Not Found");
    }

    public List<UserDTO> getUsers() {
        return socialMapper.userListToUserDTOList(userRepository.findAll());
    }

}
