package com.example.productmanagement.service;

import com.example.productmanagement.dao.entities.Product;
import com.example.productmanagement.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        try{
            return productRepository.save(product);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {
        try{
            productRepository.delete(product);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProductById(Integer id) {
        try{
            productRepository.delete(productRepository.findById(id).get());
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try{
            productRepository.save(product);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Product findProduct(Product product) {
        try{
            return productRepository.findById(product.getId()).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Product findProductById(Integer id) {
        try{
            return productRepository.findById(id).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try{
            return productRepository.findAll();
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> getAllProducts(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Page<Product> searchProducts(String keyword, int page, int taille) {
        return productRepository.findByDesignationContainsIgnoreCase(keyword,PageRequest.of(page, taille));
    }
}
