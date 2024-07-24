package com.nbc.ecommerceApp.controller;

import com.nbc.ecommerceApp.model.Product;
import com.nbc.ecommerceApp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public PagedModel<Product> getAllProducts(@RequestParam(name = "pageno", required = false, defaultValue = "1") int pageNo,
                                              @RequestParam(name = "perpage", required = false, defaultValue = "10") int recPerPage,
                                              @RequestParam(name = "sortby", required = false, defaultValue = "price") String sort) {
        return productService.getProducts(pageNo, recPerPage, sort);
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
