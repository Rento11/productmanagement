package com.example.productmanagement.service;

import com.example.productmanagement.dao.entities.Product;
import com.example.productmanagement.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductManager {
    public Product addProduct(Product product);
    public boolean deleteProduct(Product product);
    public boolean deleteProductById(Integer id);
    public boolean updateProduct(Product product);
    public Product findProduct(Product product);
    public Product findProductById(Integer id);
    public List<Product> getAllProducts();
    public Page<Product> getAllProducts(int page, int taille);
    public Page<Product> searchProducts(String keyword, int page, int taille);
}