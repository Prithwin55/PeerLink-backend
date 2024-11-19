package com.peerlink_backend.peerlink_backend.api.response.story;

import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryDtoDetails {
    private long id;

    private String image;

    private String caption;

    private LocalDateTime timestamp;
}
