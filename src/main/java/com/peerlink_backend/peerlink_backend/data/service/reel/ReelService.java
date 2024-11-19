package com.peerlink_backend.peerlink_backend.data.service.reel;

import com.peerlink_backend.peerlink_backend.api.dto.reel.ReelDto;
import com.peerlink_backend.peerlink_backend.data.entity.reel.Reel;

import java.util.List;

public interface ReelService {
    public ReelDto createReel(ReelDto reel,String jwt);
    public List<ReelDto> findAllReel();
    public List<ReelDto> findUserReel(long userId);
}
