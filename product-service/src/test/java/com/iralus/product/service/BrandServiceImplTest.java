package com.iralus.product.service;

import com.iralus.product.entity.Brand;
import com.iralus.product.entity.Status;
import com.iralus.product.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrandServiceImplTest {
    @Mock
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        Brand brand =
                Brand.builder()
                        .brandId(1L)
                        .brandName("Geely")
                        .status(Status.IN)
                        .build();
        Mockito.when(brandService.fetchBrandByName("Geely"))
                .thenReturn(brand);
    }

    @Test
    @DisplayName("Get Data Based On Valid Brand Name")
    public void whenValidBrandName_thenBrandShouldFound(){
        String brandName = "Geely";
        Brand brand = brandService.fetchBrandByName(brandName);
        assertEquals(brandName, brand.getBrandName());
    }

    @Test
    @DisplayName("Get Data Based On Invalid Brand Name")
    public void whenInvalidBrandName_thenBrandShouldNotFound(){
        String brandName = "Geelly";
        String returnedBrandName = null;
        try{
         Brand brand = brandService.fetchBrandByName(brandName);
         returnedBrandName = brand.getBrandName();

        }catch (Exception e){
            returnedBrandName = "WRONG";
        }
        assertNotEquals(brandName, returnedBrandName);

    }
}