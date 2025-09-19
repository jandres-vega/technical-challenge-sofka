package com.sofka.customerPerson.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "person_id")
@Getter
@Setter
public class Customer extends Person {

    @Column(name = "customer_id", nullable = false, unique = true, length = 20)
    private String customerId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private Boolean status = true;

    public Customer(String nombre, String genero, Integer edad, String identificacion,
                   String direccion, String telefono, String clienteId, String password) {
        super(null, nombre, genero, edad, identificacion, direccion, telefono);
        this.customerId = clienteId;
        this.password = password;
        this.status = true;
    }

    public Customer(String nombre, String genero, Integer edad, String identificacion,
                    String direccion, String telefono, String clienteId, String password, Boolean status) {
        super(null, nombre, genero, edad, identificacion, direccion, telefono);
        this.customerId = clienteId;
        this.password = password;
        this.status = true;
    }
}
