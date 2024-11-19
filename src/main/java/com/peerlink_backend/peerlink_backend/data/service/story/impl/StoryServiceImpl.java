package com.peerlink_backend.peerlink_backend.data.service.story.impl;

import com.peerlink_backend.peerlink_backend.api.dto.story.StoryDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.reel.ReelMapper;
import com.peerlink_backend.peerlink_backend.api.mapper.story.StoryMapper;
import com.peerlink_backend.peerlink_backend.data.entity.story.Story;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.repository.story.StoryRepository;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.story.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StoryServiceImpl implements StoryService {
    UserRepository userRepository;
    StoryRepository storyRepository;
    @Override
    public StoryDto createStory(StoryDto storyDto, String jwt) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        Story story= StoryMapper.INSTANCE.mapToEntity(storyDto);
        story.setUser(user);
       return StoryMapper.INSTANCE.mapToDto( storyRepository.save(story));

    }

    @Override
    public List<StoryDto> findStoryByUserId(long id) {
      List<StoryDto> stories=  storyRepository.findByUserId(id).stream()
                .map((e)-> StoryMapper.INSTANCE.mapToDto(e)).
                collect(Collectors.toList());
      return stories;
    }
}
