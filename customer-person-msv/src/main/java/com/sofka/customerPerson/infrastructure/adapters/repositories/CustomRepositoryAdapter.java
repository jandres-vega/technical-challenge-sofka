package com.sofka.customerPerson.infrastructure.adapters.repositories;

import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.domain.repository.CustomRepository;
import com.sofka.customerPerson.infrastructure.adapters.percistence.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomRepositoryAdapter implements CustomRepository {

    private final ICustomerRepository customerRepository;

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findCustomerByCustomerId(id);
    }

    @Override
    public Optional<Customer> findCustomerByIdentification(String identification) {
        return customerRepository.findCustomerByIdentification(identification);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsByCustomerId(String customerId) {
        return customerRepository.findCustomerByCustomerId(customerId).isPresent();
    }

    @Override
    public boolean existsByIdentification(String identification) {
        return customerRepository.findCustomerByIdentification(identification).isPresent();
    }
}
