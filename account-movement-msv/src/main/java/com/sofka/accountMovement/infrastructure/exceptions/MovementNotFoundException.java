package com.sofka.accountMovement.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class MovementNotFoundException extends BaseException {
    public MovementNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
