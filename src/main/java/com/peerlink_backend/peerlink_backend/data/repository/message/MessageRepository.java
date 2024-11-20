package com.peerlink_backend.peerlink_backend.data.repository.message;

import com.peerlink_backend.peerlink_backend.data.entity.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    public List<Message> findByChatId(long chatId);
}
