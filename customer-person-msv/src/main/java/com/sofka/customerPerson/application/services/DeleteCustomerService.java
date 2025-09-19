package com.sofka.customerPerson.application.services;

import com.sofka.codeBase.infrastructure.exceptions.BaseException;
import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.infrastructure.adapters.percistence.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteCustomerService {

    private final ICustomerRepository customerRepository;

    @Transactional
    public void deleteCustomer(String customerId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId)
                .orElseThrow(() -> new BaseException("Customer not found", HttpStatus.NOT_FOUND));

        customerRepository.delete(customer);
    }
}
