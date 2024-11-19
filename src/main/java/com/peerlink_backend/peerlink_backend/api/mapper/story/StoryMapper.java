package com.peerlink_backend.peerlink_backend.api.mapper.story;

import com.peerlink_backend.peerlink_backend.api.dto.story.StoryDto;
import com.peerlink_backend.peerlink_backend.data.entity.story.Story;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoryMapper {
    StoryMapper INSTANCE= Mappers.getMapper(StoryMapper.class);

    StoryDto mapToDto(Story story);
    Story mapToEntity(StoryDto storyDto);
}
