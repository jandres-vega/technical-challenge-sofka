package com.sofka.accountMovement.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistsException extends BaseException {

    public AccountAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
