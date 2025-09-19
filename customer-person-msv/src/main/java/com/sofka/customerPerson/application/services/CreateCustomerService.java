package com.sofka.customerPerson.application.services;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.domain.repository.CustomRepository;
import com.sofka.customerPerson.infrastructure.exceptions.CustomerAlreadyExistsException;
import com.sofka.customerPerson.infrastructure.exceptions.DuplicateIdentificationException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerService {

    private final CustomRepository customerRepository;

    @Transactional
    public Customer apply(Customer customer) {
        try {

            if (customerRepository.findCustomerById(customer.getCustomerId()).isPresent()) {
                throw new CustomerAlreadyExistsException("Cliente ID ya existe: " + customer.getCustomerId());
            }

            if (customerRepository.findCustomerByIdentification(customer.getIdentification()).isPresent()) {
                throw new DuplicateIdentificationException("Identificación ya existe: " + customer.getIdentification());
            }

            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new BaseException("Error saving customer. Rolling back transaction.", HttpStatus.BAD_REQUEST, e);
        }
    }
}
