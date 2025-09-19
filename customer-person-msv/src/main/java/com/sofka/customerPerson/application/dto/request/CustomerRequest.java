package com.sofka.customerPerson.application.dto.request;

import lombok.*;

@Data
@Builder
public class CustomerRequest {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
    private String customerId;
    private String password;
    private boolean status;

    public boolean getStatus() {
        return status;
    }
}
