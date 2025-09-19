package com.sofka.accountMovement.application.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MovementRequest {
    private String accountNumber;
    private String movementType;
    private BigDecimal value;
}
