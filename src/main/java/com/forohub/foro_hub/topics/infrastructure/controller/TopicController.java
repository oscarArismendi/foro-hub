package com.forohub.foro_hub.topics.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;
import com.forohub.foro_hub.topics.domain.service.TopicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    // @Autowired is put automatically
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<TopicResponse> createTopic(@Valid @RequestBody TopicRequest request) {
        TopicResponse response = topicService.createTopic(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
