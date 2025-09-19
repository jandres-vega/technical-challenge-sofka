package com.sofka.accountMovement.application.mappers;

import com.sofka.accountMovement.application.dto.response.AccountResponse;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements IBaseMapper<Account, AccountResponse> {
    @Override
    public AccountResponse map(Account source) {
        return AccountResponse.builder()
                .id(source.getId())
                .accountNumber(source.getAccountNumber())
                .accountType(source.getAccountType())
                .initialBalance(source.getInitialBalance())
                .currentBalance(source.getCurrentBalance())
                .status(source.getStatus())
                .customerId(source.getCustomerId())
                .build();
    }
}
