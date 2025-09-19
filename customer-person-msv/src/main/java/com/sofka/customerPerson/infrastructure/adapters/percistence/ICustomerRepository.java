package com.sofka.customerPerson.infrastructure.adapters.percistence;

import com.sofka.customerPerson.domain.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findCustomerById(String id);
    Optional<Customer> findCustomerByIdentification(String identification);
    @Query("SELECT c FROM Customer c WHERE c.customerId = :customerId")
    Optional<Customer> findCustomerByCustomerId(@Param("customerId") String customerId);
}
