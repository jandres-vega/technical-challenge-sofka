package com.sofka.accountMovement.application.usecases.commands;

import com.sofka.accountMovement.application.services.AccountService;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteAccountCommandHandler implements ICommandHandler<String, Void> {

    private final AccountService accountService;

    @Override
    public Void handle(String command) {
        accountService.deleteAccount(command);
        return null;
    }
}
