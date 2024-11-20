package com.peerlink_backend.peerlink_backend.api.response.message;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDtoDetails {
    private long id;

    private String content;

    private String image;


    private UserDtoDetails user;

    private LocalDateTime timestamp;
}
