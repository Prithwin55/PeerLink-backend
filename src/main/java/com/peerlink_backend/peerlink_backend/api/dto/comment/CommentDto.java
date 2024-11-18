package com.peerlink_backend.peerlink_backend.api.dto.comment;

import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private long id;
    private String content;
    private UserDto user;
    private PostDto post;
}
