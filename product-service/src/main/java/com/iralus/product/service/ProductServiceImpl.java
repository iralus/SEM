package com.iralus.product.service;

import com.iralus.product.entity.Product;
import com.iralus.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iralus.product.util.EmptyChecker.empty;


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
        return productRepository.findById(productId).orElseThrow(() ->
                new IllegalArgumentException(
                        "Product with id"+productId+"could not be fount"
                ));
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product productDB = productRepository.getReferenceById(productId);
        if( !empty( product.getProductName() ) ){
            productDB.setProductName(product.getProductName());
        }
        if( !empty( product.getTagName() ) ){
            productDB.setTagName(product.getTagName());
        }
        if( !empty( product.getOem() ) ){
            productDB.setOem(product.getOem());
        }
        if( !empty( product.getHsCode() ) ){
            productDB.setHsCode(product.getHsCode());
        }
        if( !empty( product.getUnitPrice() ) ){
            productDB.setUnitPrice(product.getUnitPrice());
        }
        if( !empty( product.getLength() ) ){
            productDB.setLength(product.getLength());
        }
        if( !empty( product.getWidth()) ){
            productDB.setWidth(product.getWidth());
        }
        if( !empty( product.getHeight() ) ){
            productDB.setHeight(product.getHeight());
        }
        if( !empty( product.getWeight() ) ){
            productDB.setWeight(product.getWeight());
        }
        if( !empty( product.getBrand() ) ){
            productDB.setBrand(product.getBrand());
        }
        if( !empty( product.getModel() ) ){
            productDB.setModel(product.getModel());
        }
        if( !empty( product.getStatus() ) ){
            productDB.setStatus(product.getStatus());
        }
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long productId) {
        Product product = fetchProductById(productId);
        productRepository.delete(product);
        return product;
    }


}
