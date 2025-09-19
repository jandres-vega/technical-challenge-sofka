package com.sofka.accountMovement.application.services;

import com.sofka.accountMovement.domain.models.Account;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.accountMovement.domain.repository.MovementRepository;
import com.sofka.accountMovement.infrastructure.exceptions.InsufficientBalanceException;
import com.sofka.accountMovement.infrastructure.exceptions.MovementNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MovementService {

    private final MovementRepository movementRepository;
    private final AccountService accountService;

    public Movement createMovement(String accountNumber, String movementType, BigDecimal value) {
        Account account = accountService.getAccountByNumber(accountNumber);

        BigDecimal newBalance = account.getCurrentBalance().add(value);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new InsufficientBalanceException();

        account.setCurrentBalance(newBalance);
        accountService.updateAccount(account);

        Movement movement = new Movement(movementType, value, newBalance, account);
        return movementRepository.save(movement);
    }

    @Transactional(readOnly = true)
    public Movement getMovementById(String id) {
        return movementRepository.findById(id)
                .orElseThrow(() ->new MovementNotFoundException("Movimiento no encontrado con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Movement> getMovementsByAccountId(String accountId) {
        return movementRepository.findByAccountId(accountId);
    }

    @Transactional(readOnly = true)
    public List<Movement> getMovementsByDateRange(String accountId, LocalDateTime startDate, LocalDateTime endDate) {
        return movementRepository.findByAccountIdAndDateBetween(accountId, startDate, endDate);
    }

    public void deleteMovement(String id) {
        Movement movement = getMovementById(id);
        movementRepository.deleteById(id);
    }
}
