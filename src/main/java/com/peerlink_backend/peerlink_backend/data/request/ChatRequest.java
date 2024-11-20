package com.peerlink_backend.peerlink_backend.data.request;

import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRequest {
 long userId;
}
