package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.exception.ProductNotFoundException;
import com.nbc.ecommerceApp.model.Product;
import com.nbc.ecommerceApp.reposiroty.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product with {id:"+id+"} is not found"));
    }

    public void addProduct(Product prod) {
        productRepo.save(prod);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
