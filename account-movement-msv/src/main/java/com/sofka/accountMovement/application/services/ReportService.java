package com.sofka.accountMovement.application.services;

import com.sofka.accountMovement.application.dto.response.AccountStatementResponse;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.accountMovement.infrastructure.external.CustomerClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final AccountService accountService;
    private final MovementService movementService;
    private final CustomerClient customerClient;

    public List<AccountStatementResponse> generateAccountStatement(String customerId, LocalDateTime startDate, LocalDateTime endDate) {
        // Obtener información del cliente desde el microservicio customer-person
        String customerName = customerClient.getCustomerById(customerId).getName();

        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        List<AccountStatementResponse> statements = new ArrayList<>();

        for (Account account : accounts) {
            List<Movement> movements = movementService.getMovementsByDateRange(account.getId(), startDate, endDate);

            for (Movement movement : movements) {
                AccountStatementResponse statement = AccountStatementResponse.builder()
                        .fecha(movement.getDate())
                        .cliente(customerName)
                        .numeroCuenta(account.getAccountNumber())
                        .tipo(account.getAccountType())
                        .saldoInicial(account.getInitialBalance())
                        .estado(account.getStatus())
                        .movimiento(movement.getValue())
                        .saldoDisponible(movement.getBalance())
                        .build();
                statements.add(statement);
            }
        }

        return statements;
    }
}
