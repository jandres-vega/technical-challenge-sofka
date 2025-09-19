package com.sofka.customerPerson.application.query;

import com.sofka.codeBase.application.ports.in.IQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCustomerQuery implements IQuery {
    private final String id;
}
