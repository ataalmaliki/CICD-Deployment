package com.hawaya.socialapp.mappers;

import com.hawaya.socialapp.dto.PostDTO;
import com.hawaya.socialapp.dto.UserDTO;
import com.hawaya.socialapp.model.Post;
import com.hawaya.socialapp.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocialMapper {

    public abstract User userDTOToUser(UserDTO userDTO);

    public abstract Post postDTOToPost(PostDTO postDTO);

    public abstract PostDTO postToPostDTO(Post post);

    public abstract UserDTO userToUserDTO(User user);

    @IterableMapping(elementTargetType = PostDTO.class)
    public abstract List<PostDTO> postListToPostDTOList(List<Post> list);

    @IterableMapping(elementTargetType = UserDTO.class)
    public abstract List<UserDTO> userListToUserDTOList(List<User> list);

}
