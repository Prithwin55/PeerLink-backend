package com.peerlink_backend.peerlink_backend.api.authController;

import com.peerlink_backend.peerlink_backend.api.authFormats.LoginRequest;
import com.peerlink_backend.peerlink_backend.api.dto.user.UserDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.user.UserMapper;
import com.peerlink_backend.peerlink_backend.api.authFormats.AuthResponse;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.exception.ResourceAlreadyExistException;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.user.UserService;
import com.peerlink_backend.peerlink_backend.data.service.userDetailsService.CustomerUserDetailsService;
import com.peerlink_backend.peerlink_backend.data.validations.user.UserValidation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth/peerlink/user")
public class AuthController {
    UserService userService;
    PasswordEncoder passwordEncoder;
    UserValidation userValidation;
    UserRepository userRepository;
    CustomerUserDetailsService customerUserDetailsService;
    @PostMapping(value = "/signup")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody UserDto userDto){

        if(userValidation.checkEmailAlreadyExist(userDto.getEmail()))
            throw  new ResourceAlreadyExistException("User Already Exist With Same Email");
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user= UserMapper.INSTANCE.mapToEntity(userDto);
        User saved= userRepository.save(user);

        Authentication authentication=new UsernamePasswordAuthenticationToken(saved.getEmail(),saved.getPassword());

        String token= JwtProvider.generateToken(authentication);

        AuthResponse result=new AuthResponse(token,"USER REGISTERED SUCCESSFULLY");

        return new ResponseEntity(result,HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LoginRequest loginRequest){
        Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token= JwtProvider.generateToken(authentication);

        AuthResponse result=new AuthResponse(token,"USER LOGIN SUCCESSFULL");

        return new ResponseEntity(result,HttpStatus.OK);
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customerUserDetailsService.loadUserByUsername(email);
        if(userDetails==null)
            throw new BadCredentialsException("Invalid Username");
        if(!passwordEncoder.matches(password,userDetails.getPassword()))
            throw new BadCredentialsException("Invalid Password");
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
