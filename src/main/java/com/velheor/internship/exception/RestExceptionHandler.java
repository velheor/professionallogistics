package com.velheor.internship.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return customHandleException(ex, errorMessage, HttpStatus.NOT_FOUND);
    }

    @Override
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .map(error -> error.getField() + " : " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(message)
                .path(Objects.requireNonNull(headers.getLocation()).getPath())
                .build();

        return handleExceptionInternal(ex, errorMessage, headers, status, request);
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<Object> handleJwtAuthenticationException(JwtAuthenticationException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(ex.getMessage())
                .path(Objects.requireNonNull(headers.getLocation()).getPath())
                .build();

        return handleExceptionInternal(ex, errorMessage, headers, status, request);
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex, HttpServletRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.FORBIDDEN.value())
                .message(ex.getMessage())
                .path(Objects.requireNonNull(request.getRequestURI()))
                .build();

        return customHandleException(ex, errorMessage, HttpStatus.FORBIDDEN);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        log.warn(ex.getMessage());
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<Object> customHandleException(Exception ex, Object message, HttpStatus status) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(message, status);
    }
}
