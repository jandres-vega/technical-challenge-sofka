package com.sofka.accountMovement.application.usecases.query;

import com.sofka.accountMovement.application.query.GetReportQuery;
import com.sofka.accountMovement.application.dto.response.AccountStatementResponse;
import com.sofka.accountMovement.application.services.ReportService;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetReportQueryHandler implements IQueryHandler<GetReportQuery, List<AccountStatementResponse>> {

    private final ReportService reportService;

    @Override
    public List<AccountStatementResponse> handle(GetReportQuery query) {
        return reportService.generateAccountStatement(
                query.getCustomerId(),
                query.getStartDate(),
                query.getEndDate()
        );
    }
}
