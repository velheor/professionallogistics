package com.velheor.internship.exception;

import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage entityNotFoundException(EntityNotFoundException ex) {
        log.info(ex.getMessage());
        return new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), ex.toString(),
            LocalDateTime.now());
    }
}
