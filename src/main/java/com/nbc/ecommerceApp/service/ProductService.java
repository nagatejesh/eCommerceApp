package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
