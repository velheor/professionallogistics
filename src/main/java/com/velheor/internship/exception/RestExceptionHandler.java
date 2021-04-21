package com.velheor.internship.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.info(ex.getMessage());

        List<String> errors = ex.getBindingResult().getAllErrors().stream()
            .filter(error -> error instanceof FieldError)
            .map(error -> (FieldError) error)
            .map(error -> error.getField() + " : " + error.getDefaultMessage())
            .collect(Collectors.toList());
        return new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), errors,
            LocalDateTime.now());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JwtAuthenticationException.class)
    public ErrorMessage jwtAuthenticationException(JwtAuthenticationException ex) {
        log.info(ex.getMessage());
        return new ErrorMessage(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex.toString(),
            LocalDateTime.now());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorMessage badCredentialsException(BadCredentialsException ex) {
        log.info(ex.getMessage());
        return new ErrorMessage(HttpStatus.UNAUTHORIZED, ex.getMessage(),
            "Incorrect email or password",
            LocalDateTime.now());
    }
}
