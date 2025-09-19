package com.sofka.accountMovement.application.query;

import com.sofka.codeBase.application.ports.in.IQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAccountQuery implements IQuery {
    private final String id;
}
