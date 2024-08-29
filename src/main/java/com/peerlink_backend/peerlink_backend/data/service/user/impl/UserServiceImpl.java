package com.peerlink_backend.peerlink_backend.data.service.user.impl;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.user.UserMapper;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceAlreadyExistException;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.user.UserService;
import com.peerlink_backend.peerlink_backend.data.validations.user.UserValidation;
import com.peerlink_backend.peerlink_backend.data.validations.user.impl.UserValidationImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserValidation userValidation;
    @Override
    public UserDto registerUser(UserDto userDto) {
        if(userValidation.checkEmailAlreadyExist(userDto.getEmail()))
            throw  new ResourceAlreadyExistException("User Already Exist With Same Email");
        User user= UserMapper.INSTANCE.mapToEntity(userDto);

        return UserMapper.INSTANCE.mapToDto(userRepository.save(user));
    }

    @Override
    public List<UserDtoDetails> getAllUsers() {
        List<UserDtoDetails> users=userRepository.findAll()
                .stream().map((e)->UserMapper.INSTANCE.mapToDetails(e))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDtoDetails findUserById(long id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
        System.out.println(user.getPosts());
        return UserMapper.INSTANCE.mapToDetails(user);
    }

    @Override
    public UserDto findUserByEmail(String email) {
      User user=  userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
        return UserMapper.INSTANCE.mapToDto(user);
    }

    @Override
    public UserDto followUser(String jwt, long userId2) {
        String email=JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));
        long userId1=user.getId();
        if(!(userValidation.checkUserExistById(userId1)&&userValidation.checkUserExistById(userId2)))
            throw  new ResourceNotFoundException("User Not Found");
        if(userValidation.checkAlreadyFollows(userId1,userId2))
            throw new ResourceAlreadyExistException("User already follows");
        Optional<User> user1=userRepository.findById(userId1);
        Optional<User> user2 =userRepository.findById(userId2);
        user2.get().getFollowers().add(userId1);
        user1.get().getFollowing().add(userId2);

       userRepository.save(user1.get());
       userRepository.save(user2.get());

       return UserMapper.INSTANCE.mapToDto(user1.get());
    }

    @Override
    public UserDto updateUser(String jwt,UserDto userDto) {

        String email=JwtProvider.getEmailFromJwtToken(jwt);
        User oldUser=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user Not Found"));

        if(!userValidation.checkUserExistById(oldUser.getId()))
            throw new ResourceNotFoundException("UserNotFound");
//        User oldUser=userRepository.findById(userDto.getId()).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
        if(userDto.getFirstName()!=null)
            oldUser.setFirstName(userDto.getFirstName());
        if(userDto.getLastName()!=null)
            oldUser.setLastName(userDto.getLastName());
        if(userDto.getPassword()!=null)
            oldUser.setPassword(userDto.getPassword());
        if(userDto.getEmail()!=null)
            oldUser.setEmail(userDto.getEmail());
        if(userDto.getGender()!=null)
            oldUser.setGender(userDto.getGender());
        if(userDto.getFollowers()!=null)
            oldUser.setFollowers(userDto.getFollowers());
        if(userDto.getFollowing()!=null)
            oldUser.setFollowing(userDto.getFollowing());

       User saved= userRepository.save(oldUser);
       return UserMapper.INSTANCE.mapToDto(saved);
    }

    @Override
    public List<UserDto> searchUserByQuery(String query) {
      List<UserDto>userList=  userRepository.searchUserByQuery(query).stream()
                .map((e)->UserMapper.INSTANCE.mapToDto(e))
                .collect(Collectors.toList());
      return userList;
    }

    @Override
    public UserDto findUserByJwt(String jwt) {
        String email=JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
        return UserMapper.INSTANCE.mapToDto(user);
    }
}
