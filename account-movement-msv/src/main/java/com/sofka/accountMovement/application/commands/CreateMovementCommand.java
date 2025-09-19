package com.sofka.accountMovement.application.commands;

import com.sofka.codeBase.application.ports.in.IQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CreateMovementCommand implements IQuery {
    private String accountNumber;
    private String movementType;
    private BigDecimal value;
}
