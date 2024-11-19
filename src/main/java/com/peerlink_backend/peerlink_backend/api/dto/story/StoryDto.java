package com.peerlink_backend.peerlink_backend.api.dto.story;

import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoryDto {
    private long id;

    private UserDtoDetails user;

    private String image;

    private String caption;

    private LocalDateTime timestamp;
}
