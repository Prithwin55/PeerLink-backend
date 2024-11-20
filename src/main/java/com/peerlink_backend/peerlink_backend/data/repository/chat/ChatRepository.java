package com.peerlink_backend.peerlink_backend.data.repository.chat;

import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    public List<Chat> findByUsersId(long userId);

    @Query("SELECT c FROM Chat c WHERE :user MEMBER OF c.users AND :reqUser MEMBER OF c.users")
    public Chat findChatByUserId(@Param("user")User user,@Param("reqUser") User reqUser);
}
