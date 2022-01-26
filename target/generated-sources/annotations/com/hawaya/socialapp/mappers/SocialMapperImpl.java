package com.hawaya.socialapp.mappers;

import com.hawaya.socialapp.dto.PostDTO;
import com.hawaya.socialapp.dto.UserDTO;
import com.hawaya.socialapp.model.Post;
import com.hawaya.socialapp.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T14:26:13+0300",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class SocialMapperImpl implements SocialMapper {

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setAddress( userDTO.getAddress() );
        user.setEmail( userDTO.getEmail() );
        user.setId( userDTO.getId() );
        user.setPassword( userDTO.getPassword() );
        user.setUserName( userDTO.getUserName() );

        return user;
    }

    @Override
    public Post postDTOToPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setContent( postDTO.getContent() );
        post.setCreationDate( postDTO.getCreationDate() );
        post.setId( postDTO.getId() );

        return post;
    }

    @Override
    public PostDTO postToPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setContent( post.getContent() );
        postDTO.setCreationDate( post.getCreationDate() );
        postDTO.setId( post.getId() );

        return postDTO;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAddress( user.getAddress() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setId( user.getId() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setUserName( user.getUserName() );

        return userDTO;
    }

    @Override
    public List<PostDTO> postListToPostDTOList(List<Post> list) {
        if ( list == null ) {
            return null;
        }

        List<PostDTO> list1 = new ArrayList<PostDTO>( list.size() );
        for ( Post post : list ) {
            list1.add( postToPostDTO( post ) );
        }

        return list1;
    }

    @Override
    public List<UserDTO> userListToUserDTOList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDTO> list1 = new ArrayList<UserDTO>( list.size() );
        for ( User user : list ) {
            list1.add( userToUserDTO( user ) );
        }

        return list1;
    }
}
