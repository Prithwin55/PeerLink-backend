package com.peerlink_backend.peerlink_backend.data.service.post;

import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;

import java.util.List;

public interface PostService {
    PostDto createPost(String jwt,PostDto postDto);
    PostDto findPostById(long id);
    List<PostDto> findPostByUserId(UserDto user);
    String deletePost(String jwt,long postId);
    List<PostDto> findAllPost();
    PostDto likePost(String jwt,long postId);
    UserDtoDetails savePost(String jwt,long postId);
}
