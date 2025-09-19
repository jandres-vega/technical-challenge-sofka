package com.sofka.customerPerson.infrastructure.adapters.rest.controllers;

import com.sofka.codeBase.application.ports.in.ICommandHandler;
import com.sofka.codeBase.application.ports.in.IQueryHandler;
import com.sofka.codeBase.infrastructure.adapters.BaseController;
import com.sofka.customerPerson.application.dto.request.CustomerRequest;
import com.sofka.customerPerson.application.dto.response.CustomerResponse;
import com.sofka.customerPerson.application.query.GetAllCustomerQuery;
import com.sofka.customerPerson.application.query.GetCustomerQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class CustomerController extends BaseController {

    private final ICommandHandler<CustomerRequest, CustomerResponse> createCustomerCommandHandler;
    private final IQueryHandler<GetCustomerQuery, CustomerResponse> getCustomerQueryHandler;
    private final IQueryHandler<GetAllCustomerQuery, List<CustomerResponse>> getAllCustomersQueryHandler;
    private final ICommandHandler<CustomerRequest, CustomerResponse> updateCustomerCommandHandler;
    private final ICommandHandler<String, Void> deleteCustomerCommandHandler;

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody CustomerRequest request) {
        return handleRequest(() -> createCustomerCommandHandler.handle(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCliente(@PathVariable String id) {
        return handleRequest(() -> getCustomerQueryHandler.handle(new GetCustomerQuery(id)));
    }

    @GetMapping
    public ResponseEntity<?> getAllClientes() {
        return handleRequest(() -> getAllCustomersQueryHandler.handle(new GetAllCustomerQuery()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerRequest request) {
        request.setCustomerId(id);
        System.out.println("AQUI LLEGA " + id + " - " + request);
        return handleRequest(() -> updateCustomerCommandHandler.handle(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        return handleRequest(() -> {
            deleteCustomerCommandHandler.handle(id);
            return Map.of("message", "Customer deleted successfully");
        });
    }
}
