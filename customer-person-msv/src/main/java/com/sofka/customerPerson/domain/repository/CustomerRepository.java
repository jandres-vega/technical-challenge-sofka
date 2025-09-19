package com.sofka.customerPerson.domain.repository;

import com.sofka.customerPerson.domain.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findCustomerById(String id);
    Optional<Customer> findCustomerByIdentification(String identification);
    Customer save(Customer customer);
    Optional<Customer> findById(String id);
    List<Customer> findAll();
    void deleteById(String id);
}
