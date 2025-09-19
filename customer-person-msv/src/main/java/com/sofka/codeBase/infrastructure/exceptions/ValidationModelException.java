package com.sofka.codeBase.infrastructure.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationModelException extends BaseException {
    public ValidationModelException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
