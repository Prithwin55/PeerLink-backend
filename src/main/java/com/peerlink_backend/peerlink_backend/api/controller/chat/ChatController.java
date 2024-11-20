package com.peerlink_backend.peerlink_backend.api.controller.chat;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.request.ChatRequest;
import com.peerlink_backend.peerlink_backend.data.service.chat.ChatService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/peerlink/chat")
public class ChatController {
    ChatService chatService;
    UserRepository userRepository;

    @PostMapping("/create/{id}")
    public ResponseEntity<ChatDto> createChat(@RequestHeader("Authorization") String jwt,@PathVariable long id){
        return new ResponseEntity( chatService.createChat(jwt,id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDto> findChatById(@PathVariable long id){
        return ResponseEntity.ok( chatService.findChatById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<List<ChatDto>> findUsersChat(@RequestHeader("Authorization") String jwt){
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        return ResponseEntity.ok(chatService.findUsersChat(user.getId()));
    }
}
