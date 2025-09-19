package com.sofka.customerPerson.application.services;

import com.sofka.customerPerson.domain.models.Customer;
import com.sofka.customerPerson.domain.repository.CustomRepository;
import com.sofka.customerPerson.infrastructure.exceptions.CustomerNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateCustomerService  {

    private final CustomRepository customerRepository;

    @Transactional
    public Customer updateCustomer(Customer customer) {
        String id = customer.getId();
        Customer customerFind = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente no encontrado con ID: " + id));
        customerFind.setName(customer.getName());
        customerFind.setGender(customer.getGender());
        customerFind.setAge(customer.getAge());
        customerFind.setAddress(customer.getAddress());
        customerFind.setPhone(customer.getPhone());
        customerFind.setPassword(customer.getPassword());
        customerFind.setStatus(customer.getStatus());

        return customerRepository.save(customerFind);
    }
}
