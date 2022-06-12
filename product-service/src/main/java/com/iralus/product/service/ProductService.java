package com.iralus.product.service;

import com.iralus.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product addProduct(Product product);
    List<Product> fetchProducts();
    Product fetchProductById(Long productId);
    Product updateProduct(Long productId, Product product);
    Product deleteProduct(Long productId);

}
