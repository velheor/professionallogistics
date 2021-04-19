package com.velheor.internship.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final HttpStatus status;
    private final String message;
    private final List<String> errors;
    private final LocalDateTime timestamp;

    public ErrorMessage(HttpStatus status, String message, String errors,
        LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(errors);
        this.timestamp = timestamp;
    }
}
