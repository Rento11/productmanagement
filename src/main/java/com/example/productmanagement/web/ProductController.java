package com.example.productmanagement.web;

import com.example.productmanagement.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    private ProductManager productManager;
}
