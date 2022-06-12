package com.iralus.product.controller;

import com.iralus.product.entity.Product;
import com.iralus.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/")
    public List<Product> fetchProducts(){
        return productService.fetchProducts();
    }
    @GetMapping("/{productId}")
    public Product fetchProductById(@PathVariable Long productId){
        return productService.fetchProductById(productId);
    }
    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
    @PutMapping({"/{productId}"})
    public Product updateProduct(@PathVariable Long productId,
                                 @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }
}
