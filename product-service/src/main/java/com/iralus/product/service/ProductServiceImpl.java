package com.iralus.product.service;

import com.iralus.product.entity.Product;
import com.iralus.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchProductById(Long productId) {
        return productRepository.getReferenceById(productId);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product productDB = productRepository.getReferenceById(productId);
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }


}
