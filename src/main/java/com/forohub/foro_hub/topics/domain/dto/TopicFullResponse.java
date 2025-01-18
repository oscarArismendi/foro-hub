package com.forohub.foro_hub.topics.domain.dto;

public record TopicFullResponse(
    String title,
    String message,
    String status,
    Long authorId,
    Long courseId
) {}
