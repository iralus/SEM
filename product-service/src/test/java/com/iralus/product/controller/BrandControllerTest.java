package com.iralus.product.controller;

import com.iralus.product.entity.Brand;
import com.iralus.product.entity.Status;
import com.iralus.product.service.BrandService;
import com.iralus.product.service.ModelService;
import com.iralus.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    @MockBean
    private ModelService modelService;

    @MockBean
    private ProductService productService;

    private Brand brand;

    @BeforeEach
    void setUp() {
        brand = Brand.builder()
                .brandId(1L)
                .brandName("Geely")
                .status(Status.IN)
                .build();
    }

    @Test
    void addBrand() throws Exception {
        Brand inputBrand = Brand.builder()
                .brandName("Geely")
                .status(Status.IN)
                .build();

        Mockito.when(brandService.addBrand(inputBrand))
                .thenReturn(brand);
        mockMvc.perform(post("/brands/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"brandName\" : \"Geely\",\n" +
                        "    \"status\" : 1\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchBrandById() throws Exception {
        Mockito.when(brandService.fetchBrandById(1L))
                .thenReturn(brand);
        mockMvc.perform(get("/brands/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandName").value(brand.getBrandName()));


    }
}