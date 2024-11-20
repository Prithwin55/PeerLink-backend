package com.peerlink_backend.peerlink_backend.api.controller.message;

import com.peerlink_backend.peerlink_backend.api.dto.comment.CommentDto;
import com.peerlink_backend.peerlink_backend.api.dto.message.MessageDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/peerlink/message")
public class MessageController {

    MessageService messageService;
    UserRepository userRepository;
    @PostMapping("/create/message/{chatId}")
    public ResponseEntity<MessageDto> createMessage(@RequestHeader("Authorization") String jwt, @PathVariable long chatId,@RequestBody MessageDto messageDto){
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));

       return new ResponseEntity<>( messageService.createMessage(user,chatId,messageDto), HttpStatus.CREATED);

    }
    @GetMapping("/message/{chatId}")
    public ResponseEntity<List<MessageDto>> findChatMessages(@RequestHeader("Authorization") String jwt, @PathVariable long chatId){
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));

       return ResponseEntity.ok(messageService.findChatMessages(chatId,user));

    }
}
