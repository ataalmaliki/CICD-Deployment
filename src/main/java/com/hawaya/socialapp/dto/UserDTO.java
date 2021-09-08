package com.hawaya.socialapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String email;
    private String password;
    private String address;

}