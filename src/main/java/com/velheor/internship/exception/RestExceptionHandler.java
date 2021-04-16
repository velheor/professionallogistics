package com.velheor.internship.exception;

import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage entityNotFoundException(EntityNotFoundException ex) {
        log.info(ex.getMessage());
        return new ErrorMessage(LocalDateTime.now().toString(), ex.getMessage());
    }
}
