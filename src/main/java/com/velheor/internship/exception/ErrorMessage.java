package com.velheor.internship.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;

    public ErrorMessage(String message, String errors,
                        LocalDateTime timestamp) {
        this.message = message;
        this.errors = Collections.singletonList(errors);
        this.timestamp = timestamp;
    }
}
