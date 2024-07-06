package com.nbc.ecommerceApp.service;

import com.nbc.ecommerceApp.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(100,"Sony Xperia 1 II",32000.0f),
            new Product(101,"Sony Alpha 500D",48000.0f),
            new Product(102,"Sony Bravia",29999.0f),
            new Product(103,"Sony Buds Pro 2",18900.0f)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products
                .stream()
                .filter(product -> product.getId()==id)
                .findFirst().get();
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    private int getIndexById(int id) {
        for (int i=0; i<products.size();i++)
            if(products.get(i).getId()==id)
                return i;
        return -1;
    }
    public void updateProduct(Product product) {
        int index = getIndexById(product.getId());
        log.debug("product index :"+index);
        if(index>=0)
            products.set(index, product);
    }

    public void deleteProduct(int id) {
        int index = getIndexById(id);
        if(index>=0)
            products.remove(index);
    }
}
