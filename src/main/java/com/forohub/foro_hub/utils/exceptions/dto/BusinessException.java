package com.forohub.foro_hub.utils.exceptions.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private String code;
    private HttpStatus status;
    
    public BusinessException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
