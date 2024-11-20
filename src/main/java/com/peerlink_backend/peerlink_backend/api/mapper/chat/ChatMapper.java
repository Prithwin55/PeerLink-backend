package com.peerlink_backend.peerlink_backend.api.mapper.chat;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE= Mappers.getMapper(ChatMapper.class);
    ChatDto mapToDto(Chat chat);
    Chat mapToEntity(ChatDto chatDto);
}
