package com.peerlink_backend.peerlink_backend.api.response.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDtoDetails {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private List<Long> followers;
    private List<Long> following;
    private List<PostDto> posts;
    private List<PostDto> savedPosts;
}
