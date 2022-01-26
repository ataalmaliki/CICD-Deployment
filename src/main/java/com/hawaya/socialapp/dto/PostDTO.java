package com.hawaya.socialapp.dto;

import lombok.Data;

@Data
public class PostDTO {
    private Long id;
    private String content;
    private String creationDate;
}