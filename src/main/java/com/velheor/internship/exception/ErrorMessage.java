package com.velheor.internship.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    @JsonCreator
    public ErrorMessage(@JsonProperty("timestamp") LocalDateTime timestamp,
                        @JsonProperty("status") Integer status,
                        @JsonProperty("error") String error,
                        @JsonProperty("message") String message,
                        @JsonProperty("path") String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }

    public static class ErrorMessageBuilder {
        private LocalDateTime timestamp;
        private Integer status;
        private String error;
        private String message;
        private String path;

        ErrorMessageBuilder() {
        }

        public ErrorMessageBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorMessageBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ErrorMessageBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ErrorMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessageBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(timestamp, status, error, message, path);
        }

        public String toString() {
            return "ErrorMessage.ErrorMessageBuilder(timestamp=" + this.timestamp + ", status=" + this.status + ", error=" + this.error + ", message=" + this.message + ", path=" + this.path + ")";
        }
    }
}
