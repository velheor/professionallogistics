package com.velheor.internship.exception;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ErrorMessage {

    private final LocalDateTime timestamp;
    private final String message;
}
