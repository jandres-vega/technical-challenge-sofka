package com.sofka.customerPerson.application.services;

import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.domain.repository.CustomerRepository;
import com.sofka.customerPerson.infrastructure.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class GetCustomerService  {

    private final CustomerRepository customerRepository;

    public Customer getCustomerByCustomerId(String customerId) {
        return customerRepository.findCustomerById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente no encontrado con ID: " + customerId));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}

