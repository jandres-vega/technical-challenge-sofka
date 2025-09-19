package com.sofka.accountMovement.application.usecases.query;

import com.sofka.accountMovement.application.query.GetAllAccountsQuery;
import com.sofka.accountMovement.application.dto.response.AccountResponse;
import com.sofka.accountMovement.application.services.AccountService;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllAccountsQueryHandler implements IQueryHandler<GetAllAccountsQuery, List<AccountResponse>> {

    private final AccountService accountService;
    private final IBaseMapper<Account, AccountResponse> accountMapper;

    @Override
    public List<AccountResponse> handle(GetAllAccountsQuery query) {
        List<Account> accounts = accountService.getAllAccounts();
        return accounts.stream().map(accountMapper::map).toList();
    }
}
