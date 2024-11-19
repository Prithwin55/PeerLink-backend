package com.peerlink_backend.peerlink_backend.api.controller.story;

import com.peerlink_backend.peerlink_backend.api.dto.reel.ReelDto;
import com.peerlink_backend.peerlink_backend.api.dto.story.StoryDto;
import com.peerlink_backend.peerlink_backend.data.service.story.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/peerlink/story")
public class StoryController {
    StoryService storyService;
    @PostMapping("/create")
    public ResponseEntity<StoryDto> createReel(@RequestHeader("Authorization")String jwt, @RequestBody StoryDto storyDto){
        return new ResponseEntity<>(storyService.createStory(storyDto,jwt), HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<StoryDto>> findUsersReel(@PathVariable long id){
        return new ResponseEntity<>(storyService.findStoryByUserId(id), HttpStatus.OK);
    }
}
