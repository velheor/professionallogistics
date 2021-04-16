package com.velheor.internship.exception;

import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage entityNotFoundException(EntityNotFoundException ex) {
        log.info(ex.getMessage());
        return new ErrorMessage(LocalDateTime.now(), ex.getMessage());
    }
}
