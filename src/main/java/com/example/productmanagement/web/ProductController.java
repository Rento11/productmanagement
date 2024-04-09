package com.example.productmanagement.web;

import com.example.productmanagement.dao.entities.Product;
import com.example.productmanagement.service.ProductManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @Autowired
    ProductManager productManager;

    @GetMapping("/productsList")
    public String getProducts(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "taille", defaultValue = "1") int taille, @RequestParam(name = "search", defaultValue = "") String keyword) {
        Page<Product> products = productManager.searchProducts(keyword,page, taille);
        model.addAttribute("products", products.getContent());
        int[] pages = new int[products.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "productsList";
    }

    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(Model model, @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        productManager.addProduct(product);
        return "redirect:/productsList";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduitAction(@RequestParam(name = "id") Integer id, Integer page, String search) {
        if (productManager.deleteProductById(id)) {
            return "redirect:/productsList";
        } else {
            return "error";
        }
    }

    @GetMapping("/updateProduct")
    public String updateProductGet(Model model, @RequestParam(name = "id") Integer id) {
        Product product = productManager.findProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "updateProduct";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateProduct")
    public String updateProductPost(Model model, @RequestParam(name = "id") Integer id, @RequestParam(name = "title") String title, @RequestParam(name = "designation") String designation, @RequestParam(name = "price") Double price) {
        Product product = productManager.findProductById(id);
        product.setTitle(title);
        product.setDesignation(designation);
        product.setPrice(price);
        if (product != null) {
            productManager.updateProduct(product);
            return "redirect:/productsList";
        } else {
            return "error";
        }
    }
}