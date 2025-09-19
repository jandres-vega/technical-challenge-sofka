package com.sofka.customerPerson.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("Should create customer with valid data")
    void shouldCreateCustomerWithValidData() {

        String nombre = "Jose Lema";
        String genero = "Masculino";
        Integer edad = 35;
        String identificacion = "1234567890";
        String direccion = "Otavalo sn y principal";
        String telefono = "098254785";
        String clienteId = "CLI001";
        String password = "1234";

        Customer customer = new Customer(nombre, genero, edad, identificacion,
                direccion, telefono, clienteId, password);

        assertNotNull(customer);
        assertEquals(nombre, customer.getName());
        assertEquals(genero, customer.getGender());
        assertEquals(edad, customer.getAge());
        assertEquals(identificacion, customer.getIdentification());
        assertEquals(direccion, customer.getAddress());
        assertEquals(telefono, customer.getPhone());
        assertEquals(clienteId, customer.getCustomerId());
        assertEquals(password, customer.getPassword());
        assertTrue(customer.getStatus());
    }

    @Test
    @DisplayName("Should inherit from Person class")
    void shouldInheritFromPersonClass() {

        Customer customer = new Customer("Juan", "Masculino", 30, "0987654321",
                "Direccion Test", "0999999999", "CLI002", "pass");

        assertInstanceOf(Person.class, customer);
        assertNotNull(customer.getName());
        assertNotNull(customer.getGender());
        assertNotNull(customer.getAge());
        assertNotNull(customer.getIdentification());
        assertNotNull(customer.getAddress());
        assertNotNull(customer.getPhone());
    }
}