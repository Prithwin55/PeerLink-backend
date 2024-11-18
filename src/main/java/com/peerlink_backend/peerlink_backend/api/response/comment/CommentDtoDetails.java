package com.peerlink_backend.peerlink_backend.api.response.comment;


import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDtoDetails {
    private long id;
    private String content;
    private UserDto user;
    private PostDto post;
    //private List<UserDtoDetails> liked;
}
