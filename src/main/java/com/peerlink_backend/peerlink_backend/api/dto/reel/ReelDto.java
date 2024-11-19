package com.peerlink_backend.peerlink_backend.api.dto.reel;

import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReelDto {
    private long id;
    private String title;
    private String video;
    private UserDtoDetails user;
}
