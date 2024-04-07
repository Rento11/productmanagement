package com.example.productmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductmanagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(){
        return args -> {

        };
    }
}

