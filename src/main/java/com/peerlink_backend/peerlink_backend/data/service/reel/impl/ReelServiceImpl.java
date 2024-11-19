package com.peerlink_backend.peerlink_backend.data.service.reel.impl;

import com.peerlink_backend.peerlink_backend.api.dto.reel.ReelDto;
import com.peerlink_backend.peerlink_backend.api.jwt.JwtProvider;
import com.peerlink_backend.peerlink_backend.api.mapper.reel.ReelMapper;
import com.peerlink_backend.peerlink_backend.data.entity.reel.Reel;
import com.peerlink_backend.peerlink_backend.data.entity.user.User;
import com.peerlink_backend.peerlink_backend.data.repository.reel.ReelRepository;
import com.peerlink_backend.peerlink_backend.data.repository.user.UserRepository;
import com.peerlink_backend.peerlink_backend.data.service.reel.ReelService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReelServiceImpl implements ReelService {
    UserRepository userRepository;
    ReelRepository reelRepository;
    @Override
    public ReelDto createReel(ReelDto reelDto, String jwt) {
        String email= JwtProvider.getEmailFromJwtToken(jwt);
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        Reel reel= ReelMapper.INSTANCE.mapToEntity(reelDto);
        reel.setUser(user);
       return ReelMapper.INSTANCE.mapToDto(reelRepository.save(reel));
    }

    @Override
    public List<ReelDto> findAllReel() {
        List<ReelDto> reels=reelRepository.findAll()
                .stream().map((e)-> ReelMapper.INSTANCE.mapToDto(e)).
                collect(Collectors.toList());
        return reels;
    }

    @Override
    public List<ReelDto> findUserReel(long userId) {
        List<ReelDto> reels= reelRepository.findByUserId(userId)
                .stream().map((e)-> ReelMapper.INSTANCE.mapToDto(e)).
                collect(Collectors.toList());
        return reels;
    }
}
