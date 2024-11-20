package com.peerlink_backend.peerlink_backend.api.dto.message;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageDto {
    private long id;

    private String content;

    private String image;

    private ChatDto chat;

    private UserDtoDetails user;

    private LocalDateTime timestamp;
}
