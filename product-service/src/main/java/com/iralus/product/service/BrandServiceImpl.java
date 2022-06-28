package com.iralus.product.service;

import com.iralus.product.entity.Brand;
import com.iralus.product.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iralus.product.util.EmptyChecker.empty;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> fetchBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand fetchBrandById(Long brandId) {
        return brandRepository.findById(brandId).orElseThrow(()->
                new IllegalArgumentException("Brand with id"+brandId+"could not be fount"));
    }

    @Override
    public Brand updateBrand(Long brandId, Brand brand) {
        Brand brandDB = fetchBrandById(brandId);
        if(!empty(brand.getBrandName())){
            brandDB.setBrandName(brand.getBrandName());
        }
        if(!empty(brand.getStatus())){
            brandDB.setStatus(brand.getStatus());
        }
        return brandRepository.save(brandDB);
    }

    @Override
    public Brand deleteBrand(Long brandId) {
        Brand brand = fetchBrandById(brandId);
        brandRepository.delete(brand);
        return brand;
    }

    @Override
    public Brand fetchBrandByName(String brandName) {
        return brandRepository.findByBrandName(brandName);
    }
}
