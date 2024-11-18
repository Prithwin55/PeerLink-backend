package com.peerlink_backend.peerlink_backend.data.service.comment.impl;

import com.peerlink_backend.peerlink_backend.data.repository.comment.CommentRepository;
import com.peerlink_backend.peerlink_backend.data.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;
}
