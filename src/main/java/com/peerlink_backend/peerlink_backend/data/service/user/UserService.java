package com.peerlink_backend.peerlink_backend.data.service.user;

import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;

import java.util.List;

public interface UserService {
    public UserDto registerUser(UserDto userDto);
    public List<UserDtoDetails>getAllUsers();
    public UserDtoDetails findUserById(long id);
    public UserDto findUserByEmail(String email);
    public UserDto followUser(String jwt,long userId2);
    public UserDto updateUser(String jwt,UserDto userDto);
    public List<UserDto> searchUserByQuery(String query);
    public UserDto findUserByJwt(String jwt);
}
