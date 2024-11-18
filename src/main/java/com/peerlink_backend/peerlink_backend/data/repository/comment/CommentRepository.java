package com.peerlink_backend.peerlink_backend.data.repository.comment;

import com.peerlink_backend.peerlink_backend.data.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
