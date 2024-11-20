package com.peerlink_backend.peerlink_backend.data.entity.message;

import com.peerlink_backend.peerlink_backend.data.entity.chat.Chat;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "chat_id")
    @ManyToOne
    private Chat chat;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

}
