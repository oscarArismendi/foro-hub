package com.forohub.foro_hub.topics.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;

public interface TopicService {
    TopicResponse createTopic(TopicRequest request);

    Page<TopicResponse> listAll(Pageable pageable);
}
