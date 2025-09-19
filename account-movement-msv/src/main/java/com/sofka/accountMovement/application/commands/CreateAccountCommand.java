package com.sofka.accountMovement.application.commands;

import com.sofka.codeBase.application.ports.in.IQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountCommand implements IQuery {
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private String customerId;
}
