package com.peerlink_backend.peerlink_backend.data.entity.chat;

import com.peerlink_backend.peerlink_backend.data.entity.message.Message;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "chat_name")
    private String chat_name;
    @Column(name = "chat_image")
    private String chat_image;
    @ManyToMany
    private List<User> users=new ArrayList<>();
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages=new ArrayList<>();
}
