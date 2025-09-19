package com.sofka.customerPerson.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class CustomerAlreadyExistsException extends BaseException {
    public CustomerAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
