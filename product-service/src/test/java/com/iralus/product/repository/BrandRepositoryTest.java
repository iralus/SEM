package com.iralus.product.repository;

import com.iralus.product.entity.Brand;
import com.iralus.product.entity.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Brand brand =
                Brand.builder()
                        .brandName("Geely")
                        .status(Status.IN)
                        .build();
        testEntityManager.persist(brand);
    }

    @Test
    public void whenFindById_thenReturnBrand(){
        Brand brand = brandRepository.findById(1L).get();
        assertEquals(brand.getBrandName(), "Geely");
    }
}