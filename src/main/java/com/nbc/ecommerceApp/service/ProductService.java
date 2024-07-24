package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.model.Product;
import org.springframework.data.web.PagedModel;

import java.util.List;

public interface ProductService {

    PagedModel<Product> getProducts(int pageNo, int perPage, String sort);

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
