package com.example.productmanagement.service;

import com.example.productmanagement.dao.entities.Product;
import com.example.productmanagement.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return false;
    }

    @Override
    public boolean updateProduct(Integer id) {
        return false;
    }

    @Override
    public Product findProduct(Product product) {
        return null;
    }

    @Override
    public Product findProductById(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts(Integer id) {
        return null;
    }
}
