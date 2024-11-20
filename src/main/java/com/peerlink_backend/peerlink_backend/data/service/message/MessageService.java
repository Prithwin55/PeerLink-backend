package com.peerlink_backend.peerlink_backend.data.service.message;

import com.peerlink_backend.peerlink_backend.api.dto.message.MessageDto;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;

import java.util.List;

public interface MessageService {

    public MessageDto createMessage(User user, long chatId, MessageDto messageDto);
    public List<MessageDto>findChatMessages(long chatId,User user);
}
