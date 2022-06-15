package com.iralus.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @SequenceGenerator(
            name = "model_sequence",
            sequenceName = "model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_sequence"
    )
    private Long modelId;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "description")
    private String description;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "brandId"
    )
    private Brand brand;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
