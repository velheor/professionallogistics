package com.velheor.internship.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorMessage {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String path;
}
