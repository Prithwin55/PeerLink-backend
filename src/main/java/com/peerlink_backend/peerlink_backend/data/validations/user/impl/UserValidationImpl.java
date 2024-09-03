package com.peerlink_backend.peerlink_backend.data.validations.user.impl;

import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceNotFoundException;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.validations.user.UserValidation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserValidationImpl implements UserValidation {
    UserRepository userRepository;

    public  boolean checkEmailAlreadyExist(String email){
       Optional<User>  user=userRepository.findByEmail(email);
       return user.isPresent();
    }

    @Override
    public boolean checkUserExistById(long id) {
        Optional<User> user= userRepository.findById(id);
        return user.isPresent();
    }

    @Override
    public boolean checkAlreadyFollows(long id1, long id2) {
       User user1= userRepository.findById(id1).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
       User user2= userRepository.findById(id2).orElseThrow(()->new ResourceNotFoundException("UserNotFound"));
        if(user2.getFollowers().contains(id2)||user1.getFollowing().contains(id2))
            return true;
        return false;
    }


}
