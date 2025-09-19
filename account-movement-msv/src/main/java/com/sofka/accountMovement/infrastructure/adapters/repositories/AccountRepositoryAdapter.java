package com.sofka.accountMovement.infrastructure.adapters.repositories;

import com.sofka.accountMovement.domain.models.Account;
import com.sofka.accountMovement.domain.repository.AccountRepository;
import com.sofka.accountMovement.infrastructure.adapters.percistence.IAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final IAccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByCustomerId(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteById(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }
}
