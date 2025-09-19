package com.sofka.customerPerson.application.mapper;

import com.sofka.codeBase.application.mappers.base.IBaseMapper;
import com.sofka.customerPerson.application.dto.response.CustomerResponse;
import com.sofka.customerPerson.domain.models.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements IBaseMapper<Customer, CustomerResponse> {
    @Override
    public CustomerResponse map(Customer source) {
        CustomerResponse response = new CustomerResponse();
        response.setId(source.getId());
        response.setName(source.getName());
        response.setGender(source.getGender());
        response.setAge(source.getAge());
        response.setIdentification(source.getIdentification());
        response.setAddress(source.getAddress());
        response.setPhone(source.getPhone());
        response.setCustomerId(source.getCustomerId());
        response.setStatus(source.getStatus());
        return response;
    }
}
