package com.sofka.accountMovement.infrastructure.adapters.percistence;

import com.sofka.accountMovement.domain.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, String> {
    List<Movement> findByAccountId(String accountId);
    List<Movement> findByAccountIdAndDateBetween(String accountId, LocalDateTime startDate, LocalDateTime endDate);
}
