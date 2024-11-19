package com.peerlink_backend.peerlink_backend.data.repository.reel;

import com.peerlink_backend.peerlink_backend.data.entity.reel.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReelRepository extends JpaRepository<Reel,Long> {
    List<Reel> findByUserId(long userId);
}
