package com.sofka.accountMovement.infrastructure.adapters.percistence;

import com.sofka.accountMovement.domain.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomerId(String customerId);
    boolean existsByAccountNumber(String accountNumber);
}
