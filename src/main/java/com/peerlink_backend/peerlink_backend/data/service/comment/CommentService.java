package com.peerlink_backend.peerlink_backend.data.service.comment;

import com.peerlink_backend.peerlink_backend.api.dto.comment.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,long postID,String jwt);
}
