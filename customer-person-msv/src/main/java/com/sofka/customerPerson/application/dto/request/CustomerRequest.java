package com.sofka.customerPerson.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
public class CustomerRequest {

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El genero es requerido")
    private String gender;

    @NotNull(message = "age is required")
    @Min(value = 0, message = "La edad debe ser mayor o igual a 0")
    @Max(value = 120, message = "La edad debe ser menor o igual a 80")
    private Integer age;

    @NotBlank(message = "La identificacion es requerida")
    @Size(max = 20, message = "Identificacion debe tener maximo 20 caracteres")
    private String identification;

    @NotBlank(message = "El direccion es requerido")
    private String address;
    @NotBlank(message = "El telefono es requerido")
    private String phone;

    private String customerId;
    private String password;
    private boolean status;

    public boolean getStatus() {
        return status;
    }
}
