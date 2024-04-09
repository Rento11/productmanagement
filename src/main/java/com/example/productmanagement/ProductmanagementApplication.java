package com.example.productmanagement;

import com.example.productmanagement.dao.entities.Product;
import com.example.productmanagement.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductmanagementApplication {

    @Autowired
    public ProductManager productManager;
    public static void main(String[] args) {
        SpringApplication.run(ProductmanagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(){
        return args -> {
            Product product1 = new Product(null,"HP Elite Book","840G4",4000.00);
            Product product2 = new Product(null,"Think pad","Gen4",3500.00);
            Product product3 = new Product(null,"MSI","Katana",8000.00);
            productManager.addProduct(product1);
            productManager.addProduct(product2);
            productManager.addProduct(product3);
        };
    }
}

