package com.forohub.foro_hub.utils.exceptions.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
    String code,
    String message ) {}
