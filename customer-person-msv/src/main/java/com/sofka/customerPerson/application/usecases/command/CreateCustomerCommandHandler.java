package com.sofka.customerPerson.application.usecases.command;

import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.codeBase.application.ports.in.ICommandHandler;
import com.sofka.customerPerson.application.dto.request.CustomerRequest;
import com.sofka.customerPerson.application.dto.response.CustomerResponse;
import com.sofka.customerPerson.application.services.CreateCustomerService;
import com.sofka.customerPerson.domain.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CreateCustomerCommandHandler implements ICommandHandler<CustomerRequest, CustomerResponse> {

    private final CreateCustomerService customerService;
    private final IBaseMapper<Customer, CustomerResponse> clienteToClienteResponseMapper;

    @Override
    public CustomerResponse handle(CustomerRequest command) {

        Customer customer = new Customer(
                command.getName(),
                command.getGender(),
                command.getAge(),
                command.getIdentification(),
                command.getAddress(),
                command.getPhone(),
                command.getCustomerId(),
                command.getPassword()
        );

        Customer savedCustomer = customerService.apply(customer);
        return clienteToClienteResponseMapper.map(savedCustomer);

    }
}
