package com.sofka.accountMovement.application.usecases.commands;

import com.sofka.accountMovement.application.commands.CreateMovementCommand;
import com.sofka.accountMovement.application.dto.response.MovementResponse;
import com.sofka.accountMovement.application.services.MovementService;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateMovementCommandHandler implements ICommandHandler<CreateMovementCommand, MovementResponse> {

    private final MovementService movementService;
    private final IBaseMapper<Movement, MovementResponse> movementMapper;

    @Override
    public MovementResponse handle(CreateMovementCommand command) {
        Movement movement = movementService.createMovement(
                command.getAccountNumber(),
                command.getMovementType(),
                command.getValue()
        );
        return movementMapper.map(movement);
    }
}
