package com.peerlink_backend.peerlink_backend.api.controller.comment;

import com.peerlink_backend.peerlink_backend.api.dto.comment.CommentDto;
import com.peerlink_backend.peerlink_backend.data.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/peerlink/comment")
public class CommentController {
    CommentService commentService;
    @PostMapping("/create/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable long postId, @RequestHeader("Authorization") String jwt){
       return new ResponseEntity( commentService.createComment(commentDto,postId,jwt), HttpStatus.CREATED);
    }
}
