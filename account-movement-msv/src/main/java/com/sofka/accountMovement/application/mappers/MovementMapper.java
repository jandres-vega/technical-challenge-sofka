package com.sofka.accountMovement.application.mappers;

import com.sofka.accountMovement.application.dto.response.MovementResponse;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class MovementMapper implements IBaseMapper<Movement, MovementResponse> {
    @Override
    public MovementResponse map(Movement source) {
        return MovementResponse.builder()
                .id(source.getId())
                .date(source.getDate())
                .movementType(source.getMovementType())
                .value(source.getValue())
                .balance(source.getBalance())
                .accountNumber(source.getAccount().getAccountNumber())
                .build();
    }
}
