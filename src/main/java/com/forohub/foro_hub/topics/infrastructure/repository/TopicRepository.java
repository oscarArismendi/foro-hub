package com.forohub.foro_hub.topics.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forohub.foro_hub.topics.domain.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitleAndMessage(String title, String message);
}
