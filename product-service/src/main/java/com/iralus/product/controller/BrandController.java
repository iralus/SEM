package com.iralus.product.controller;

import com.iralus.product.entity.Brand;
import com.iralus.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/")
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }

    @GetMapping("/")
    public List<Brand> fetchBrands(){
        return brandService.fetchBrands();
    }
    @GetMapping("/{brandId}")
    public Brand fetchBrandById(@PathVariable Long brandId){
        return brandService.fetchBrandById(brandId);
    }
    @DeleteMapping("/{brandId}")
    public Brand deleteBrand(@PathVariable Long brandId){
        return brandService.deleteBrand(brandId);
    }
    @PutMapping("/{brandId}")
    public Brand updateBrand(@PathVariable Long brandId,
                             @RequestBody Brand brand){
        return brandService.updateBrand(brandId, brand);
    }
}
