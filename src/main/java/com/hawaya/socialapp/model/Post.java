package com.hawaya.socialapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String content;
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
