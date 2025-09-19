package com.sofka.customerPerson.application.services;

import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.infrastructure.adapters.percistence.ICustomerRepository;
import com.sofka.customerPerson.infrastructure.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteCustomerService {

    private final ICustomerRepository customerRepository;

    @Transactional
    public void deleteCustomer(String customerId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente no encontrado con ID: " + customerId));

        customerRepository.delete(customer);
    }
}
