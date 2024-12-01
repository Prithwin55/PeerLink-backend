package com.peerlink_backend.peerlink_backend.api.response.post;

import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.comment.CommentDtoDetails;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDtoDetails {
    private long id;
    private String caption;
    private String image;
    private String video;
    private LocalDateTime createdAt;
    private List<UserDtoDetails> liked;
    private List<CommentDtoDetails> comments;
}
