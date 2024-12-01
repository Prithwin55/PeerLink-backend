package com.peerlink_backend.peerlink_backend.api.dto.user;
import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.response.post.PostDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private List<Long> followers;
    private List<Long> following;
    private List<PostDtoDetails> posts;
}