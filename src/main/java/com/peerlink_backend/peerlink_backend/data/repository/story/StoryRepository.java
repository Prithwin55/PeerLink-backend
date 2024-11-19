package com.peerlink_backend.peerlink_backend.data.repository.story;

import com.peerlink_backend.peerlink_backend.data.entity.story.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {
    List<Story> findByUserId(long userId);
}
