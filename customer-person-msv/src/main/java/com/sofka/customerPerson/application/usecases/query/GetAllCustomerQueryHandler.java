package com.sofka.customerPerson.application.usecases.query;

import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.customerPerson.application.dto.response.CustomerResponse;
import com.sofka.customerPerson.application.query.GetAllCustomerQuery;
import com.sofka.customerPerson.application.services.GetCustomerService;
import com.sofka.customerPerson.domain.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllCustomerQueryHandler implements IQueryHandler<GetAllCustomerQuery, List<CustomerResponse>> {

    private final GetCustomerService getCustomerService;
    private final IBaseMapper<Customer, CustomerResponse> customerMapper;


    @Override
    public List<CustomerResponse> handle(GetAllCustomerQuery query) {
        List<Customer> customers = getCustomerService.getAllCustomers();
        return customers.stream().map(customerMapper::map).toList();
    }
}
