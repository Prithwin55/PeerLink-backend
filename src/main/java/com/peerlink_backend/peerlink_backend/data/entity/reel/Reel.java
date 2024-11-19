package com.peerlink_backend.peerlink_backend.data.entity.reel;

import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reel")
@Getter
@Setter
public class Reel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "video")
    private String video;

    @ManyToOne
    private User user;

}
