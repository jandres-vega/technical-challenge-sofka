package com.sofka.customerPerson.application.services;

import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.domain.repository.CustomerRepository;
import com.sofka.customerPerson.infrastructure.exceptions.CustomerAlreadyExistsException;
import com.sofka.customerPerson.infrastructure.exceptions.DuplicateIdentificationException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer apply(Customer customer) {
        if (customerRepository.findCustomerById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExistsException("Cliente ID ya existe: " + customer.getCustomerId());
        }

        if (customerRepository.findCustomerByIdentification(customer.getIdentification()).isPresent()) {
            throw new DuplicateIdentificationException("Identificación ya existe: " + customer.getIdentification());
        }

        return customerRepository.save(customer);
    }
}
