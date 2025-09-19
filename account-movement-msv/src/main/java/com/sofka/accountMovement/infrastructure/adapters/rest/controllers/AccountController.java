package com.sofka.accountMovement.infrastructure.adapters.rest.controllers;

import com.sofka.accountMovement.application.commands.CreateAccountCommand;
import com.sofka.accountMovement.application.query.GetAccountQuery;
import com.sofka.accountMovement.application.query.GetAllAccountsQuery;
import com.sofka.accountMovement.application.dto.request.AccountRequest;
import com.sofka.accountMovement.application.dto.response.AccountResponse;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.codeBase.infrastructure.adapters.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class AccountController extends BaseController {

    private final ICommandHandler<CreateAccountCommand, AccountResponse> createAccountCommandHandler;
    private final IQueryHandler<GetAccountQuery, AccountResponse> getAccountQueryHandler;
    private final IQueryHandler<GetAllAccountsQuery, List<AccountResponse>> getAllAccountsQueryHandler;
    private final ICommandHandler<String, Void> deleteAccountCommandHandler;


    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest request) {
        CreateAccountCommand command = new CreateAccountCommand(
                request.getAccountNumber(),
                request.getAccountType(),
                request.getInitialBalance(),
                request.getCustomerId()
        );
        return handleCreateRequest(() -> createAccountCommandHandler.handle(command));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable String id) {
        return handleRequest(() -> getAccountQueryHandler.handle(new GetAccountQuery(id)));
    }

    @GetMapping
    public ResponseEntity<?> getAllAccounts() {
        return handleRequest(() -> getAllAccountsQueryHandler.handle(new GetAllAccountsQuery()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable String id) {
        return handleRequest(() -> {
            deleteAccountCommandHandler.handle(id);
            return Map.of("message", "Account deleted successfully");
        });
    }

}
