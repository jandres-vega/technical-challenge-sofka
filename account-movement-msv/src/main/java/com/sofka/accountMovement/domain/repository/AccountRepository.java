package com.sofka.accountMovement.domain.repository;

import com.sofka.accountMovement.domain.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(String id);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findAll();
    List<Account> findByCustomerId(String customerId);
    void deleteById(String id);
    boolean existsByAccountNumber(String accountNumber);
}
