package com.peerlink_backend.peerlink_backend.data.service.comment.impl;

import com.peerlink_backend.peerlink_backend.api.dto.comment.CommentDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.comment.CommentMapper;
import com.peerlink_backend.peerlink_backend.data.entity.comment.Comment;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.repository.comment.CommentRepository;
import com.peerlink_backend.peerlink_backend.data.repository.post.PostRepository;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;
    UserRepository userRepository;
    PostRepository postRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto, long postID, String jwt) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        Post post=postRepository.findById(postID)
                .orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
        Comment comment=new Comment(commentDto.getId(), commentDto.getContent(), user,post);
        commentRepository.save(comment);
        return CommentMapper.INSTANCE.mapToDto(comment);
    }
}
