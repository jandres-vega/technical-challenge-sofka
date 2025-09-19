package com.sofka.codeBase.infrastructure.exceptions;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {
    private final HttpStatus status;
    private final Map<String, Object> additionalDetails;

    public BaseException(String message, HttpStatus status, Exception exception, Throwable throwable) {
        super(message, throwable != null ? throwable : exception);
        this.status = status;
        this.additionalDetails = new HashMap<>();
    }

    public BaseException(String message, HttpStatus status) {
        this(message, status, null, null);
    }

    public BaseException(String message, HttpStatus status, Exception exception) {
        this(message, status, exception, null);
    }

    public BaseException(String message, HttpStatus status, Throwable throwable) {
        this(message, status, null, throwable);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Map<String, Object> getAdditionalDetails() {
        return additionalDetails;
    }

    public void addDetail(String key, Object value) {
        additionalDetails.put(key, value);
    }
}
