package com.sofka.customerPerson.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends BaseException {

    public CustomerNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
