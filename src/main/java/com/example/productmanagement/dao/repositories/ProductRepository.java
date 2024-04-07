package com.example.productmanagement.dao.repositories;

import com.example.productmanagement.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
