package com.sofka.codeBase.infrastructure.adapters;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class BaseController {
    protected <T> ResponseEntity<T> createSuccessResponse(T body) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    protected ResponseEntity<Map<String, String>> createErrorResponse(Throwable throwable) {
        String errorMessage = throwable instanceof RuntimeException ? throwable.getMessage() : "Unexpected error";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("error", errorMessage));
    }

    protected <T> ResponseEntity<?> handleRequest(HandlerFunction<T> processingFunction) {
        try {
            return createSuccessResponse(processingFunction.handle());
        } catch (Throwable throwable) {
            return createErrorResponse(throwable);
        }
    }

    @FunctionalInterface
    public interface HandlerFunction<T> {
        T handle() throws Exception;
    }
}
