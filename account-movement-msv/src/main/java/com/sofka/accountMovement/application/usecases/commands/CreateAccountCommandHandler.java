package com.sofka.accountMovement.application.usecases.commands;

import com.sofka.accountMovement.application.commands.CreateAccountCommand;
import com.sofka.accountMovement.application.dto.response.AccountResponse;
import com.sofka.accountMovement.application.services.AccountService;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateAccountCommandHandler implements ICommandHandler<CreateAccountCommand, AccountResponse> {

    private final AccountService accountService;
    private final IBaseMapper<Account, AccountResponse> accountMapper;

    @Override
    public AccountResponse handle(CreateAccountCommand command) {
        Account account = new Account(
                command.getAccountNumber(),
                command.getAccountType(),
                command.getInitialBalance(),
                command.getCustomerId()
        );

        Account savedAccount = accountService.createAccount(account);
        return accountMapper.map(savedAccount);
    }
}
