package com.peerlink_backend.peerlink_backend.api.mapper.user;

import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {})
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User mapToEntity(UserDto userDto);
    UserDto mapToDto(User user);

    UserDtoDetails mapToDetails(User user);
}
