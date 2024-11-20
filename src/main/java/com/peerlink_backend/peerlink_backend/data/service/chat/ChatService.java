package com.peerlink_backend.peerlink_backend.data.service.chat;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;

import java.util.List;

public interface ChatService {
    public ChatDto createChat(String jwt,long id);
    public ChatDto findChatById(long id);
    public List<ChatDto> findUsersChat(long userId);

}
