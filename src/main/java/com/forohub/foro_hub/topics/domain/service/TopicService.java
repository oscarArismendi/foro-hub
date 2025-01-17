package com.forohub.foro_hub.topics.domain.service;

import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;

public interface TopicService {
    TopicResponse createTopic(TopicRequest request);
}
