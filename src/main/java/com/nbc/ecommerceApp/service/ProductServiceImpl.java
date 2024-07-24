package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.exception.ProductNotFoundException;
import com.nbc.ecommerceApp.model.Product;
import com.nbc.ecommerceApp.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public PagedModel<Product> getProducts(int pageNo, int perPage, String sort) {
        return new PagedModel<>(productRepo.findAll(PageRequest.of(pageNo, perPage, Sort.by(sort))));
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
