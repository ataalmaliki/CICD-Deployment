package com.hawaya.socialapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String address;

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private List<Post> posts;

}
