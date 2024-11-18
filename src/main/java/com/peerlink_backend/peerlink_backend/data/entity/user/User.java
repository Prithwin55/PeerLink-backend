package com.peerlink_backend.peerlink_backend.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peerlink_backend.peerlink_backend.data.entity.comment.Comment;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String email;
    @JsonIgnore
    @Column(name="password")
    private String password;
    @Column(name="gender")
    private String gender;
    @Column(name="followers")
    private List<Long> followers=new ArrayList<>();
    @Column(name="following")
    private List<Long> following=new ArrayList<>();

    @Column(name = "posts")
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();

    @Column(name="savedPost")
    @ManyToMany
    private List<Post> savedPosts=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments=new ArrayList<>();

    @ManyToMany
    @Column(name = "likedComments")
    private List<Comment> likedComments=new ArrayList<>();
}
