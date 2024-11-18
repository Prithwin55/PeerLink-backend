package com.peerlink_backend.peerlink_backend.api.mapper.comment;

import com.peerlink_backend.peerlink_backend.api.dto.comment.CommentDto;
import com.peerlink_backend.peerlink_backend.data.entity.comment.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE= Mappers.getMapper(CommentMapper.class);

    Comment mapToEntity(CommentDto commentDto);

    CommentDto mapToDto(Comment comment);
}
