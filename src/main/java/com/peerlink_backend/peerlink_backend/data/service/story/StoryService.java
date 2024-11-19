package com.peerlink_backend.peerlink_backend.data.service.story;

import com.peerlink_backend.peerlink_backend.api.dto.story.StoryDto;

import java.util.List;

public interface StoryService {

    StoryDto createStory(StoryDto storyDto,String jwt);
    List<StoryDto> findStoryByUserId(long id);
}
