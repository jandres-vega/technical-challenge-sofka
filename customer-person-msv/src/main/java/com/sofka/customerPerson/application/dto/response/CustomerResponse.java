package com.sofka.customerPerson.application.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String id;
    private String name;
    private Integer age;
    private String customerId;
}
