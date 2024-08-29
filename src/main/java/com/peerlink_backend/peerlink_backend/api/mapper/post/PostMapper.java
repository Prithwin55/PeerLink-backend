package com.peerlink_backend.peerlink_backend.api.mapper.post;

import com.peerlink_backend.peerlink_backend.api.dto.post.PostDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.post.Post;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE= Mappers.getMapper(PostMapper.class);

    Post mapToEntity(PostDto postDto);
    PostDto mapToDto(Post post);

    UserDtoDetails maptoDetails(User user);
}
