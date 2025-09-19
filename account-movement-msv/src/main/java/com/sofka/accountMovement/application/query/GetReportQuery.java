package com.sofka.accountMovement.application.query;

import com.sofka.codeBase.application.ports.in.IQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class GetReportQuery implements IQuery {
    private String customerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
