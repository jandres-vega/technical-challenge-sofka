package com.sofka.accountMovement.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
