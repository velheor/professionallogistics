package com.velheor.internship.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final String message;
    private final List<String> errors;
    private final LocalDateTime timestamp;

    public ErrorMessage(String message, String errors,
                        LocalDateTime timestamp) {
        this.message = message;
        this.errors = Collections.singletonList(errors);
        this.timestamp = timestamp;
    }
}
