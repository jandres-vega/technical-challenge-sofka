package com.sofka.accountMovement.domain.repository;

import com.sofka.accountMovement.domain.models.Movement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovementRepository {
    Movement save(Movement movement);
    Optional<Movement> findById(String id);
    List<Movement> findAll();
    List<Movement> findByAccountId(String accountId);
    List<Movement> findByAccountIdAndDateBetween(String accountId, LocalDateTime startDate, LocalDateTime endDate);
    void deleteById(String id);
}
