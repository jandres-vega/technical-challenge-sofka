package com.sofka.accountMovement.infrastructure.exceptions;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class InsufficientBalanceException extends BaseException {

    public InsufficientBalanceException() {
        super("Saldo no disponible", HttpStatus.BAD_REQUEST);
    }
}
