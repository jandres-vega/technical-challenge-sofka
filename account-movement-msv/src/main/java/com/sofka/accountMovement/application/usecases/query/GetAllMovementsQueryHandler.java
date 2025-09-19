package com.sofka.accountMovement.application.usecases.query;

import com.sofka.accountMovement.application.query.GetAllMovementsQuery;
import com.sofka.accountMovement.application.dto.response.MovementResponse;
import com.sofka.accountMovement.application.services.MovementService;
import com.sofka.accountMovement.domain.models.Movement;
import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllMovementsQueryHandler implements IQueryHandler<GetAllMovementsQuery, List<MovementResponse>> {

    private final MovementService movementService;
    private final IBaseMapper<Movement, MovementResponse> movementMapper;

    @Override
    public List<MovementResponse> handle(GetAllMovementsQuery query) {
        List<Movement> movements = movementService.getAllMovements();
        return movements.stream().map(movementMapper::map).toList();
    }
}
