package com.sofka.customerPerson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sofka.codeBase", "com.sofka.customerPerson"})
public class CustomerPersonMsvApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerPersonMsvApplication.class, args);
    }

}
