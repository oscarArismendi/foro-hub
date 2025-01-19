package com.forohub.foro_hub.topics.infrastructure.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forohub.foro_hub.topics.domain.dto.TopicFullResponse;
import com.forohub.foro_hub.topics.domain.dto.TopicRequest;
import com.forohub.foro_hub.topics.domain.dto.TopicResponse;
import com.forohub.foro_hub.topics.domain.dto.UpdateTopicRequest;
import com.forohub.foro_hub.topics.domain.service.TopicService;

import jakarta.transaction.Transactional;
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

     @GetMapping
    public ResponseEntity<Page<TopicResponse>> listAll(Pageable pageable) {
        Page<TopicResponse> topics = topicService.listAll(pageable);
        return ResponseEntity.ok(topics);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicFullResponse> update(@PathVariable Long id,@RequestBody @Valid UpdateTopicRequest data) {
        return topicService.update( id, data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> findTopic(@PathVariable Long id) {
        ResponseEntity<TopicResponse> response = topicService.findTopic(id);
        return response;
    }
}
