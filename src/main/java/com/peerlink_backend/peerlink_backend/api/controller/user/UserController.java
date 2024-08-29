package com.peerlink_backend.peerlink_backend.api.controller.user;


import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.response.user.UserDtoDetails;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping(value="api/peerlink/user")
public class UserController {
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDtoDetails>> getAllUsers(){
       return new ResponseEntity<>( userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDtoDetails> findUserById(@PathVariable long id){
        return new ResponseEntity(userService.findUserById(id),HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email){
        return new ResponseEntity(userService.findUserByEmail(email),HttpStatus.OK);
    }

    @PostMapping("/follow/{userId2}")
    public ResponseEntity<UserDto> followUser(@RequestHeader("Authorization")String jwt,@PathVariable long userId2){
        return new ResponseEntity(userService.followUser(jwt,userId2),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestHeader("Authorization")String jwt,@RequestBody UserDto userDto){
        return new ResponseEntity(userService.updateUser(jwt,userDto),HttpStatus.OK);
    }

    @PostMapping("/search/{query}")
    public ResponseEntity<List<UserDto>> searchUserByQuery(@PathVariable String query){
        return ResponseEntity.ok(userService.searchUserByQuery(query));
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserFromToken(@RequestHeader("Authorization")String jwt){
        return ResponseEntity.ok(userService.findUserByJwt(jwt));
    }
}
