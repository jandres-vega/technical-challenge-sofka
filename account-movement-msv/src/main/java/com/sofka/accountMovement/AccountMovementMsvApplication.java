package com.sofka.accountMovement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountMovementMsvApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountMovementMsvApplication.class, args);
    }

}
