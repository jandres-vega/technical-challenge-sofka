package com.sofka.accountMovement.application.services;

import com.sofka.accountMovement.domain.models.Account;
import com.sofka.accountMovement.domain.repository.AccountRepository;
import com.sofka.accountMovement.infrastructure.exceptions.AccountAlreadyExistsException;
import com.sofka.accountMovement.infrastructure.exceptions.AccountNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(Account account) {
        if (accountRepository.existsByAccountNumber(account.getAccountNumber())) {
            throw new AccountAlreadyExistsException("Número de cuenta ya existe: " + account.getAccountNumber());
        }
        return accountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    @Transactional(readOnly = true)
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada con número: " + accountNumber));
    }

    @Transactional(readOnly = true)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Account> getAccountsByCustomerId(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    public Account updateAccount(Account account) {
        Account existingAccount = getAccountById(account.getId());
        existingAccount.setAccountType(account.getAccountType());
        existingAccount.setStatus(account.getStatus());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(String id) {
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
    }
}
