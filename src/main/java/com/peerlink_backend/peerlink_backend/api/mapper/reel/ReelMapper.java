package com.peerlink_backend.peerlink_backend.api.mapper.reel;

import com.peerlink_backend.peerlink_backend.api.dto.reel.ReelDto;
import com.peerlink_backend.peerlink_backend.data.entity.reel.Reel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReelMapper {
    ReelMapper INSTANCE= Mappers.getMapper(ReelMapper.class);
    ReelDto mapToDto(Reel reel);
    Reel mapToEntity(ReelDto reel);
}
