package com.forohub.foro_hub.topics.domain.dto;

public record TopicResponse(
    Long id,
    String title,
    String message,
    String status
) {}
