package com.sofka.accountMovement.infrastructure.adapters.repositories;

import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.accountMovement.domain.repository.MovementRepository;
import com.sofka.accountMovement.infrastructure.adapters.percistence.IMovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MovementRepositoryAdapter implements MovementRepository {

    private final IMovementRepository movementJpaRepository;

    @Override
    public Movement save(Movement movement) {
        return movementJpaRepository.save(movement);
    }

    @Override
    public Optional<Movement> findById(String id) {
        return movementJpaRepository.findById(id);
    }

    @Override
    public List<Movement> findAll() {
        return movementJpaRepository.findAll();
    }

    @Override
    public List<Movement> findByAccountId(String accountId) {
        return movementJpaRepository.findByAccountId(accountId);
    }

    @Override
    public List<Movement> findByAccountIdAndDateBetween(String accountId, LocalDateTime startDate, LocalDateTime endDate) {
        return movementJpaRepository.findByAccountIdAndDateBetween(accountId, startDate, endDate);
    }

    @Override
    public void deleteById(String id) {
        movementJpaRepository.deleteById(id);
    }
}
