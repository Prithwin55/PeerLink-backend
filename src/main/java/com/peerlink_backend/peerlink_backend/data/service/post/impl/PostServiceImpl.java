package com.peerlink_backend.peerlink_backend.data.service.post.impl;

import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.post.PostMapper;
import com.peerlink_backend.peerlink_backend.api.mapper.user.UserMapper;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceAlreadyExistException;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import com.peerlink_backend.peerlink_backend.data.repository.post.PostRepository;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.post.PostService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    UserRepository userRepository;
    @Override
    public PostDto createPost(String jwt,PostDto postDto) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        postDto.setUser(UserMapper.INSTANCE.mapToDto(user));
        Post post=PostMapper.INSTANCE.mapToEntity(postDto);
        return PostMapper.INSTANCE.mapToDto(postRepository.save(post));
    }

    @Override
    public PostDto findPostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("PostNotFound"));
        return PostMapper.INSTANCE.mapToDto(post);
    }

    @Override
    public List<PostDto> findPostByUserId(UserDto user) {
      List<PostDto> posts=  postRepository.findByUser(UserMapper.INSTANCE.mapToEntity(user)).stream()
                .map((e)->PostMapper.INSTANCE.mapToDto(e))
                .collect(Collectors.toList());
        return posts;
    }

    @Override
    public String deletePost(String jwt, long postId) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        Post post= postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("NOT FOUND"));
        if(post.getUser().getId()!=user.getId())
            throw new ResourceNotFoundException("Can't delete others post");
        postRepository.delete(post);
        return "Deleted";
    }

    @Override
    public List<PostDto> findAllPost() {
       return postRepository.findAll().stream()
                .map((e)-> PostMapper.INSTANCE.mapToDto(e))
                .collect(Collectors.toList());

    }

    @Override
    public PostDto likePost(String jwt, long postId) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        Post post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }else{
            post.getLiked().add(user);
        }
        return PostMapper.INSTANCE.mapToDto(postRepository.save(post));
    }

    @Override
    public UserDtoDetails savePost(String jwt, long postId) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        Post post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
        if(user.getSavedPosts().contains(post))
            user.getSavedPosts().remove(post);
        else
            user.getSavedPosts().add(post);
        return UserMapper.INSTANCE.mapToDetails(userRepository.save(user));
    }
}
