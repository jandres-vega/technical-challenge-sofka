package com.sofka.customerPerson.application.usecases.query;

import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.customerPerson.application.dto.response.CustomerResponse;
import com.sofka.customerPerson.application.query.GetCustomerQuery;
import com.sofka.customerPerson.application.services.GetCustomerService;
import com.sofka.customerPerson.domain.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GetCustomerQueryHandler implements IQueryHandler<GetCustomerQuery, CustomerResponse> {

    private final GetCustomerService getCustomerService;
    private final IBaseMapper<Customer, CustomerResponse> customerMapper;

    @Override
    public CustomerResponse handle(GetCustomerQuery query) {
        Customer customer = getCustomerService.getCustomerByCustomerId(query.getId());
        return customerMapper.map(customer);
    }
}
