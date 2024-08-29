package com.peerlink_backend.peerlink_backend.api.dto.post;

import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String caption;
    private String image;
    private String video;
    private LocalDateTime createdAt;
    private UserDto user;
    private List<UserDto> liked;
//    private List<UserDto> like;
}
