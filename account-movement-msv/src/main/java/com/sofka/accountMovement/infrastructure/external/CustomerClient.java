package com.sofka.accountMovement.infrastructure.external;

import com.sofka.accountMovement.application.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-person-msv",
        url = "${customer.person.url}"
)
public interface CustomerClient {

    @GetMapping("/clientes/{id}")
    CustomerResponse getCustomerById(@PathVariable String id);
}
