package com.peerlink_backend.peerlink_backend.data.service.chat.impl;

import com.peerlink_backend.peerlink_backend.api.dto.chat.ChatDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.chat.ChatMapper;
import com.peerlink_backend.peerlink_backend.api.mapper.post.PostMapper;
import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.repository.chat.ChatRepository;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.chat.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
    ChatRepository chatRepository;
    UserRepository userRepository;
    @Override
    public ChatDto createChat(String jwt, long id) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));

        User user1=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        Chat isExist=chatRepository.findChatByUserId(user,user1);
        if(isExist!=null){
            return ChatMapper.INSTANCE.mapToDto(isExist);
        }
        Chat chat=new Chat();
        chat.getUsers().add(user);
        chat.getUsers().add(user1);
        chat.setTimestamp(LocalDateTime.now());

        return ChatMapper.INSTANCE.mapToDto(chatRepository.save(chat));

    }

    @Override
    public ChatDto findChatById(long id) {
       Chat chat= chatRepository.findById(id).
        orElseThrow(()->new ResourceNotFoundException("Chat Not Found"));

       return ChatMapper.INSTANCE.mapToDto(chat);
    }

    @Override
    public List<ChatDto> findUsersChat(long userId) {
        List<ChatDto> chats=chatRepository.findByUsersId(userId).
                stream()
                .map((e)-> ChatMapper.INSTANCE.mapToDto(e))
                .collect(Collectors.toList());
        return chats;
    }
}
