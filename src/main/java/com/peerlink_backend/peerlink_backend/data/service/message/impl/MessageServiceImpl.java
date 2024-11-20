package com.peerlink_backend.peerlink_backend.data.service.message.impl;

import com.peerlink_backend.peerlink_backend.api.dto.message.MessageDto;
import com.peerlink_backend.peerlink_backend.api.mapper.chat.ChatMapper;
import com.peerlink_backend.peerlink_backend.api.mapper.message.MessageMapper;
import com.peerlink_backend.peerlink_backend.api.mapper.user.UserMapper;
import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import com.peerlink_backend.peerlink_backend.data.entity.message.Message;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import com.peerlink_backend.peerlink_backend.data.repository.chat.ChatRepository;
import com.peerlink_backend.peerlink_backend.data.repository.message.MessageRepository;
import com.peerlink_backend.peerlink_backend.data.request.ChatRequest;
import com.peerlink_backend.peerlink_backend.data.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    MessageRepository messageRepository;
    ChatRepository chatRepository;

    @Override
    public MessageDto createMessage(User user, long chatId, MessageDto messageDto) {

        Chat chat= chatRepository.findById(chatId).
        orElseThrow(()->new ResourceNotFoundException("Chat Not Found"));

        messageDto.setTimestamp(LocalDateTime.now());
        messageDto.setChat(ChatMapper.INSTANCE.mapToDto(chat));
        messageDto.setUser(UserMapper.INSTANCE.mapToDetails(user));

        messageRepository.save(MessageMapper.INSTANCE.mapToEntity(messageDto));

        return messageDto;
    }

    @Override
    public List<MessageDto> findChatMessages(long chatId,User user) {
        Chat chat= chatRepository.findById(chatId).
                orElseThrow(()->new ResourceNotFoundException("Chat Not Found"));

        if(chat.getUsers().contains(user)){
            List<MessageDto> message=messageRepository.findByChatId(chatId).stream()
                    .map((e)->MessageMapper.INSTANCE.mapToDto(e)).collect(Collectors.toList());
            return message;
        }else{
            throw new ResourceNotFoundException("Cannot access others message");
        }


    }
}
