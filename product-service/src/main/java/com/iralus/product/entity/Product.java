package com.iralus.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "tag_name")
    private String tagName;
    @Column(name = "oem")
    private String oem;
    @Column(name = "hs_code")
    private String hsCode;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "length")
    private Double length;
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @Column(name = "weight")
    private Double weight;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "brandId"
    )
    private Brand brand;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "model_id",
            referencedColumnName = "modelId"
    )
    private Model model;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
