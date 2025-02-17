package com.nbc.ecommerceApp.controller;

import com.nbc.ecommerceApp.model.Product;
import com.nbc.ecommerceApp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProduct(@RequestBody @Valid Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/product")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
