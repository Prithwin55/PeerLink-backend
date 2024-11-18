package com.peerlink_backend.peerlink_backend.api.dto.comment;

import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private long id;
    private String content;
    private UserDto userDto;
}
