package com.peerlink_backend.peerlink_backend.api.response.reel;

import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReelDtoDetails {
    private long id;
    private String title;
    private String video;
}
