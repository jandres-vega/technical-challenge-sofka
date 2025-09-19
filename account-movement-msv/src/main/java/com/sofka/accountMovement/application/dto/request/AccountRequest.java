package com.sofka.accountMovement.application.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountRequest {
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private Boolean status;
    private String customerId;

}
