package com.sofka.accountMovement.application.usecases.query;

import com.sofka.accountMovement.application.query.GetAccountQuery;
import com.sofka.accountMovement.application.dto.response.AccountResponse;
import com.sofka.accountMovement.application.services.AccountService;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAccountQueryHandler implements IQueryHandler<GetAccountQuery, AccountResponse> {

    private final AccountService accountService;
    private final IBaseMapper<Account, AccountResponse> accountMapper;

    @Override
    public AccountResponse handle(GetAccountQuery query) {
        Account account = accountService.getAccountById(query.getId());
        return accountMapper.map(account);
    }
}
