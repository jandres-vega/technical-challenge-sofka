package com.sofka.customerPerson.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class DuplicateIdentificationException extends BaseException {

    public DuplicateIdentificationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
