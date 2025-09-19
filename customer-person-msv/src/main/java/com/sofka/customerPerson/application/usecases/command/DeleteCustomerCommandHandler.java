package com.sofka.customerPerson.application.usecases.command;

import com.sofka.codeBase.application.ports.in.ICommandHandler;
import com.sofka.customerPerson.application.services.DeleteCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCustomerCommandHandler implements ICommandHandler<String, Void> {

    private final DeleteCustomerService deleteCustomerService;

    @Override
    public Void handle(String customerId) {
        deleteCustomerService.deleteCustomer(customerId);
        return null;
    }
}
