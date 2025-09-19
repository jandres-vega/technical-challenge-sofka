package com.sofka.accountMovement.infrastructure.adapters.rest.controllers;

import com.sofka.accountMovement.application.commands.CreateMovementCommand;
import com.sofka.accountMovement.application.query.GetAllMovementsQuery;
import com.sofka.accountMovement.application.dto.request.MovementRequest;
import com.sofka.accountMovement.application.dto.response.MovementResponse;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.codeBase.infrastructure.adapters.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovementController extends BaseController {

    private final ICommandHandler<CreateMovementCommand, MovementResponse> createMovementCommandHandler;
    private final IQueryHandler<GetAllMovementsQuery, List<MovementResponse>> getAllMovementsQueryHandler;

    @PostMapping
    public ResponseEntity<?> createMovement(@RequestBody MovementRequest request) {
        CreateMovementCommand command = new CreateMovementCommand(
                request.getAccountNumber(),
                request.getMovementType(),
                request.getValue()
        );
        return handleCreateRequest(() -> createMovementCommandHandler.handle(command));
    }

    @GetMapping
    public ResponseEntity<?> getAllMovements() {
        return handleRequest(() -> getAllMovementsQueryHandler.handle(new GetAllMovementsQuery()));
    }
}
