package com.forohub.foro_hub.topics.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.forohub.foro_hub.topics.domain.dto.TopicFullResponse;
import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;
import com.forohub.foro_hub.topics.domain.dto.UpdateTopicRequest;

public interface TopicService {
    TopicResponse createTopic(TopicRequest request);

    Page<TopicResponse> listAll(Pageable pageable);

    ResponseEntity<TopicFullResponse> update(Long id,UpdateTopicRequest data);

    ResponseEntity<TopicResponse> findTopic(Long id);

    ResponseEntity<TopicResponse> deleteTopic(Long id);
}
