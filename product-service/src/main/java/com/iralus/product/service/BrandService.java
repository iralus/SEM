package com.iralus.product.service;

import com.iralus.product.entity.Brand;
import com.iralus.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    Brand addBrand(Brand brand);
    List<Brand> fetchBrands();
    Brand fetchBrandById(Long brandId);
    Brand updateBrand(Long brandId, Brand brand);
    Brand deleteBrand(Long brandId);
}
