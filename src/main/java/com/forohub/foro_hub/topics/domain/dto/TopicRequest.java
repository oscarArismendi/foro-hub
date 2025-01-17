package com.forohub.foro_hub.topics.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequest(
    @NotBlank String title,
    @NotBlank String message,
    @NotNull Long authorId,
    @NotNull Long courseId
) {}
