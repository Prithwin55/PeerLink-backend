package com.peerlink_backend.peerlink_backend.api.dto.chat;

import com.peerlink_backend.peerlink_backend.api.response.message.MessageDtoDetails;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatDto {
    private long id;

    private String chat_name;

    private String chat_image;

    private List<UserDtoDetails> users=new ArrayList<>();

    private LocalDateTime timestamp;

    private  List<MessageDtoDetails> messages;
}
