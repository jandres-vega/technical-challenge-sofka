package com.sofka.accountMovement.infrastructure.adapters.rest.controllers;

import com.sofka.accountMovement.application.services.MovementService;
import com.sofka.accountMovement.domain.models.Account;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.accountMovement.infrastructure.adapters.percistence.IAccountRepository;
import com.sofka.accountMovement.infrastructure.exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class MovementControllerTest {

    @Autowired
    private MovementService movementService;

    @Autowired
    private IAccountRepository accountRepository;

    private Account testAccount;

    @BeforeEach
    void setUp() {
        testAccount = Account.builder()
                .accountNumber("478758")
                .accountType("Ahorro")
                .initialBalance(BigDecimal.valueOf(2000))
                .currentBalance(BigDecimal.valueOf(2000))
                .status(true)
                .customerId("CLI001")
                .build();

        testAccount = accountRepository.save(testAccount);
    }

    @Test
    @DisplayName("Integration Test: Should create movement and update balance successfully")
    void shouldCreateMovementAndUpdateBalance() {
        // Given
        String accountNumber = "478758";
        String movementType = "RETIRO";
        BigDecimal value = BigDecimal.valueOf(-575);
        BigDecimal expectedBalance = BigDecimal.valueOf(1425);

        // When
        Movement movement = movementService.createMovement(accountNumber, movementType, value);

        // Then
        assertNotNull(movement);
        assertEquals(movementType, movement.getMovementType());
        assertEquals(value, movement.getValue());
        assertEquals(expectedBalance, movement.getBalance());
        assertNotNull(movement.getDate());
        assertNotNull(movement.getId());

        // Verify account balance was updated in database
        Account updatedAccount = accountRepository.findById(testAccount.getId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals(expectedBalance, updatedAccount.getCurrentBalance());
    }

    @Test
    @DisplayName("Integration Test: Should throw InsufficientBalanceException when balance is insufficient")
    void shouldThrowInsufficientBalanceException() {
        // Given
        String accountNumber = "478758";
        String movementType = "RETIRO";
        BigDecimal excessiveAmount = BigDecimal.valueOf(-3000); // More than available balance

        // When & Then
        InsufficientBalanceException exception = assertThrows(
                InsufficientBalanceException.class,
                () -> movementService.createMovement(accountNumber, movementType, excessiveAmount)
        );

        assertEquals("Saldo no disponible", exception.getMessage());

        // Verify account balance remains unchanged
        Account unchangedAccount = accountRepository.findById(testAccount.getId()).orElse(null);
        assertNotNull(unchangedAccount);
        assertEquals(BigDecimal.valueOf(2000), unchangedAccount.getCurrentBalance());
    }

    @Test
    @DisplayName("Integration Test: Should create deposit movement successfully")
    void shouldCreateDepositMovement() {
        // Given
        String accountNumber = "478758";
        String movementType = "DEPOSITO";
        BigDecimal value = BigDecimal.valueOf(500);
        BigDecimal expectedBalance = BigDecimal.valueOf(2500);

        // When
        Movement movement = movementService.createMovement(accountNumber, movementType, value);

        // Then
        assertNotNull(movement);
        assertEquals(movementType, movement.getMovementType());
        assertEquals(value, movement.getValue());
        assertEquals(expectedBalance, movement.getBalance());

        // Verify account balance was updated
        Account updatedAccount = accountRepository.findById(testAccount.getId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals(expectedBalance, updatedAccount.getCurrentBalance());
    }

}