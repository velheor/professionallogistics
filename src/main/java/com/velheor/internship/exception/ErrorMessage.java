package com.velheor.internship.exception;

import lombok.Data;

@Data
public class ErrorMessage {

    private final String timestamp;
    private final String message;
}
