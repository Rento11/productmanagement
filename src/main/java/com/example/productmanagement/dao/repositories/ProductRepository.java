package com.example.productmanagement.dao.repositories;

import com.example.productmanagement.dao.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByDesignationContainsIgnoreCase(String keyword, Pageable pageable);
}
