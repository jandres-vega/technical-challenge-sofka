package com.sofka.accountMovement.infrastructure.adapters.rest.controllers;

import com.sofka.accountMovement.application.query.GetReportQuery;
import com.sofka.accountMovement.application.dto.response.AccountStatementResponse;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.codeBase.infrastructure.adapters.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReportController extends BaseController {

    private final IQueryHandler<GetReportQuery, List<AccountStatementResponse>> getReportQueryHandler;

    @GetMapping
    public ResponseEntity<?> generateReport(
            @RequestParam String customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        GetReportQuery query = new GetReportQuery(customerId, startDate, endDate);
        return handleRequest(() -> getReportQueryHandler.handle(query));
    }
}
