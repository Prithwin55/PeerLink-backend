package com.peerlink_backend.peerlink_backend.api.mapper.message;

import com.peerlink_backend.peerlink_backend.api.dto.message.MessageDto;
import com.peerlink_backend.peerlink_backend.api.mapper.post.PostMapper;
import com.peerlink_backend.peerlink_backend.data.entity.message.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE= Mappers.getMapper(MessageMapper.class);

    MessageDto mapToDto(Message message);
    Message mapToEntity(MessageDto messageDto);
}
